package info.riado;

import info.riado.domain.Formation;
import info.riado.format.FormationFormFormatter;
import info.riado.thymeleaf.RiadoDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.number.NumberFormatAnnotationFormatterFactory;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.thymeleaf.dialect.IDialect;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import java.util.Collection;
import java.util.Collections;
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

	@Bean
	public RiadoDialect riadoDialect() {
		return new RiadoDialect();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
