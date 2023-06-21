<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="mainTitle" value="Courses" />
<c:set var="secondaryTitle" value="Nouvelle Liste" />
<c:if test="${!empty id}">
	<c:set var="secondaryTitle" value="${param.list.name}" />
</c:if>
<jsp:include page="./fragments/header.jsp">
	<jsp:param name="mainTitle" value="${mainTitle}"/>
	<jsp:param name="secondaryTitle" value="${secondaryTitle}"/>
</jsp:include>

		<div class="MainContainer">
			<div class="content">
				<div class="col-12">
				    <h2 class="my-5 text-center">${secondaryTitle}</h2>
						<form id="manageListForm" name="manageListForm" method="POST" action="" />
					    <div class="row">
					    		<div style="margin : auto;"><span>Nom :</span> <input type="text" id="listName" name="listName" value="" />
					        <ul class="list-group col-12">
					        		<!--  ONE LIST ITEM TEMPLATE -->
					        		<c:forEach items="${articles}" var="v">
					            	
											</c:forEach>
					        </ul>
					        </div>
					    </div>
				    </form>
				</div>
			</div>
		</div>

<jsp:include page="./fragments/footer.jsp">
	<jsp:param name="sourcePage" value="manageList"/>
</jsp:include>

