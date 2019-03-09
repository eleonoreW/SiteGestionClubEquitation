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
                            <a class="nav-link" href="gotoClient">Clients</a>
                        </li>
                        <li>
                            <a class="nav-link " href="gotoProfesseur">Professeurs</a>
                        </li>
                        <li>
                            <a class="nav-link" href="gotoAdministrateur">Administrateurs</a>
                        </li>
                        <li>
                            <a class="nav-link" href="">Activités</a>
                        </li>
                        <li>
                            <a class="nav-link active" href="">Chevaux</a>
                        </li>
                        <li>
                            <a class="nav-link" href="connection.jsp">Se déconnecter</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav> 
        
        <div class="container" style="margin-top: 100px;">
            <h1>Creation cheval</h1>
            <s:form action="updateCheval" >	
                
                <s:textfield name="nom" id="cheval_nom"
                        label="Nom" labelposition="left" required="required" autofocus="autofocus" readonly="true">
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
                
                <s:submit value = "submit" align="center"></s:submit>
            </s:form>
        </div>
      
      
    <!------ FOOTER ------->  
    <%@ include file="../template/Footer.jsp"%>
    <!------ /FOOTER ------->   
    
   </body>
</html>