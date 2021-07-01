package br.com.zupacademy.gian.casadocodigo.request;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.gian.casadocodigo.model.Cliente;
import br.com.zupacademy.gian.casadocodigo.model.Estado;
import br.com.zupacademy.gian.casadocodigo.model.Pais;
import br.com.zupacademy.gian.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.gian.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.gian.casadocodigo.validator.CpfOuCnpj;
import br.com.zupacademy.gian.casadocodigo.validator.ExistsId;
import br.com.zupacademy.gian.casadocodigo.validator.UniqueValue;

public class NovoClienteRequest {

	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email", message = "Email já cadastrado")
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@CpfOuCnpj
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento", message = "Documento já cadastrado")
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;	
	
	@ExistsId(domainClass = Pais.class, fieldName = "idPais", message = "País não encontrado")
	private Long idPais;

	private Long idEstado;
	
	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;
	
	private boolean precisaEstado = false;
	private boolean estadoPertenceAoPais = true;
	
	@Deprecated
	public NovoClienteRequest() {
	}
	
	public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		
		Optional<Estado> estadoInformadoRequest = null;
		Estado estado = null;
		
		Optional<Pais> pais = paisRepository.findById(this.idPais);		
		
		List<Estado> estadosDoPais = estadoRepository.findByPaisId(getIdPais());
		
		if (estadosDoPais.size() > 0) {
			if (getIdEstado() == null) {
				precisaEstado = true;
			} else {
				estadoInformadoRequest = 
					estadoRepository.findByIdAndPaisId(getIdEstado(), getIdPais());
			
				if (estadoInformadoRequest.isEmpty()) {					
					estadoPertenceAoPais = false;
				} else {					
					estado = estadoInformadoRequest.get();
				}			
			}				
		}		
		
		return new Cliente(this.email, this.nome, 
				this.sobrenome, this.documento, 
				this.endereco, this.complemento, 
				this.cidade, pais.get(), estado, 
				this.telefone, this.cep);		
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

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public boolean isPrecisaEstado() {
		return precisaEstado;
	}

	public boolean isEstadoPertenceAoPais() {
		return estadoPertenceAoPais;
	}
}
