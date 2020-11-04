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

<div class="container">
	<h1>bbs게시판</h1>
 
 
 <section id="container">
        <table class="board_list">
		<colgroup>
			<col width="10%"/>
			<col width="*"/>
			<col width="15%"/>
			<col width="20%"/>
			<col width="10%"/>
		</colgroup>
              <thead>
   				<tr>
					<th scope="col">글번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
					<th scope="col">조회수</th>
   				</tr>
              </thead>
              <tbody>
                  <c:choose>
                      <c:when test="${fn:length(list) > 0 }">
                          <c:forEach items="${list}" var="bList">
                              <tr>
                              <th scope="row">${bList.USER_ID}</th>
                              <td>
                              	<a href='<c:url value='/board/boardDetail?idx=${bList.USER_ID}'/>' 
                              		class="text-dark">${bList.TITLE }
                              	</a>
                              </td>
                     
                            </tr>
                          </c:forEach>
                      </c:when>
                      <c:otherwise>
                          <tr>
                              <td colspan="5">조회된 결과가 없습니다.</td>
                          </tr>
                      </c:otherwise>
                  </c:choose>
                
              </tbody>
              
              
            </table>


	<c:if test="${not empty paginationInfo}">
		<ui:pagination paginationInfo = "${paginationInfo}" type="text" jsFunction="fn_search"/>
	</c:if>
	<input type="hidden" id="currentPageNo" name="currentPageNo"/>
	
	<a href='<c:url value='/board/boardWrite'/>' role="button" class="btn btn-outline-info">글쓰기</a>
	<a href='<c:url value='/excelDown.do'/>' role="button" class="btn btn-outline-info">엑셀</a>
	<a href="#this" class="btn" id="write">글쓰기2</a>



		<script type="text/javascript">
		$(document).ready(function(){
			$("#write").on("click", function(e){ //글쓰기 버튼
				e.preventDefault();
				fn_openBoardWrite();
			});	
			
			$("a[name='title']").on("click", function(e){ //제목 
				e.preventDefault();
				fn_openBoardDetail($(this));
			});
		});
		
		
		function fn_openBoardWrite(){
	        
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/board/boardWrite' />");
			comSubmit.submit();
		}
		
		function fn_openBoardDetail(obj){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/sample/openBoardDetail' />");
			comSubmit.addParam("IDX", obj.parent().find("#IDX").val());
			comSubmit.submit();
		}
		
   		function fn_search(pageNo){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/board/boardList' />");
			comSubmit.addParam("currentPageNo", pageNo);
			comSubmit.submit();
		}
		
	</script>	
</section>
 </div>
 
 

</body>
</html>
