<%@ taglib prefix="s" uri="/struts-tags" %>

 <s:if test="%{listActivite.size()>0}">
    <table>
    <s:iterator value="listActivite" status="ligne">
    
    <td><s:a href="LoadActivite?nom=%{nom}"><s:property value="nom"/></s:a></td>
    <td><s:property value="details"/></td>
    <td><s:property value="date"/></td>
    </tr>
    </s:iterator>
 
</s:if>
  
<s:else>
    Aucune activite dans la liste
</s:else>

</table>
