
<%@ taglib prefix="s" uri="/struts-tags" %>

<ul>
    <li><s:property value="nom"/></li>
    <li><s:property value="type.{nom}"/></li>
    <li><s:property value="lieu.{nom}"/></li>
    <li><s:property value="details"/></li>
    <li><s:property value="duree"/></li>
    <li><s:property value="date"/></li>
    <li><s:property value="nbPlaceDispo"/></li>
</ul>

<h2>Reserver</h2>
<form action="ReserveActivite" method="get">
    Nombre de place a reserver </br>
    <input type="number" name="nbPersonne"></br>
    <input type="hidden" name="activite_id" value="<s:property value="activite_id"/>"></br>
    <input type="submit" value="Submit">
</form>
  
