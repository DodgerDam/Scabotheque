<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@page session="true"%>
 
<div class="scabotheque-header">
	<div  class="logo">
		<img src="<c:url value="/resources/images/Scabotheques.png" />"  alt="Scabotheque" />
	</div>

	<div class="identification">
		<c:choose>
			<c:when test="${pageContext.request.remoteUser != null}">
				Vous êtes conencté en ${pageContext.request.remoteUser}
				<br>
	      		<a href="<c:url value="/login?logout" />">Déconnexion</a>
			</c:when>
			<c:otherwise>
				Vous n'êtes pas connecté
			</c:otherwise>
		</c:choose>
	</div>
	<div class="version">
		Version : ${project.version}
	</div>
</div>
	