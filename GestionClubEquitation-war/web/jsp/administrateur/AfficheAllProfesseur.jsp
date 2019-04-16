<%-- 
    Document   : ListerBookByAuthor
    Created on : 12 juin 2017, 14:09:37
    Author     : cdavezac
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="#session.typePersonne == null || #session.typePersonne != 'admin'">
    <s:action name="gotoAccessDenied" executeResult="true"/>
</s:if> 
<s:else>



    <s:if test="%{listAll.size()>0}">

        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Nom</th>
                    <th scope="col">Prenom</th>
                    <th scope="col">Nombre d'heures/semaines</th>
                    <th scope="col">Mail</th>
                    <th scope="col">Telephone</th>
                    <th scope="col">Date de naissance</th>
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
        <p class="h3" align="center">Aucun Professeur dans la liste</p>
    </s:else>

</s:else>  