<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<form action="update" method="post">
		<input type="hidden" name="page" value="${cri.page}"> <input type="hidden" name="perPageNum" value="${cri.perPageNum}">
		<table>
			<tr>
				<th>번호</th>
				<td><input type="text" name="bno" readonly value="${board.bno}"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${board.title }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="50" name="content">${board.content}</textarea></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${board.writer }"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="수정"> <input type="reset" value="취소">
					<button id="list">목록</button>
					<button id="delete">삭제</button></td>
			</tr>
		</table>
	</form>
	<form id="jobForm">
		<input type="hidden" name="page" value="${cri.page}"/> 
		<input type="hidden" name="perPageNum" value="${cri.perPageNum}"/>
		<input type="hidden" name="bno" value="${board.bno}"/>
	</form>

	<script type="text/javascript">
		var jobForm = $("#jobForm");

		$('#list').on('click', function(e) {
			e.preventDefault();
			jobForm.attr("action", "/list").attr("method", "get");
			jobForm.find("[name='bno']").remove();
			jobForm.submit();
		});
		
		$('#delete').on('click', function(e) {
			e.preventDefault();
			jobForm.attr("action", "/delete").attr("method", "get");
			jobForm.submit();
		});
	</script>
</body>
</html>