<%-- 
    Document   : index
    Created on : 23/03/2014, 07:32:29 PM
    Author     : aya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>SICEE</title>

        <!-- Bootstrap core CSS -->
        <link href="<s:url value="css/bootstrap.css"/>" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/login.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy this line! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>

        <input type="button" class="btn btn-default" value="Boton">

        <div class="container">

            <s:form class="form-signin" role="form">
                <h2 class="form-signin-heading">Bienvenido a SICEE</h2>
                <br>
                
                <s:textfield class="form-control" placeholder="Usuario" required="" autofocus=""/>
                <s:password class="form-control" placeholder="Password" required=""/>
                <br>
                <s:submit class="btn btn-lg btn-primary btn-block"/>
            </s:form>

        </div> <!-- /container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
    </body>
</html>