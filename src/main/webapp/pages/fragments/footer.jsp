		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!-- Footer -->
		<footer class="row bg-dark footer-demodule fixed-bottom py-1">
			<div class="col-lg-4 offset-lg-4 text-center">
				<c:if test="${param.sourcePage eq 'home'}">
					<a class="btn newList" href="<%= request.getContextPath() %>/ServletListManager" title="Créer une nouvelle liste"><i class="material-icons">add</i></a>
				</c:if>
				<c:if test="${param.sourcePage eq 'manageList' or param.sourcePage eq 'error404' or param.sourcePage eq 'error500'}">
					<a class="btn homepage ${param.sourcePage}" href="<%= request.getContextPath() %>/" title="Accueil"><i class="material-icons">arrow_back</i></a>
				</c:if>
				<c:if test="${param.sourcePage eq 'manageKart'}">
					<a class="btn homepage ${param.sourcePage}" href="<%= request.getContextPath() %>/" title="Accueil"><i class="material-icons">arrow_back</i></a>
					<form method="POST" action="" id="" name="">
						<input type="hidden" name="listId" value="${param.listId}" />
						<a class="btn resetList  ${param.sourcePage}" href="#" title="Réinitialiser le panier" onClick="confirmListRest();"><i class="material-icons">remove_done</i></a>
					</form>
				</c:if>
			</div>
			<div class="credits col-lg-12 text-center">ShoppingList App&trade; - &copy; GUÉRIN Florian & THEBAULT Dimitry 2023 (via ENI Nantes)</div>
			<!-- /container -->
		</footer>
	</body>
</html>