package errorhandling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import errorhandling.config.ConfigProperties;
import errorhandling.constants.ErrorConstants;
import errorhandling.domain.ExceptionModel;
import errorhandling.exception.AuthorizationException;
import errorhandling.exception.BadRequestException;
import errorhandling.exception.GenericException;

@ControllerAdvice
public class GlobalErroHandling {

	@Autowired
	ConfigProperties properties;

	@ExceptionHandler(GenericException.class)
	public ResponseEntity<ExceptionModel> handlingGenericException(GenericException e) {
		return properties.buildResponse(ErrorConstants.GENERIC_ERROR);
	}

	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<ExceptionModel> handlingAuthorizationException(AuthorizationException e) {
		return properties.buildResponse(ErrorConstants.AUTH_ERROR);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ExceptionModel> handlingBadRequest(BadRequestException e) {
		return properties.buildResponse(ErrorConstants.BAD_ERROR);
	}

}
