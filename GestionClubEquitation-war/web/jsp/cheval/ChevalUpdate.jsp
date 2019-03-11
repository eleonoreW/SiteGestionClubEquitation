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
                            <a class="nav-link" href="connection.jsp">Se déconnecter</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav> 
        
        <div class="container" style="margin-top: 100px;">
            <h1>Modification de <s:property value="nom"/></h1>
            <s:form action="UpdateCheval" >	
                
                <s:textfield name="description" id="cheval_description"
                             label="Description" labelpostion="left">
                </s:textfield> 
                <s:textfield name="commentaire" id="cheval_commentaire"
                        label="Commentaire" labelposition="left" autofocus="autofocus" >
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
                    value ="chevalAmodifier.{proprietaire}.{mail}"/>
                
                <s:select label="Race" 
                    list="listRace.{nom}" 
                    value ="chevalAmodifier.{race}.{nom}"
                    name="raceSelected" required="required"/>
                
                <s:submit value = "Mettre a jour" align="center"></s:submit>
                
            </s:form>
            
             <s:form action="DeleteCheval?nom=%{nom}" >		
            <s:submit value = "Supprimer" align="center"></s:submit>
            </s:form>
        </div>
      
      
    <!------ FOOTER ------->  
    <%@ include file="../template/Footer.jsp"%>
    <!------ /FOOTER ------->   
    
   </body>
</html>