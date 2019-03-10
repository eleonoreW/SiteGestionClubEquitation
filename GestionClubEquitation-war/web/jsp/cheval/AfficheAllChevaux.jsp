<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="%{listAllCheval.size()>0}">
    <table class="table">
        <thead>
            <tr>
                <th scope="col">Nom</th>
                <th scope="col">Date de Naissance</th>
                <th scope="col">Description</th>
                <th scope="col">Commentaire</th>
                <th scope="col">Taille</th>
            </tr>
        </thead>
        <tbody>
            <s:iterator value="listAllCheval" status="ligne">
                <tr>
                    <td><s:a href="LoadCheval?nom=%{nom}"><s:property value="nom"/></s:a></td>
                    <td><s:property value="dateNaissance"/></td>
                    <td><s:property value="description"/></td>
                    <td><s:property value="commentaire"/></td>
                    <td><s:property value="taille"/></td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</s:if>
<s:else>
    Pas de chevaux à consulter.
</s:else> 