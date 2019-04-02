<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<!-- <script src="resources/js/selectCommune.js"></script> -->
<!-- <script src="resources/js/jquery.js"></script> -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  

<!-- <div id="masque"> -->
<!-- 	Le contenu de cet élément est masqué au chargement de la page. -->
<!-- 	</div> -->

<!-- 	<a href="#" id="afficher">Afficher l'élément</a> -->

<form:form id="editAdherent" method="post" modelAttribute="adhToEdit" action="editAdherent">
	<form:input type="hidden" path="adherent.id"/>

	<div class="entete">
		<div class="photo">
			<img src="<c:url value="/resources/images/noAdh.png" />" />
		</div>
		<div>
			<h2>${adhToEdit.adherent.denomination}</h2>
			<div>
				<span class="label"><spring:message code="label.code"/></span>
				<span class="data" > ${adhToEdit.adherent.code} </span>
			</div>
		</div>
	</div>

	<fieldset>
	   	<legend><spring:message code="label.identite"/></legend>
	   	
	   	<div class="showDetail">
			<form:label path="adherent.code" ><spring:message code="label.libelle"/></form:label>
			<form:label path="adherent.code" >${adhToEdit.adherent.code}</form:label>
			<form:input type="hidden" name="adherent.code" path="adherent.code"/>
			<b><i><form:errors class="valeur" path="adherent.code" /></i></b>
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
			<form:label class="valeur"  id="communeAdhLibelle" path="adherent.commune" >${adhToEdit.adherent.commune.codePostal} - ${adhToEdit.adherent.commune.libelle}</form:label>
			<form:input id="communeAdh" type="hidden" path="adherent.commune.id"/>
			<form:input type="hidden" path="adherent.commune.codePostal"/>
			<form:input type="hidden" path="adherent.commune.libelle"/>
			<span><a href="#" id="editCommune"><svg><use xlink:href="resources/images/icones.svg#edit"></use></svg></a></span>
		</div>
	</fieldset>


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

	<fieldset>
	   	<legend><spring:message code="label.exploitation"/></legend>

		<div class="showDetail">
			<form:label path="adherent.agence"><spring:message code="label.agenceRattachement"/></form:label>
			<form:select class="valeur" name="adherent.agence" path="adherent.agence.id">
				<form:options items="${agenceList}" itemValue="id" itemLabel="libelle" />
			</form:select>					        
		</div>
	
		<div class="showDetail">
			<form:label path="adherent.secteur"><spring:message code="label.secteur"/></form:label>
			<form:select class="valeur" name="adherent.secteur" path="adherent.secteur.id">
				<form:options items="${secteurList}" itemValue="id" itemLabel="libelle" />
			</form:select>
<%-- 			<form:label class="valeur" path="adherent.secteur.libelle" >${adhToEdit.adherent.secteur.libelle}</form:label> --%>
		</div>

		<div class="showDetail">
			<form:label path="adherent.tournee"><spring:message code="label.tournee"/></form:label>
			<form:select class="valeur" name="adherent.tournee" path="adherent.tournee.id">
				<form:options items="${tourneeList}" itemValue="id" itemLabel="libelle" />
			</form:select>					        
		</div>

		<div class="showDetail">
			<form:label path="adherent.isOutilDechargement"><spring:message code="label.outilDechargement"/></form:label>
			<form:checkbox path="adherent.isOutilDechargement"/>
		</div>
	</fieldset>

	<fieldset>
	   	<legend><spring:message code="label.administratif"/></legend>

		<div class="showDetail">
			<form:label path="adherent.dateEntree"><spring:message code="label.dateEntree"/></form:label>
			<div>
			<form:input class="valeur" type="date" name="adherent.dateEntree" path="adherent.dateEntree"/>
			<form:errors class="errors" path="adherent.dateEntree" />
			</div>
		</div>
	
		<div class="showDetail">
			<form:label path="adherent.role" ><spring:message code="label.role"/></form:label>
			<form:select class="valeur" name="adherent.role" path="adherent.role.id">
				<form:options items="${roleList}" itemValue="id" itemLabel="libelle" />
			</form:select>
			<b><i><form:errors path="adherent.role" /></i></b>
		</div>
	
		<div class="showDetail"> 
			<form:label path="adherent.formeJuridique" ><spring:message code="label.formeJuridique"/></form:label>
			<form:select class="valeur" name="adherent.formeJuridique" path="adherent.formeJuridique.id">
				<form:options items="${formJuridList}" itemValue="id" itemLabel="libelle" />
			</form:select>
		</div>
		
		<div class="showDetail">
			<form:label path="adherent.siren" ><spring:message code="label.siren"/></form:label>
			<form:input class="valeur" name="adherent.siren" path="adherent.siren"/>
			<b><i><form:errors path="adherent.siren" /></i></b>
		</div>

		<div class="showDetail">
			<form:label path="adherent.siret" ><spring:message code="label.siret"/></form:label>
			<form:input class="valeur" name="adherent.siret" path="adherent.siret"/>
			<b><i><form:errors path="adherent.siret" /></i></b>
		</div>
	
		<div class="showDetail">
			<form:label path="adherent.ape" ><spring:message code="label.ape"/></form:label>
			<form:select class="valeur" name="adherent.ape" path="adherent.ape.id">
				<form:options items="${apeList}" itemValue="id" itemLabel="libelle" />
			</form:select>
		</div>

		<div class="showDetail">
			<form:label path="adherent.numRepMetier" ><spring:message code="label.numRepMetier"/></form:label>
			<form:input class="valeur" name="adherent.numRepMetier" path="adherent.numRepMetier"/>
			<b><i><form:errors path="adherent.numRepMetier" /></i></b>
		</div>

		<div class="showDetail">
			<form:label path="adherent.rcsRm" ><spring:message code="label.rcsRm"/></form:label>
			<form:input class="valeur" name="adherent.rcsRm" path="adherent.rcsRm"/>
			<b><i><form:errors path="adherent.rcsRm" /></i></b>
		</div>

		<div class="showDetail">
			<form:label path="adherent.rcsCommune" ><spring:message code="label.rcsCommune"/></form:label>
			<form:label class="valeur"  id="rcsCommuneLibelle" path="adherent.rcsCommune" >${adhToEdit.adherent.rcsCommune.codePostal} - ${adhToEdit.adherent.rcsCommune.libelle}</form:label>
			<form:input id="rcsCommune" type="hidden" path="adherent.rcsCommune.id"/>
			<form:input type="hidden" path="adherent.rcsCommune.libelle"/>
			<form:input type="hidden" path="adherent.rcsCommune.codePostal"/>
			<span><a href="#" id="editRcsCommune"><svg><use xlink:href="resources/images/icones.svg#edit"></use></svg></a></span>
		</div>
		
		<div class="showDetail">
			<form:label path="adherent.dateClotureExe"><spring:message code="label.dateClotureExe"/></form:label>
			<div>
			<form:input class="valeur" type="date" name="adherent.dateClotureExe" path="adherent.dateClotureExe"/>
			<form:errors class="errors" path="adherent.dateClotureExe" />
			</div>
		</div>
		
<!-- 		<div class="showDetail"> -->
<%-- 			<form:label path="adherent.contactComptable"><spring:message code="label.contactComptable"/></form:label> --%>
<%-- 			<form:input class="valeur" name="adherent.contactComptable" path="adherent.contactComptable"/> --%>
<%-- 			<b><i><form:errors path="adherent.contactComptable" /></i></b> --%>
<!-- 		</div> -->
		
		<div class="showDetail">
			<form:label path="adherent.isFormationCommerce" ><spring:message code="label.formationCommerce"/></form:label>
			<form:checkbox path="adherent.isFormationCommerce"/>
		</div>

		<div class="showDetail">
			<form:label path="adherent.etat" ><spring:message code="label.etat"/></form:label>
			<form:select class="valeur" name="adherent.etat" path="adherent.etat.id">
				<form:options items="${etatList}" itemValue="id" itemLabel="libelle" />
			</form:select>
		</div>

		
	</fieldset>

	<div>
		<button id="save" type="submit">Enregistrer</button>
		<c:url value="/showAdherent" var="url"><c:param name="idAdh" value="${adhToEdit.adherent.id}"/></c:url>
		<button id="cancel" type="reset" onClick="window.location='${url}'">Annuler</button>
	</div>

</form:form>

<div  id="dialogCommune" title="Selection de la commune" >
<%-- 		<form> --%>
		<span>commune actuel </span>
		<span id="currentCommune"></span></br>
		
		<span>recherche de la nouvelle </span>
		<span>saisir le code postal</span>
		<input id="filterCP" type="text" />
		<select id="communeListe" multiple></select>
<%-- 		</form> --%>
</div>

<script>
$( function() {
	communeDialog = $('#dialogCommune').dialog({
		resizable:false,
	    modal:true,
	    autoOpen:false,
	    height:400,
	    width:315,

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
		
		$.get("loadCommuneListe",params, function(response) {
			console.log("retour servlet : " + response.length);

			        $selectList = $("#communeListe");
			        $selectList.find("option").remove();  
			        $.each(JSON.parse(response), function(index, commune) {
				        $("<option>").val(commune.id).text(commune.libelle).appendTo($selectList);
			        });                   
			 
			    });
	}
	
//     var dialog, form,
 
//       // From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
//       emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,
//       name = $( "#name" ),
//       email = $( "#email" ),
//       password = $( "#password" ),
//       allFields = $( [] ).add( name ).add( email ).add( password ),
//       tips = $( ".validateTips" );
 
//     function updateTips( t ) {
//       tips
//         .text( t )
//         .addClass( "ui-state-highlight" );
//       setTimeout(function() {
//         tips.removeClass( "ui-state-highlight", 1500 );
//       }, 500 );
//     }
 
//     function checkLength( o, n, min, max ) {
//       if ( o.val().length > max || o.val().length < min ) {
//         o.addClass( "ui-state-error" );
//         updateTips( "Length of " + n + " must be between " +
//           min + " and " + max + "." );
//         return false;
//       } else {
//         return true;
//       }
//     }
 
//     function checkRegexp( o, regexp, n ) {
//       if ( !( regexp.test( o.val() ) ) ) {
//         o.addClass( "ui-state-error" );
//         updateTips( n );
//         return false;
//       } else {
//         return true;
//       }
//     }
 
//     function addUser() {
//       var valid = true;
//       allFields.removeClass( "ui-state-error" );
 
//       valid = valid && checkLength( name, "username", 3, 16 );
//       valid = valid && checkLength( email, "email", 6, 80 );
//       valid = valid && checkLength( password, "password", 5, 16 );
 
//       valid = valid && checkRegexp( name, /^[a-z]([0-9a-z_\s])+$/i, "Username may consist of a-z, 0-9, underscores, spaces and must begin with a letter." );
//       valid = valid && checkRegexp( email, emailRegex, "eg. ui@jquery.com" );
//       valid = valid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );
 
//       if ( valid ) {
//         $( "#users tbody" ).append( "<tr>" +
//           "<td>" + name.val() + "</td>" +
//           "<td>" + email.val() + "</td>" +
//           "<td>" + password.val() + "</td>" +
//         "</tr>" );
//         dialog.dialog( "close" );
//       }
//       return valid;
//     }
 
//     dialog = $( "#dialog-form" ).dialog({
//       autoOpen: false,
//       height: 400,
//       width: 350,
//       modal: true,
//       buttons: {
//         "Create an account": addUser,
//         Cancel: function() {
//           dialog.dialog( "close" );
//         }
//       },
//       close: function() {
//         form[ 0 ].reset();
//         allFields.removeClass( "ui-state-error" );
//       }
//     });
 
//     form = dialog.find( "form" ).on( "submit", function( event ) {
//       event.preventDefault();
//       addUser();
//     });
 
//     $( "#create-user" ).button().on( "click", function() {
//       dialog.dialog( "open" );
//     });
  } );
  </script>
</head>
<body>
 
