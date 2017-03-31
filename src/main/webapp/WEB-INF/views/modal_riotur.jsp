<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="galeria_riotur" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="color: #2a6496">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">  &times;</span></button>
                <h4 class="modal-title" id="myModalLabel">
                    <span class="titulo-modal">Rio Tur</span>
                </h4>
            </div>
            <div class="modal-body" >
                <div class="row">
                    <div class="col-xs-12 texto-modal">

                        <p>
                            Desafio:  Ativação de marca para o Rock in Rio.
                        </p>
                        Inspirado no museu MAR, o stand tem suporte de conteúdo inspirado na cidade maravilhosa contando com shows e ambientes que conduzem os visitantes
                        a uma experiência contemplativa do Rio de Janeiro.
                    </div>
                </div>

                <c:forEach var="i" begin="1" end="2">
                    <br>
                    <div class="row">
                        <div class="col-xs-12">
                            <img src="<c:url value="/img/galeria/riotur/riotur${i}.jpg" />" style="width: 100%"/>
                        </div>
                    </div>
                </c:forEach>


            </div>
        </div>
    </div>
</div>