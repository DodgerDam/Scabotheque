<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/style/style.css" />" />
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/style/menu.css" />" />
        <link rel="shortcut icon" type="image/png" href="/resources/images/favicon.png"/>
		<link REL="SHORTCUT ICON" href="http://www.votre-site-internet.com/images/favicon.ico">
        <title><spring:message code="titre.application"/></title>
    </head>
    <body>
        <div class="header">
        	<tiles:insertAttribute name="header" />
        	<tiles:insertAttribute name="menu-v2" />
        </div>    
    	<div class="body">
    	    <div class="content">    
    	    	<tiles:insertAttribute name="body" />
    	    	<c:if test = "${pageType == 'ADHERENT_DETAIL' || pageType == 'ADHERENT_ACTIVITE' || pageType == 'ADHERENT_EXPLOITATION' || pageType == 'ADHERENT_ADMINISTRATIF'}">
					<tiles:insertAttribute name="adherentBottomNavBar" />	
	    	   	</c:if>
    	    </div>    
    	</div>
    	<div class="footer">
    	   	<tiles:insertAttribute name="footer" />
	   	</div>
	</body>    
</html>    