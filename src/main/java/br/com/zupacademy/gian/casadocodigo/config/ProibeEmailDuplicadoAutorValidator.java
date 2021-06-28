package br.com.zupacademy.gian.casadocodigo.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.gian.casadocodigo.model.Autor;
import br.com.zupacademy.gian.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.gian.casadocodigo.request.NovoAutorRequest;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {
	
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoAutorRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		NovoAutorRequest request = (NovoAutorRequest) target;		
		Optional<Autor> emailAutor = autorRepository.findByEmail(request.getEmail());
		
		if (emailAutor.isPresent()) {
			errors.rejectValue("email", null, "Email já cadastrado");
		}
	}
}
