<%-- 
    Document   : ListerBookByAuthor
    Created on : 12 juin 2017, 14:09:37
    Author     : cdavezac
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Liste des clients</title>
<style type="text/css">@import url(css/styles.css);</style>
</head>
<body>



 <s:if test="%{listAll.size()>0}">

    <table>
    <s:iterator value="listAll" status="ligne">
    <td><s:property value="nom"/></td>
    <td><s:property value="prenom"/></td>
    <td><s:property value="mail"/></td>
    <td><s:property value="telephone"/></td>
    <td><s:property value="date_naissance"/></td>
    </tr>
    </s:iterator>
  
 </s:if>
  
<s:else>
    Aucun Employé dans la liste
</s:else>
  


</table>
</body>
</html>