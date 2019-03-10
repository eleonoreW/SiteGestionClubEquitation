
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="%{listReservation.size()>0}">

    <table>
        <td>Activite</td>
        <td>Date</td>
        <td>Nombre de personne</td>
        <s:iterator value="listReservation" status="ligne">
        <td><s:property value="activite.{nom}"/></td>
        <td><s:property value="date"/></td>
        <td><s:property value="nbPersonne"/></td>
        <td>
            <form action="CancelReservation" methode="get">
            <input type="hidden" name="reservation_id" value="<s:property value="reservation_ID"/>"></br>
            <input type="submit" value="Annuler reservation"/>
            </form>
        </td>
        </tr>
        </s:iterator>
    </table>
     
</s:if>
  
<s:else>
    Aucune reservation faite
</s:else>
  

