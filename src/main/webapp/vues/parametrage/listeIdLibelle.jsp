<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form:form method="post" action="parametrage">
	<div style="display:flex;">
		<div>
			<input type="text" name="findString" placeholder="Texte à rechercher"  value=""/>
			<spring:message code="count.adherent" arguments="${listIdLib.list.size()}"/>
		</div>
		<div>
			<button type="submit">Rechercher</button>
	    </div>
	</div>
	
</form:form>

<div id="listeIdLibelle">
	<form:form method="post" modelAttribute="creation" action="ajout${pageLink}" id="type" value="agence">
		<spring:message code="label.libelle" />
        <form:input path="libelle"/>
        <b><i><form:errors path="libelle" cssclass="error"/></i></b><br>
        <input type="submit"/>
    </form:form>

	<form:form method="post" modelAttribute="editList" action="edit${pageLink}">
		<div class="showDetail">
			<span class="label"><spring:message code="label.libelle"/></span>
	
			<c:forEach items="${editList.list}" var="idLibelle" varStatus="status">
					<div>
						<form:input type="hidden" name="list[${status.index}].id" path="list[${status.index}].id"/>
<%-- 						<form:errors class="errors" path="list[${status.index}].id" /> --%>
					</div>
				
					<div class="showDetail">
						<form:input class="valeur" name="list[${status.index}].libelle" path="list[${status.index}].libelle"/> 
						<c:url value="/supprime${pageLink}" var="url"><c:param name="id" value="${idLibelle.id}"/></c:url>
						<a href="${url}"><spring:message code="suppression.supprimer.libelle" /></a>
						<form:errors class="errors" path="list[${status.index}].libelle" />
					</div>
				
			</c:forEach>
		</div>
		<div class="editButton">
			<input type="submit">
	    </div>
	</form:form>
	
</div>
