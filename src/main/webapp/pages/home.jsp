<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="mainTitle" value="Courses" />
<c:set var="secondaryTitle" value="Liste prédéfinies" />
<jsp:include page="./fragments/header.jsp">
	<jsp:param name="mainTitle" value="${mainTitle}"/>
	<jsp:param name="secondaryTitle" value="${secondaryTitle}"/>
</jsp:include>

		<div class="MainContainer">
			<div class="content">
				<div class="col-12">
				    <h2 class="my-5 text-center">${secondaryTitle}</h2>
				
				    <div class="row">
				        <ul class="list-group col-12">
				        		<!--  ONE LIST ITEM TEMPLATE -->
				        		<c:forEach items="${lists}" var="v">
				            <li class="list-group-item d-flex justify-content-between align-items-center">${v.getName()}
				            <!-- 
				            <form method="POST" action="" id="list${v.getShoppingListId()}" name="list${v.getShoppingListId()}">
				            	<input type="text" id="listName${v.getShoppingListId()}" name="listName${v.getShoppingListId()}" value="${v.getName()}" />
				            	<a onClick="validate(${v.getShoppingListId()});" >Valider</a>
				            </form>
				              -->
				                <div>
				                    <a href="panier.html?id=${v.getShoppingListId()}" class="badge" title="Commencer ses courses"><i class="material-icons">shopping_cart</i></a>
				                    <!-- <a href="#" class="badge" title="Renommer la liste"><i class="material-icons">edit</i></a> -->
				                    <form method="POST" action="<%= request.getContextPath() %>/Homepage"><a href="#supprimer" onClick="" class="badge text-danger" title="Supprimer"><i class="material-icons">delete</i></a></form>
				                </div>
				             </li>
										</c:forEach>
				            
				        </ul>
				    </div>
				</div>
			</div>
		</div>

<jsp:include page="./fragments/footer.jsp">
	<jsp:param name="sourcePage" value="home"/>
</jsp:include>

