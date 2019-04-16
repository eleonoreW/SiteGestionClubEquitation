<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!------ HEAD ------->  
    <%@ include file="../template/Header.jsp"%>
    <!------ /HEAD ------->  

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
                                <a class="nav-link " href="gotoProfesseur">Professeurs</a>
                            </li>
                            <li>
                                <a class="nav-link" href="gotoAdministrateur">Administrateurs</a>
                            </li>
                            <li>
                                <a class="nav-link" href="gotoActivite">Activités</a>
                            </li>
                            <li class="nav-item dropdown ">
                                <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
                    <h1 class="display-5">Gestion du cheval</h1>
                </div>
            </div>
            <div class="container">
                <center>
                    <p class="h3" >Ajout d'un nouveau cheval</p>
                    <s:form action="createCheval" >	

                        <s:textfield name="nom" id="cheval_nom"
                                     label="Nom" labelposition="left" required="required" autofocus="autofocus">
                        </s:textfield>
                        <s:textfield name="description" id="cheval_description"
                                     label="Description" labelpostion="left">
                        </s:textfield> 
                        <s:textfield name="commentaire" id="cheval_commentaire"
                                     label="Commentaire" labelposition="left" autofocus="autofocus">
                        </s:textfield>

                        <s:textfield type="number" name="dateNaissance" label="DateNaissance" labelposition="left" required="required" 
                                     placeholder="13012019">
                        </s:textfield> 

                        <s:textfield type="number" name="nbHeureMaxSemaine" label="HeureMaxSemaine" labelposition="left" required="required"
                                     placeholder="20">
                        </s:textfield> 

                        <s:textfield type="number" name="taille" label="Taille" labelposition="left" required="required" 
                                     placeholder="160">
                        </s:textfield> 

                        <s:select label="Proprietaire"
                                  list="listProprietaire.{mail}" 
                                  name="proprietaireSelected"
                                  value ="listProprietaire.{mail}"/>

                        <s:select label="Race" 
                                  list="listRace.{nom}" 
                                  value ="listRace.{nom}"
                                  name="raceSelected" required="required"/>

                        <s:submit value = "Ajouter" align="center"></s:submit>
                    </s:form>


                    </br>
                    <hr/>
                    </br>

                    <p class="h3" align="center">Liste des chevaux</p>     

                    <s:action name="AfficheAllChevaux" executeResult="true"/>
            </div>   
        </s:else> 

        <!------ FOOTER ------->  
        <%@ include file="../template/Footer.jsp"%>
        <!------ /FOOTER ------->   
