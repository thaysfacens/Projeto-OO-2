package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


@Entity
public class Conteudo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codConteudo;
	private String nomeConteudo;	
	private int organizarConteudo;	
	
	@ManyToMany
	private List<Pergunta> listaPerguntas = new ArrayList<Pergunta>();
	
	@OneToOne
	private Disciplina disciplina;		
	
	public Conteudo(long codConteudo, String nomeConteudo) {
		super();
		this.codConteudo = codConteudo;
		this.nomeConteudo = nomeConteudo;		
	}

	public Conteudo() {		
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public long getCodConteudo() {
		return codConteudo;
	}
	
	public void setCodConteudo(long codConteudo) {
		this.codConteudo = codConteudo;
	}
	
	public String getNomeConteudo() {
		return nomeConteudo;
	}
	
	public void setNomeConteudo(String nomeConteudo) {
		this.nomeConteudo = nomeConteudo;
	}
	
	public List<Pergunta> getListaPerguntas() {
		return listaPerguntas;
	}
	
	public void setListaPerguntas(List<Pergunta> listaPerguntas) {
		this.listaPerguntas = listaPerguntas;
	}
	
	public void addPergunta(Pergunta pergunta)	{
		listaPerguntas.add(pergunta);		
	}
	
	public int getOrganizarConteudo() {
		return organizarConteudo;
	}
	
	public void setOrganizarConteudo(int organizarConteudo) {
		this.organizarConteudo = organizarConteudo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeConteudo == null) ? 0 : nomeConteudo.hashCode());
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
		Conteudo other = (Conteudo) obj;
		if (nomeConteudo == null) {
			if (other.nomeConteudo != null)
				return false;
		} else if (!nomeConteudo.equals(other.nomeConteudo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Conteudo [codConteudo=" + codConteudo + ", nomeConteudo=" + nomeConteudo + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
