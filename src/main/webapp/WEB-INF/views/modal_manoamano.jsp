<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="galeria_manoamano" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="color: #2a6496">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">  &times;</span></button>
                <h4 class="modal-title" id="myModalLabel">
                    <span class="titulo-modal">Mano a Mano</span>
                </h4>
            </div>
            <div class="modal-body" >
                <div class="row">
                    <div class="col-xs-12 texto-modal">

                        <p>
                            Desafio: Ativar a praia de Copacana para o desafio de atletismo com Usain Bolt.
                        </p>
                        Aconteceu na praia de Copacabana, um evento com os maiores representantes do atletismo brasileiro e mundial. É o “Desafio Mano a Mano”, que contou com a presença do jamaicano Usain Bolt, Tricampeão olímpico nos 100m e 200m.
                        <br><br>Em uma pista de 150m montada na areia da praia, os velocistas Bruno Tenório Lins, Sandro Viana, Franciela Krasucki e Evelyn do Santos vão representar o Brasil na competição.
                        <br><br>O evento foi transmitido pelo programa Esporte Espetacular, da Rede Globo.
                        <br><br>Esta foi a primeira vez que os atletas correram a distância de 150m e em uma única reta dentro de uma competição, já que todos estão acostumados a competir nos 100m e 200m rasos.
                    </div>
                </div>

                <c:forEach var="i" begin="1" end="8">
                    <br>
                    <div class="row">
                        <div class="col-xs-12">
                            <img src="<c:url value="/img/galeria/manoamano/mano${i}.jpg" />" style="width: 100%"/>
                        </div>
                    </div>
                </c:forEach>

                <br>

                <div class="row">
                    <div class="col-xs-12">
                        <div class="video-container">
                            <iframe id="video-manoamano-vimeo1" src="https://player.vimeo.com/video/109290860" width="640" height="320" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>
                            <p><a href="https://vimeo.com/109290860">mano a mano 2014</a> from <a href="https://vimeo.com/user16507673">Felipe</a> on <a href="https://vimeo.com">Vimeo</a>.</p>                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>