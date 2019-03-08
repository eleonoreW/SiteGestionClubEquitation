<%-- 
    Document   : AjoutPersonne
    Created on : 7 mars 2019, 13:42:07
    Author     : bguil
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--<link rel="stylesheet" href="../../css/administrationMenu.css" />-->
<title>Page Administrateur</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%@ taglib prefix="s" uri="/struts-tags" %>
</head>
    
    <body>

	<nav id="adminMenu">
                           
            <ul>
                <li><a class="active" href="" >Employés</a></li>
                <li><a href="" >Chevaux</a></li>
                <li><a href="#" >Accueil</a>   </li>
            </ul>   
	</nav>   
        
        
        <section id="adminSection">
                  
            <div id="formulaire">
            <center><h2>Ajout d'un nouvel administrateur</h2>


            <s:form action="AddNewAdminForm" >		

                <s:textfield name="admin_prenom" id="admin_prenom"
                        label="nom" labelposition="left" required="required" autofocus="autofocus">
                </s:textfield>	
                <s:textfield name="admin_nom" id="admin_nom"
                        label="nom" labelposition="left" required="required">
                </s:textfield>	
                <s:textfield name="admin_mail" id="admin_mail"
                        label="mail" labelposition="left" required="required">
                </s:textfield>	
                <s:textfield name="admin_tel" id="admin_tel"
                        label="tel" labelposition="left" required="required">
                </s:textfield>
                <s:textfield name="admin_datenaissance" id="admin_datenaissance"
                        label="date de naissance" labelposition="left" required="required">
                </s:textfield>
                <s:submit value = "Register" align="center"></s:submit>

            </s:form>
                
        <p> Tout les administrateurs : </p>     
        
        <s:action name="AfficheAllAdministrateurs" executeResult="true"/>
                
                
	</div>    
