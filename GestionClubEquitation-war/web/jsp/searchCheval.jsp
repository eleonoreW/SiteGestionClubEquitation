<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!------ HEAD ------->  
    <%@ include file="template/Header.jsp"%>
    <!------ /HEAD ------->  
    
    <body>
        <!------ MENU ------>Ì
        <%@ include file="template/Menu.jsp"%>
        <!------ /MENU ------>
        
        <div class="container" style="margin-top: 100px;">
            <h1>Creation cheval</h1>
            <s:form action="searchCheval" >	
                
                <s:textfield name="nom" id="cheval_nom"
                        label="Nom" labelposition="left" required="required" autofocus="autofocus">
                </s:textfield>
                 <s:select label="Race" 
                    headerKey="-1" headerValue="Selectionner race"
                    list="listRace.{Nom}" 
                    name="raceSelected"/>
                 <s:select label="Proprietaire" 
                    headerKey="-1" headerValue="Selectionner propriétaire"
                    list="listProprietaire.{mail}" 
                    name="proprietaireSelected"/>
                <s:textfield type="number" name="dateNaissanceMin" label="DateNaissanceMin" labelposition="left"
                             placeholder="13012019">
                </s:textfield> 
                <s:textfield type="number" name="dateNaissanceMax" label="DateNaissanceMax" labelposition="left"
                             placeholder="13012019">
                </s:textfield>
                <s:textfield type="number" name="tailleMin" label="TailleMin" labelposition="left"
                             placeholder="120">
                </s:textfield>
                <s:textfield type="number" name="tailleMax" label="TailleMax" labelposition="left"
                             placeholder="200">
                </s:textfield> 
                <s:submit value = "submit" align="center"></s:submit>
            </s:form>
        </div>
      
      
    <!------ FOOTER ------->  
    <%@ include file="template/Footer.jsp"%>
    <!------ /FOOTER ------->   
    
   </body>
</html>
