package errorhandling.responsebuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import errorhandling.config.ConfigProperties;
import errorhandling.constants.ErrorConstants;
import errorhandling.domain.ExceptionModel;

@Service
public class ResponseBuilder {

	@Autowired
	ConfigProperties properties;

	public ResponseEntity<ExceptionModel> buildMessage(ExceptionModel model) {
		model.setMsg(properties.getModelProperty(ErrorConstants.GENERIC_ERROR));
		return new ResponseEntity<ExceptionModel>(model, model.getStatus());

	}

}
