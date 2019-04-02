<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id=header>
	<div  class="logo">
		<img src="<c:url value="/resources/images/Scabotheques.png" />"  alt="Scabotheque" />
	</div>
	<div class="identification">
	    <form:form action="login" method="post">
	        <fieldset>
	            <div>
	                <label for="username">Utilisateur</label>
	                <input type="text" id="username" name="Utilisateur" placeholder="Utilisateur" required="required" autofocus="autofocus" />
	            </div>
	
	            <div>
	                <label for="password">Mot de passe</label>
	                <input type="password" id="password" name="Mot de passe" placeholder="Mot de passe" required="required" />
	            </div>
	
	            <div>
	                <input type="submit" value="Connexion" />
	            </div>
	
	            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	        </fieldset>
	    </form:form>
	</div>
</div>
	