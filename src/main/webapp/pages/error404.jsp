<%
	String mainTitle = "Erreur 404";
	String secondaryTitle = "Ressource non trouvée";
	request.setCharacterEncoding("UTF-8");

%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./fragments/header.jsp">
	<jsp:param name="mainTitle" value="<%= mainTitle %>"/>
	<jsp:param name="secondaryTitle" value="<%= secondaryTitle %>"/>
</jsp:include>

<main class="oopsMain">
    <h2 class="oopsTitle">Oops, vous êtes perdu(e) !</h2>
    <p class="oopsText">La page que vous recherchez semble avoir été avalée par un trou noir intergalactique.</p>
    <img class="oopsImage rounded" src="<%=request.getContextPath() %>/images/blackhole.jpg" alt="Erreur 404 - Page introuvable">
    <div class="oopsContainer">
        <a class="oopsButton" href="mailto:admin@example.com">Contacter l'administrateur</a>
    </div>
</main>
<jsp:include page="./fragments/footer.jsp">
	<jsp:param name="sourcePage" value="error404"/>
</jsp:include>