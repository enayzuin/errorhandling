package errorhandling.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:errorhandling.properties")
public class ConfigProperties {

	@Autowired
	private Environment env;

	public String getPropertyByName(String propertcyName) {
		String property = env.getProperty(propertcyName);
		return property;
	}
}
