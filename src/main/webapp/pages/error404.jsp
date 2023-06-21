<%
	String mainTitle = "Erreur 404";
	String secondaryTitle = "Ressource non trouvée";
%>

<jsp:include page="./fragments/header.jsp">
	<jsp:param name="mainTitle" value="<%= mainTitle %>"/>
	<jsp:param name="secondaryTitle" value="<%= secondaryTitle %>"/>
</jsp:include>
<% error = true; %>
<div class="col-12">
    <h2 class="my-5 text-center"><%= secondaryTitle %></h2>
</div>

<jsp:include page="./fragments/footer.jsp"></jsp:include>