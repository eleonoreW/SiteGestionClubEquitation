<%-- 
    Document   : index
    Created on : 6 mars 2019, 22:03:01
    Author     : Mathieu HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <!------ HEAD ------->  
    <%@ include file="jsp/template/Header.jsp"%>
    <!------ /HEAD ------->  
    
    <body class="bg">
        
        <!------ MENU ------>
        <%@ include file="jsp/template/Menu.jsp"%>
        <!------ /MENU ------>
        
       
                

               
  <header class=" text-white " style="margin-top: 125px;margin-bottom: 300px;">
    <div class="container">
      <div class="row">
        <div class="col-xl-9 mx-auto">
          <h1 class="display-2" style="font-weight: bold;">CENTRE EQUESTRE</h1>
          <h1 class="display-4">du Lac Saint-Jean</h1>
        </div>
      </div>
    </div>
      <div class="col-md-10 col-lg-8 col-xl-7 mx-auto" style="margin-top: 25px;">
          <center><p class="lead">Créer un compte pour profiter de nos activités</p>
          <s:form action="AddNewClientFormHorsCo" >		
                                <s:textfield name="client_prenom" id="client_prenom"
                                        label="Prenom" labelposition="left" required="required" autofocus="autofocus">
                                </s:textfield>	
                                <s:textfield name="client_nom" id="client_nom"
                                        label="Nom" labelposition="left" required="required">
                                </s:textfield>	
                                <s:textfield name="client_mail" id="client_mail"
                                        label="Mail" labelposition="left" required="required">
                                </s:textfield>
                                <s:password name="client_password" value="%{password}"
                                     label="Mot de passe" labelposition="left" required="required"></s:password>
                                <s:textfield name="client_tel" id="client_tel"
                                        label="Tel" labelposition="left" required="required">
                                </s:textfield>
                                <s:textfield name="client_datenaissance" id="client_datenaissance"
                                        label="Date de naissance" labelposition="left" required="required">
                                </s:textfield>
                                <s:submit value="S'enregistrer" align="right"></s:submit>
              </s:form></center>
        </div>
  </header>
                 
           
        </div> <!-- container -->
      <footer class="page-footer font-small blue pt-4 bg-light fixed-bottom" style="margin-bottom: 55px;">
          <div class="row justify-content-md-center">
              <div class="col col-lg-5">
                <p class="lead">Nos services</p>
                <p>
                    Nous gardons et bichonons vos chevaux gratuitement à condition qu'ils puissent nous servir à effectuer nos activités.
                    Nous proposons un large choix d'activités équestres dans la région.
                    Réservez une activité pour vous et vos amis avec nos profs agréés.</br>
                </p><br/>
              </div> 
          </div>
      </div>
    <!------ FOOTER ------->  
    <%@ include file="jsp/template/Footer.jsp"%>
    <!------ /FOOTER ------->   
    
   </body>
</html>
