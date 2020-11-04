<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<%@ include file="/WEB-INF/include/include-body.jspf" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
</head>
<body>
<div class="container col-md-6">
    <form action='<c:url value='/board/boardUpdate'/>' method="post">
        <div class="form-group">
            <label for="exampleFormControlInput1">제목</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="title" value="${detail.TITLE }">
        </div>
        <div class="form-group">
            <label for="exampleFormControlInput1">작성자</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="crea_id" value="${detail.CREA_ID }" readonly>
        </div>
        <div class="form-group">
            <label for="exampleFormControlTextarea1">내용</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="10" name="contents">${detail.CONTENTS }</textarea>
        </div>
        <input type="hidden" name="idx" value="${detail.IDX }">
        <button type="submit" class="btn btn-info">수정하기</button>
        <button type="button" class="btn btn-secondary">뒤로가기</button>
    </form>
</div>

</body>
</html>