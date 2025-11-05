package org.example.service;

import org.example.model.FotoCachorro;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class DogService {

    //A URL fixa da API externa que queremos chamar.
    private final String API_URL = "https://dog.ceo/api/breeds/image/random";

    //Este método faz a mágica de chamar a API externa.
    public FotoCachorro buscarFoto(){

        // RestTemplate é a ferramenta do Spring para fazer chamadas HTTP (acessar URLs).
        RestTemplate restTemplate = new RestTemplate();

        // Esta linha faz 3 coisas:
        // 1. Chama (faz um GET) a URL da API_URL.
        // 2. Recebe a resposta (que é um JSON).
        // 3. Converte automaticamente esse JSON para um objeto da nossa classe 'FotoCachorro.class'.
        return restTemplate.getForObject(API_URL, FotoCachorro.class);
    }
}