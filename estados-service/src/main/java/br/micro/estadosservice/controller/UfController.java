package br.micro.estadosservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.micro.estadosservice.entity.Uf;
import br.micro.estadosservice.service.UfService;

@RestController
@RequestMapping("/uf")
public class UfController {
 
    private static final Logger LOGGER = LoggerFactory.getLogger(UfController.class);
 
    @Autowired
    UfService ufService;
 
    @GetMapping
    public List<Uf> buscarTodos() {
        LOGGER.info("Buscando todos os estados");
        return ufService.buscarTodos();
    }
    
    @GetMapping("/{isn}")
    public Uf buscaPorIsn(@PathVariable("isn") Integer isn) {
        LOGGER.info("Buscando estado: isn={}", isn);
        return ufService.buscarPorIsn(isn);
    }
    
    @PostMapping
    public Uf salvar(@RequestBody Uf entity) {
        LOGGER.info("Salvando estado: {}", entity);
        return ufService.salvar(entity);
    }
    
}
