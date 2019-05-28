<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  
<form:form id="editAdherentContact" method="post" modelAttribute="contactToEdit" action="editAdherentContact" >
	<div class="entete">
				
		<div class="photo">
			<img src="<c:url value="/resources/images/noAdh.png" />" />
		</div>
		<div>
			<h2>${adherent.denomination}</h2>
			<div>
				<span class="label"><spring:message code="label.codeAdh"/></span>
				<span class="data" > ${adherent.code} </span>
			</div>
		</div>
	</div>

	<fieldset>
	   	<legend><spring:message code="label.contacts"/></legend>

			
			<c:forEach items="${contactToEdit.adherentContacts}" var="adherentContacts" varStatus="status">
			
				<div>
					<c:out value="${adherentContacts.type.libelle}"/>
				</div>
				<div class="showDetail">
					
					<!-- Permet de ne pas perdre les données autre que celles modifié -->
					<form:input type="hidden" path="adherentContacts[${status.index}].id"/>
					<form:input type="hidden" path="adherentContacts[${status.index}].adherentId"/>
					<form:input type="hidden" path="adherentContacts[${status.index}].type.libelle"/>
					<form:input type="hidden" path="adherentContacts[${status.index}].typeContactId"/>
				
					<form:select class="valeur" path="adherentContacts[${status.index}].civilite" >
						<form:option  value="Mr">Mr</form:option>
						<form:option  value="Mme">Mme</form:option>
					</form:select>
				
					<spring:message code="label.nom" var="message"/>
					<form:input class="valeur" path="adherentContacts[${status.index}].nom" placeholder="${message}"/>

					<spring:message code="label.prenom" var="message"/>
					<form:input class="valeur" path="adherentContacts[${status.index}].prenom" placeholder="${message}"/>
				
					<spring:message code="label.mail" var="message"/>
					<form:input class="valeur" path="adherentContacts[${status.index}].mail" placeholder="${message}"/>

					<spring:message code="label.fixe" var="message"/>
					<form:input class="valeur" path="adherentContacts[${status.index}].fixe" placeholder="${message}"/>
					
					<spring:message code="label.mobile" var="message"/>
					<form:input class="valeur" path="adherentContacts[${status.index}].mobile" placeholder="${message}"/>
					
				</div>
				<div><b><i><form:errors class="valeur" path="adherentContacts[${status.index}].nom" escape="false"/></i></b></div>
				<div><b><i><form:errors class="valeur" path="adherentContacts[${status.index}].prenom" /></i></b></div>
				<div><b><i><form:errors class="valeur" path="adherentContacts[${status.index}].mail" /></i></b></div>
				<div><b><i><form:errors class="valeur" path="adherentContacts[${status.index}].fixe" /></i></b></div>
		</c:forEach>
	</fieldset>

	<div class="editButton">
		<button id="copieAll" type="button">Copier le premier dans tous les contacts</button>
		<button id="save" type="submit">Enregistrer</button>
		<c:url value="/adherentDetail" var="url"><c:param name="idAdh" value="${adherent.id}"/></c:url>
		<button id="cancel" type="reset" onClick="window.location='${url}'">Annuler</button>
	</div>

</form:form>

<script>
$(function() {
	
	$('#copieAll').click(function(e){ 
		console.log ("c'est bien, t'as cliqué ... ");
		
		console.log($("#adherentContacts0\\.nom").val());
		$("input[id*='\\.nom']").val($("#adherentContacts0\\.nom").val());
		$("input[id*='\\.prenom']").val($("#adherentContacts0\\.prenom").val());
		$("input[id*='\\.mail']").val($("#adherentContacts0\\.mail").val());
		$("input[id*='\\.fixe']").val($("#adherentContacts0\\.fixe").val());
		$("input[id*='\\.mobile']").val($("#adherentContacts0\\.mobile").val());

// 		$test = $("input[id*='\\.nom']");
// 		console.log ("test : " + $test.val());
	
// 		$test.val("LE NOM");
		
	});
		
  } );
  </script>
<!-- </head> -->
<!-- <body> -->
 
