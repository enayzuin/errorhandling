package errorhandling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import errorhandling.constants.ErrorConstants;
import errorhandling.domain.ExceptionModel;
import errorhandling.exception.AuthorizationException;
import errorhandling.exception.BadRequestException;
import errorhandling.exception.GenericException;
import errorhandling.responsebuilder.ResponseBuilder;

@ControllerAdvice
public class GlobalErrorHandling {

	@Autowired
	ResponseBuilder responseBuilder;

	@ExceptionHandler(GenericException.class)
	public ResponseEntity<ExceptionModel> handlingGenericException(GenericException e) {
		return responseBuilder.buildMessage(ErrorConstants.GENERIC_ERROR);
	}

	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<ExceptionModel> handlingAuthorizationException(AuthorizationException e) {
		return responseBuilder.buildMessage(ErrorConstants.AUTH_ERROR);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ExceptionModel> handlingBadRequest(BadRequestException e) {
		return responseBuilder.buildMessage(ErrorConstants.BAD_ERROR);
	}

}
