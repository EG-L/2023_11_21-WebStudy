package com.sist.model;

import javax.servlet.http.HttpServletRequest;
// 요청 처리 후에 결고값을 request/session에 값을 담아서 jsp로 전송
/*
 * 	   request
 *	JSP => Model => DAO
 *	    <=       <=
 *     request => 결과값을 추가해서 전송
 *     	          setAttribute
 *     =========================== call by reference
 * */
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
public class GoodsModel { 
	public void goodsListData(HttpServletRequest request) {
		//type , page
		
		String type = request.getParameter("type");
		if(type==null) {
			type="1";
		}
		String page = request.getParameter("page");
		if(page==null) {
			page="1";
		}
		//페이지 지정
		int curpage = Integer.parseInt(page);
		//페이지 해당 목록
		GoodsDAO dao = new GoodsDAO();
		ArrayList<GoodsVO> list = dao.goodsAllListData(curpage, Integer.parseInt(type));
		
		int totalpage = dao.goodsTotalPage(Integer.parseInt(type));
		
		final int BLOCK = 10;
		
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage) endPage=totalpage;
		
		// JSP에서 출력할 데이터를 전송
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("type", type);
	}
	
	public void goodsDetailData(HttpServletRequest request) {
		//요청값을 받는다.
		//요청에 해당되는 데이터베이스 값 읽기
		//request에 담아 준다.
		//=========== detail.jsp
		
		String type = request.getParameter("type");
		String no = request.getParameter("no");
		String mode = request.getParameter("mode");
		
		GoodsDAO dao = new GoodsDAO();
		GoodsVO vo = dao.goodsFindListData(Integer.parseInt(mode), Integer.parseInt(no));
		
		request.setAttribute("vo", vo);
		request.setAttribute("mode", mode);
	}

}
