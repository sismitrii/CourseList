<%
	String title = "Courses";
	String subtitle = "Liste prédéfinies";
%>
<%@include file="fragments/header.jsp" %>
		<div class="MainContainer">
			<div class="title">
				<h1><%= title %></h1>
			</div>
			<div class="content">
			</div>
		</div>

<div class="col-12">
    <h2 class="my-5 text-center">Listes prédéfinies</h2>

    <div class="row">
        <ul class="list-group col-12">
            <li class="list-group-item d-flex justify-content-between align-items-center">Liste bio
                <div>
                    <a href="panier.html" class="badge" title="Commencer ses courses"><i class="material-icons">shopping_cart</i></a>
                    <a href="#supprimer" class="badge text-danger" title="Supprimer"><i class="material-icons">delete</i></a>
                </div>

            </li>
            <li class="list-group-item d-flex justify-content-between align-items-center">Liste grande surface
                <div>
                    <a href="panier.html" class="badge" title="Commencer ses courses"><i class="material-icons">shopping_cart</i></a>
                    <a href="#supprimer" class="badge text-danger" title="Supprimer"><i class="material-icons">delete</i></a>
                </div>
            </li>
            <li class="list-group-item d-flex justify-content-between align-items-center">Liste surgelés
                <div>
                    <a href="panier.html" class="badge" title="Commencer ses courses"><i class="material-icons">shopping_cart</i></a>
                    <a href="#supprimer" class="badge text-danger" title="Supprimer"><i class="material-icons">delete</i></a>
                </div>
            </li>
        </ul>
    </div>
<%@include file="fragments/footer.jsp" %>

