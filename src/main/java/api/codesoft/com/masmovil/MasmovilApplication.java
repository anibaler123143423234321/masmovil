package api.codesoft.com.masmovil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories("api.codesoft.com.masmovil.repository")
@EntityScan("api.codesoft.com.masmovil.model")
public class MasmovilApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasmovilApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// Configuración de CORS
				registry.addMapping("/**")
						.allowedOrigins(
								"https://fibramoviltotal.es",
								"https://fibramoviltotal.com",
								"http://localhost:4321"
						)
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
						.allowedHeaders("*") // Permitir todos los encabezados
						.allowCredentials(true); // Permitir credenciales si es necesario
			}
		};
	}
}
