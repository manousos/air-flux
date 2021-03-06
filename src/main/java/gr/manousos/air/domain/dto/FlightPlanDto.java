package gr.manousos.air.domain.dto;

import java.time.Instant;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The flight plan dto.
 */
@Getter
@Setter
@Builder
public class FlightPlanDto {

  /**
   * The origin IATA airport code.
   */
  private String origin;
  /**
   * The destination IATA airport code.
   */
  private String destination;
  /**
   * The arrival time.
   */
  private Instant arrival;
  /**
   * The departure time.
   */
  private Instant departure;
  /**
   * The aircraft model.
   */
  private String equipment;
}
