<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!------ HEAD ------->  
    <%@ include file="../template/Header.jsp"%>
    <!------ /HEAD ------->  
    
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
                <h1 class="display-5">Rechercher un cheval</h1>
            </div>
        </div>
        <div class="container">
            <center>
            <s:form action="searchCheval" >	
                
                <s:textfield name="nom" id="cheval_nom"
                        label="Nom" labelposition="left" autofocus="autofocus">
                </s:textfield>
                 <s:select label="Race" 
                    headerKey="-1" headerValue="Selectionner race"
                    list="listRace.{Nom}" 
                    name="raceSelected"/>
                 <s:select label="Propriétaire" 
                    headerKey="-1" headerValue="Selectionner propriétaire"
                    list="listProprietaire.{mail}" 
                    name="proprietaireSelected"/>
                <s:textfield type="number" name="STRdateNaissanceMin" label="DateNaissanceMin" labelposition="left"
                             placeholder="13012019">
                </s:textfield> 
                <s:textfield type="number" name="STRdateNaissanceMax" label="DateNaissanceMax" labelposition="left"
                             placeholder="13012019">
                </s:textfield>
                <s:textfield type="number" name="STRtailleMin" label="TailleMin" labelposition="left"
                             placeholder="120">
                </s:textfield>
                <s:textfield type="number" name="STRtailleMax" label="TailleMax" labelposition="left"
                             placeholder="200">
                </s:textfield> 
                <s:submit value = "submit" align="center"></s:submit>
            </s:form>

            <s:if test="%{listChevalResult.size()>0}">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Nom</th>
                            <th scope="col">Date de Naissance</th>
                            <th scope="col">Description</th>
                            <th scope="col">Commentaire</th>
                            <th scope="col">Taille</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="listChevalResult" status="ligne">
                            <tr>
                                 <td><s:a href="LoadCheval?nom=%{nom}"><s:property value="nom"/></s:a></td>
                                <td><s:property value="dateNaissance"/></td>
                                <td><s:property value="description"/></td>
                                <td><s:property value="commentaire"/></td>
                                <td><s:property value="taille"/></td>
                                </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>
            <s:else>
                Pas de chevaux à consulter.
            </s:else> 
        </div>
      
    <!------ FOOTER ------->  
    <%@ include file="../template/Footer.jsp"%>
    <!------ /FOOTER ------->   
    
   </body>
</html>