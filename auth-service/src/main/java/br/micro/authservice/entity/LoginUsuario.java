package br.micro.authservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "t_usuario", schema = "seguranca")
@SequenceGenerator(name = "s_usuario", sequenceName = "s_usuario", allocationSize = 1)
public class LoginUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_usuario")
	@Column(name = "cod_usuario")
    private Integer codUsuario;
	
	@NotNull
	@Length(max = 50)
	@Column(name = "login", unique = true)
    private String login;
	
	@NotNull
	@Length(max = 50)
	@Column(name = "senha")
    private String senha;
	
	@NotNull
	@Length(max = 50)
	@Column(name = "papel")
	private String papel;
}
