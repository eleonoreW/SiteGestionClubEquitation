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
      <h1>Hello World From Struts2</h1>
      <form action = "hello">
         <label for = "name">Please enter your name</label><br/>
         <input type = "text" name = "name"/>
         <input type = "submit" value = "Say Hello"/>
      </form>
      
      
    <!------ FOOTER ------->  
    <%@ include file="jsp/template/Footer.jsp"%>
    <!------ /FOOTER ------->   
    
   </body>
</html>
