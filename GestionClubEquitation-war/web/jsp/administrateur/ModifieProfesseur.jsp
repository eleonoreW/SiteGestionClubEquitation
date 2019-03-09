<%-- 
    Document   : modifiePersonne
    Created on : 7 mars 2019, 21:58:28
    Author     : bguil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ taglib prefix="s" uri="/struts-tags" %>
        <h1>Hello World!</h1>
        
        
        <s:form action="ReplaceProfesseur?id=%{id}" >		

            <s:textfield name="prof_prenom" id="prof_prenom" value="%{prenom}"
                      label="nom" labelposition="left" required="required" autofocus="autofocus">
              </s:textfield>	
              <s:textfield name="prof_nom" id="prof_nom" value="%{nom}"
                      label="prenom" labelposition="left" required="required">
              </s:textfield>
              <s:textfield type="number" name="prof_heureSem" id="prof_heureSem" value="%{nbHeureMaxSemaine}"
                        label="nombre d'heures par semaine" labelposition="left" required="required">
              </s:textfield>
              <s:textfield name="prof_mail" id="prof_mail" value="%{mail}"
                      label="mail" labelposition="left" required="required">
              </s:textfield>
              <s:password name = "prof_password" value="%{password}"
                     label="password" labelposition="left" required="required"></s:password>
              <s:textfield name="prof_tel" id="prof_tel" value="%{telephone}"
                      label="tel" labelposition="left" required="required">
              </s:textfield>
              <s:textfield name="prof_datenaissance" id="prof_datenaissance" value="%{date_naissance}"
                      label="date de naissance" labelposition="left" required="required">
              </s:textfield>
              <s:submit value = "Update" align="center"></s:submit>

        </s:form>
        
        <s:form action="DeleteProfesseur?id=%{id}" >		
            <s:submit value = "Delete" align="center"></s:submit>
        </s:form>

            
    </body>
</html>
