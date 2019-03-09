
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!------ HEAD ------->  
    <%@ include file="../template/Header.jsp"%>
    <!------ /HEAD ------->  
    
    <body>
        <%@ taglib prefix="s" uri="/struts-tags" %>
        <!------ MENU ------>Ì
        <%@ include file="../template/Menu.jsp"%>
        <!------ /MENU ------>
        
        <div class="container" style="margin-top: 100px;">
            <h1>Consulter les chevaux</h1>
            <s:form action="searchCheval" >	
                
                <s:textfield name="nom" id="cheval_nom"
                        label="Nom" labelposition="left" autofocus="autofocus">
                </s:textfield>
                 <s:select label="Race" 
                    headerKey="-1" headerValue="Selectionner race"
                    list="listRace.{Nom}" 
                    name="raceSelected"/>
                 <s:select label="Propriétaire" 
                    headerKey="-1" headerValue="Selectionner propriétaire"
                    list="listProprietaire.{mail}" 
                    name="proprietaireSelected"/>
                <s:textfield type="number" name="STRdateNaissanceMin" label="DateNaissanceMin" labelposition="left"
                             placeholder="13012019">
                </s:textfield> 
                <s:textfield type="number" name="STRdateNaissanceMax" label="DateNaissanceMax" labelposition="left"
                             placeholder="13012019">
                </s:textfield>
                <s:textfield type="number" name="STRtailleMin" label="TailleMin" labelposition="left"
                             placeholder="120">
                </s:textfield>
                <s:textfield type="number" name="STRtailleMax" label="TailleMax" labelposition="left"
                             placeholder="200">
                </s:textfield> 
                <s:submit value = "submit" align="center"></s:submit>
            </s:form>
            
            
             
            
        
        <s:if test="%{listChevalResult.size()>0}">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Nom</th>
                        <th scope="col">Date de Naissance</th>
                        <th scope="col">Description</th>
                        <th scope="col">Commentaire</th>
                        <th scope="col">Taille</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="listChevalResult" status="ligne">
                        <tr>
                            <td><s:property value="nom"/></td>
                            <td><s:property value="dateNaissance"/></td>
                            <td><s:property value="description"/></td>
                            <td><s:property value="commentaire"/></td>
                            <td><s:property value="taille"/></td>
                            </tr>
                    </s:iterator>
                </tbody>
            </table>
        </s:if>
        <s:else>
            Pas de chevaux à consulter.
        </s:else> 
        </div>
    <!------ FOOTER ------->  
    <%@ include file="../template/Footer.jsp"%>
    <!------ /FOOTER ------->   
    
   </body>
</html>