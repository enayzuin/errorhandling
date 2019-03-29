package errorhandling.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;

import errorhandling.constants.ErrorConstants;
import errorhandling.domain.ExceptionModel;

@Configuration
@PropertySource("classpath:errorhandling.properties")
public class ConfigProperties {

	@Autowired
	private Environment env;

	public String getModelProperty(ExceptionModel model) {
		return env.getProperty(model.getMsg());
	}
}
