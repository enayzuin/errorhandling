package errorhandling.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import errorhandling.exception.AuthorizationException;
import errorhandling.exception.BadRequestException;
import errorhandling.exception.GenericException;

@RestController
@RequestMapping("/start")
public class ControllerTest {

	@RequestMapping(value = "/genericError", method = RequestMethod.GET)
	public String genericError() throws GenericException {
		throw new GenericException();

	}

	@RequestMapping(value = "/authError", method = RequestMethod.GET)
	public String authError() throws AuthorizationException {
		throw new AuthorizationException();

	}

	@RequestMapping(value = "/badError", method = RequestMethod.GET)
	public String badError() throws BadRequestException {
		throw new BadRequestException();

	}

}
