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
        
        
        <s:form action="ReplaceClient?id=%{id}" >		

            <s:textfield name="client_prenom" id="client_prenom" value="%{prenom}"
                      label="nom" labelposition="left" required="required" autofocus="autofocus">
              </s:textfield>	
              <s:textfield name="client_nom" id="client_nom" value="%{nom}"
                      label="prenom" labelposition="left" required="required">
              </s:textfield>	
              <s:textfield name="client_mail" id="client_mail" value="%{mail}"
                      label="mail" labelposition="left" required="required">
              </s:textfield>
              <s:password name="client_password" value="%{password}"
                     label="password" labelposition="left" required="required"></s:password>
              <s:textfield name="client_tel" id="client_tel" value="%{telephone}"
                      label="tel" labelposition="left" required="required">
              </s:textfield>
              <s:textfield name="client_datenaissance" id="client_datenaissance" value="%{date_naissance}"
                      label="date de naissance" labelposition="left" required="required">
              </s:textfield>
              <s:submit value = "Update" align="center"></s:submit>

        </s:form>
        
        <s:form action="DeleteClient?id=%{id}" >		
            <s:submit value = "Delete" align="center"></s:submit>
        </s:form>

            
    </body>
</html>
