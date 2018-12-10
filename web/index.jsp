<%--
  Created by IntelliJ IDEA.
  User: David
  Date: 09/12/2018
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Atividade SVG & JTS</title>
    <link rel="stylesheet" type="text/css" href="Assets/index.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<body>
<form id="form1" method="get" action="Controller">
    <div id="header">
        <p id="headerText">Atividade SVG & JTS</p>
        <p id="team">Equipe: Eduardo e David</p>
    </div>
    <br>
    <br>
    <div class="container">
        <div class="row">
            <div class="col-sm">
                <ul class="list-group">
                    <li class="list-group-item">
                        <center>
                            <label style="font-weight: bold">Cidade 1</label><br>
                        </center>
                        <label>Estado: </label>
                        <select name= "estado1" class="form-control" onchange="this.form.submit()" id="exampleFormControlSelect1">
                        <option>Selecione um estado...</option>
                            <c:forEach var="estado" items="${estados}">
                                <option ${estadoEscolhido1==estado?'selected':''}>${estado}</option>
                            </c:forEach>
                        </select><br>

                        <label>Cidade: </label>
                        <select name: "cidade1" class="form-control" id="exampleFormControlSelect1">
                        <option>Selecione uma cidade...</option>
                        <c:forEach var="cidade" items="${cidades}">
                            <option ${cidadeEscolhida1==cidade?'selected':''}>${cidade}</option>
                        </c:forEach>
                        </select>
                    </li>

                    <li class="list-group-item">
                        <b><label>População (Senso 2010): ${populacao1}</label></b><br>
                        <b><label>Densidade Demográfica:</label></b><br>
                        <b><label>Área:</label></b><br>
                        <b><label>Perímetro:</label></b><br>
                    </li>
                </ul>
            </div>
            <div class="col-sm">
                <ul class="list-group">
                    <li class="list-group-item">
                        <center>
                            <label style="font-weight: bold">Cidade 2</label><br>
                        </center>

                        <label>Estado: </label>
                        <select class="form-control" id="exampleFormControlSelect1">
                            <option>Selecione um estado...</option>
                        </select><br>

                        <label>Cidade: </label>
                        <select class="form-control" id="exampleFormControlSelect1">
                            <option>Selecione uma cidade...</option>
                        </select>
                    </li>

                    <li class="list-group-item">
                        <b><label>População:</label></b><br>
                        <b><label>Densidade Demográfica:</label></b><br>
                        <b><label>Área:</label></b><br>
                        <b><label>Perímetro:</label></b><br>
                    </li>
                </ul>
            </div>
        </div><br>
        <b><center>Distancia aproximada: </center></b>
    </div>
</form>
</body>
</html>