package sistema.service;

import java.util.List;

import sistema.dao.DisciplinaDAO;
import sistema.modelos.Disciplina;
import sistema.modelos.Conteudo;

public class DisciplinaService {
	
	private DisciplinaDAO disciplinaDAO = new DisciplinaDAO();

	public Disciplina salvar(Disciplina disciplina) {

		disciplina = disciplinaDAO.save(disciplina);
		disciplinaDAO.closeEntityManager();
		return disciplina;
	}

	public List<Disciplina> getDisciplinas() {
		List<Disciplina> list = disciplinaDAO.getAll(Disciplina.class);
		disciplinaDAO.closeEntityManager();
		return list;
	}

	public void alterar(Disciplina disciplina) {

		disciplinaDAO.save(disciplina);
		disciplinaDAO.closeEntityManager();

	}

	public void remover(Disciplina disciplina) {

		disciplina = disciplinaDAO.getById(Disciplina.class, disciplina.getCodDisciplina());
		disciplinaDAO.remove(disciplina);
		disciplinaDAO.closeEntityManager();
	}

	public Disciplina pesquisar(Disciplina disciplina) {

		disciplina = disciplinaDAO.getById(Disciplina.class, disciplina.getCodDisciplina());
		disciplinaDAO.closeEntityManager();
		return disciplina;
	}

	public List<Conteudo> pesquisarConteudosDisciplina(Disciplina disciplina) {

		List<Conteudo> listaConteudo;

		disciplina = disciplinaDAO.getById(Disciplina.class, disciplina.getCodDisciplina());
		listaConteudo = disciplina.getListaConteudo();

		return listaConteudo;
	}


}
