<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<div class="scroll-stop navbar" id="navbar">

	<!-- 	Menu Adherents -->
	<c:url value="/listeAdherents" var="urlListe" />
	<c:url value="/addAdherent" var="urlAdd" />
	<div class="dropdown <c:if test = "${pageType == 'LIST_ADHERENT'}">active</c:if>">
	    <a href="#"> 
			<svg class="icon" ><use xlink:href="resources/images/icones.svg#card-v2"></use></svg>
			<spring:message code="menu.listeadherent"/> 
			<i class="fa fa-caret-down"></i>
	    </a>
	    <div id="drop" class="scroll-stop dropdown-content">
	      	<a href="${urlListe}" class="navbar first-element <c:if test = "${pageType == 'LIST_ADHERENT'}"> active </c:if>">
	      		<svg class="icon" ><use xlink:href="resources/images/icones.svg#card-v2"></use></svg>
				<spring:message code="menu.listeadherent"/> <i class="fa fa-caret-down"></i>
			</a>
	   		<a href="${urlAdd}">
		   		<svg class="icon" ><use xlink:href="resources/images/icones.svg#card-add"></use></svg>
				<spring:message code="menu.addadherent"/>
			</a>
		</div>
	</div> 
	
	<!-- 	Menu Fournisseur sans menu déroulant -->
	<c:url value="/enCours" var="url" />
	<a <c:if test = "${pageType == 'GESTION_FOURNISSEUR'}"> class="active"</c:if> href="${url}">
		<svg class="icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
		<spring:message code="menu.gestionFournisseur"/>
	</a>
	
	
	<!-- 	Fichiers partagés -->
	<div class="dropdown">
	    <a href="#" class="navbar"> 
			<svg class="icon" ><use xlink:href="resources/images/icones.svg#excel"></use></svg>
			<spring:message code="menu.shareFiles"/>
			<i class="fa fa-caret-down"></i>
	    </a>
	    <div class="scroll-stop dropdown-content">
	      	<a class="navbar first-element"> 
				<svg class="icon" ><use xlink:href="resources/images/icones.svg#excel"></use></svg>
				<spring:message code="menu.shareFiles"/>
				<i class="fa fa-caret-down"></i>
		    </a>
			<a href=<c:url value="https://scabois-my.sharepoint.com/:x:/g/personal/dslowensky_scabois_onmicrosoft_com/Ea2sNJqVMptPhJSnvU_-UqoBqd2XJ9hZ7XXdXMGowEI_tA?e=OBvmRq"/> target="_blank">
				<svg class="icon"><use xlink:href="resources/images/icones.svg#excel"></use></svg>
				<spring:message code="menu.testExcel"/>
			</a>
	     </div>
	</div> 
	
	<!-- 	Liens Utiles -->
	<div class="dropdown">
	    <a href="#" class="navbar"> 
			<svg class="icon" ><use xlink:href="resources/images/icones.svg#card-v2"></use></svg>
			<spring:message code="menu.gestionLiensUtils"/>
			<i class="fa fa-caret-down"></i>
	    </a>
	    <div class="scroll-stop dropdown-content">
	      	<a class="navbar first-element">
	      		<svg class="icon" ><use xlink:href="resources/images/icones.svg#card-v2"></use></svg>
				<spring:message code="menu.gestionLiensUtils"/> <i class="fa fa-caret-down"></i>
			</a>
	   		<a href=<c:url value="http://srvoutils/ScaboisWiki/doku.php?id=start"/> target="_blank">
				<svg class="icon" ><use xlink:href="resources/images/icones.svg#wiki"></use></svg>
				<spring:message code="menu.wiki"/>
			</a>
			<a href=<c:url value="http://adherents.scabois.fr"/> target="_blank">
				<svg class="icon"><use xlink:href="resources/images/icones.svg#book"></use></svg>
				<spring:message code="menu.openWeb"/>
			</a>
			<a href=<c:url value="https://questionnaire.dfiweb.net/"/> target="_blank">
				<svg class="icon"><use xlink:href="resources/images/icones.svg#questionnaire"></use></svg>
				<spring:message code="menu.defiWeb"/>
			</a>
			<a href=<c:url value="http://orcab.net/"/> target="_blank">
				<svg class="icon"><use xlink:href="resources/images/icones.svg#modus"></use></svg>
				<spring:message code="menu.electromenager"/>
			</a>
			<a href=<c:url value="https://www.facebook.com/ArtipoleDoleChoisey/"/> target="_blank">
				<svg class="icon"><use xlink:href="resources/images/icones.svg#facebook"></use></svg>
				<spring:message code="menu.facebook"/>
			</a>
		</div>
	</div> 

	<!-- 	Parametrage des tables de bases -->
	<c:url value="/parametrage" var="urlParamAgence"><c:param name="type" value="Agence"/></c:url>
	<c:url value="/parametrage" var="urlParamMetier"><c:param name="type" value="Activite"/></c:url>
	<c:url value="/parametrage" var="urlParamPole"><c:param name="type" value="Pole"/></c:url>
	<c:url value="/parametrage" var="urlParamRole"><c:param name="type" value="Role"/></c:url>
	<c:url value="/parametrage" var="urlParamSecteur"><c:param name="type" value="Secteur"/></c:url>
	<c:url value="/parametrage" var="urlParamVille"><c:param name="type" value="Ville"/></c:url>
	<div class="dropdown">
	    <a class="navbar"> 
			<svg class="icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
			<spring:message code="menu.parametrage"/>
			<i class="fa fa-caret-down"></i>
	    </a>
	    <div class="scroll-stop dropdown-content">
		    <a class="navbar first-element"> 
				<svg class="icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
				<spring:message code="menu.parametrage"/>
				<i class="fa fa-caret-down"></i>
		    </a>
			<a href="${urlParamAgence}">
				<svg class="icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
				<spring:message code="menu.paramAgence"/>
			</a>
			<a href="${urlParamMetier}">
				<svg class="icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
				<spring:message code="menu.paramActivite"/>
			</a>
			<a href="${urlParamPole}">
				<svg class="icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
				<spring:message code="menu.paramPole"/>
			</a>
			<a href="${urlParamRole}">
				<svg class="icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
				<spring:message code="menu.paramPole"/>
			</a>
			<a href="${urlParamSecteur}">
				<svg class="icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg>
				<spring:message code="menu.paramSecteur"/>
			</a>
<%-- 			<a href="${urlParamVille}"> --%>
<!-- 				<svg class="icon" ><use xlink:href="resources/images/icones.svg#supply"></use></svg> -->
<%-- 				<spring:message code="menu.paramVille"/> --%>
<!-- 			</a> -->
		</div>
	</div> 
	<a href="javascript:void(0);" class="menu-icon" onclick="myFunctionMenu()">
		<i class="fa fa-bars"></i>
	</a>
</div>

<script>

window.onscroll = function() {onScrollFunction()};
var navbar = document.getElementById("navbar");
var drop = document.getElementById("drop");
var sticky = navbar.offsetTop;


var elementList=document.getElementsByClassName('scroll-stop');
var nbElement=elementList.length;



function onScrollFunction() {
	if (window.pageYOffset >= sticky) {
		for (var i=0 ; i<nbElement ; i++){
			elementList[i].classList.add("sticky")
		}
		navbar.classList.add("sticky")
// 		drop.classList.add("sticky-dropdown")
	} else {
		for (var i=0 ; i<nbElement ; i++){
			elementList[i].classList.remove("sticky")
		}
		navbar.classList.remove("sticky");
// 	    drop.classList.remove("sticky-dropdown");
  }
}

</script>
	