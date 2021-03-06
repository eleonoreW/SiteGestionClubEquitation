<%-- 
    Document   : AjoutPersonne
    Created on : 7 mars 2019, 13:42:07
    Author     : bguil
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!------ HEAD ------->  
    <%@ include file="../template/Header.jsp"%>
    <!------ /HEAD ------->  

    <%@ taglib prefix="s" uri="/struts-tags" %>


    <body>
        <s:if test="#session.typePersonne == null || #session.typePersonne != 'admin'">
            <s:action name="gotoAccessDenied" executeResult="true"/>
        </s:if> 
        <s:else>


            <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
                <div class="container">
                    <a class="navbar-brand" href="/">
                        <img class="img-fluid" src="img/logo.png" alt="club logo" style="max-height: 50px">
                        <span class="littleMAJ">Club Équitation</span>
                    </a>
                    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarResponsive">
                        <ul class="navbar-nav ml-auto">
                            <li>
                                <a class="nav-link " href="gotoClient">Clients</a>
                            </li>
                            <li>
                                <a class="nav-link active" href="gotoProfesseur">Professeurs</a>
                            </li>
                            <li>
                                <a class="nav-link" href="gotoAdministrateur">Administrateurs</a>
                            </li>
                            <li>
                                <a class="nav-link" href="gotoActivite">Activités</a>
                            </li>
                            <li class="nav-item dropdown ">
                                <a class="nav-link dropdown-toggle " href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Chevaux
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="gotoCheval">Gestion des chevaux</a>
                                    <a class="dropdown-item" href="gotoChevalSearch">Rechercher un cheval</a>
                                </div>
                            </li>
                            <li>
                                <a class="nav-link" href="logoutPersonne">Se déconnecter</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>    

            <div class="jumbotron" style="margin-top: 65px">
                <div class="container" >
                    <h1 class="display-5">Gestion des professeurs</h1>
                </div>
            </div>
            <div class="container" >

                <div id="formulaire">
                    <center>

                        <p class="h3" >Ajout d'un nouveau professeur</p>


                        <s:form action="AddNewProfesseurForm" >		

                            <s:textfield name="prof_prenom" id="prof_prenom"
                                         label="Prenom" labelposition="left" required="required" autofocus="autofocus">
                            </s:textfield>	
                            <s:textfield name="prof_nom" id="prof_nom"
                                         label="Nom" labelposition="left" required="required">
                            </s:textfield>	
                            <s:textfield type="number" name="prof_heureSem" id="prof_mail"
                                         label="Nombre d'heures par semaine" labelposition="left" required="required">
                            </s:textfield>
                            <s:textfield name="prof_mail" id="prof_mail"
                                         label="Mail" labelposition="left" required="required">
                            </s:textfield>
                            <s:password name = "prof_password" value="%{password}"
                                        label="Password" labelposition="left" required="required"></s:password>
                            <s:textfield name="prof_tel" id="prof_tel"
                                         label="tel" labelposition="left" required="required">
                            </s:textfield>
                            <s:textfield name="prof_datenaissance" id="prof_datenaissance"
                                         label="Date de naissance" labelposition="left" required="required">
                            </s:textfield>
                            <s:submit value = "Ajouter" align="center"></s:submit>

                        </s:form>
                </div> 
                </br>
                <hr/>
                </br>

                <p class="h3" align="center">Liste des professeurs</p>     

                <s:action name="AfficheAllProfesseurs" executeResult="true"/>

            </div>     

        </s:else>         
        <!------ FOOTER ------->  
        <%@ include file="../template/Footer.jsp"%>
        <!------ /FOOTER ------->       