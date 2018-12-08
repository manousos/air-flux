package gr.manousos.air.domain;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The flight document data.
 */
@Document
@Getter
@Setter
public class Flight extends AbstractDocument<String> {

  /**
   * The departure date and time.
   */
  private Instant departureTime;
  /**
   * The origin airport IATA code.
   */
  private String originAirportCode;
  /**
   * The departure airport IATA code.
   */
  private String destinationAirportCode;
  /**
   * The flight duration in minutes.
   */
  private Long flightDuration;
}
