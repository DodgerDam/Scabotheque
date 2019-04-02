<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<div id="showAdherent">
	<fieldset>
    	<legend><spring:message code="label.identite"/></legend>
		<div class="entete">
			<div class="photo">
				<img src="<c:url value="/resources/images/noAdh.png" />" />
			</div>
			<div>
				<h2>${adherent.denomination}</h2>
				<div class="showDetail">
					<span class="label"> Code adherent</span>
					<span class="data" > ${adherent.code} </span>
					<c:url value="/editIdentiteAdh" var="url"><c:param name="idAdh" value="${adherent.id}"/></c:url>
					<span><a href="${url}"><svg><use xlink:href="resources/images/icones.svg#edit"></use></svg></a></span>
				</div>
				<div  class="showDetail">
					<span class="label"><spring:message code="label.denomination"/></span>
					<span class="data">${adherent.denomination}</span>
				</div>
	
				<div  class="showDetail">
					<span class="label"><spring:message code="label.adresse"/></span>
					<span class="data">${adherent.adresse}</span>
				</div>
			
				<div  class="showDetail">
					<span class="label"><spring:message code="label.adresseComplement"/></span>
					<span class="data">${adherent.adresseComplement}</span>
				</div>
				<div  class="showDetail">
					<span class="label"><spring:message code="label.commune"/></span>
					<span class="data"><spring:message code="message.commune" arguments="${adherent.commune.codePostal}, ${adherent.commune.libelle}"/></span>
				</div>
				<div  class="showDetail">
					<span class="label"><spring:message code="label.adhArtipole"/></span>
					<span class="data">
						<c:choose>
							<c:when test="${adherent.isArtipole}"><spring:message code="yes"/></c:when> 
							<c:otherwise><spring:message code="no"/></c:otherwise> 
						</c:choose>
					</span>
				</div>
				<div  class="showDetail"> 
					<span class="label"><spring:message code="label.agenceRattachement"/></span>
					<span class="data">${adherent.agence.libelle}</span>
				</div>
			
				<div  class="showDetail">
					<span class="label"><spring:message code="label.secteur"/></span>
					<span class="data">${adherent.secteur.libelle}</span>
				</div>
			</div>	
		</div>	
	</fieldset>

	<fieldset>
    	<legend><spring:message code="label.contacts"/></legend>
    	
    	Ici la liste de tout les contactes ...
	
<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.commune"/></span> --%>
<%-- 			<span class="data"><spring:message code="message.commune" arguments="${adherent.commune.codePostal}, ${adherent.commune.libelle}"/></span> --%>
<!-- 		</div> -->

	</fieldset>

</div>

	<c:url value="/editActiviteAdh" var="urlActivite"><c:param name="idAdh" value="${adherent.id}"/></c:url>
	<c:url value="/editExploitationAdh" var="urlExploit"><c:param name="idAdh" value="${adherent.id}"/></c:url>
	<c:url value="/editAdministratifAdh" var="urlAdmin"><c:param name="idAdh" value="${adherent.id}"/></c:url>

<div class="bottomNavBar">
	<c:url value="/enCours" var="url" />
	<a href="${urlActivite}">
		<svg class="icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
		<spring:message code="label.activite"/>
	</a>
	
	<a href="${urlExploit}">
		<svg class="icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
		<spring:message code="label.exploitation"/>
	</a>

	<a href="${urlAdmin}">
		<svg class="icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
		<spring:message code="label.administratif"/>
	</a>
</div>

<!-- 	<fieldset> -->
<%--     	<legend><spring:message code="label.activite"/></legend> --%>
    	
<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.pole"/></span> --%>
<%-- 			<span class="data" >${adherent.pole.libelle}</span> --%>
<%-- 			<c:url value="/editActiviteAdh" var="url"><c:param name="idAdh" value="${adherent.id}"/></c:url> --%>
<%-- 	    	<span><a href="${url}"><svg><use xlink:href="resources/images/icones.svg#edit"></use></svg></a></span> --%>
<!-- 		</div> -->
	
<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.adhArtipole"/></span> --%>
<!-- 			<span class="data"> -->
<%-- 				<c:choose> --%>
<%-- 					<c:when test="${adherent.isArtipole}"><spring:message code="yes"/></c:when>  --%>
<%-- 					<c:otherwise><spring:message code="no"/></c:otherwise>  --%>
<%-- 				</c:choose> --%>
<!-- 			</span> -->
<!-- 		</div> -->
	
<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.charteArtipole"/></span> --%>
<!-- 			<span class="data"> -->
<%-- 				<c:choose> --%>
<%-- 					<c:when test="${adherent.isCharteArtipole}"><spring:message code="yes"/></c:when>  --%>
<%-- 					<c:otherwise><spring:message code="no"/></c:otherwise>  --%>
<%-- 				</c:choose> --%>
<!-- 			</span> -->
<!-- 		</div> -->
	
<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.flocageArtipole"/></span> --%>
<%-- 			<span class="data"><c:choose> --%>
<%-- 					<c:when test="${adherent.isFlocageArtipole}"><spring:message code="yes"/></c:when>  --%>
<%-- 					<c:otherwise><spring:message code="no"/></c:otherwise>  --%>
<%-- 				</c:choose> --%>
<!-- 			</span> -->
<!-- 		</div> -->
		
<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.siteArtipole"/></span> --%>
<%-- 			<span class="data"><c:choose> --%>
<%-- 					<c:when test="${adherent.isFacebookArtipole}"><spring:message code="yes"/></c:when>  --%>
<%-- 					<c:otherwise><spring:message code="no"/></c:otherwise>  --%>
<%-- 				</c:choose> --%>
<!-- 			</span> -->
<!-- 		</div> -->

<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.facebookArtipole"/></span> --%>
<%-- 			<span class="data"><c:choose> --%>
<%-- 					<c:when test="${adherent.isFacebookArtipole}"><spring:message code="yes"/></c:when>  --%>
<%-- 					<c:otherwise><spring:message code="no"/></c:otherwise>  --%>
<%-- 				</c:choose> --%>
<!-- 			</span> -->
<!-- 		</div> -->

<!-- 	</fieldset> -->
		
<!-- 	<fieldset> -->
<%-- 	   	<legend><spring:message code="label.exploitation"/></legend> --%>
	   	
<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.agenceRattachement"/></span> --%>
<%-- 			<span class="data">${adherent.agence.libelle}</span> --%>
<%-- 			<c:url value="/editExploitationAdh" var="url"><c:param name="idAdh" value="${adherent.id}"/></c:url> --%>
<%-- 	    	<span><a href="${url}"><svg><use xlink:href="resources/images/icones.svg#edit"></use></svg></a></span> --%>
<!-- 		</div> -->
	
<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.secteur"/></span> --%>
<%-- 			<span class="data">${adherent.secteur.libelle}</span> --%>
<!-- 		</div> -->

<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.tournee"/></span> --%>
<%-- 			<span class="data">${adherent.tournee.libelle}</span> --%>
<!-- 		</div> -->

<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.outilDechargement"/></span> --%>
<%-- 			<span class="data">${adherent.isOutilDechargement}</span> --%>
<!-- 		</div> -->

<!-- 	</fieldset> -->

<!-- 	<fieldset> -->
<%--     	<legend><spring:message code="label.administratif"/></legend> --%>
	
<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.dateEntree"/></span> --%>
<%-- 			<span class="data"><fmt:formatDate pattern="MM/dd/yyyy" value="${adherent.dateEntree}" /></span> --%>
<%-- 			<c:url value="/editAdministratifAdh" var="url"><c:param name="idAdh" value="${adherent.id}"/></c:url> --%>
<%-- 	    	<span><a href="${url}"><svg><use xlink:href="resources/images/icones.svg#edit"></use></svg></a></span> --%>
<!-- 		</div> -->

<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.role"/></span> --%>
<%-- 			<span class="data">${adherent.role.libelle}</span> --%>
<!-- 		</div> -->
		
<!-- 		<div  class="showDetail">  -->
<%-- 			<span class="label"><spring:message code="label.formeJuridique"/></span> --%>
<%-- 			<span class="data">${adherent.formeJuridique.libelle}</span> --%>
<!-- 		</div> -->
	
<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.siren"/></span> --%>
<%-- 			<span class="data">${adherent.siren}</span> --%>
<!-- 		</div> -->
		
<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.siret"/></span> --%>
<%-- 			<span class="data">${adherent.siret}</span> --%>
<!-- 		</div> -->
		
<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.ape"/></span> --%>
<%-- 			<span class="data">${adherent.ape.libelle}</span> --%>
<!-- 		</div> -->
		
<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.numRepMetier"/></span> --%>
<%-- 			<span class="data">${adherent.numRepMetier}</span> --%>
<!-- 		</div> -->
		
<!-- 		<div  class="showDetail"> -->
<%-- 	        <span class="label"><spring:message code="label.rcsRm"/></span> --%>
<%-- 			<span class="data">${adherent.rcsRm}</span> --%>
<!-- 		</div> -->

<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.rcsCommune"/></span> --%>
<%-- 			<span class="data">${adherent.rcsCommune.libelle}</span> --%>
<!-- 		</div> -->

<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.dateClotureExe"/></span> --%>
<%-- 			<span class="data"><fmt:formatDate pattern="MM/dd/yyyy" value="${adherent.dateClotureExe}" /></span> --%>
<!-- 		</div> -->

<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.contactComptable"/></span> --%>
<%-- 			<span class="data">${adherent.contactComptable}</span> --%>
<!-- 		</div> -->

<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.formationCommerce"/></span> --%>
<%-- 			<span class="data"><c:choose> --%>
<%-- 					<c:when test="${adherent.isFormationCommerce}"><spring:message code="yes"/></c:when>  --%>
<%-- 					<c:otherwise><spring:message code="no"/></c:otherwise>  --%>
<%-- 				</c:choose> --%>
<!-- 			</span> -->
<!-- 		</div> -->
		
<!-- 		<div  class="showDetail"> -->
<%-- 			<span class="label"><spring:message code="label.etat"/></span> --%>
<%-- 			<span class="data">${adherent.etat.libelle}</span> --%>
<!-- 		</div> -->

<!-- 	</fieldset> -->
<!-- </div> -->
