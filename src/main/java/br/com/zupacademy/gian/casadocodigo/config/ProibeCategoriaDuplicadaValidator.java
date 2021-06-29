package br.com.zupacademy.gian.casadocodigo.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import br.com.zupacademy.gian.casadocodigo.model.Categoria;
import br.com.zupacademy.gian.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.gian.casadocodigo.request.NovaCategoriaRequest;

@Component
public class ProibeCategoriaDuplicadaValidator implements Validator {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCategoriaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		NovaCategoriaRequest request = (NovaCategoriaRequest) target;		
		Optional<Categoria> categoria = categoriaRepository.findByNome(request.getNome());
		
		if (categoria.isPresent()) {
			errors.rejectValue("nome", null, "Nome já cadastrado");
		}
	}

}
