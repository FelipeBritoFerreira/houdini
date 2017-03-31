<%--
  Created by IntelliJ IDEA.
  User: FBF0113
  Date: 16/02/2017
  Time: 15:58
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Houdini</title>

    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />

    <link rel="stylesheet" type="text/css" href="/bootstrap-3.3.7-dist/css/bootstrap.min.css" />


    <script src="/resources/jquery-1.11.3.min.js"></script>
    <script src="/js/houdini.js"></script>




</head>
<body>





<%--<form id="form-arquivo" method="post" action="galeria/upload" enctype="multipart/form-data" >--%>
<form id="form-arquivo">

    <p>
    <input  type="text" id="nomeGaleria" name="nomeGaleria" placeholder="Nome da galeria" maxlength="20"><br>
    <small>Máximo 20 caracteres</small>
    </p>

    <%--<p>--%>
    <%--<input type="text" name="titulomodal" id="titulomodal" placeholder="Título do Modal" maxlength="30"><br>--%>
    <%--<small>Máximo 30 caracteres</small>--%>
    <%--</p>--%>

    <%--<p>--%>
    <%--<input type="text" name="textodesafio" id="textodesafio" placeholder="Descrição do desafio" >--%>
    <%--</p>--%>

    <%--<p>--%>
    <%--<textarea placeholder="Descrição da galeria" id="textogaleria" name="textogaleria" rows="8"></textarea>--%>
    <%--</p>--%>

    <p>
    <input type="file" name="arquivos" >
    </p>

    <p>
    <input type="file" name="arquivos" >
    </p>

    <%--<p>--%>
    <%--<input type="file" id="arquivo2" name="arquivos" >--%>
    <%--</p>--%>

    <p>
    <input type="submit" id="bt-enviar-arquivo" value="enviar">
    </p>

</form>





</body>
</html>
