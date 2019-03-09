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
            <s:form action="creationCheval" >	
                
                <s:textfield name="nom" id="cheval_nom"
                        label="Nom" labelposition="left" required="required" autofocus="autofocus">
                </s:textfield>
                <s:textfield name="description" id="cheval_description"
                             label="Description" labelpostion="left">
                </s:textfield> 
                <s:textfield name="commentaire" id="cheval_commentaire"
                        label="Commentaire" labelposition="left" required="required" autofocus="autofocus">
                </s:textfield>
                
                <s:textfield type="number" name="dateNaissance" label="DateNaissance" labelposition="left" required="required" 
                             placeholder="13012019">
                </s:textfield> 
                
                <s:textfield type="number" name="nbHeureMaxSemaine" label="HeureMaxSemaine" labelposition="left"
                             placeholder="20">
                </s:textfield> 
                
                <s:textfield type="number" name="taille" label="Taille" labelposition="left" required="required" 
                             placeholder="160">
                </s:textfield> 
                
                <s:select label="Proprietaire" 
                    headerKey="-1" headerValue="Selectionner propriétaire"
                    list="listProprietaire.{mail}" 
                    name="proprietaireSelected"/>
                
                <s:select label="Race" 
                    headerKey="-1" headerValue="Selectionner race"
                    list="listRace.{Nom}" 
                    name="raceSelected"/>
                
                <s:submit value = "submit" align="center"></s:submit>
            </s:form>
        </div>
      
      
    <!------ FOOTER ------->  
    <%@ include file="template/Footer.jsp"%>
    <!------ /FOOTER ------->   
    
   </body>
</html>
