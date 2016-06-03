package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Entity
public class Disciplina implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codDisciplina;
	private String nomeDisciplina;	
	
	@Transient
	private Professor professor;
	
	@OneToMany(mappedBy="disciplina")
	private List<Conteudo> listaConteudo = new ArrayList<Conteudo>();
	
	//Many...
	private ArrayList<Prova> listaProvas = new ArrayList<Prova>();	
	
	public Disciplina(long codDisciplina, String nomeDisciplina) {
		super();
		this.codDisciplina = codDisciplina;
		this.nomeDisciplina = nomeDisciplina;
	}
	
	public Disciplina() {
		
	}
	
	public long getCodDisciplina() {
		return codDisciplina;
	}
	
	public void setCodDisciplina(long codDisciplina) {
		this.codDisciplina = codDisciplina;
	}
	
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	public List<Conteudo> getListaConteudo() {
		return listaConteudo;
	}
	
	public void setListaConteudo(List<Conteudo> listaConteudo) {
		this.listaConteudo = listaConteudo;
	}
	
	public ArrayList<Prova> getListaProvas() {
		return listaProvas;
	}
	
	public void setListaProvas(ArrayList<Prova> listaProvas) {
		this.listaProvas = listaProvas;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public void addConteudo(Conteudo conteudo)	{
		listaConteudo.add(conteudo);		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeDisciplina == null) ? 0 : nomeDisciplina.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (nomeDisciplina == null) {
			if (other.nomeDisciplina != null)
				return false;
		} else if (!nomeDisciplina.equals(other.nomeDisciplina))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disciplina [codDisciplina=" + codDisciplina + ", nomeDisciplina=" + nomeDisciplina + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
