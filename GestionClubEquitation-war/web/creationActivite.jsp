<%@ taglib prefix="s" uri="/struts-tags" %>
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
        
        <div class="container" style="margin-top: 100px;">
            <h1>Creation activité</h1>
            <s:form action="AddNewActivite" >		
                <s:textfield name="activite_nom" id="activite_nom"
                        label="Nom" labelposition="left" required="required" autofocus="autofocus">
                </s:textfield>
                <s:textfield name="activite_details" id="activite_details"
                             label="Details" labelpostion="left">
                </s:textfield> 

                <s:date name="activite_date" format="hh/dd/MM/yyyy" />
                
                <s:select label="Durée (h)"
                    name="activite_duree"
                    headerKey="-1" headerValue="1"
                    list="{2, 3, 4, 5, 6, 7, 8}"
                    value="selectedDuree"
                    required="true" />
                
                <s:textfield name="activite_capacite" id="activite_capacite"
                        label="Capacité" labelposition="left">
                </s:textfield>

                <s:submit value = "Register" align="center"></s:submit>
            </s:form>
        </div>
      
      
    <!------ FOOTER ------->  
    <%@ include file="jsp/template/Footer.jsp"%>
    <!------ /FOOTER ------->   
    
   </body>
</html>
