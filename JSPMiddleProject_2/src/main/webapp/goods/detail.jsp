<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*"%>
<jsp:useBean id="model" class="com.sist.model.GoodsModel"></jsp:useBean>
<%
	model.goodsDetailData(request);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<h1 class="text-center">상품 상세보기</h1>
		<table class="table">
				<tr>
					<td width="35%" align="center" rowspan="9">
						<img src="${vo.goods_poster}" id="image">
					</td>
					<td width="65%" align="center">
						<span id="title">
							${vo.goods_name }
						</span>
					</td>
				</tr>
				<tr>
					<td width="65%">
						<span id="sub">${vo.goods_sub }</span>
					</td>
				</tr>
				<tr>
					<td width="65%">
						<span id="percent">${vo.goods_discount }%</span>&nbsp;
						<span id="price">${vo.goods_price}</span>
						<p>
							<del id="psub">${vo.goods_price }</del>
						</p>
					</td>
				</tr>
				<tr>
					<td width="65%">
						<span id="label">첫구매할인가</span>
						<span id="price2">${vo.goods_first_price}</span>
					</td>
				</tr>
				<tr>
					<td width="65%">
						<span id="star">★★★★★</span>&nbsp;
						<span id="bold">4.5</span>&nbsp;
						<span id="count">(299)</span>
					</td>
				</tr>
				<tr>
					<td width="65%">
						<img src="https://recipe1.ezmember.co.kr/img/mobile/icon_delivery3.png">&nbsp;
						<span id="dev">배송</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span id="delivery"> ${vo.goods_delivery}</span>
					</td>
				</tr>
				<tr>
					<td width="65%">
						<select id="sel">
							<option>옵션 선택</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="65%">
						<input type="button" value="장바구니" id="cart">
						<input type="button" value="바로구매" id="buy">
						<input type="button" value="목록" id="cart" onclick="javascript:history.back()">
					</td>
				</tr>
			</table>
	</div>
</body>
</html>