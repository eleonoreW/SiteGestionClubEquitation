<%-- 
    Document   : AjoutPersonne
    Created on : 7 mars 2019, 13:42:07
    Author     : bguil
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--<link rel="stylesheet" href="../../css/administrationMenu.css" />-->
<title>Page Administrateur</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%@ taglib prefix="s" uri="/struts-tags" %>
</head>
    
    <body>

	<nav id="adminMenu">
                           
            <ul>
                <li><a class="active" href="" >Employés</a></li>
                <li><a href="" >Chevaux</a></li>
                <li><a href="#" >Accueil</a>   </li>
            </ul>   
	</nav>   
        
        
        <section id="adminSection">
                  
            <div id="formulaire">
            <center><h2>Ajout d'un nouvel administrateur</h2>


            <s:form action="AddNewAdminForm" >		

                <s:textfield name="admin_nom" id="admin_firstname"
                        label="nom" labelposition="left" required="required" autofocus="autofocus">
                </s:textfield>	
                <s:textfield name="admin_prenom" id="admin_prenom"
                        label="prenom" labelposition="left" required="required">
                </s:textfield>	
                <s:textfield name="admin_mail" id="admin_mail"
                        label="mail" labelposition="left" required="required">
                </s:textfield>	
                <s:textfield name="admin_tel" id="admin_tel"
                        label="tel" labelposition="left" required="required">
                </s:textfield>
                <s:textfield name="admin_datenaissance" id="admin_datenaissance"
                        label="date de naissance" labelposition="left" required="required">
                </s:textfield>
                <s:submit value = "Register" align="center"></s:submit>

            </s:form>
                
        <s:if test="%{bookList.size()>0}" >
        <s:iterator value="bookList">        
    
            <div id="line1">
                
                  <div id="cover">
                      <img src=" <s:property value='getImage_path()'/> ">
                
                  </div>
                
                  <div id="book_text">
                        <div id="book_title">   
                             <b>Title : </b><b><s:property value="book.getTitle()"/></b>
                        </div>
                      
                        <div id="book_author">   
                            <b>Author : </b><s:property value="author[#pos.index].getAuthor_lastname()"/>
                            <s:property value="author[#pos.index].getAuthor_firstname()"/>
                        </div>
                        <div id="book_editor">   
                            <b>Editor : </b><s:property value="getEditor().getEditor_name()"/>
                        </div>
                        <div id="book_category">   
                            <b>Category : </b><s:property value="getCategory().getCategory_name()"/>/ <b>Price :</b><s:property value="getBook_price()"/>
                        </div>
                      
                        <div id="book_publication_date">               
                                <b>Published :</b><s:property value="getPublication_date()"/>                           
                        </div>
                      
                        <div id="book_isbn">               
                                <b>Isbn : </b><s:property value="getiSBN()"/>                                
                        </div>
                      
                        <div id="book_information">               
                             <s:property value="getBook_description()"/>
                        </div>
                
            </div>
        </div>  
        </s:iterator>  
        </s:if>
        <s:else>
            No book stored in database
        </s:else>   
                
                
	</div>    
