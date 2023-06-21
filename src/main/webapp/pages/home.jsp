<%
	String mainTitle = "Courses";
	String secondaryTitle = "Liste prédéfinies";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./fragments/header.jsp">
	<jsp:param name="mainTitle" value="<%= mainTitle %>"/>
	<jsp:param name="secondaryTitle" value="<%= secondaryTitle %>"/>
</jsp:include>

		<div class="MainContainer">
			<div class="content">
				<div class="col-12">
				    <h2 class="my-5 text-center"><%= secondaryTitle %></h2>
				
				    <div class="row">
				        <ul class="list-group col-12">
				        		<!--  ONE LIST ITEM TEMPLATE -->
				        		<c:forEach items="${lists}" var="v">
				            <li class="list-group-item d-flex justify-content-between align-items-center">${v.getName()}
				                <div>
				                    <a href="panier.html?id=${v.getShoppingListId()}" class="badge" title="Commencer ses courses"><i class="material-icons">shopping_cart</i></a>
				                    <a href="#supprimer" class="badge text-danger" title="Supprimer"><i class="material-icons">delete</i></a>
				                </div>
				             </li>
										</c:forEach>
				            
				        </ul>
				    </div>
				</div>
			</div>
		</div>

<jsp:include page="./fragments/footer.jsp"></jsp:include>

