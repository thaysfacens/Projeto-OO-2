package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Conteudo;
import sistema.modelos.Pergunta;
import sistema.service.ConteudoService;
import sistema.service.PerguntaService;

@ManagedBean(name = "perguntaManagedBean")
@ViewScoped
public class PerguntaManagedBean {
	
	private Pergunta pergunta = new Pergunta();
	private List<Conteudo> listaConteudo;
	private PerguntaService pergService = new PerguntaService();
	private ConteudoService contService = new ConteudoService();
	private List<Pergunta> perguntas;

	public void salvar() { // Este metodo contem o erro que nao grava no Banco de Dados
		((Conteudo) listaConteudo).addPergunta(pergunta);
		pergunta.setListaConteudo(listaConteudo);

		pergunta = pergService.salvar(pergunta);

		if (perguntas != null)
			perguntas.add(pergunta);

		pergunta = new Pergunta();
		listaConteudo = null;

	}

	public List<Conteudo> getConteudos() {
		return contService.getConteudos();

	}	

	public List<Conteudo> getListaConteudo() {
		return listaConteudo;
	}

	public void setListaConteudo(List<Conteudo> listaConteudo) {
		this.listaConteudo = listaConteudo;
	}

	public void remove(Pergunta pergunta) {
		pergService.remover(pergunta);
		perguntas.remove(pergunta);
	}	

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public List<Pergunta> getPerguntas() {
		if (perguntas == null)
			perguntas = pergService.getPerguntas();

		return perguntas;
	}

	public void onRowEdit(RowEditEvent event) {

		Pergunta p = ((Pergunta) event.getObject());
		pergService.alterar(p);
	}

}
