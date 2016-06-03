package sistema.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;

import sistema.beans.datamodel.ConteudoDataModel;
import sistema.modelos.Conteudo;
import sistema.modelos.Pergunta;
import sistema.service.ConteudoService;

@ManagedBean
@ViewScoped
public class ConteudoPaiManagedBean {
	
	private Conteudo conteudo = new Conteudo();
	private Conteudo conteudoSelecionado;
	private ConteudoService servico = new ConteudoService();
	private List<Conteudo> conteudos;

	/**
	 * @return the conteudoSelecionado
	 */
	public Conteudo getConteudoSelecionado() {
		return conteudoSelecionado;
	}

	/**
	 * @param conteudoSelecionado
	 *            the conteudoSelecionado to set
	 */
	public void setConteudoSelecionado(Conteudo conteudoSelecionado) {
		this.conteudoSelecionado = conteudoSelecionado;
	}

	public void salvar() {
		conteudo = servico.salvar(conteudo);

		if (conteudos != null)
			conteudos.add(conteudo);

		conteudo = new Conteudo();

	}

	public DataModel<Conteudo> getConteudos() {
		if (conteudos == null)
			conteudos = servico.getConteudos();

		return new ConteudoDataModel(conteudos);
	}

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void remove(Conteudo conteudo) {
		if (servico.pesquisarPerguntasConteudo(conteudo).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível remover conteudos",
					"Conteudo possui perguntas!"));
		} else {
			servico.remover(conteudo);
			conteudos.remove(conteudo);
		}
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}

	public List<Pergunta> getPerguntasConteudo() {
		if (conteudoSelecionado != null) {
			return servico.pesquisarPerguntasConteudo(conteudoSelecionado);
		} else
			return null;
	}

	public void onRowEdit(RowEditEvent event) {

		Conteudo c = ((Conteudo) event.getObject());
		servico.alterar(c);
	}

}
