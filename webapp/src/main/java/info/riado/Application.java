package info.riado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import java.util.EnumSet;

/**
 * @author ivan
 */

@SpringBootApplication
public class Application {

	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return (ServletContext servletContext) -> {
			final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
			characterEncodingFilter.setEncoding("UTF-8");

			servletContext
				.addFilter("characterEncodingFilter", characterEncodingFilter)
				.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*");
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
