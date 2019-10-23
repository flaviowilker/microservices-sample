package br.micro.funcionariosservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.micro.funcionariosservice.entity.Funcionario;
import br.micro.funcionariosservice.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
 
    private static final Logger LOGGER = LoggerFactory.getLogger(FuncionarioController.class);
 
    @Autowired
    FuncionarioService funcionarioService;
 
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<Funcionario> buscarTodos() {
        LOGGER.info("Buscando todos os funcionários");
        return funcionarioService.buscarTodos();
    }
    
    @GetMapping("/{isn}")
    @PreAuthorize("hasRole('USER')")
    public Funcionario buscaPorIsn(@PathVariable("isn") Integer isn) {
        LOGGER.info("Buscando funcionário: isn={}", isn);
        return funcionarioService.buscarPorIsn(isn);
    }
    
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public Funcionario salvar(@RequestBody Funcionario entity) {
        LOGGER.info("Salvando funcionário: {}", entity);
        return funcionarioService.salvar(entity);
    }
    
}
