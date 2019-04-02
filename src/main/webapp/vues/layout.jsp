<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link type="text/css" rel="stylesheet" href="resources/style/style.css" />
        <link type="text/css" rel="stylesheet" href="resources/style/menu.css" />
        <title><spring:message code="titre.application"/></title>
    </head>
    <body>
        <div class="header">
        	<tiles:insertAttribute name="header" />
        	<tiles:insertAttribute name="menu-v2" />
        </div>    
    	<div class="body">
<!--     	    <div class="menu"> -->
<%--     	    	<tiles:insertAttribute name="menu" /> --%>
<!--     	    </div>     -->
    	    <div class="content">    
    	    	<tiles:insertAttribute name="body" />
    	    </div>    
    	</div>
    	<div class="footer">
    	   	<tiles:insertAttribute name="footer" />
    	</div>    
	    
</body>    
</html>    