package br.com.zupacademy.gian.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(unique = true)
	private String email;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String sobrenome;
	
	@NotNull
	@Column(unique = true)
	private String documento;
	
	@NotNull
	private String endereco;
	
	@NotNull
	private String complemento;
	
	@NotNull
	private String cidade;
	
	@NotNull
	@ManyToOne
	private Pais pais;
	
	@ManyToOne
	private Estado estado;
	
	@NotNull
	private String telefone;
	
	@NotNull
	private String cep;

	public Cliente(String email, String nome, String sobrenome, String documento,
			String endereco, String complemento, String cidade, Pais pais,
			Estado estado, String telefone, String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}
}
