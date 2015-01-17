package info.riado.config;

import info.riado.format.FormationFormFormatter;
import info.riado.format.LawyerStatusFormatter;
import info.riado.interceptors.HelpersInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author ivan
 */
@Configuration
public class RiadoWebMvcConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new FormationFormFormatter());
		registry.addFormatter(new LawyerStatusFormatter());
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HelpersInterceptor());
	}

}
