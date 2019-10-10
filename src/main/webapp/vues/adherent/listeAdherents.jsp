<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<form:form  method="post" modelAttribute="criteria" action="listeAdherents">
	<form:input type="hidden" name="sender" path="sender"/>
	<form:input type="hidden" name="object" path="object"/>
	<form:input type="hidden" name="messageMail" path="messageMail"/>
	<form:input type="hidden" name="contactFonctionIds" path="contactFonctionIds"/>

	<div class="listAdherent-recherche">
		<div class="listAdherent-recherche-criteres">
			<div>

				<spring:message code="label.texteRecherche" var="recherchePH"/>
				<form:input type="text" path="text" placeholder="${recherchePH}" autofocus="true"/>
<%-- 					<form:select class="valeur" name="metier" path="metier"> --%>
<%-- 						<form:options items="${adhMetierList}" itemValue="id" itemLabel="libelle" /> --%>
<%-- 					</form:select> --%>
				<form:select name="poleId" path="poleId">
					<form:option value="0" label="- Pole -" />
					<form:options items="${polesList}" itemValue="id" itemLabel="libelle" />
				</form:select>
				<form:select name="secteurId" path="secteurId">
					<form:option value="0" label="- Secteur -"  />
					<form:options items="${secteursList}" itemValue="id" itemLabel="libelle" />
				</form:select>
				
<!-- 				<div> -->
			    	<form:checkbox id="showAll" name="showAll" path="showAll"/> 
			    	<label style="float:none;" for="showAll">Afficher les inactifs</label>
			    	<form:checkbox id="showSousCompte" name="showSousCompte" path="showSousCompte"/> 
			    	<label style="float:none;" for="showSousCompte">Afficher les sous comptes</label>
<!-- 			    </div> -->
<!-- 			    <div> -->
<%-- 			    	<form:checkbox id="showSousCompte" name="showSousCompte" path="showSousCompte"/>  --%>
<!-- 			    	<label style="float:none;" for="showSousCompte">Afficher les sous comptes</label> -->
<!-- 			    </div> -->
		    </div>
		    <div>
				<spring:message code="count.adherent" arguments="${listeAdherents.size()}"/>
			</div>
			<div <c:if test = "${criteria.avertissement == ''}"> style="display: none;" </c:if> >
				${criteria.avertissement}
			</div>
			
		</div>
		<div class="listAdherent-recherche-button">
			
			<button class="action-button" type="submit">Rechercher</button>
			<c:url value="/downloadFile" var="urlDownload">
				<c:param name="findText" value="${criteria.text}"/>
				<c:param name="poleId" value="${criteria.poleId}"/>
				<c:param name="secteurId" value="${criteria.secteurId}"/>
				<c:param name="showAll" value="${criteria.showAll}"/>
				<c:param name="showAll" value="${criteria.showSousCompte}"/>
			</c:url>
			
			<sec:authorize access="hasAnyRole('ROLE_MAILING','ROLE_EXPORT')">
				<div class="scabotheque-dropdown">
					<button id="btnMenu" type="button" class="scabotheque-dropdown-btn" onclick="openMenu()">
						<svg class="scabotheque-dropdown-btn-icon" ><use xlink:href="<c:url value="/resources/images/icones.svg#menu"/>"></use></svg>
					</button>
				    <div id="listAdhMenu" class="scabotheque-dropdown-container">
						<sec:authorize access="hasRole('ROLE_EXPORT')">
					    	<div class="scabotheque-dropdown-item">
						      	<a href="${urlDownload}" id="exportExcel">
						      		<svg class="scabotheque-dropdown-item-icon" ><use xlink:href="<c:url value="/resources/images/icones.svg#excel"/>"></use></svg>
									<spring:message code="menu.exportExcel"/>
								</a>
							</div>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_MAILING')">
							<div class="scabotheque-dropdown-item">
			 			   		<a href="#" id="mailingLink">
							   		<svg class="scabotheque-dropdown-item-icon" ><use xlink:href="<c:url value="/resources/images/icones.svg#mail"/>"></use></svg>
									<spring:message code="menu.mailing"/>
								</a>
							</div>
						</sec:authorize>
					</div>
				</div>
			</sec:authorize>
	    </div>
	</div>
</form:form>

<form:form id="mailingForm" method="post" modelAttribute="criteria" action="sendMail">
	<form:input type="hidden" name="adherentIds" path="adherentIds"/>
	<form:input type="hidden" name="text" path="text"/>
	<form:input type="hidden" name="poleId" path="poleId"/>
	<form:input type="hidden" name="secteurId" path="secteurId"/>
	<form:input type="hidden" name="showAll" path="showAll"/>

	<div id="editor" style="display:grid; border: 1px solid #82aa37; border-radius: 0.4em; margin: 0.2em; padding: 0.4em;">
		<spring:message code="label.mail.note"/>
		
		<span class="displayInline">
						Dirigeant : <form:checkbox path="mailingDirigeant" /> 
<!-- 					</span> -->

<!-- 					<span class="displayInline"> -->
						Commercial : <form:checkbox path="mailingCommerce" /> 
<!-- 					</span> -->
						
<!-- 					<span class="displayInline"> -->
						Administratif : <form:checkbox path="mailingAdministratif"/>  
<!-- 					</span> -->
						
<!-- 					<span class="displayInline"> -->
						Compta : <form:checkbox path="mailingCompta"/> 
		   	    	</span>
		
<%-- 		<form:select name="contactFonctionIds" path="contactFonctionIds" multiple="true"> --%>
<%-- 			<form:options items="${contactFonctionList}" itemValue="id" itemLabel="libelle" /> --%>
<%-- 		</form:select> --%>
		
		<spring:message code="label.mail.expediteur" var="expediteurPH"/>
		<form:input type="text" path="sender" placeHolder="${expediteurPH}"/>
		
		<spring:message code="label.mail.objet" var="objetPH"/>
		<form:input type="text" path="object" placeHolder="${objetPH}"/>
		
		<!-- Create the editor container -->
		<spring:message code="label.mail.message" var="messagePH"/>
		<form:textarea id="summernote" name="editordata" path="messageMail"  placeholder="${messagePH }"/>
			
		<div>
			<button class="action-button"  type="submit">Envoyer</button>
		</div>
	
	</div>
</form:form>

<div class="listeAdherents">
	<c:forEach items="${listeAdherents}" var="adherent">
		<div class="adherents-item">
			<div class="photo">
				<c:choose >
					<c:when test = "${adherent.photoImg == ''}"> 
						<img src="<c:url value="/resources/images/noAdh.png" />" />
					</c:when>
					<c:otherwise> 						
						<img src="${adherent.photoImg}">
					</c:otherwise>
				</c:choose>
			</div>
			<div class="detail">
					<c:url value="/adherentDetail" var="urlShowAdh"><c:param name="idAdh" value="${adherent.id}"/></c:url>
					<a href="${urlShowAdh}" class="scabotheque-h3"><c:out value="${adherent.libelle}"/></a>
				<div class="info">
					<div class="code">
						<span class="adherentLabel"><spring:message code="label.codeAdh"/></span><span class="data"><c:out value="${adherent.code}"/></span>
			   	    	<span class="adherentLabel"><spring:message code="label.pole"/></span><span class="data"><c:out value="${adherent.pole.libelle}"/></span>
			   	    	<span class="adherentLabel"><spring:message code="label.role"/></span><span class="data"><c:out value="${adherent.role.libelle}"/></span>
			   	    </div>
					<div class="statut">
						<span class="adherentLabel"><spring:message code="label.codeERP"/></span><span class="data"><c:out value="${adherent.codeERP}"/></span>
						<span class="adherentLabel"><spring:message code="label.agenceRattachement"/></span><span class="data"><c:out value="${adherent.agence.libelle}"/></span>
			   	    	<div class="etatAdh">
			   	    		<span class="adherentLabel"><spring:message code="label.etat"/></span><span class="data"><c:out value="${adherent.etat.libelle}"/></span>
			   	    		<c:choose >
				   	    		<c:when test = "${adherent.etat.id == '1'}"> 
									<div class="cercleVert"></div>
								</c:when>
				   	    		<c:when test = "${adherent.etat.id == '2'}"> 
									<div class="cercleRouge"></div>
								</c:when>
			   	    		</c:choose>
			   	    		 
			   	    	</div>
		   	    	</div>
					<div class="raccourcis">
					    <span class="command"><a href="${urlShowAdh}">
					    <svg <c:if test = "${empty adherent.contacts}">style="fill:red"</c:if>><use xlink:href="resources/images/icones.svg#contact"></use></svg></a></span>
					    <span class="command"><a href="${urlShowAdh}"><svg><use xlink:href="resources/images/icones.svg#more"></use></svg></a></span>
		   	    	</div>
	   	    	</div>
			</div>
		</div>
	</c:forEach>
</div>

<script>
$(document).ready(function() {
	  $('#summernote').summernote({
	 		placeholder: '<spring:message code="label.mail.message"/>',
	 		tabsize: 2,
	 		height: 150
		  
	  });
	  
	});
	
// 	$('#summernote').summernote({
// 		placeholder: 'Hello stand alone ui',
// 		tabsize: 4,
// 		height: 100
// 	});

	$( function() {
		$('#btnMenu').click(function(e){ 
			$( "#listAdhMenu" ).toggle( 'slow' );
		});
		
		$('#exportExcel').click(function(e){ 
			$( "#listAdhMenu" ).toggle( 'slow' );
		});
	
		$('#mailingLink').click(function(e){ 
			$( "#listAdhMenu" ).toggle( 'slow' );
			$( "#mailingForm" ).toggle( 'slow' );
		});
	});
</script>
