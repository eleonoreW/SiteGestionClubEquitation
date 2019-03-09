<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="%{listActivite.size()>0}">

    <table>
        <tr>   
            <td><b>Activite</b></td>
            <td><b>Type</b></td>
            <td><b>Lieu</b></td>
            <td><b>Details</b></td>
            <td><b>Duree</b></td>
            <td><b>Date</b></td>
        </tr>
  
        <s:iterator value="listActivite" status="ligne">
        <td><s:a href="LoadActiviteClient?activite_id=%{activite_id}"><s:property value="nom"/></s:a></td>
        <td><s:property value="type.{nom}"/></td>
        <td><s:property value="lieu.{nom}"/></td>
        <td><s:property value="details"/></td>
        <td><s:property value="duree"/></td>
        <td><s:property value="date"/></td>
        </tr>
        </s:iterator>

        </s:if>

       <s:else>
           Aucune Activite disponible a ce jour
       </s:else>
  
    </table>