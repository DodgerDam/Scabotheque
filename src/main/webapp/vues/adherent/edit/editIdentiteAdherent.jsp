<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<form:form id="editAdherent" method="post" modelAttribute="adhToEdit" action="editIdentiteAdh">
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
<%-- 	<form:input type="hidden" name="adherent.code" path="adherent.code"/> --%>
<%-- 	<form:input type="hidden" name="adherent.libelle" path="adherent.libelle"/> --%>
<%-- 	<form:input type="hidden" name="adherent.denomination" path="adherent.denomination"/> --%>
<%-- 	<form:input type="hidden" name="adherent.adresse" path="adherent.adresse"/> --%>
<%-- 	<form:input type="hidden" name="adherent.adresseComplement" path="adherent.adresseComplement"/> --%>
<%-- 	<form:input type="hidden" path="adherent.commune.id"/> --%>
	<form:input type="hidden" path="adherent.pole.id"/>
	<form:input type="hidden" path="adherent.isArtipole"/>
	<form:input type="hidden" path="adherent.isCharteArtipole"/>
	<form:input type="hidden" path="adherent.isFlocageArtipole"/>
	<form:input type="hidden" path="adherent.isWebArtipole"/>
	<form:input type="hidden" path="adherent.isFacebookArtipole"/>
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
	   	<legend><spring:message code="label.identite"/></legend>
	   	
	   	<div class="showDetail">
			<form:label path="adherent.code" ><spring:message code="label.codeAdh"/></form:label>
			<form:label path="adherent.code" >${adhToEdit.adherent.code}</form:label>
			<form:input type="hidden" name="adherent.code" path="adherent.code"/>
			<b><i><form:errors class="valeur" path="adherent.code" /></i></b>
		</div>

	   	<div class="showDetail">
			<form:label path="adherent.codeERP" ><spring:message code="label.codeERP"/></form:label>
			<form:input class="valeur" name="adherent.codeERP" path="adherent.codeERP"/>
			<b><i><form:errors class="valeur" path="adherent.codeERP" /></i></b>
		</div>
		
		<div class="showDetail">
			<form:label path="adherent.libelle" ><spring:message code="label.libelle"/></form:label>
			<form:input class="valeur" name="adherent.libelle" path="adherent.libelle"/>
			<b><i><form:errors class="valeur" path="adherent.libelle" /></i></b>
		</div>
		
		<div class="showDetail">
			<form:label path="adherent.denomination" ><spring:message code="label.denomination"/> </form:label>
			<form:input class="valeur" name="adherent.denomination" path="adherent.denomination"/>
			<b><i><form:errors class="valeur" path="adherent.denomination" /></i></b>
		</div>

		<div class="showDetail">
			<form:label path="adherent.adresse" ><spring:message code="label.adresse"/></form:label>
			<form:input class="valeur" name="adherent.adresse" path="adherent.adresse"/>
			<b><i><form:errors class="valeur" path="adherent.adresse" /></i></b>
		</div>

		<div class="showDetail">
			<form:label path="adherent.adresseComplement" ><spring:message code="label.adresseComplement"/></form:label>
			<form:input class="valeur" name="adherent.adresseComplement" path="adherent.adresseComplement"/>
			<b><i><form:errors class="valeur" path="adherent.adresseComplement" /></i></b>
		</div>
		
		<div class="showDetail">
			<form:label path="adherent.commune" ><spring:message code="label.commune"/></form:label>
			<form:label id="communeAdhLibelle" path="adherent.commune" class="valeur" >${adhToEdit.adherent.commune.codePostal} - ${adhToEdit.adherent.commune.libelle}</form:label>
			<form:input id="communeAdh" type="hidden" path="adherent.commune.id"/>
			<form:input type="hidden" path="adherent.commune.codePostal"/>
			<form:input type="hidden" path="adherent.commune.libelle"/>
			<span><a href="#" id="editCommune"><svg><use xlink:href="<c:url value="/resources/images/icones.svg#edit"/>"></use></svg></a></span>
		</div>
	</fieldset>

	<div class="editButton">
		<button id="save" type="submit">Enregistrer</button>
		<c:url value="/adherentDetail" var="url"><c:param name="idAdh" value="${adhToEdit.adherent.id}"/></c:url>
		<button id="cancel" type="reset" onClick="window.location='${url}'">Annuler</button>
	</div>

</form:form>

<div id="overlay"></div>
<div  id="dialogCommune" title="Selection de la commune" >

	<span>Recherche de la commune:</span>
	<input id="filterCP" type="text" placeholder="Code postale ou Nom"  />
	<br>
	<select id="communeListe" class="communeListe" multiple >
		<option value="" >trop de résultat</option>
	</select>

</div>

<script>
$( function() {
	communeDialog = $('#dialogCommune').dialog({
		
		show: "fade",
        hide: "fade",
        resizable: false,
        autoOpen: false,
	    modal: true,

	    buttons: {
	    	"Selectionner" : function() {
	        	$("#communeAdh").val($('#communeListe :selected').val());
	        	$("#communeAdhLibelle").text($('#communeListe :selected').text());
				$(this).dialog("close");
				return true;
	        },
	        "Annuler" : function() {
	        	$(this).dialog("close");
				return false;
	        }
	      }
	    });
	
	$('#currentCommune').text($('#communeAdhLibelle').text());
	  
	$('#editCommune').click(function(e){ 
		communeDialog.dialog("open");
	});
	
	$('#filterCP').bind("keyup", function(){
		populateListe();
	});
	  
	
	function populateListe(){
 		var params={filter: $("#filterCP").val()};
 		console.log (params);
		
		$.get("/scabotheque/loadCommuneListe",params, function(response) {
			console.log("retour servlet : " + response.length);
	        $selectList = $("#communeListe");
	        $selectList.find("option").remove();  
	        $.each(JSON.parse(response), function(index, commune) {
		        $("<option>").val(commune.id).text(commune.libelle).appendTo($selectList);
	        });                   
		});
	}
  } );
  </script>
<!-- </head> -->
<!-- <body> -->
 
