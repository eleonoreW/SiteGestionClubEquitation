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
                            <a class="nav-link active" href="LoadReservationClient">Reservations</a>
                        </li>
                        <li>
                            <a class="nav-link" href="goToListeActivitesClient">Activités</a>
                        </li>
                        <li>
                            <a class="nav-link " href="gotoChevalClient">Chevaux</a>
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
                <h1 class="display-5">Mes réservation</h1>
            </div>
        </div>
        <div class="container">

            <s:if test="%{listReservation.size()>0}">

                <table class="table">
                    <tr>
                        <th scope="col">Activite</th>
                        <th scope="col">Date</th>
                        <th scope="col">Nombre de personnes</th>
                        <th scope="col"></th>
                    </tr>
                    <s:iterator value="listReservation" status="ligne">
                    <tr>
                        <td><s:property value="activite.getNom()"/></td>
                        <td><s:property value="date"/></td>
                        <td><s:property value="nbPersonne"/></td>
                        <td>
                            <form action="CancelReservation" methode="get">
                            <input type="hidden" name="reservation_id" value="<s:property value="reservation_ID"/>">
                            <input type="submit" value="Annuler reservation"/>
                            </form>
                        </td>
                    </tr>
                    </s:iterator>
                </table>
            </s:if>

            <s:else>
                <p class="h3" align="center">Aucune reservation</p>
            </s:else>
        </div>

        <!------ FOOTER ------->  
        <%@ include file="../template/Footer.jsp"%>
        <!------ /FOOTER ------->   

    </body>
</html>
