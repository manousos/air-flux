package gr.manousos.air.component.convert;

import static java.time.temporal.ChronoUnit.MINUTES;

import gr.manousos.air.domain.AircraftBase;
import gr.manousos.air.domain.Flight;
import gr.manousos.air.domain.dto.FlightPlanDto;
import gr.manousos.air.repository.AircraftBaseRepository;
import java.time.Instant;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * Implement {@link ConvertService} for {@link Flight} to {@link FlightPlanDto} object.
 */
@Component
public class FlightToDtoConvertService implements ConvertService<Flight, FlightPlanDto> {

  private final Map<String, String> airportToCityMap;
  private final AircraftBaseRepository aircraftBaseRepository;

  public FlightToDtoConvertService(Map<String, String> airportToCityMap,
      AircraftBaseRepository aircraftBaseRepository) {
    this.airportToCityMap = airportToCityMap;
    this.aircraftBaseRepository = aircraftBaseRepository;
  }

  @Override
  public FlightPlanDto convertTo(Flight flight) {
    AircraftBase aircraftBase = aircraftBaseRepository
        .findByCity(airportToCityMap.get(flight.getDestinationAirportCode()));

    return FlightPlanDto
        .builder()
        .arrival(calculateArrivalTime(flight.getDepartureTime(), flight.getFlightDuration()))
        .departure(flight.getDepartureTime())
        .destination(flight.getDestinationAirportCode())
        .origin(flight.getOriginAirportCode())
        .equipment(aircraftBase.getAircraftModel())
        .build();
  }

  /**
   * Calculate the arrival time of aircraft.
   *
   * @param departTime the departure time.
   * @param duration the time duration of flights in minutes.
   * @return the exactly arrival time on destination airport.
   */
  private Instant calculateArrivalTime(Instant departTime, Long duration) {
    return departTime.plus(duration, MINUTES);
  }
}
