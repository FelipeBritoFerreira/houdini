<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="modal fade" id="galeria_nissan" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="color: #2a6496">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">
                    <span class="titulo-modal">Nissan Olympic Games</span>
                </h4>
            </div>

            <div class="modal-body" >
                <div class="row">
                    <div class="col-xs-12 texto-modal">

                        <p>
                            Desafio: Tornar o programa Nissan Hospitality o maior point e Hub de informação e lazer durante as Olimpíadas Rio 2016.
                        </p>

                        Uma das grandes atrações do Rio de Janeiro nos Jogos Olímpicos, o Hotel Nissan Kicks, em Copacabana, transformou-se em num dos mais badalados points da cidade.

                        <br><br>Durante o dia, o espaço foi totalmente dedicado ao trabalho, com áreas específicas para quem quiser acompanhar as competições.
                        <br><br>Porém, à noite, a música toma conta do ambiente, com concorridíssimos shows no roof top.
                        <br><br>Como pano de fundo, a deslumbrante vista da praia mais famosa do Brasil. Com tecnologia avançada, bancadas de trabalho, backdrops, televisões com transmissão dos Jogos e local para entrevistas, o Media Room, uma área reservada aos profissionais de imprensa.
                        <br><br>Um totem interativo foi instalado para que as pessoas possam imprimir, através de perfis no Instagram, suas fotos preferidas. Para isso, foi necessária a utilização da hastag #Quemseatreve e o login na conta desta rede social.
                        <br><br>O espaço foi aberto a todos os profissionais de imprensa, com vagas limitadas.
                        <br><br>A parte musical contou com dez espetáculos exclusivos, apenas para convidados. O leque de atrações é bastante eclético, com artistas como Maria Rita, Ludmila, Projota, Paralamas do Sucesso, Banda Eva, Xande de Pilares & Salgueiro, Daniel, Zeca Pagodinho, Jorge Aragão e Diogo Nogueira.

                    </div>
                </div>


                <c:forEach var="i" begin="1" end="9">
                    <br>
                    <div class="row">
                        <div class="col-xs-12">
                            <img src="<c:url value="/img/galeria/nissan/nissan${i}.jpg" />" style="width: 100%"/>
                        </div>
                    </div>
                </c:forEach>

                <br>

                <div class="row">
                    <div class="col-xs-12">
                        <div class="video-container">
                            <iframe id="video-nissan-vimeo1" src="https://player.vimeo.com/video/169748781" width="640" height="360" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>
                            <p><a href="https://vimeo.com/169748781">NISSAN</a> from <a href="https://vimeo.com/user16507673">Felipe</a> on <a href="https://vimeo.com">Vimeo</a>.</p>
                        </div>
                    </div>
                </div>

                <br>

                <div class="row">
                    <div class="col-xs-12">
                        <div class="video-container">
                            <iframe id="video-nissan-youtube1" width="853" height="480" src="https://www.youtube.com/embed/2PSDSr3VcSA" frameborder="0" allowfullscreen ></iframe>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

</div>
