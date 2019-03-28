package errorhandling.constants;

import org.springframework.http.HttpStatus;

import errorhandling.domain.ExceptionModel;

public class ErrorConstants {

	public static final ExceptionModel AUTH_ERROR = new ExceptionModel("authorization.exception", "401",
			HttpStatus.UNAUTHORIZED);

	public static final ExceptionModel BAD_ERROR = new ExceptionModel("bad.request", "400", HttpStatus.BAD_REQUEST);

	public static ExceptionModel GENERIC_ERROR = new ExceptionModel("generic.error", "500",
			HttpStatus.INTERNAL_SERVER_ERROR);

}
