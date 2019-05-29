<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="showAdherent">
	<fieldset>
    	<legend><spring:message code="label.administratif"/></legend>
    	
		<div class="entete">
			<div class="photo">
				<img src="<c:url value="/resources/images/noAdh.png" />" />
			</div>
			<div>
				<div class="nomAdherent">
					<h2>${adherent.denomination}</h2>
					<c:url value="/edit/editAdministratifAdh" var="url"><c:param name="idAdh" value="${adherent.id}"/></c:url>
					<span><a href="${url}"><svg><use xlink:href="resources/images/icones.svg#edit"></use></svg></a></span>
		    	</div>
	
				<div  class="showDetail">
					<span class="label"><spring:message code="label.dateEntree"/></span>
					<span class="data"><fmt:formatDate pattern="MM/dd/yyyy" value="${adherent.dateEntree}" /></span>
				</div>
		
				<div  class="showDetail">
					<span class="label"><spring:message code="label.role"/></span>
					<span class="data">${adherent.role.libelle}</span>
				</div>
				
				<div  class="showDetail"> 
					<span class="label"><spring:message code="label.formeJuridique"/></span>
					<span class="data">${adherent.formeJuridique.libelle}</span>
				</div>
			
				<div  class="showDetail">
					<span class="label"><spring:message code="label.siren"/></span>
					<span class="data">${adherent.siren}</span>
				</div>
				
				<div  class="showDetail">
					<span class="label"><spring:message code="label.siret"/></span>
					<span class="data">${adherent.siret}</span>
				</div>
				
				<div  class="showDetail">
					<span class="label"><spring:message code="label.ape"/></span>
					<span class="data">${adherent.ape.libelle}</span>
				</div>
				
				<div  class="showDetail">
					<span class="label"><spring:message code="label.numRepMetier"/></span>
					<span class="data">${adherent.numRepMetier}</span>
				</div>
				
				<div  class="showDetail">
			        <span class="label"><spring:message code="label.rcsRm"/></span>
					<span class="data">${adherent.rcsRm}</span>
				</div>
		
				<div  class="showDetail">
					<span class="label"><spring:message code="label.rcsCommune"/></span>
					<span class="data">${adherent.rcsCommune.libelle}</span>
				</div>
		
				<div  class="showDetail">
					<span class="label"><spring:message code="label.dateClotureExe"/></span>
					<span class="data"><fmt:formatDate pattern="MM/dd/yyyy" value="${adherent.dateClotureExe}" /></span>
				</div>
		
				<div  class="showDetail">
					<span class="label"><spring:message code="label.formationCommerce"/></span>
					<span class="data"><c:choose>
							<c:when test="${adherent.isFormationCommerce}"><spring:message code="yes"/></c:when> 
							<c:otherwise><spring:message code="no"/></c:otherwise> 
						</c:choose>
					</span>
				</div>
				
				<div  class="showDetail">
					<span class="label"><spring:message code="label.etat"/></span>
					<span class="data">${adherent.etat.libelle}</span>
				</div>
			</div>
		</div>
	</fieldset>
</div>
