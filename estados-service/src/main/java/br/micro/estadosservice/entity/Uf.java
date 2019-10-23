package br.micro.estadosservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "t_uf", schema = "estados")
@SequenceGenerator(name = "t_uf", sequenceName = "s_uf", allocationSize = 1)
@Proxy(lazy = true)
public class Uf {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_uf")
	@Column(name = "cod_uf")
    private Integer codUf;
    
    @Length(max = 50)
    @Column(name = "nome")
    private String nome;
    
    @Length(max = 2)
    @Column(name = "sigla")
    private String sigla;
	
    public Uf(Integer codUf) {
        this.codUf = codUf;
    }
	
}
