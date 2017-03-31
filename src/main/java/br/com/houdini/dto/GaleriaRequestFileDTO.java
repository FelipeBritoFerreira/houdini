package br.com.houdini.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * Created by FBF0113 on 16/02/2017.
 */
public class GaleriaRequestFileDTO implements Serializable {

    private static final long serialVersionUID = -5930904419691645745L;

    private String tituloGaleria;
    private String tituloThumbnail;
    private String tituloModal;
    private String textoDesafio;
    private String textoGaleria;
    private MultipartFile[] arquivos;

    public String getTituloGaleria() {
        return tituloGaleria;
    }

    public void setTituloGaleria(String tituloGaleria) {
        this.tituloGaleria = tituloGaleria;
    }

    public String getTituloThumbnail() {
        return tituloThumbnail;
    }

    public void setTituloThumbnail(String tituloThumbnail) {
        this.tituloThumbnail = tituloThumbnail;
    }

    public String getTituloModal() {
        return tituloModal;
    }

    public void setTituloModal(String tituloModal) {
        this.tituloModal = tituloModal;
    }

    public String getTextoDesafio() {
        return textoDesafio;
    }

    public void setTextoDesafio(String textoDesafio) {
        this.textoDesafio = textoDesafio;
    }

    public String getTextoGaleria() {
        return textoGaleria;
    }

    public void setTextoGaleria(String textoGaleria) {
        this.textoGaleria = textoGaleria;
    }

    public MultipartFile[] getArquivos() {
        return arquivos;
    }

    public void setArquivos(MultipartFile[] arquivos) {
        this.arquivos = arquivos;
    }
}
