<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="galeria_verao" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="color: #2a6496">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">  &times;</span></button>
                <h4 class="modal-title" id="myModalLabel">
                    <span class="titulo-modal">Verão O Globo</span>
                </h4>
            </div>
            <div class="modal-body" >
                <div class="row">
                    <div class="col-xs-12 texto-modal">

                        <p>
                            Desafio: Desenvolver na orla de Ipanema o melhor point do verão carioca.
                        </p>
                        Na estação mais quente do ano, uma das melhores opções dos cariocas e turistas que estão na cidade é curtir os dias ensolarados nas praias do Rio de Janeiro. Melhor ainda é aproveitar as atividades gratuitas do “Verão Rio”, projeto do jornal O Globo em parceria com a Orla Rio, que contempla os banhistas com muito esporte, lazer, serviço e música.
                        <br><br>Para quem curte boa música, teve shows com bandas de Reggae, Surf Music, MPB, POP e Bossa Nova, além de um DJ que não deixou ninguém parado na tenda principal do evento.
                        <br><br>O espaço também contou com ações que visavam o bem-estar, saúde e harmonia do corpo, como shiatsu e yoga. A marca Blue Man aproveitou o espaço para promover um desfile e apresentar ao público modelos de sua coleção de verão 2015.
                        <br><br>O público teve a oportunidade de curtir o show de George Israel, saxofonista e violonista do Kid Abelha desde sua formação em 1981 e que mantém carreira solo paralelamente desde 2004.
                        <br><br>No dia seguinte foi a vez da apresentação da Móveis Coloniais de Acaju, banda brasileira avant-gardede pop rock e art rock, com influências do indie rock, pós-punk, garage rock, ska e música típica brasileira.
                        <br><br>O projeto recebeu também, em outras datas, a Banda Tereza, Sergio Brito, Noite do Vinil, Criadores de Acaso, Ana Canãs, Tiago Iorc, Dodô, Jesuton, entre outros.
                        <br><br>A terceira edição do projeto Verão Rio foi uma realização do jornal O Globo em parceria com a Orla Rio e Prefeitura por intermédio da RioTur, e tem patrocínio master da TRESsemmé, patrocínio da Smirnoff, Pão de Açúcar e Leite de Rosas.
                    </div>
                </div>

                <c:forEach var="i" begin="1" end="15">
                    <br>
                    <div class="row">
                        <div class="col-xs-12">
                            <img src="<c:url value="/img/galeria/verao/verao${i}.jpg" />" style="width: 100%"/>
                        </div>
                    </div>
                </c:forEach>

                <br>

                <div class="row">
                    <div class="col-xs-12">
                        <div class="video-container">
                            <iframe id="video-verao-youtube1" width="853" height="480" src="https://www.youtube.com/embed/v51-39RJ4tU" frameborder="0" allowfullscreen ></iframe>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>