<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="input" method="POST">
		<table>
			<tr>
				<th>Title</th>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<th>Content</th>
				<td><textarea rows="5" cols="50" name="content"></textarea></td>
			</tr>
			<tr>
				<th>Writer</th>
				<td><input type="text" name="writer" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="저장" /> 
				<input type="reset" value="취소" /> 
				<input type="submit" value="목록" onclick="location.href='list'" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>