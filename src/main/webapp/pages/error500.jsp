<%
	String mainTitle = "Erreur 500";
	String secondaryTitle = "Erreur serveur inconnue";
%>

<%@include file="fragments/header.jsp" %>
<% error = true; %>
<div class="col-12">
    <h2 class="my-5 text-center"><%= secondaryTitle %></h2>
</div>

<%@include file="fragments/footer.jsp" %>