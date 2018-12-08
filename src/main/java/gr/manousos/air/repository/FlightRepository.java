package gr.manousos.air.repository;

import gr.manousos.air.domain.Flight;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository from document {@link Flight}.
 */
public interface FlightRepository extends MongoRepository<Flight, String> {

  /**
   * Find all flights by origin airport code.
   *
   * @param originAirportCode the IATA airport code.
   * @return a list of findings flights.
   */
  List<Flight> findAllByOriginAirportCode(String originAirportCode);
}
