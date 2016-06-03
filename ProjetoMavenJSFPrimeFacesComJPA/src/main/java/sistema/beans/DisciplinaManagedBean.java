package sistema.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;

import sistema.beans.datamodel.DisciplinaDataModel;
import sistema.modelos.Disciplina;
import sistema.modelos.Conteudo;
import sistema.service.DisciplinaService;

@ManagedBean
@ViewScoped
public class DisciplinaManagedBean {
	
	private Disciplina disciplina = new Disciplina();
	private Disciplina disciplinaSelecionada;
	private DisciplinaService servico = new DisciplinaService();
	private List<Disciplina> disciplinas;

	/**
	 * @return the disciplinaSelecionada
	 */
	public Disciplina getDisciplinaSelecionada() {
		return disciplinaSelecionada;
	}

	/**
	 * @param disciplinaSelecionada
	 *            the disciplinaSelecionada to set
	 */
	public void setDisciplinaSelecionada(Disciplina disciplinaSelecionada) {
		this.disciplinaSelecionada = disciplinaSelecionada;
	}

	public void salvar() {
		disciplina = servico.salvar(disciplina);

		if (disciplinas != null)
			disciplinas.add(disciplina);

		disciplina = new Disciplina();

	}

	public DataModel<Disciplina> getDisciplinas() {
		if (disciplinas == null)
			disciplinas = servico.getDisciplinas();

		return new DisciplinaDataModel(disciplinas);
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void remove(Disciplina disciplina) {
		if (servico.pesquisarConteudosDisciplina(disciplina).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível remover disciplinas",
					"Disciplina possui conteudos!"));
		} else {
			servico.remover(disciplina);
			disciplinas.remove(disciplina);
		}
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Conteudo> getConteudosDisciplina() {
		if (disciplinaSelecionada != null) {
			return servico.pesquisarConteudosDisciplina(disciplinaSelecionada);
		} else
			return null;
	}

	public void onRowEdit(RowEditEvent event) {

		Disciplina d = ((Disciplina) event.getObject());
		servico.alterar(d);
	}


}
