<%-- 
    Document   : index
    Created on : 6 mars 2019, 22:03:01
    Author     : Mathieu HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!------ HEAD ------->  
    <%@ include file="../template/Header.jsp"%>
    <!------ /HEAD ------->  

    <body>
        <%@ taglib prefix="s" uri="/struts-tags" %>
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
                            <!--TODO-->
                            <a class="nav-link " href="LoadReservationClient">Reservations</a>
                        </li>
                        <li>
                            <a class="nav-link" href="goToListeActivitesClient">Activités</a>
                        </li>
                        <li>
                            <a class="nav-link active" href="gotoChevalClient">Chevaux</a>
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
                <h1 class="display-5">Mes Chevaux</h1>
            </div>
        </div>
        <div class="container">
            <center>
                <p class="h3" align="center">Vos chevaux enregistrés</p>
                
                <s:if test="%{listAllCheval.size()>0}">
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
                            <s:iterator value="listAllCheval" status="ligne">
                                <tr>
                                    <td><s:property value="nom"/></td>
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
                    <p class="h3" align="center">Vous n'avez aucun cheval enregistré.</p>
                </s:else> 
        </div>

        <!------ FOOTER ------->  
        <%@ include file="../template/Footer.jsp"%>
        <!------ /FOOTER ------->   

    </body>
</html>
