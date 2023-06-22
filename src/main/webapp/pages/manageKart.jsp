<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="mainTitle" value="Courses" />
<c:set var="secondaryTitle" value="Panier" />
<jsp:include page="./fragments/header.jsp">
	<jsp:param name="mainTitle" value="${mainTitle}"/>
	<jsp:param name="secondaryTitle" value="${secondaryTitle}"/>
</jsp:include>
		<div class="MainContainer">
			<div class="content">
				<div class="col-12">
				    <h2 class="my-5 text-center">${secondaryTitle}<br />${list.getName()}</h2>
				
				    <div class="row">
				        <ul class="list-group col-12">
				        		<!--  ONE LIST ITEM TEMPLATE -->
				        		<c:forEach items="${articles}" var="v">
					            <li class="list-group-item d-flex justify-content-between align-items-center">${v.getName()}
					                <div>
					                	<form method="POST" action="<%= request.getContextPath() %>/ServletKartManager"><input type="checkbox" id="article${v.getArticleId()}" /></form>
					                </div>
					             </li>
										</c:forEach>
				        </ul>
				    </div>
				</div>
			</div>
		</div>

<jsp:include page="./fragments/footer.jsp">
	<jsp:param name="sourcePage" value="manageKart"/>
</jsp:include>

