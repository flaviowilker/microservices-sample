package br.micro.estadosservice.repository;

import org.springframework.stereotype.Repository;

import br.micro.estadosservice.entity.Uf;

@Repository
public interface UfRepository extends GenericRepository<Uf, Integer> {
}