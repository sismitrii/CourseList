<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="mainTitle" value="Courses" />
<c:set var="secondaryTitle" value="Panier" />
<c:set var="checked" value="" />
<jsp:include page="./fragments/header.jsp">
	<jsp:param name="mainTitle" value="${mainTitle}"/>
	<jsp:param name="secondaryTitle" value="${secondaryTitle}"/>
</jsp:include>
		<main class="mainContainer">
			<div class="content">
				<div class="col-12">
				    <h2 class="my-5 text-center">${secondaryTitle}<br />${list.getName()}</h2>
				
				    <div class="row">
				        <ul class="list-group col-12">
				        		<!--  ONE LIST ITEM TEMPLATE -->
				        		<c:forEach items="${articles}" var="v">
				        			<c:set var="checked" value="" />
				        			<c:if test="${v.isStatus()}">
												<c:set var="checked" value="checked" />
											</c:if>
					            <li class="list-group-item d-flex justify-content-between align-items-center"><span class="listItem ${checked}">${v.getName()}</span>
					                <div>
					                	<form id="formToggleArticle${v.getArticleId()}" name="formToggleArticle${v.getArticleId()}" method="POST" action="<%= request.getContextPath() %>/ServletKartManager">
					                		<input type="checkbox" name="check" value="${v.getArticleId()}" id="article${v.getArticleId()}" onClick="get('formToggleArticle${v.getArticleId()}').submit();" ${checked} />
					                		<input type="hidden" name="articleId" value="${v.getArticleId()}" />
					                		<input type="hidden" name="listId" value="${list.getShoppingListId()}" />
					                	</form>
					                </div>
					             </li>
										</c:forEach>
				        </ul>
				    </div>
				</div>
			</div>
		</main>

<jsp:include page="./fragments/footer.jsp">
	<jsp:param name="sourcePage" value="manageKart"/>
	<jsp:param name="listId" value="${list.getShoppingListId()}"/>
</jsp:include>

