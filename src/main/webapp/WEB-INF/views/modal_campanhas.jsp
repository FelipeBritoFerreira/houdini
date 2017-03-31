<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="galeria_campanhas" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="color: #2a6496">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">  &times;</span></button>
                <h4 class="modal-title" id="myModalLabel">
                    <span class="titulo-modal">Campanhas</span>
                </h4>
            </div>
            <div class="modal-body" >
                <div class="row">
                    <div class="col-xs-12 texto-modal">

                        <span style="font-size: 12pt">
                            A Houdini também está presente nas produções high-end com foco em criar e produzir imagens digitais para agências e desenvolver do conceito à execução.
                        </span>
                        <br><br>
                        <span style="font-size: 12pt">
                            Design de produto e packing também complementam nossa expertise.
                        </span>
                    </div>
                </div>

                <c:forEach var="i" begin="1" end="17">
                    <br>
                    <div class="row">
                        <div class="col-xs-12">
                            <img src="<c:url value="/img/galeria/campanhas/${i}.jpg" />" style="width: 100%"/>
                        </div>
                    </div>
                </c:forEach>


            </div>
        </div>
    </div>
</div>