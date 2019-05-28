<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<div id="showAdherent">
	<fieldset>
    	<legend><spring:message code="label.identite"/></legend>
		<div class="entete">
			<div class="photo">
				<img src="<c:url value="/resources/images/noAdh.png" />" />
			</div>
			<div>
				<div class="nomAdherent">
					<h2>${adherent.denomination}</h2>
					<c:url value="/edit/editIdentiteAdh" var="url"><c:param name="idAdh" value="${adherent.id}"/></c:url>
					<span><a href="${url}"><svg><use xlink:href="resources/images/icones.svg#edit"></use></svg></a></span>
		    	</div>
		    			    	
				<div class="showDetail">
					<span class="label"> Code adherent</span>
					<span class="data" > ${adherent.code} </span>
				</div>
				<div  class="showDetail">
					<span class="label"><spring:message code="label.libelle"/></span>
					<span class="data">${adherent.libelle}</span>
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
	    	<div class="editIcone">
	    		<c:url value="/edit/editAdherentContact" var="url"><c:param name="idAdh" value="${adherent.id}"/></c:url>
				<span><a href="${url}"><svg><use xlink:href="resources/images/icones.svg#edit"></use></svg></a></span>
	    	</div>
			<div class="listContact">
				<c:forEach items="${mapContact}" var="contact">
					<span class="data">${contact.key.libelle}</span>
					<span class="data">${contact.value.civilite}</span>
					<span class="data">${contact.value.nom} ${contact.value.prenom}</span>
					<span class="data">${contact.value.mail}</span>
					<span class="data">${contact.value.fixe}</span>
					<span class="data">${contact.value.mobile}</span>
				</c:forEach>
			</div>
	</fieldset>
</div>
