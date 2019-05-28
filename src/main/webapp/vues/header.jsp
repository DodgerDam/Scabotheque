<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@page session="true"%>
 
<div id=header>
	<div  class="logo">
		<img src="<c:url value="/resources/images/Scabotheques.png" />"  alt="Scabotheque" />
	</div>

	<div class="identification">
		<c:choose>
			<c:when test="${pageContext.request.remoteUser != null}">
				<h2>Vous êtes conencté en ${pageContext.request.remoteUser}</h2>
	      		<a href="<c:url value="/login?logout" />">Déconnexion</a>
			</c:when>
			<c:otherwise>
				<h2>Vous n'êtes pas connecté</h2>
			</c:otherwise>
		</c:choose>
	</div>
	<div>
		Version : ${project.version}
	</div>

	
</div>
	