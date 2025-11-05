package org.example.service;

import org.example.model.TypeCachorro;
import org.example.repository.TypeCachorroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeCachorroService {

    @Autowired
    private TypeCachorroRepository typeCachorroRepository;

    //Busca todas as raças do banco de dados.
    public List<TypeCachorro> findAll(){
        return typeCachorroRepository.findAll();
    }
}