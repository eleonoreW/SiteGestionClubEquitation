<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <!------ HEAD ------->  
    <%@ include file="../template/Header.jsp"%>
    <!------ /HEAD ------->  

    <%@ taglib prefix="s" uri="/struts-tags" %>

    
    <body>
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
                            <a class="nav-link " href="gotoActivite">Activités</a>
                        </li>
                        <li class="nav-item dropdown ">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
                <h1 class="display-5">Gestion activité</h1>
            </div>
        </div>
        <div class="container">
            <center>
            <p class="h3" >Ajout d'une nouvelle activité</p>
            
            <s:form action="creationActivite" >		
                <s:textfield name="nom" id="activite_nom"
                        label="Titre" labelposition="left" required="required" autofocus="autofocus">
                </s:textfield>
                <s:textfield name="details" id="activite_details"
                             label="Details" labelpostion="left">
                </s:textfield> 
                
                <s:textfield type="number" name="date" label="Date" labelposition="left" required="required" 
                             placeholder="20190113">
                </s:textfield> 
                
                <s:select label="Durée (h)"
                    name="duree"
                    headerKey="-1" headerValue="1"
                    list="{2, 3, 4, 5, 6, 7, 8}"
                    value="selectedDuree"
                    required="true" />
                
                <s:textfield name="capacite" type="number" id="activite_capacite"
                        label="Capacité" labelposition="left">
                </s:textfield>
                
                <s:select label="Lieu"
                    name="lieuSelected"
                    headerKey="-1" headerValue="Selectionner lieu"
                    list="listLieu.{nom}"
                    required="true" />
                
                <s:select label="Prof" 
                    headerKey="-1" headerValue="Selectionner prof"
                    list="listProf.{mail}" 
                    name="profSelected"/>

                <s:select label="Type" 
                    headerKey="-1" headerValue="Selectionner type"
                    list="listType.{nom}" 
                    name="typeSelected"/>

                <s:select label="Chevaux"
                    multiple="true"
                    headerKey="-1"
                    list="listCheval.{nom}"
                    name="listChevalSelected"/>
                
                <s:submit value = "Ajouter" align="center"></s:submit>
            </s:form>
            </br>
            <hr/>
            </br>
            
            <p class="h3" align="center">Liste des activités</p>     
        
            <s:action name="AfficheAllActivites" executeResult="true"/>
        </div>
      
      
    <!------ FOOTER ------->  
    <%@ include file="../template/Footer.jsp"%>
    <!------ /FOOTER ------->   
    
   </body>
</html>
