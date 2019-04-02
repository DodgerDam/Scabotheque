<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- <div> -->
	<form method="post" action="listeAdherents">
		<div style="display:flex;">
			<div>
				<div>
					<input type="text" name="findString" placeholder="Texte à rechercher"  value=""/>
			<!-- 		<select name="metier"> -->
			<!-- 	        <option>Recherche un metier</option> -->
			<%-- 	        <c:forEach items="${adhMetierList}" var="metier"> --%>
			<%-- 		        <option value="${metier.libelle}" /> --%>
			<%-- 	        </c:forEach> --%>
			<!-- 	    </select> -->
				    <select name="pole">
				        <option value="0">pour un pole</option>
				        <c:forEach items="${polesList}" var="pole">
					        <option value="${pole.id}"> ${pole.libelle} </option>
				        </c:forEach>
				    </select>
				    <select name="secteur">
				        <option value="0">pour un secteur</option>
				        <c:forEach items="${secteursList}" var="secteur">
					        <option value="${secteur.id}"> ${secteur.libelle} </option>
				        </c:forEach>
				    </select>
			    </div>
			    <div>
					<spring:message code="count.adherent" arguments="${listeAdherents.size()}"/>
				</div>
			</div>
			<div>
				<button type="submit">Rechercher</button>
	<!-- 		<input type="submit" value="Rechercher"/> -->
		    </div>
		</div>
		
	</form>
<!-- </div> -->

<div id="listeAdherents">

	<c:forEach items="${listeAdherents}" var="adherent">
		<c:url value="/showAdherent" var="urlShowAdh"><c:param name="idAdh" value="${adherent.id}"/></c:url>
		<div class="list">
			<div class="photo">
				<img src="<c:url value="/resources/images/noAdh.png" />" />
			</div>
			<div class="detail">
					<a href="${urlShowAdh}"><h3><c:out value="${adherent.libelle}"/></h3></a>
				<div class="info">
					<div class="code">
						<span class="label"><spring:message code="label.code"/></span><span class="data"><c:out value="${adherent.code}"/></span>
			   	    	<span class="label"><spring:message code="label.pole"/></span><span class="data"><c:out value="${adherent.pole.libelle}"/></span>
			   	    	<span class="label"><spring:message code="label.role"/></span><span class="data"><c:out value="${adherent.role.libelle}"/></span>
			   	    </div>
					<div class="statut">
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
					    <span class="command"><a href="${urlShowAdh}"><svg><use xlink:href="resources/images/icones.svg#more"></use></svg></a></span>
<%-- 					    <c:url value="/editAdherent" var="url"><c:param name="idAdh" value="${adherent.id}"/></c:url> --%>
<%-- 					    <span class="command"><a href="${url}"><svg><use xlink:href="resources/images/icones.svg#edit"></use></svg></a></span> --%>
		   	    	</div>
	   	    	</div>
			</div>
		</div>
	</c:forEach>


<!-- 	<table id="adherents"> -->
<!-- 		<thead> -->
<!-- 			<tr> -->
<%-- 			    <th><spring:message code="colonne.identifiant"/></th> --%>
<%-- 			    <th><spring:message code="colonne.libelle"/></th> --%>
<%-- 			    <th><spring:message code="colonne.adresse"/></th> --%>
<%-- 			    <th><spring:message code="colonne.secteur"/></th> --%>
<%-- 			    <th><spring:message code="colonne.pole"/></th> --%>
<!-- 			    <th class="link"></th> -->
<!-- 			    <th class="link"></th> -->
<!-- 			    <th class="link"></th> -->
<!-- 			</tr> -->
<!-- 		</thead> -->
	
<!-- 	    <tbody> -->
<%-- 	        <c:forEach items="${listeAdherents}" var="adherent"> --%>
<!-- 	            <tr> -->
<%-- 	                <td><c:out value="${adherent.code}"/></td> --%>
<%-- 	                <td><c:out value="${adherent.libelle}"/></td> --%>
<%-- 	                <td><c:out value="${adherent.adresse}"/></td> --%>
<%-- 	                <td><c:out value="${adherent.secteur.libelle}"/></td> --%>
<%-- 	                <td><c:out value="${adherent.pole.libelle}"/></td> --%>
<!-- 	                <td> -->
<%-- 					    <c:url value="/showAdherent" var="url"><c:param name="idAdh" value="${adherent.id}"/></c:url> --%>
<%-- 					    <a href="${url}"><svg><use xlink:href="resources/images/icones.svg#more"></use></svg></a> --%>
<!-- 					</td> -->
<!-- 					<td> -->
<%-- 					    <c:url value="/editAdherent" var="url"><c:param name="idAdh" value="${adherent.id}"/></c:url> --%>
<%-- 					    <a href="${url}"><svg><use xlink:href="resources/images/icones.svg#edit"></use></svg> --%>
<!-- 					</td> -->
<!-- 	            </tr> -->
<%-- 	        </c:forEach> --%>
<!-- 		</tbody> -->
<!-- 	</table> -->
</div>
