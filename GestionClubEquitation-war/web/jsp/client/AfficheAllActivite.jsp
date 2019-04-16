<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!------ HEAD ------->  
    <%@ include file="../template/Header.jsp"%>
    <!------ /HEAD ------->  

    <%@ taglib prefix="s" uri="/struts-tags" %>


    <body>
        <s:if test="#session.typePersonne == null || #session.typePersonne != 'client'">
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
                                <!--TODO-->
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
                    <h1 class="display-5">Nos Activités</h1>
                </div>
            </div>
            <div class="container" >
                <s:if test="%{listActivite.size()>0}">

                    <table class="table">
                        <tr>   
                            <th scope="col">Activite</th>
                            <th scope="col">Type</th>
                            <th scope="col">Lieu</th>
                            <th scope="col">Details</th>
                            <th scope="col">Duree</th>
                            <th scope="col">Date</th>
                        </tr>
                        <s:iterator value="listActivite" status="ligne">
                            <tr>
                                <td><s:a href="LoadActiviteClient?activite_id=%{activite_id}"><s:property value="nom"/></s:a></td>
                                <td><s:property value="type.getNom()"/></td>
                                <td><s:property value="lieu.getNom()"/></td>
                                <td><s:property value="details"/></td>
                                <td><s:property value="duree"/></td>
                                <td><s:property value="date"/></td>
                            </tr>
                        </s:iterator>
                    </table>
                </s:if>

                <s:else>
                    <p class="h3" align="center">Aucune nouvelle activite disponible à ce jour !</p>
                </s:else>
            </div> 

        </s:else>  
        <!------ FOOTER ------->  
        <%@ include file="../template/Footer.jsp"%>
        <!------ /FOOTER ------->    

