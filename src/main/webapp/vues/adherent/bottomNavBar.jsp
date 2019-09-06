<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>


<c:url value="/adherentDetail" var="urlDetail"><c:param name="idAdh" value="${adherent.id}"/></c:url>
<c:url value="/adherentActivite" var="urlActivite"><c:param name="idAdh" value="${adherent.id}"/></c:url>
<c:url value="/adherentArtipole" var="urlArtipole"><c:param name="idAdh" value="${adherent.id}"/></c:url>
<c:url value="/adherentExploitation" var="urlExploit"><c:param name="idAdh" value="${adherent.id}"/></c:url>
<c:url value="/adherentAdministratif" var="urlAdmin"><c:param name="idAdh" value="${adherent.id}"/></c:url>
<c:url value="/adherentInformatique" var="urlInfo"><c:param name="idAdh" value="${adherent.id}"/></c:url>

<div class="bottomNavBar">
	<c:url value="/enCours" var="url" />
	<a  <c:if test = "${pageType == 'ADHERENT_DETAIL'}"> class="bottomNavBar-active"</c:if> href="${urlDetail}" >
		<svg class="appMenu-icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
		<spring:message code="label.adherent"/>
	</a>
	
	<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_ACTIVITE')">
		<a  <c:if test = "${pageType == 'ADHERENT_ACTIVITE'}"> class="bottomNavBar-active"</c:if> href="${urlActivite}">
			<svg class="appMenu-icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
			<spring:message code="label.activite"/>
		</a>
	</sec:authorize>
	
	<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_ARTIPOLE')">
		<a  <c:if test = "${pageType == 'ADHERENT_ARTIPOLE'}"> class="bottomNavBar-active"</c:if> href="${urlArtipole}">
			<svg class="appMenu-icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
			<spring:message code="label.artipole"/>
		</a>
	</sec:authorize>
	
	<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_EXPLOITATION')">
		<a <c:if test = "${pageType == 'ADHERENT_EXPLOITATION'}"> class="bottomNavBar-active"</c:if> href="${urlExploit}">
			<svg class="appMenu-icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
			<spring:message code="label.exploitation"/>
		</a>
	</sec:authorize>

	<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_ADMIN_FINANCE')">
		<a <c:if test = "${pageType == 'ADHERENT_ADMINISTRATIF'}"> class="bottomNavBar-active"</c:if> href="${urlAdmin}">
			<svg class="appMenu-icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
			<spring:message code="label.administratif"/>
		</a>
	</sec:authorize>
	
	<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_INFORMATIQUE')">
		<a <c:if test = "${pageType == 'ADHERENT_INFORMATIQUE'}"> class="bottomNavBar-active"</c:if> href="${urlInfo}">
			<svg class="appMenu-icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
			<spring:message code="label.informatique"/>
		</a>
	</sec:authorize>
</div>