package br.com.houdini.utils;

import br.com.houdini.beans.Galeria;
import br.com.houdini.beans.ImagemGaleria;
import br.com.houdini.beans.TipoPosicaoTextoThumbnail;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by FBF0113 on 17/03/2017.
 */
@Component
public class HtmlUtils {


    /**
     * Monta o HTML da galeria de imagens
     * @param galerias
     * @return
     */
    public String montarGalerias(List<Galeria> galerias) {

        StringBuilder html = new StringBuilder();

        for (Galeria galeria : galerias) {

            html.append("<div id=\"galeria-"+galeria.getNomeGaleria()+"\" data-toggle=\"modal\" data-target=\"#galeria_"+galeria.getNomeGaleria()+"\">");
                html.append("<figure class=\"effect-oscar  wowload fadeInUp\">");
                    html.append("<img src=\""+galeria.getImagemThumbnail().getUrl()+"\" />");
                        html.append("<figcaption>");
                            if (galeria.getTipoPosicaoTextoThumbnail() == TipoPosicaoTextoThumbnail.UMA_LINHA) {
                                html.append("<p class=\"posicao-uma-linha\">");
                            } else {
                                html.append("<p class=\"posicao-duas-linha\">");
                            }
                            html.append("<span class=\"titulo-thumbnail\">"+galeria.getTituloThumbnail()+"</span>");
                        html.append("</p>");
                    html.append("</figcaption>");
                html.append("</figure>");
            html.append("</div>");
        }

        return html.toString();

    }


    /**
     * Monta o HTML com os modais
     * @return
     */
    public String montarTodosModais(List<Galeria> galerias) {


        StringBuilder modal = new StringBuilder();

        for (Galeria galeria : galerias) {

            modal.append("<div class=\"modal fade\" id=\"galeria_"+galeria.getNomeGaleria()+"\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" style=\"color: #2a6496\">");
                modal.append("<div class=\"modal-dialog modal-lg\" role=\"document\">");
                    modal.append("<div class=\"modal-content\">");
                        modal.append("<div class=\"modal-header\">");
                        modal.append("<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>");
                    modal.append("<h4 class=\"modal-title\" id=\"myModalLabel\">");
                        modal.append("<span class=\"titulo-modal\">"+galeria.getTituloModal()+"</span>");
                    modal.append("</h4>");
                modal.append("</div>");
                modal.append("<div class=\"modal-body\" >");
                    modal.append("<div class=\"row\">");
                        modal.append("<div class=\"col-xs-12 texto-modal\">");

                        if (!galeria.getSubtituloModal().isEmpty()) {
                            modal.append("<p>");
                            modal.append(galeria.getSubtituloModal());
                            modal.append("</p>");
                        }

                        if (!galeria.getTextoModal().isEmpty()) {
                            for (String paragrafo : galeria.getTextoModal()) {
                                modal.append(paragrafo + "<br><br>");
                            }
                        }
                modal.append("</div>");
                modal.append("</div>");

                for (ImagemGaleria imagem : galeria.getImagens()) {
                    modal.append("<br>");
                        modal.append("<div class=\"row\">");
                            modal.append("<div class=\"col-xs-12\">");
                                modal.append("<img src=\"<c:url value=\""+imagem.getUrl()+"\" />\" style=\"width: 100%\"/>");
                            modal.append("</div>");
                        modal.append("</div>");
                }

                for (String video : galeria.getVideos()) {
                    modal.append("<br>");
                        modal.append("<div class=\"row\">");
                            modal.append("<div class=\"col-xs-12\">");
                                modal.append("<div class=\"video-container\">");
                                    modal.append(video);
                                modal.append("</div>");
                            modal.append("</div>");
                        modal.append("</div>");
                }

                modal.append("</div>");
                modal.append("</div>");
                modal.append("</div>");
                modal.append("</div>");

        }

        return modal.toString();
    }


}
