<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="galeria_rodaskol" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="color: #2a6496">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">  &times;</span></button>
                <h4 class="modal-title" id="myModalLabel">
                    <span class="titulo-modal">Roda Skol</span>
                </h4>
            </div>
            <div class="modal-body" >
                <div class="row">
                    <div class="col-xs-12 texto-modal">

                        <p>
                            Desafio: Integrar a marca Skol no verão carioca em um evento único midiático que integre e ofereça aos visitantes uma experiência de marca inédita.
                        </p>
                                Entretenimento, interatividade, arte, cultura e uma linda vista panorâmica. Essas são as propostas para a roda-gigante instalada no Forte de Copacabana, no Rio de Janeiro.
                        <br><br>A nova atração turística da capital fluminense é patrocinada pela cerveja Skol e será inaugurada para o público no feriado de São Sebastião, padroeiro da cidade.
                        <br><br>Importada da Alemanha, com 36 metros de altura - equivalente a um prédio de 12 andares -, 80 toneladas e 24 gôndolas com seis lugares cada uma, a roda-gigante virá recheada de alta tecnologia.
                        <br><br>Segundo os organizadores, as gôndolas serão equipadas com som ambiente e saídas para MP3 Player.
                        <br><br>Os visitantes puderam montar uma roda de amigos na roda-gigante, ao som da trilha sonora pessoal e com o privilégio da bela paisagem das praias de Copacabana e Ipanema.
                        <br><br>O Campo de Marte, a área externa do Forte que recebe a atração, contou ainda com dois bares - o da Roda, mobiliado para "criar" rodas de amigos, e o da Pista, instalado em frente à roda, com muita música, tecnologia e um lounge com música ambiente.
                        <br><br>Montados em um amplo espaço de sete mil metros quadrados, esses três ambientes receberam até quatro mil pessoas.
                    </div>
                </div>

                <%--<c:forEach var="i" begin="1" end="8">--%>
                    <%--<br>--%>
                    <%--<div class="row">--%>
                        <%--<div class="col-xs-12">--%>
                            <%--<img src="<c:url value="/img/galeria/manoamano/mano${i}.jpg" />" style="width: 100%"/>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</c:forEach>--%>

                <br>

                <div class="row">
                    <div class="col-xs-12">
                        <div class="video-container">
                            <iframe id="video-rodaskol-vimeo1" src="https://player.vimeo.com/video/82312585" width="640" height="320" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>
                            <p><a href="https://vimeo.com/82312585">Roda Skol</a> from <a href="https://vimeo.com/user16507673">Felipe</a> on <a href="https://vimeo.com">Vimeo</a>.</p>                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>