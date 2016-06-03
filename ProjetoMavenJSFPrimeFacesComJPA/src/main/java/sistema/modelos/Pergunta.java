package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Pergunta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codPergunta;
	private Pergunta tipoPergunta;
	private int qtdeUtilizada;
	private int tempo;
	private ArrayList<Prova> listaProvas = new ArrayList<Prova>();
	private String imagem;
	private int nivelDificuldade;
	private String enunciado;
	
	@ManyToMany
	public List<Conteudo> listaConteudo = new ArrayList<Conteudo>();
	
	public long getCodPergunta() {
		return codPergunta;
	}
	public void setCodPergunta(long codPergunta) {
		this.codPergunta = codPergunta;
	}
	public Pergunta getTipoPergunta() {
		return tipoPergunta;
	}
	public void setTipoPergunta(Pergunta tipoPergunta) {
		this.tipoPergunta = tipoPergunta;
	}
	public int getQtdeUtilizada() {
		return qtdeUtilizada;
	}
	public void setQtdeUtilizada(int qtdeUtilizada) {
		this.qtdeUtilizada = qtdeUtilizada;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	public ArrayList<Prova> getListaProvas() {
		return listaProvas;
	}
	public void setListaProvas(ArrayList<Prova> listaProvas) {
		this.listaProvas = listaProvas;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public int getNivelDificuldade() {
		return nivelDificuldade;
	}
	public void setNivelDificuldade(int nivelDificuldade) {
		this.nivelDificuldade = nivelDificuldade;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}		
	
	public List<Conteudo> getListaConteudo() {
		return listaConteudo;
	}
	public void setListaConteudo(List<Conteudo> listaConteudo) {
		this.listaConteudo = listaConteudo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codPergunta ^ (codPergunta >>> 32));
		result = prime * result + ((enunciado == null) ? 0 : enunciado.hashCode());
		result = prime * result + ((tipoPergunta == null) ? 0 : tipoPergunta.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pergunta other = (Pergunta) obj;
		if (codPergunta != other.codPergunta)
			return false;
		if (enunciado == null) {
			if (other.enunciado != null)
				return false;
		} else if (!enunciado.equals(other.enunciado))
			return false;
		if (tipoPergunta == null) {
			if (other.tipoPergunta != null)
				return false;
		} else if (!tipoPergunta.equals(other.tipoPergunta))
			return false;
		return true;
	}
	
	
	
	
}
