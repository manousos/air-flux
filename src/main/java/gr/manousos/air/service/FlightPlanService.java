package gr.manousos.air.service;

import gr.manousos.air.domain.dto.FlightPlanDto;
import java.util.List;

/**
 * Services for flight plan.
 */
public interface FlightPlanService {

  /**
   * Gen all flights plan by departure airport.
   *
   * @param airportDepart the IATA code of airport.
   * @return a list of flights plan.
   */
  List<FlightPlanDto> getAllFlightPlan(String airportDepart);
}
