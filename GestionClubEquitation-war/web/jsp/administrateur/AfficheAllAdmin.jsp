<%-- 
    Document   : ListerBookByAuthor
    Created on : 12 juin 2017, 14:09:37
    Author     : cdavezac
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>


 
 <s:if test="%{listAll.size()>0}">

    <table>
    <s:iterator value="listAll" status="ligne">
    <td><s:a href="LoadAdmin?mail=%{mail}"><s:property value="nom"/></s:a></td>
    <td><s:property value="prenom"/></td>
    <td><s:property value="mail"/></td>
    <td><s:property value="telephone"/></td>
    <td><s:property value="date_naissance"/></td>
    </tr>
    </s:iterator>
  
 </s:if>
  
<s:else>
    Aucun Administrateur dans la liste
</s:else>
  


</table>
