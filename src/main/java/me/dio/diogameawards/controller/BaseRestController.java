package me.dio.diogameawards.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import me.dio.diogameawards.service.exception.BusinessException;
import me.dio.diogameawards.service.exception.NoContentException;

// Tratando as excessões
@RequestMapping("/api")
public class BaseRestController {

	//handler, nome do padrão
	@ExceptionHandler(NoContentException.class)
	public ResponseEntity<Void> handlerNoContentException(NoContentException exception){
		return ResponseEntity.noContent().build();
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ApiErrorDTO> handlerBusinessException(BusinessException exception){
		ApiErrorDTO error = new ApiErrorDTO(exception.getMessage());
		return ResponseEntity.badRequest().body(error);
		//return ResponseEntity.noContent().build();
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ApiErrorDTO> handlerUnexpectedException(Throwable exception){
		ApiErrorDTO error = new ApiErrorDTO("Ocorreu um erro inesperado !");
		return ResponseEntity.internalServerError().body(error);
	}

}
