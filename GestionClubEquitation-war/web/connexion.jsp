<%-- 
    Document   : index
    Created on : 6 mars 2019, 22:03:01
    Author     : Mathieu HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!------ HEAD ------->  
    <%@ include file="jsp/template/Header.jsp"%>
    <!------ /HEAD ------->  
    
    <body>
        <!------ MENU ------>
        <%@ include file="jsp/template/Menu.jsp"%>
        <!------ /MENU ------>
        
        
        <%@ taglib prefix="s" uri="/struts-tags" %>

        <center><h2>Connexion</h2>


        <s:if test="hasActionErrors()">


         <div class="errors">
           <s:actionerror/>
        </div>
        </s:if>    


         <div class="errors">
             <s:actionmessage/>
        </div>


        <s:form action="login" id="login" method="post">
            <s:textfield type="mail" name="mail" label="Enter Your email * " placeholder="johndoe@gmail.com"/>
             <s:password  name="password" label="Enter Your Password * " /><br>
             <s:checkbox name="RememberMe" label="Remember Me" value="RemMe" />
             <s:submit value="Login" align="right" />
        </s:form>
      
  
    
   </body>
</html>
