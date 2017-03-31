<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="galeria_friboi" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="color: #2a6496">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">  &times;</span></button>
                <h4 class="modal-title" id="myModalLabel">
                    <span class="titulo-modal">Friboi</span>
                </h4>
            </div>
            <div class="modal-body" >
                <div class="row">
                    <div class="col-xs-12 texto-modal">

                        <p>
                            Desafio: Ativar a marca no evento Rio Gastronomia.
                        </p>
                        A plataforma Academia da Carne Friboi criou uma série de ações de ativação, que começam com a apresentação massiva da plataforma, em 650 varejistas de todo o Brasil.
                        <br><br>Foi montada no evento uma estação de aulas e consumo, reunindo em um único espaço todas as soluções para a elaboração da Academia da Carne Friboi.
                        <br><br>Se a sugestão for Picanha, por exemplo, o produto estará no refrigerador assim como os ingredientes devidamente estocados e condicionados no local.
                        <br><br>A Estação da Academia da Carne Friboi  levará os chefs parceiros para os pontos de venda. Lá, eles darão aulas rápidas de gastronomia.
                    </div>
                </div>

                <c:forEach var="i" begin="1" end="3">
                    <br>
                    <div class="row">
                        <div class="col-xs-12">
                            <img src="<c:url value="/img/galeria/friboi/fri${i}.jpg" />" style="width: 100%"/>
                        </div>
                    </div>
                </c:forEach>


            </div>
        </div>
    </div>
</div>