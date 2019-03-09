<%-- 
    Document   : ListerBookByAuthor
    Created on : 12 juin 2017, 14:09:37
    Author     : cdavezac
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>


 
 <s:if test="%{listAll.size()>0}">

    <table class="table">
        <thead>
        <tr>
    <th scope="col">Nom</th>
    <th scope="col">Prenom</th>
    <th scope="col">Nombre d'heures/semaines</th>
    <th scope="col">Mail</th>
    <th scope="col">telephone</th>
    <th scope="col">date de naissance</th>
  </tr>
  </thead>
  <tbody>
    <s:iterator value="listAll" status="ligne">
    <tr>
        <td><s:a href="LoadProfesseur?mail=%{mail}"><s:property value="nom"/></s:a></td>
        <td><s:property value="prenom"/></td>
        <td><s:property value="nbHeureMaxSemaine"/></td>
        <td><s:property value="mail"/></td>
        <td><s:property value="telephone"/></td>
        <td><s:property value="date_naissance"/></td>
    </tr>
    </s:iterator>
    </tbody>
 </table>
 </s:if>
  
<s:else>
    Aucun Professeur dans la liste
</s:else>
  


</table>
