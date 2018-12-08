package gr.manousos.air.service;

import static java.util.stream.Collectors.toList;

import gr.manousos.air.component.convert.ConvertService;
import gr.manousos.air.domain.Flight;
import gr.manousos.air.domain.dto.FlightPlanDto;
import gr.manousos.air.repository.FlightRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Implementation of {@link FlightPlanService}.
 */
@Service
public class FlightPlanServiceImpl implements FlightPlanService {

  private final FlightRepository flightRepository;
  private ConvertService flightToDtoConvertService;

  public FlightPlanServiceImpl(
      FlightRepository flightRepository, ConvertService flightToDtoConvertService) {
    this.flightRepository = flightRepository;
    this.flightToDtoConvertService = flightToDtoConvertService;
  }

  @Override
  public List<FlightPlanDto> getAllFlightPlan(String airportDepart) {
    List<Flight> flights;
    if (StringUtils.isEmpty(airportDepart)) {
      flights = flightRepository.findAll();
    } else {
      flights = flightRepository
          .findAllByOriginAirportCode(airportDepart);
    }
    return flights.stream()
        .map(f -> (FlightPlanDto) flightToDtoConvertService.convertTo(f))
        .collect(toList());
  }


}
