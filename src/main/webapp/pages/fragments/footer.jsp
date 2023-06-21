		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!-- Footer -->
		<footer class="row bg-dark footer-demodule fixed-bottom py-1">
			<div class="col-lg-4 offset-lg-4 text-center">
				<c:if test="${param.sourcePage eq 'home'}">
					<a class="btn" href="<%= request.getContextPath() %>/ServletListManager" title="Créer une nouvelle liste"><i class="material-icons">add</i></a>
				</c:if>
				<c:if test="${param.sourcePage eq 'manageList'}">
					<a class="btn" href="<%= request.getContextPath() %>/Homepage" title="Accueil"><i class="material-icons">add</i></a>
				</c:if>
			</div>
			<div class="credits col-lg-12 text-center">ShoppingList App&trade; - &copy; GUÉRIN Florian & THEBAULT Dimitry 2023 (via ENI Nantes)</div>
			<!-- /container -->
		</footer>
	</body>
</html>