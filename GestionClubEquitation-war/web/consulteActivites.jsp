<%-- 
    Document   : index
    Created on : 6 mars 2019, 22:03:01
    Author     : Mathieu HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!------ HEAD ------->  
    <%@ include file="jsp/template/Header.jsp"%>
    <!------ /HEAD ------->  

    <body>
        <%@ taglib prefix="s" uri="/struts-tags" %>
        <!------ MENU ------>
        <%@ include file="jsp/template/Menu.jsp"%>
        <!------ /MENU ------>

        <div class="jumbotron" style="margin-top: 65px">
            <div class="container" >
                <h1 class="display-5">Nos activités</h1>
            </div>
        </div>
        <div class="container">
            <s:if test="%{listActivite.size()>0}">

                <table class="table">
                    <tr>   
                        <th scope="col">Activite</th>
                        <th scope="col">Type</th>
                        <th scope="col">Lieu</th>
                        <th scope="col">Details</th>
                        <th scope="col">Duree</th>
                        <th scope="col">Date</th>
                    </tr>
                    <s:iterator value="listActivite" status="ligne">
                        <tr>
                        <td><s:property value="nom"/></td>
                        <td><s:property value="type.getNom()"/></td>
                        <td><s:property value="lieu.getNom()"/></td>
                        <td><s:property value="details"/></td>
                        <td><s:property value="duree"/></td>
                        <td><s:property value="date"/></td>
                        </tr>
                    </s:iterator>
                </table>
            </s:if>

            <s:else>
                <p class="h3" align="center">Aucune Activite disponible a ce jour</p>
            </s:else>

        </div>

        <!------ FOOTER ------->  
        <%@ include file="jsp/template/Footer.jsp"%>
        <!------ /FOOTER ------->   

    </body>
</html>
