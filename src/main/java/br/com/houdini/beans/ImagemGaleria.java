package br.com.houdini.beans;

public class ImagemGaleria {
	
	private String url;
	private String nomeArquivo;
	private TipoImagem tipoImagem;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public TipoImagem getTipoImagem() {
		return tipoImagem;
	}

	public void setTipoImagem(TipoImagem tipoImagem) {
		this.tipoImagem = tipoImagem;
	}
}
