<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ taglib prefix="s" uri="/struts-tags" %>
        <h1>Modifier ou supprimer une activite</h1>
        
        
        <s:form action="ReplaceActivite?id=%{id}" >		

            <s:textfield name="nom" id="activite_nom"
                        label="Nom" labelposition="left" required="required" autofocus="autofocus">
                </s:textfield>
                <s:textfield name="details" id="activite_details"
                             label="Details" labelpostion="left">
                </s:textfield> 
                
                <s:textfield type="number" name="date" label="Date" labelposition="left" required="required" 
                             placeholder="13012019">
                </s:textfield> 
            
                <s:select label="Durée (h)"
                    name="duree"
                    headerKey="-1" headerValue="1"
                    list="{2, 3, 4, 5, 6, 7, 8}"
                    value="selectedDuree"
                    required="true" />
                
                <s:textfield name="capacite" type="number" id="activite_capacite"
                        label="Capacité" labelposition="left">
                </s:textfield>
                <s:submit value = "Update" align="center"></s:submit>

        </s:form>
        
        <s:form action="DeleteActivite?id=%{id}" >		
            <s:submit value = "Delete" align="center"></s:submit>
        </s:form>

            
    </body>
</html>
