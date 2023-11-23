package com.sist.view;

import java.io.*;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;

@WebServlet("/foodListServlet")
public class foodListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 브라우저를 통해서 요청 시 처리해서 브라우저로 HTML을 전송하는 메소드
		//톰캣에 의해 자동 호출
		//메소드 영역 => JSP다 => service
		// JSP => 실행 => class변경 => 컴파일해서 실행
		//전송타입 => HTML , XML , JSON
		response.setContentType("text/html;charset=UTF-8");
		//                       text/xml => xml , text/plain => json 파싱방법
		// HTML전송
		PrintWriter out = response.getWriter();
		//                ==================== 접속한 클라이언트 브라우저
		bookDAO dao = bookDAO.newInstance();
		ArrayList<bookVO> list = dao.bookListData(1);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy"); 
		
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>책 보기</h1>");
		out.println("<table border=1 width=800>");
		out.println("<tr>");
		out.println("<th width=10%>책 이름</th>");
		out.println("<th width=15%></th>");
		out.println("<th width=20%>지은이</th>");
		out.println("<th width=15%>출간일</th>");
		out.print("<th width=15%>isbn</th>");
		out.println("</tr>");
		for(bookVO vo:list) {
			out.println("<tr>");
			out.println("<td width=40%>"+vo.getBooktitle()+"</th>");
			out.println("<td width=10% >"+"<img src='"+vo.getImage()+"' width=30% height=30%></th>");
			out.println("<td width=20%>"+vo.getBookperson()+"</th>");
			out.println("<td width=15%>"+simpleDateFormat.format(vo.getBookdate())+"</th>");
			out.println("<td width=15%>"+vo.getIsbn()+"</th>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.print("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}
