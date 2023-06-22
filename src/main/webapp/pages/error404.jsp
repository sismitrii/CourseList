<%
	String mainTitle = "Erreur 404";
	String secondaryTitle = "Ressource non trouvée";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./fragments/header.jsp">
	<jsp:param name="mainTitle" value="<%= mainTitle %>"/>
	<jsp:param name="secondaryTitle" value="<%= secondaryTitle %>"/>
</jsp:include>

<div class="col-12">
    <h2 class="my-5 text-center"><%= secondaryTitle %></h2>
</div>

<jsp:include page="./fragments/footer.jsp">
	<jsp:param name="sourcePage" value="error404"/>
</jsp:include>