package gr.manousos.air.repository;

import gr.manousos.air.domain.AircraftBase;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository from document {@link AircraftBase}.
 */
public interface AircraftBaseRepository extends MongoRepository<AircraftBase, String> {

  /**
   * Find aircraft base by registration code.
   *
   * @param registrationCode the aircraft registration code.
   * @return the optional finding aircraft info data.
   */
  Optional<AircraftBase> findByRegistration(String registrationCode);

  /**
   * Find aircraft base by city name airport.
   *
   * @param city the given city name airport.
   * @return the finding aircraft info data.
   */
  AircraftBase findByCity(String city);
}
