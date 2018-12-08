package gr.manousos.air.domain.dto;

import java.time.Instant;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The operation plan dto.
 */
@Getter
@Setter
@Builder
public class OperatingInstructionDto {

  /**
   * The origin airport code.
   */
  private String origin;
  /**
   * The destination airport code.
   */
  private String destination;
  /**
   * The departure date time of flight.
   */
  private Instant departure;
}
