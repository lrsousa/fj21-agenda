package br.com.caelum.agenda.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

@Transactional
@Controller
public class AgendaController {
	
	@Qualifier("jpaContatoDao")
	@Autowired
	ContatoDao dao;
	
	/* Sem construtor */
	/*
	@Autowired
	public AgendaController(JdbcContatoDao dao) {
		this.dao = dao;
	}
	*/
	
	@RequestMapping("novoContato")
	public String form() {
		return "agenda/formulario";
	}
	
	@RequestMapping("adicionaContato")
	public String adiciona(@Valid Contato contato, BindingResult result) {
		if(result.hasFieldErrors("nome")) {
			return "agenda/formulario";
		}
		dao.adiciona(contato);
		return "redirect:listaContatos";
	}
	
	@RequestMapping("listaContatos")
	public String lista(Model model) {
		model.addAttribute("contatos", dao.lista());
		return "agenda/lista";
	}
	
	@RequestMapping("removeContato")
	public void remove(Contato contato, HttpServletResponse response) {
		dao.remove(contato);
		response.setStatus(200);
	}
	
	@RequestMapping("mostraContato")
	public String mostra(Long id, Model model) {
		model.addAttribute("contato", dao.consultaPorId(id));
		return "agenda/mostra";
	}
	
	@RequestMapping("alteraContato")
	public String altera(Contato contato) {
		dao.altera(contato);
		return "redirect:listaContatos";
	}
}