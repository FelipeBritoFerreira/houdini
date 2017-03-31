package br.com.houdini.beans;

import java.util.List;

public class Galeria {
	
	private String nomeGaleria;
	private List<ImagemGaleria> imagens;
	private String tituloThumbnail;
	private String tituloModal;
	private String subtituloModal;
	private List<String> textoModal;
	private List<String> videos;
	private ImagemGaleria imagemThumbnail;
	private TipoPosicaoTextoThumbnail tipoPosicaoTextoThumbnail;
	private int ordemThumbnail;

	public String getNomeGaleria() {
		return nomeGaleria;
	}

	public void setNomeGaleria(String nomeGaleria) {
		this.nomeGaleria = nomeGaleria;
	}

	public List<ImagemGaleria> getImagens() {
		return imagens;
	}

	public void setImagens(List<ImagemGaleria> imagens) {
		this.imagens = imagens;
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

	public String getSubtituloModal() {
		return subtituloModal;
	}

	public void setSubtituloModal(String subtituloModal) {
		this.subtituloModal = subtituloModal;
	}

	public List<String> getTextoModal() {
		return textoModal;
	}

	public void setTextoModal(List<String> textoModal) {
		this.textoModal = textoModal;
	}

	public List<String> getVideos() {
		return videos;
	}

	public void setVideos(List<String> videos) {
		this.videos = videos;
	}

	public ImagemGaleria getImagemThumbnail() {
		return imagemThumbnail;
	}

	public void setImagemThumbnail(ImagemGaleria imagemThumbnail) {
		this.imagemThumbnail = imagemThumbnail;
	}

	public TipoPosicaoTextoThumbnail getTipoPosicaoTextoThumbnail() {
		return tipoPosicaoTextoThumbnail;
	}

	public void setTipoPosicaoTextoThumbnail(TipoPosicaoTextoThumbnail tipoPosicaoTextoThumbnail) {
		this.tipoPosicaoTextoThumbnail = tipoPosicaoTextoThumbnail;
	}

	public int getOrdemThumbnail() {
		return ordemThumbnail;
	}

	public void setOrdemThumbnail(int ordemThumbnail) {
		this.ordemThumbnail = ordemThumbnail;
	}
}
