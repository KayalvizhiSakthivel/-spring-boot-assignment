<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
div.scrollmenu {
	background-color: #333;
	overflow: auto;
	white-space: nowrap;
}

div.scrollmenu a {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 9px;
	text-decoration: none;
}

div.scrollmenu a:hover {
	background-color: #777;
}

h1 {
	font-family: cursive;
	font-style: italic;
}

#bio td, #bio th, #bio tr {
	border: 1px solid #ddd;
	padding: 8px;
	margin-bottom: 300px;
	margin-right: 20px;
	margin-left: 50px;
}

#bio #imd {
	background-color: #4CAF50;
	color: white
}
</style>
<title>Book Management System</title>
</head>
<body>

	<h2 align="center">Book Management System</h2>
	<div class="scrollmenu">

		<a href="addBook">Add Book |</a> <a href="addSubject">Add Subject
			|</a> <a href="deleteBook">Delete Book |</a> <a href="deleteSubject">Delete
			Subject |</a> <a href="searchBook">Search Book |</a> <a
			href="searchSubject">Search Subject |</a> <a href="searchBookByTitle">Search
			Book- Title |</a> <a href="searchSubjectByDur">Search Subject-
			Duration</a>

	</div>
	<h1 align="center">Search Book</h1>
	<form:form action="searchBook" method="POST" modelAttribute="book">

		<table>
			<tr>
				<td>Book Id</td>
				<td><input name="value" /></td>
			</tr>
		</table>
		<c:forEach var="f" items="${book }">
			<br>
			<button name="field" value="${f}">Search by ${f}</button>
		</c:forEach>


	</form:form>
	<br>
	<br>
	<c:choose>
		<c:when test="${recs eq null or recs.size() eq 0 }">
			<h3>No Emp Record(s) Found</h3>
		</c:when>
		<c:otherwise>
			<table id="bio">
				<thead>
					<tr>
						<th id="imd">Book Id</th>
						<th id="imd">Title</th>
						<th id="imd">Price</th>
						<th id="imd">Volume</th>
						<th id="imd">Publish Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${recs }">
						<tr>
							<td>${b.bookId }</td>
							<td>${b.title }</td>
							<td>${b.price }</td>
							<td>${b.volume }</td>
							<td>${b.publishDate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>
