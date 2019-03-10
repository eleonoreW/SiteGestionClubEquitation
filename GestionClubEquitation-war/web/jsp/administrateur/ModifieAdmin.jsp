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
                            <a class="nav-link active" href="gotoAdministrateur">Administrateurs</a>
                        </li>
                        <li>
                            <a class="nav-link" href="gotoActivite">Activités</a>
                        </li>
                        <li>
                            <a class="nav-link" href="gotoCheval">Chevaux</a>
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
                      label="nom" labelposition="left" required="required" autofocus="autofocus">
              </s:textfield>	
              <s:textfield name="admin_nom" id="admin_nom" value="%{nom}"
                      label="prenom" labelposition="left" required="required">
              </s:textfield>	
              <s:textfield name="admin_mail" id="admin_mail" value="%{mail}"
                      label="mail" labelposition="left" required="required">
              </s:textfield>
              <s:password name="admin_password" value="%{password}"
                     label="password" labelposition="left" required="required"></s:password>
              <s:textfield name="admin_tel" id="admin_tel" value="%{telephone}"
                      label="tel" labelposition="left" required="required">
              </s:textfield>
              <s:textfield name="admin_datenaissance" id="admin_datenaissance" value="%{date_naissance}"
                      label="date de naissance" labelposition="left" required="required">
              </s:textfield>
              <s:submit value = "Update" align="center"></s:submit>

        </s:form>
        
        <s:form action="DeleteAdmin?id=%{id}" >		
            <s:submit value = "Delete" align="center"></s:submit>
        </s:form>

        </div>     
        
        
	 <!------ FOOTER ------->  
    <%@ include file="../template/Footer.jsp"%>
    <!------ /FOOTER ------->     