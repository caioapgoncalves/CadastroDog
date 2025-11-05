package org.example.controller;

import org.example.model.Cachorro;
import org.example.service.TypeCachorroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult; // Import não usado, mas comum
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.example.service.CachorroService;
@Controller
public class CachorroController {

    @Autowired
    private CachorroService service;

    @Autowired
    private TypeCachorroService typeCachorroService;

    // Este método é chamado quando o usuário acessa "http://localhost:8080/".
    @GetMapping("/")
    public ModelAndView findAll(){

        ModelAndView modelAndView = new ModelAndView("cachorro"); // Define o HTML
        modelAndView.addObject("cachorros", service.findAll()); // Busca os dados no Service e anexa
        return modelAndView;
    }

    //@GetMapping("/add"): Mapeia a URL para mostrar o formulário de adição.
    @GetMapping("/add")
    public ModelAndView add(Cachorro cachorro){ // Recebe um objeto "Cachorro" vazio
        ModelAndView modelAndView = new ModelAndView("cachorroAdd"); // Aponta para "cachorroAdd.html"
        modelAndView.addObject("cachorro", cachorro); // Envia o objeto vazio para o form (th:object)
        modelAndView.addObject("racas", typeCachorroService.findAll()); // Busca as raças para o dropdown
        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
        // Verifica se o cachorro com esse ID realmente existe
        if(service.findOne(id).isPresent()) {
            // Se existe, REUTILIZAMOS o método add()
            // mas, em vez de um objeto vazio, passamos o cachorro que encontramos no banco.
            // O Thymeleaf vai usar esses dados para preencher o formulário.
            return add(service.findOne(id).get());
        }
        // Se não achou o ID, apenas volta para a home.
        return findAll();
    }


    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id){
        service.delete(id); // Manda o Service deletar
        return findAll(); // Recarrega a página inicial
    }


    //pega todos os dados do form e "monta" um objeto Cachorro.
    @PostMapping("/save")
    public String salvarCachorro(@ModelAttribute("cachorro") Cachorro cachorro) {

        // 1. Manda o Service salvar o objeto no banco de dados.
        service.save(cachorro);

        // Em vez de retornar para a lista, nós retornamos um "redirect:".
        // Isso força o navegador do usuário a fazer uma NOVA REQUISIÇÃO
        // para a página estática "fotoCachorro.html", iniciando o fluxo da API.
        return "redirect:/fotoCachorro.html";
    }
}