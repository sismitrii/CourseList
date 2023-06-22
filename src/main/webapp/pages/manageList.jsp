<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="mainTitle" value="Courses" />
<c:set var="secondaryTitle" value="Nouvelle Liste" />
<c:if test="${!empty list}">
	<c:set var="secondaryTitle" value="${list.getName()}" />
</c:if>

<c:set var="listId" value="-1" />
<c:set var="disabled" value="" />
<c:if test="${!empty list.getShoppingListId()}">
	<c:set var="listId" value="${list.getShoppingListId()}" />
	<c:set var="disabled" value="disabled" />
</c:if>
<jsp:include page="./fragments/header.jsp">
	<jsp:param name="mainTitle" value="${mainTitle}"/>
	<jsp:param name="secondaryTitle" value="${secondaryTitle}"/>
</jsp:include>


		<div class="MainContainer">
			<div class="content">
				<div class="col-12">
				    <h2 class="my-5 text-center">${secondaryTitle}</h2>
						<form id="manageListForm" name="manageListForm" method="POST" action="">
							<input type="hidden" name="listId" id="listId" value="${listId}" />
					    <div class="row">
					    		<div style="margin : auto;"><span>Nom :</span> <input type="text" id="listName" name="listName" value="${list.getName()}" ${disabled} />
					        <ul class="list-group col-12">
					        		<!--  ONE LIST ITEM TEMPLATE -->
					        		<c:forEach items="${articles}" var="v">
					            	<li class="list-group-item d-flex justify-content-between align-items-center">${v.getName()}
					            	<div>
				                    <a href="<%= request.getContextPath() %>/ServletListManager?action=delete&articleId=${v.getArticleId()}&listId=${list.getShoppingListId()}" class="badge text-danger" title="Supprimer"><i class="material-icons">delete</i></a>
				                </div>
					            	</li>
											</c:forEach>
					        </ul>
					        </div>
					    </div>
				    <div class="row">
				    	<div style="margin : auto;">
				    		Article :
				    		<input type="text" id="articleName" name="articleName" value="" />
				    		<a href="#" id="addArticle" onClick="document.getElementById('manageListForm').submit()" class="badge" title="Ajouter article"><i class="material-icons">add_box</i></a>
				    	</div>
				    </div>
				    </form>
				</div>
			</div>
		</div>

<jsp:include page="./fragments/footer.jsp">
	<jsp:param name="sourcePage" value="manageList"/>
</jsp:include>

