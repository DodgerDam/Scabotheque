<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<form:form id="recherche" method="post" modelAttribute="criteria" action="listeAdherents">
	<div style="display:flex;">
		<div style="flex:1;">
			<div>
				<form:input type="text" path="text" placeholder="Texte à rechercher" autofocus="true"/>
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

			    <form:checkbox id="isActif" path="isActif"  /> 
			    <label style="float:none" for="isActif">Afficher les inactifs</label>
		        
		    </div>
		    <div>
				<spring:message code="count.adherent" arguments="${listeAdherents.size()}"/>
			</div>
		</div>
		<div>
			<button type="submit">Rechercher</button>
<!-- 			<button type="submit" style="min-width:10px">.</button> -->
			<c:url value="/downloadFile" var="urlDownload">
				<c:param name="findText" value="${criteria.text}"/>
				<c:param name="poleId" value="${criteria.poleId}"/>
				<c:param name="secteurId" value="${criteria.secteurId}"/>
				<c:param name="isActif" value="${criteria.isActif}"/>
			</c:url>
			<a href="${urlDownload}">Exporter</a> <!--  le resultat de la recherche au format Excel</a> --> 
						
	    </div>
	</div>
</form:form>

<%-- <c:url value="/downloadFile" var="urlDownload"> --%>
<%-- 	<c:param name="findText" value="${criteria.text}"/> --%>
<%-- 	<c:param name="poleId" value="${criteria.poleId}"/> --%>
<%-- 	<c:param name="secteurId" value="${criteria.secteurId}"/> --%>
<%-- 	<c:param name="isActif" value="${criteria.isActif}"/> --%>
<%-- </c:url> --%>
<%-- <a href="${urlDownload}"> Exporter le resultat de la recherche au format Excel </a> --%>


<div id="listeAdherents">

	<c:forEach items="${listeAdherents}" var="adherent">
		<div class="list">
			<div class="photo">
				<img src="<c:url value="/resources/images/noAdh.png" />" />
			</div>
			<div class="detail">
					<c:url value="/adherentDetail" var="urlShowAdh"><c:param name="idAdh" value="${adherent.id}"/></c:url>
					<a href="${urlShowAdh}"><h3><c:out value="${adherent.libelle}"/></h3></a>
				<div class="info">
					<div class="code">
						<span class="label"><spring:message code="label.codeAdh"/></span><span class="data"><c:out value="${adherent.code}"/></span>
			   	    	<span class="label"><spring:message code="label.pole"/></span><span class="data"><c:out value="${adherent.pole.libelle}"/></span>
			   	    	<span class="label"><spring:message code="label.role"/></span><span class="data"><c:out value="${adherent.role.libelle}"/></span>
			   	    </div>
					<div class="statut">
						<span class="label"><spring:message code="label.codeERP"/></span><span class="data"><c:out value="${adherent.codeERP}"/></span>
						<span class="label"><spring:message code="label.agenceRattachement"/></span><span class="data"><c:out value="${adherent.agence.libelle}"/></span>
			   	    	<div class="etatAdh">
			   	    		<span class="label"><spring:message code="label.etat"/></span><span class="data"><c:out value="${adherent.etat.libelle}"/></span>
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
