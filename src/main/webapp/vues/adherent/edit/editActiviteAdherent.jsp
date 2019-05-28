<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<link type="text/css" rel="stylesheet" href="/resources/style/style.css" />
<link type="text/css" rel="stylesheet" href="/resources/style/menu.css" />
        

<form:form id="editAdherent" method="post" modelAttribute="adhToEdit" action="editActiviteAdh">
	<form:input type="hidden" path="adherent.id"/>

	<div class="entete">
		<div class="photo">
			<img src="<c:url value="/resources/images/noAdh.png" />" />
		</div>
		<div>
			<h2>${adhToEdit.adherent.denomination}</h2>
			<div>
				<span class="label"><spring:message code="label.codeAdh"/></span>
				<span class="data" > ${adhToEdit.adherent.code} </span>
			</div>
		</div>
	</div>

<!-- Permet de ne pas perdre les données autre que celles modifié -->
	<form:input type="hidden" name="adherent.code" path="adherent.code"/>
	<form:input type="hidden" name="adherent.code" path="adherent.codeERP"/>
	<form:input type="hidden" name="adherent.libelle" path="adherent.libelle"/>
	<form:input type="hidden" name="adherent.denomination" path="adherent.denomination"/>
	<form:input type="hidden" name="adherent.adresse" path="adherent.adresse"/>
	<form:input type="hidden" name="adherent.adresseComplement" path="adherent.adresseComplement"/>
	<form:input type="hidden" path="adherent.commune.id"/>
<%-- 	<form:input type="hidden" path="adherent.pole.id"/> --%>
<%-- 	<form:input type="hidden" path="adherent.isArtipole"/> --%>
<%-- 	<form:input type="hidden" path="adherent.isCharteArtipole"/> --%>
<%-- 	<form:input type="hidden" path="adherent.isFlocageArtipole"/> --%>
<%-- 	<form:input type="hidden" path="adherent.isWebArtipole"/> --%>
<%-- 	<form:input type="hidden" path="adherent.isFacebookArtipole"/> --%>
	<form:input type="hidden" path="adherent.agence.id"/>
	<form:input type="hidden" path="adherent.secteur.id"/>
	<form:input type="hidden" path="adherent.tournee.id"/>
	<form:input type="hidden" path="adherent.isOutilDechargement"/>
	<form:input type="hidden" path="adherent.dateEntree"/>
	<form:input type="hidden" path="adherent.role.id"/>
	<form:input type="hidden" path="adherent.formeJuridique.id"/>
	<form:input type="hidden" path="adherent.siren"/>
	<form:input type="hidden" path="adherent.siret"/>
	<form:input type="hidden" path="adherent.ape.id"/>
	<form:input type="hidden" path="adherent.numRepMetier"/>
	<form:input type="hidden" path="adherent.rcsRm"/>
	<form:input type="hidden" path="adherent.rcsCommune.id"/>
	<form:input type="hidden" path="adherent.dateClotureExe"/>
	<form:input type="hidden" path="adherent.contactComptable"/>
	<form:input type="hidden" path="adherent.isFormationCommerce"/>
	<form:input type="hidden" path="adherent.etat.id"/>
	

	<fieldset>
	   	<legend><spring:message code="label.activite"/></legend>
	
		<div class="showDetail">
			<form:label path="adherent.pole" ><spring:message code="label.pole"/></form:label>
			<form:select class="valeur" name="adherent.pole" path="adherent.pole.id">
				<form:options items="${poleList}" itemValue="id" itemLabel="libelle" />
			</form:select>
			<b><i><form:errors path="adherent.pole" /></i></b>
		</div>

		<div  class="showDetail">
			<form:label path="adherent.isArtipole" ><spring:message code="label.adhArtipole"/></form:label>
			<form:checkbox path="adherent.isArtipole"/>
		</div>

		<div  class="showDetail">
			<form:label path="adherent.isArtipole" ><spring:message code="label.charteArtipole"/></form:label>
			<form:checkbox path="adherent.isCharteArtipole"/>
		</div>

		<div class="showDetail">
			<form:label path="adherent.isArtipole" ><spring:message code="label.flocageArtipole"/></form:label>
			<form:checkbox path="adherent.isFlocageArtipole"/>
		</div>

		<div class="showDetail">
			<form:label path="adherent.isArtipole" ><spring:message code="label.siteArtipole"/></form:label>
			<form:checkbox path="adherent.isWebArtipole"/>
		</div>

		<div class="showDetail">
			<form:label path="adherent.isArtipole" ><spring:message code="label.facebookArtipole"/></form:label>
			<form:checkbox path="adherent.isFacebookArtipole"/>
		</div>
	
	</fieldset>

	<div>
		<button id="save" type="submit">Enregistrer</button>
		<c:url value="/adherentActivite" var="url"><c:param name="idAdh" value="${adhToEdit.adherent.id}"/></c:url>
		<button id="cancel" type="reset" onClick="window.location='${url}'">Annuler</button>
	</div>

</form:form>
