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
                                <a class="nav-link " href="gotoProfesseur">Professeurs</a>
                            </li>
                            <li>
                                <a class="nav-link active" href="gotoAdministrateur">Administrateurs</a>
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
                    <h1 class="display-5">Administrateur <s:property value="prenom"/> <s:property value="nom"/></h1>
                </div>
            </div>
            <div class="container" >


                <s:form action="ReplaceAdmin?id=%{id}" >		

                    <s:textfield name="admin_prenom" id="admin_prenom" value="%{prenom}"
                                 label="Prenom" labelposition="left" required="required" autofocus="autofocus">
                    </s:textfield>	
                    <s:textfield name="admin_nom" id="admin_nom" value="%{nom}"
                                 label="Nom" labelposition="left" required="required">
                    </s:textfield>	
                    <s:textfield name="admin_mail" id="admin_mail" value="%{mail}"
                                 label="Mail" labelposition="left" required="required">
                    </s:textfield>
                    <s:password name="admin_password" value="%{password}"
                                label="Password" labelposition="left" required="required"></s:password>
                    <s:textfield name="admin_tel" id="admin_tel" value="%{telephone}"
                                 label="Tel" labelposition="left" required="required">
                    </s:textfield>
                    <s:textfield name="admin_datenaissance" id="admin_datenaissance" value="%{date_naissance}"
                                 label="Date de naissance" labelposition="left" required="required">
                    </s:textfield>
                    <s:submit value="Mettre a jour" align="center"></s:submit>

                </s:form>

                <s:form action="DeleteAdmin?id=%{id}" >		
                    <s:submit value="Supprimer" align="center"></s:submit>
                </s:form>

            </div>     

        </s:else>  
        <!------ FOOTER ------->  
        <%@ include file="../template/Footer.jsp"%>
        <!------ /FOOTER ------->     