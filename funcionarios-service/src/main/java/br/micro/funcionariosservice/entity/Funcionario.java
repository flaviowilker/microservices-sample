package br.micro.funcionariosservice.entity;

import java.util.Date;

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
@Table(name = "t_funcionario", schema = "funcionarios")
@SequenceGenerator(name = "s_funcionario", sequenceName = "s_funcionario", allocationSize = 1)
@Proxy(lazy = true)
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_funcionario")
	@Column(name = "cod_funcionario")
    private Integer codFuncionario;
    
    @Length(max = 200)
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "data_admissao")
    private Date dataAdmissao;
    
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    
    @Length(max = 20)
    @Column(name = "telefone")
    private String telefone;
    
    @Length(max = 15)
    @Column(name = "cpf")
    private String cpf;
	
    public Funcionario(Integer codFuncionario) {
        this.codFuncionario = codFuncionario;
    }
	
}
