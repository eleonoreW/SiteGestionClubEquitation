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
            <center><h2>Ajout d'un nouvel utilisateur</h2>


            <s:form action="AddNewEmployeeForm" >		

                <s:textfield name="employee_firstname" id="employee_firstname"
                        label="FirstName" labelposition="left" required="required" autofocus="autofocus">
                </s:textfield>	
                <s:textfield name="employee_lastname" id="employee_lastname"
                        label="LastName" labelposition="left" required="required">
                </s:textfield>	

                <s:submit value = "Register" align="center"></s:submit>


            </s:form>
	</div>    
