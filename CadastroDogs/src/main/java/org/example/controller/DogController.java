package org.example.controller;

import org.example.model.FotoCachorro;
import org.example.service.DogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController: ESTE é um controller de API.
 * A grande diferença: ele não retorna HTML. Ele retorna DADOS PUROS (JSON).
 * É usado para ser consumido por JavaScripts (como o nosso 'fetch').
 */
@RestController
@RequestMapping("/api/cachorro") // URL base para este controller (ex: /api/cachorro)
public class DogController {

    private final DogService dogService;

    /**
     * Construtor (Injeção de Dependência via Construtor).
     * Esta é uma forma moderna de @Autowired. Dizemos: "Spring, para criar
     * um DogController, você OBRIGATORIAMENTE precisa me dar um DogService."
     */
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    //Este é o método que o JavaScript da página 'fotoCachorro.html' chama
    @GetMapping
    public FotoCachorro buscarFoto(){

        // Retorna o objeto FotoCachorro.
        return dogService.buscarFoto();
    }
}