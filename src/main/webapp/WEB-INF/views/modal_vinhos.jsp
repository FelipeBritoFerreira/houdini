<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="galeria_vinho" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="color: #2a6496">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">  &times;</span></button>
                <h4 class="modal-title" id="myModalLabel">
                    <span class="titulo-modal">Vinhos de Portugal</span>
                </h4>
            </div>
            <div class="modal-body" >
                <div class="row">
                    <div class="col-xs-12 texto-modal">

                        <p>
                            Desafio: Trazer os melhores vinhos portugueses para o Rio de Janeiro em um evento inédito na cidade.
                        </p>
                        Branco, tinto, rosé, do Douro, do Alentejo, do Dão, de Setúbal – os vinhos portugueses foram as grandes estrelas durante os três dias do Vinhos de Portugal no Rio, evento organizado pelos jornais PÚBLICO e O Globo em parceria com a ViniPortugal.

                        <br><br>Entre 20 e 22 de Maio, o CasaShopping, na Barra da Tijuca, Rio de Janeiro, recebeu oito mil pessoas que quiseram conhecer melhor os vinhos portugueses e as regiões vitivinícolas.
                        <br><br>Houve muitas perguntas sobre castas e terroirs, mas também sobre os enoturismos que se podem visitar, os hotéis onde se pode ficar e as especialidades gastronómicas de cada região.
                        <br><br>Durante os três dias, os 66 produtores presentes no evento abriram garrafas, deram a provar e contaram as histórias dos seus vinhos.
                        <br><br>Os produtores portugueses acreditam que é preciso continuar a apostar neste mercado. E para Jorge Monteiro, Presidente da ViniPortugal, é mesmo altura de ir mais longe e, no próximo ano, levar o Vinhos de Portugal também até São Paulo.
                    </div>
                </div>

                <c:forEach var="i" begin="1" end="13">
                    <br>
                    <div class="row">
                        <div class="col-xs-12">
                            <img src="<c:url value="/img/galeria/vinho/v${i}.jpg" />" style="width: 100%"/>
                        </div>
                    </div>
                </c:forEach>

                <br>

                <div class="row">
                    <div class="col-xs-12">
                        <div class="video-container">
                            <iframe id="video-vinhos-youtube1" width="853" height="480" src="https://www.youtube.com/embed/GO8mKY5tmI8" frameborder="0" allowfullscreen ></iframe>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>