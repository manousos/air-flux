package gr.manousos.air.service;

import static java.util.stream.Collectors.toList;

import gr.manousos.air.component.convert.ConvertService;
import gr.manousos.air.domain.AircraftBase;
import gr.manousos.air.domain.Flight;
import gr.manousos.air.domain.dto.OperatingInstructionDto;
import gr.manousos.air.repository.AircraftBaseRepository;
import gr.manousos.air.repository.FlightRepository;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link OperationPlanService}.
 */
@Service
public class OperationPlanServiceImpl implements OperationPlanService {

  private final FlightRepository flightRepository;
  private final AircraftBaseRepository aircraftBaseRepository;
  private final Map<String, String> airportToCityMap;
  private final ConvertService flightToOperatingDtoConvertService;

  public OperationPlanServiceImpl(FlightRepository flightRepository,
      AircraftBaseRepository aircraftBaseRepository,
      Map<String, String> airportToCityMap,
      ConvertService flightToOperatingDtoConvertService) {
    this.flightRepository = flightRepository;
    this.aircraftBaseRepository = aircraftBaseRepository;
    this.airportToCityMap = airportToCityMap;
    this.flightToOperatingDtoConvertService = flightToOperatingDtoConvertService;
  }

  @Override
  public List<OperatingInstructionDto> getByRegistrationCode(String registrationCode) {
    AircraftBase aircraftBaseInfo = aircraftBaseRepository.findByRegistration(registrationCode)
        .orElseThrow(() -> new RuntimeException("Not known registration " + registrationCode));

    String airportCode = airportToCityMap.entrySet().stream()
        .filter(c -> c.getValue().equals(aircraftBaseInfo.getCity()))
        .map(Map.Entry::getKey)
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Not known city " + aircraftBaseInfo.getCity()));

    List<Flight> flights = flightRepository.findAllByOriginAirportCode(airportCode);
    return flights.stream()
        .map(fl -> (OperatingInstructionDto) flightToOperatingDtoConvertService.convertTo(fl))
        .collect(toList());
  }
}
