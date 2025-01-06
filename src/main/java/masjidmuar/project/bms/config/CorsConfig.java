package masjidmuar.project.bms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Value("${cors.allowed-origin}")
    private String allowedOrigin;  // This will fetch the CORS allowed origin from application.properties

    @Bean
    public CorsFilter corsFilter() {
        // Create CORS configuration and set allowed origins dynamically
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOrigin(allowedOrigin);  // Use the dynamic allowed origin
        corsConfig.addAllowedMethod("*");  // Allow all HTTP methods (GET, POST, etc.)
        corsConfig.addAllowedHeader("*");  // Allow all headers
        corsConfig.setAllowCredentials(true);  // Allow cookies to be sent

        // Set the CORS configuration to apply to all paths
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);  // Apply CORS settings globally
        return new CorsFilter(source);
    }
}
