<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!------ HEAD ------->  
    <%@ include file="../template/Header.jsp"%>
    <!------ /HEAD ------->  

    <%@ taglib prefix="s" uri="/struts-tags" %>


    <body>       <s:if test="#session.typePersonne == null || #session.typePersonne != 'client'">
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
                                <a class="nav-link " href="LoadReservationClient">Reservations</a>
                            </li>
                            <li>
                                <a class="nav-link active" href="goToListeActivitesClient">Activités</a>
                            </li>
                            <li>
                                <a class="nav-link" href="gotoChevalClient">Chevaux</a>
                            </li>
                            <li>
                                <a class="nav-link" href="logoutPersonne">Se déconnecter</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav> 
            <%@ taglib prefix="s" uri="/struts-tags" %>
            <div class="jumbotron" style="margin-top: 65px">
                <div class="container" >
                    <h2 class="display-5"><s:property value="nom"/></h1>
                </div>
            </div>
            <div class="container" style="margin-bottom:50px">
                <div class="row">
                    <div class="col-sm-7">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">Activite : <s:property value="nom"/></li>
                            <li class="list-group-item">Type d'activite : <s:property value="typeSelected"/></li>
                            <li class="list-group-item">Lieu : <s:property value="lieuSelected"/></li>
                            <li class="list-group-item">Prof : <s:property value="profSelected"/></li>
                            <li class="list-group-item">Informations supplementaires : <s:property value="details"/></li>
                            <li class="list-group-item">Duree : <s:property value="duree"/> h</li>
                            <li class="list-group-item">Date : <s:property value="date"/></li>
                            <li class="list-group-item">Nombre de places encore disponibles : <s:property value="nbPlaceDispo"/></li>

                        </ul>
                    </div>
                    <div class="col-sm-5">
                        <h2>Reservation</h2>
                        <form action="ReserveActivite" method="get">
                            Nombre de place a reserver </br>
                            <input type="number" name="nbPersonne" min="0" max="<s:property value="nbPlaceDispo"/>"></br>
                            <input type="hidden" name="activite_id" value="<s:property value="id"/>"></br>
                            <input type="submit" value="Reserver">
                        </form>
                    </div>
                </div>
            </div>

        </s:else> 
        <!------ FOOTER ------->  
        <%@ include file="../template/Footer.jsp"%>
        <!------ /FOOTER ------->    