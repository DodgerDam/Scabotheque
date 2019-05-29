<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<c:url value="/adherentDetail" var="urlDetail"><c:param name="idAdh" value="${adherent.id}"/></c:url>
<c:url value="/adherentActivite" var="urlActivite"><c:param name="idAdh" value="${adherent.id}"/></c:url>
<c:url value="/adherentExploitation" var="urlExploit"><c:param name="idAdh" value="${adherent.id}"/></c:url>
<c:url value="/adherentAdministratif" var="urlAdmin"><c:param name="idAdh" value="${adherent.id}"/></c:url>

<div class="bottomNavBar">
	<c:url value="/enCours" var="url" />
	<a <c:if test = "${pageType == 'ADHERENT_DETAIL'}"> class="active"</c:if> href="${urlDetail}" >
		<svg class="icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
		<spring:message code="label.adherent"/>
	</a>
	
	<a  <c:if test = "${pageType == 'ADHERENT_ACTIVITE'}"> class="active"</c:if> href="${urlActivite}">
		<svg class="icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
		<spring:message code="label.activite"/>
	</a>
	
	<a <c:if test = "${pageType == 'ADHERENT_EXPLOITATION'}"> class="active"</c:if> href="${urlExploit}">
		<svg class="icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
		<spring:message code="label.exploitation"/>
	</a>

	<a <c:if test = "${pageType == 'ADHERENT_ADMINISTRATIF'}"> class="active"</c:if> href="${urlAdmin}">
		<svg class="icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
		<spring:message code="label.administratif"/>
	</a>
</div>