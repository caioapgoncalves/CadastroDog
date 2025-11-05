package org.example.service;

import org.example.model.Cachorro;
import org.example.repository.CachorroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CachorroService {

    //@Autowired: Injeção de Dependência.
    @Autowired
    private CachorroRepository repository;

    //Método para listar TODOS os cachorros.
    public List<Cachorro> findAll(){
        return repository.findAll();
    }

    //Método para buscar APENAS UM cachorro pelo seu ID.
    public Optional<Cachorro> findOne(Integer id){
        return repository.findById(id);
    }

    //Método para salvar (ou atualizar) um cachorro no banco.
    public Cachorro save(Cachorro cachorro){
        return repository.save(cachorro);
    }

    //Método para deletar um cachorro pelo seu ID.
    public void delete(Integer id){
        repository.deleteById(id);
    }
}