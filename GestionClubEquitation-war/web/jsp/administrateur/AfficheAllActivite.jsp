<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="#session.typePersonne == null || #session.typePersonne != 'admin'">
    <s:action name="gotoAccessDenied" executeResult="true"/>
</s:if> 
<s:else>


    <s:if test="%{listActivite.size()>0}">




        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Titre</th>
                    <th scope="col">Description</th>
                    <th scope="col">Date</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="listActivite" status="ligne">
                    <tr>    
                        <td><s:a href="LoadActivite?nom=%{nom}"><s:property value="nom"/></s:a></td>
                        <td><s:property value="details"/></td>
                        <td><s:property value="date"/></td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>

    </s:if>

    <s:else>
        <p class="h3" align="center">Aucune activite dans la liste</p>
    </s:else>
</s:else>  
