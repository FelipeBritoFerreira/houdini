<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="galeria_rockinrio" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="color: #2a6496">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">  &times;</span></button>
                <h4 class="modal-title" id="myModalLabel">
                    <span class="titulo-modal">Rock in Rio</span>
                </h4>
            </div>
            <div class="modal-body" >


                <div class="row">

                    <div class="col-xs-12 texto-modal">

                        <p>
                            Ativação das marcas dentro do evento.
                        </p>

                        <hr>

                        <p>
                            BACARDI
                        </p>
                        <p>
                            Desafio: Ativação do novo rum Bacardí Big Apple no Rock in Rio.
                        </p>



                        O rum saborizado BACARDÍ BIG APPLE teve um espaço exclusivo dentro da Cidade do Rock durante a edição 2013 do Rock In Rio.
                        <br><br>No espaço, com cerca de 140 m², serão promovidas ações sensoriais com o conceito “Liberdade para os Sentidos”, o mote da campanha de BACARDÍ BIG APPLE.
                        <br><br>Os visitantes poderão se divertir com um gerador de eletrostática – que deixa muitos cabelos arrepiados –, saborear maçãs verdes dispostas em uma grande garrafa do rum saborizado, observar em tempo real outro palco do festival por um big “olho”, e aproveitar um backdrop para tirar fotos.
                        <br><br>O espaço teve paredes decoradas com garrafas e painéis de LED sincronizados com o aplicativo da marca no Facebook. Esses mesmos painéis proporcionarão a interação entre os visitantes do quiosque BACARDÍ BIG APPLE em Copacabana – que funcionou como um grande ponto de encontro e esquenta oficial do festival – e do stand da marca no Rock In Rio ao permitir a troca de mensagens entre o público dos dois lugares.
                        <br><br>Os coquetéis criados pelo mixologista Alex Mesquita especialmente para o evento puderam ser degustados na área VIP do Rock in Rio, exclusiva para convidados.
                    </div>
                </div>

                <c:forEach var="i" begin="1" end="6">
                    <br>
                    <div class="row">
                        <div class="col-xs-12">
                            <img src="<c:url value="/img/galeria/rockinrio/ba${i}.jpg" />" style="width: 100%"/>
                        </div>
                    </div>
                </c:forEach>



                <div class="row" style="margin-top: 5%">

                    <div class="col-xs-12 texto-modal">

                        <p>
                            HEINEKEN
                        </p>
                        <span style="font-size: 12pt">Bar da Área VIP + Lounge + Chegada Tirolesa.</span>
                    </div>
                </div>

                <c:forEach var="i" begin="1" end="10">
                    <br>
                    <div class="row">
                        <div class="col-xs-12">
                            <img src="<c:url value="/img/galeria/rockinrio/h${i}.jpg" />" style="width: 100%"/>
                        </div>
                    </div>
                </c:forEach>



                <div class="row" style="margin-top: 5%">

                    <div class="col-xs-12 texto-modal">

                        <p>
                            RIOTUR
                        </p>
                        <span style="font-size: 12pt">
                            Inspirado no museu MAR, o stand tem suporte de conteúdo inspirado na cidade maravilhosa contando com shows e ambientes que conduzem os visitantes
                        a uma experiência contemplativa do Rio de Janeiro.
                        </span>
                    </div>
                </div>

                <c:forEach var="i" begin="1" end="2">
                    <br>
                    <div class="row">
                        <div class="col-xs-12">
                            <img src="<c:url value="/img/galeria/rockinrio/riotur${i}.jpg" />" style="width: 100%"/>
                        </div>
                    </div>
                </c:forEach>




            </div>
        </div>
    </div>
</div>