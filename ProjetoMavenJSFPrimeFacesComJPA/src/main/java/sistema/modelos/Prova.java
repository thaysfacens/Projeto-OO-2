package sistema.modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prova {
	
	private long codProva;
	private int tempoExecucao;
	private int dificuldadeProva;
	private Date dataAplicacao;
	private Disciplina disciplina;
	private String nomeFaculdade;
	private String nomeTurma;
	private List<Pergunta> listaPerguntas = new ArrayList<Pergunta>();
	private ArrayList<Conteudo> listaConteudo = new ArrayList<Conteudo>();
	
	public long getCodProva() {
		return codProva;
	}
	public void setCodProva(long codProva) {
		this.codProva = codProva;
	}
	public int getTempoExecucao() {
		return tempoExecucao;
	}
	public void setTempoExecucao(int tempoExecucao) {
		this.tempoExecucao = tempoExecucao;
	}
	public int getDificuldadeProva() {
		return dificuldadeProva;
	}
	public void setDificuldadeProva(int dificuldadeProva) {
		this.dificuldadeProva = dificuldadeProva;
	}
	public Date getDataAplicacao() {
		return dataAplicacao;
	}
	public void setDataAplicacao(Date dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public String getNomeFaculdade() {
		return nomeFaculdade;
	}
	public void setNomeFaculdade(String nomeFaculdade) {
		this.nomeFaculdade = nomeFaculdade;
	}
	public String getNomeTurma() {
		return nomeTurma;
	}
	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}
	public List<Pergunta> getListaPerguntas() {
		return listaPerguntas;
	}
	public void setListaPerguntas(List<Pergunta> listaPerguntas) {
		this.listaPerguntas = listaPerguntas;
	}
	public ArrayList<Conteudo> getListaConteudo() {
		return listaConteudo;
	}
	public void setListaConteudo(ArrayList<Conteudo> listaConteudo) {
		this.listaConteudo = listaConteudo;
	}
	
		
}
