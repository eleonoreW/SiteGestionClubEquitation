
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <img class="img-fluid" src="img/chevalAccueil.png">
                </div>

                <div class="col-lg-4">
                    <h3>Créer un compte pour profiter de nos activités</h3>
                    <div style="margin: auto;">
                        <s:form action="AddNewClientForm" >	 <!-- TODO struts rediriger vers autre chose on success ? -->	
                                <s:textfield name="client_prenom" id="client_prenom"
                                        label="prenom" labelposition="left" required="required" autofocus="autofocus">
                                </s:textfield>	
                                <s:textfield name="client_nom" id="client_nom"
                                        label="nom" labelposition="left" required="required">
                                </s:textfield>	
                                <s:textfield name="client_mail" id="client_mail"
                                        label="mail" labelposition="left" required="required">
                                </s:textfield>
                                <s:password name="client_password" value="%{password}"
                                     label="password" labelposition="left" required="required"></s:password>
                                <s:textfield name="client_tel" id="client_tel"
                                        label="tel" labelposition="left" required="required">
                                </s:textfield>
                                <s:textfield name="client_datenaissance" id="client_datenaissance"
                                        label="date de naissance" labelposition="left" required="required">
                                </s:textfield>
                                <s:submit value = "Ajouter" align="center"></s:submit>
                        </s:form>
                    </div>
                </div>
            </div>    
            <div class="row">
                <h3>Nos services</h3>
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
