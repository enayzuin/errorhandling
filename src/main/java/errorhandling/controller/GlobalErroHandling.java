package errorhandling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import errorhandling.config.ConfigProperties;
import errorhandling.domain.ExceptionModel;
import errorhandling.exception.AuthorizationException;
import errorhandling.exception.BadRequestException;
import errorhandling.exception.GenericException;

@ControllerAdvice
public class GlobalErroHandling {

	@Autowired
	private ConfigProperties properties;

	@ExceptionHandler(GenericException.class)
	public ResponseEntity<ExceptionModel> handlingGenericException(GenericException e) {
		ExceptionModel error = new ExceptionModel(properties.getPropertyByName("generic.error"), "500",
				HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ExceptionModel>(error, error.getStatus());
	}

	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<ExceptionModel> handlingAuthorizationException(AuthorizationException e) {
		ExceptionModel error = new ExceptionModel(properties.getPropertyByName("authorization.exception"), "401",
				HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<ExceptionModel>(error, error.getStatus());
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ExceptionModel> handlingBadRequest(BadRequestException e) {
		ExceptionModel error = new ExceptionModel(properties.getPropertyByName("bad.request"), "400",
				HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ExceptionModel>(error, error.getStatus());
	}

}
