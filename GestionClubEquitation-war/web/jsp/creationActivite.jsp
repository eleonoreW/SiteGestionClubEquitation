<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!------ HEAD ------->  
    <%@ include file="template/Header.jsp"%>
    <!------ /HEAD ------->  
    
    <body>
        <!------ MENU ------>
        <%@ include file="template/Menu.jsp"%>
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

                
                <s:select label="Durée (h)"
                    name="activite_duree"
                    headerKey="-1" headerValue="1"
                    list="{2, 3, 4, 5, 6, 7, 8}"
                    value="selectedDuree"
                    required="true" />
                
                
                
                <s:textfield name="activite_capacite" id="activite_capacite"
                        label="Capacité" labelposition="left">
                </s:textfield>
                
                <s:select label="Lieu"
                    name="lieuSelected"
                    headerKey="-1" headerValue="Selectionner lieu"
                    list="listLieu.{nom}"
                    required="true" />
                
                <s:select label="Prof" 
                    headerKey="-1" headerValue="Selectionner prof"
                    list="listProf.{nom}" 
                    name="profSelected"/>

                <s:select label="Type" 
                    headerKey="-1" headerValue="Selectionner type"
                    list="listType.{nom}" 
                    name="typeSelected"/>

                <s:select label="Chevaux"
                    multiple="true"
                    headerKey="-1" headerValue="Selectionner chevaux"
                    list="listCheval.{nom}"
                    name="listChevalSelected"/>
                
                <s:submit value = "Register" align="center"></s:submit>
            </s:form>
        </div>
      
      
    <!------ FOOTER ------->  
    <%@ include file="template/Footer.jsp"%>
    <!------ /FOOTER ------->   
    
   </body>
</html>
