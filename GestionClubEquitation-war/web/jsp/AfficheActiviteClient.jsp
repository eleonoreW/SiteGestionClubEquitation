<%@ taglib prefix="s" uri="/struts-tags" %>

<ul>
    <li>Activite : <s:property value="nom"/></li>
    <li>Type d'activite : <s:property value="typeSelected"/></li>
    <li>Lieu : <s:property value="lieuSelected"/></li>
    <li>Prof : <s:property value="profSelected"/></li>
    <li>Informations supplémentaires : <s:property value="details"/></li>
    <li>Duree : <s:property value="duree"/> h</li>
    <li>Date : <s:property value="date"/></li>
    <li>Nombre de places encore disponibles : <s:property value="nbPlaceDispo"/></li>
    
</ul>