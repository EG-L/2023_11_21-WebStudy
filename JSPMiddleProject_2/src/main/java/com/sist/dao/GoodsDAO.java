package com.sist.dao;
import java.util.*;

import java.sql.*;
import com.sist.dbcp.*;
import com.sist.vo.*;
// 구매
public class GoodsDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static CreateDBCPConnection dbconn = new CreateDBCPConnection();
	
	private static GoodsDAO dao;
	private String[] tables= {"",
			"goods_all",
			"goods_best",
			"goods_new",
			"goods_special"};
	private final int ROW_SIZE = 12;
	// 기능
	public ArrayList<GoodsVO> goodsAllListData(int page,int type){
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		try {
			conn = dbconn.getConnection();
			String sql = "SELECT no,goods_poster,goods_name,goods_price,num "
					+ "FROM (SELECT no,goods_poster,goods_name,goods_price,rownum as num "
					+ "FROM (SELECT no,goods_poster,goods_name,goods_price "
					+ "FROM "+tables[type]+" ORDER BY no)) "
							+ "WHERE num BETWEEN ? AND ?";
			ps = conn.prepareStatement(sql);
			int start = (ROW_SIZE*page)-(ROW_SIZE-1);
			int end = (ROW_SIZE*page);
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				GoodsVO vo = new GoodsVO();
				vo.setNo(rs.getInt(1));
				vo.setGoods_poster(rs.getString(2));
				vo.setGoods_name(rs.getString(3));
				vo.setGoods_price(rs.getString(4));
				
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			dbconn.disConnection(conn, ps);
		}
		return list;
	}
	
	// 총페이지
	public int goodsTotalPage(int type) {
		int total = 0;
		try {
			conn = dbconn.getConnection();
			String sql = "SELECT CEIL(COUNT(*)/"+ROW_SIZE+") "
					+ "FROM "+tables[type];
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total = rs.getInt(1);
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			dbconn.disConnection(conn, ps);
		}
		return total;
	}
	
	public GoodsVO goodsFindListData(int type,int no){
		GoodsVO vo = new GoodsVO();
		try {
			conn = dbconn.getConnection();
			String sql = "SELECT * FROM "+tables[type]+" WHERE no="+no;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setGoods_name(rs.getString(2));
			vo.setGoods_sub(rs.getString(3));
			vo.setGoods_price(rs.getString(4));
			vo.setGoods_discount(rs.getInt(5));
			vo.setGoods_first_price(rs.getString(6));
			vo.setGoods_delivery(rs.getString(7));
			vo.setGoods_poster(rs.getString(8));
			vo.setHit(rs.getInt(9));
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			dbconn.disConnection(conn, ps);
		}
		return vo;
	}
}
