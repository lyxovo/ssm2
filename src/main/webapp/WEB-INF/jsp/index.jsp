<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	tfoot ul li
     {
       list-style-type:none;
       display:inline;
     }
</style>
</head>
<body>
	<div>
		<form action="">
			<table border="1">
			 <tr>
			    <th>编号</th>
			    <th>姓名</th>
			    <th>金币</th>
			  </tr>
			<c:forEach items="${pageInfo.list}" var="user" step="1">
			  <tr>
			    <th>${user.uid}</th>
			    <th>${user.uname}</th>
			    <th>${user.money}</th>
			  </tr>
			 </c:forEach>
			 
			 <tfoot>
				<tr>
					<td colspan="6" align="center" >
						<ul>
							<li><a href="/index.do?pageNum=1">首页</a></li>
							<c:if test="${pageInfo.hasPreviousPage}">
								<li><a href="/index.do?pageNum=${pageInfo.prePage}">上一页</a></li>
							</c:if>
							<c:forEach items="${pageInfo.navigatepageNums }" var="num" >
								<c:if test="${num==pageInfo.pageNum}">
									<li><a href="/index.do?pageNum=${num}" style="font-weight:bold;color:red">${num}</a> </li>
								</c:if>
								<c:if test="${num!=pageInfo.pageNum}">
									<li><a href="/index.do?pageNum=${num}">${num}</a> </li>
								</c:if>
							</c:forEach>
						
							<c:if test="${pageInfo.hasNextPage }">
								<li><a href="/index.do?pageNum=${pageInfo.nextPage }">下一页</a></li>
							</c:if>
							<li><a href="/index.do?pageNum=${pageInfo.pages}">末页</a></li>
						</ul>
					</td>
				</tr>
			</tfoot>
			</table>
		</form>
	</div>
</body>
</html>