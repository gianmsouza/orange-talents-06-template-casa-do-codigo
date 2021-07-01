package br.com.zupacademy.gian.casadocodigo.response;

import br.com.zupacademy.gian.casadocodigo.model.Cliente;

public class NovoClienteResponse {

	private Long id;
	
	public NovoClienteResponse(Cliente cliente) {
		this.id = cliente.getId();
	}

	public Long getId() {
		return id;
	}	
}
