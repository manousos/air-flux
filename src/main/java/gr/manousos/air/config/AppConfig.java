package gr.manousos.air.config;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Application configuration.
 */
@Configuration
@EnableMongoRepositories(basePackages = "gr.manousos.air.repository")
public class AppConfig {

  /**
   * Bean to map IATA code with airport city name.
   *
   * @return a map with key the IATA code and value the city name.
   */
  @Bean
  Map<String, String> airportToCityMap() {
    Map<String, String> airportMap = new HashMap<>();
    airportMap.put("TXL", "Berlin");
    airportMap.put("MUC", "Munich");
    airportMap.put("LHR", "London");
    airportMap.put("HAM", "Hamburg");
    return airportMap;
  }

}
