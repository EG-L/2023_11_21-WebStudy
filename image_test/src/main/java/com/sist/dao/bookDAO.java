package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class bookDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@211.238.142.119:1521:XE";
	//=> 목록(table) => 인라인뷰 => 페이지 설정
	// 상세보기 출력
	private static bookDAO dao;
	//드라이버 등록 => 한번만 생성
	bookDAO(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void getConnection() {
		try {
			conn = DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static bookDAO newInstance() {
		// 라이브러리 => newInstance,getInstance() => 싱글턴
		if(dao==null) dao=new bookDAO();
		
		return dao;
	}
	
	public ArrayList<bookVO> bookListData(int page){
		ArrayList<bookVO> list = new ArrayList<bookVO>();
		//foodVO = row
		//https://www.menupan.com
		//
		try {
			getConnection();
			// 페이지마다 데이터 읽기
			int rowSize = 20;
			// num BETWEEN ? AND ? => 1page 1 AND 20
			int start = (rowSize*page)-(rowSize-1);
			int end = page*rowSize;
			String sql = "SELECT b2.ISBN,BOOKTITLE,BOOKPERSON,BOOKDATE,IMAGE,rownum FROM BOOKMAIN b JOIN BOOKIMAGE b2 ON b.ISBN =b2.ISBN JOIN BOOKINFO b3 ON b2.ISBN =b3.ISBN WHERE rownum  BETWEEN ? AND ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs = ps.executeQuery();
			//INDEX_ASC(테이블명 인덱스명,pk,uk) , INDEX_DESC(), INDEX()
			while(rs.next()) {
				bookVO vo = new bookVO();
				
				vo.setIsbn(rs.getString(1));
				vo.setBooktitle(rs.getString(2));
				vo.setBookperson(rs.getString(3));
				vo.setBookdate(rs.getDate(4));
				vo.setImage(rs.getString(5));
				
				list.add(vo);
				// 80% 직접 구현
				// 20% 정보,이미지 수집
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		return list;
	}
	
	// 총 페이지
	public int bookTotalPage() {
		int total = 0;
		try {
			getConnection();
			String sql = "SELCT CEIL(COUNT(*)) FROM bookimage";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				total=rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		return total;
	}
	// => 상세보기
}
