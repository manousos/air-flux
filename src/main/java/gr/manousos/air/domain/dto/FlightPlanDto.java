package gr.manousos.air.domain.dto;

import java.time.Instant;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FlightPlanDto {

  private String origin;
  private String destination;
  private Instant arrival;
  private Instant departure;
  private String equipment;
}
