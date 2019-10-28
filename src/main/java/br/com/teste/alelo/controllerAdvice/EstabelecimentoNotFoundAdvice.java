package br.com.teste.alelo.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.teste.alelo.exception.EstabelecimentoNotFoundException;

@ControllerAdvice
public class EstabelecimentoNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(EstabelecimentoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String estabelecimentoNotFound(EstabelecimentoNotFoundException e) {
		return e.getMessage();
	}
}
