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
    
    <body>
        <!------ MENU ------>
        <%@ include file="jsp/template/Menu.jsp"%>
        <!------ /MENU ------>
        
      <div class="container">

            <div class="row" style="margin-top: 150px;">
                <div class="col-lg-8">
                    <img class="img-fluid" src="img/chevalAccueil.jpg">
                </div>

                <div class="col-lg-4">
                    <h3>Créer un compte pour profiter de nos activités</h3>
                    <div style="margin: auto;">
                        <s:form action="AddNewClientFormHorsCo" >	 <!-- TODO struts rediriger vers autre chose on success ? -->	
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
                                <s:submit value="S'enregistrer" align="center"></s:submit>
                        </s:form>
                    </div>
                </div>
            </div>    
            <div class="col-lg-12" style="margin-top: 100px;">
                <h3 align="center">Nos services</h3>
                <p style="text-align: center">
                    Nous gardons et bichonons vos chevaux gratuitement à condition qu'ils puissent nous servir à effectuer nos activités.<br/>
                    Nous proposons un large choix d'activités équestres dans la région.<br/>
                    Réservez une activité pour vous et vos amis avec nos profs agréés.<br/>
                </p>
            </div>
        </div> <!-- container -->
      
    <!------ FOOTER ------->  
    <%@ include file="jsp/template/Footer.jsp"%>
    <!------ /FOOTER ------->   
    
   </body>
</html>
