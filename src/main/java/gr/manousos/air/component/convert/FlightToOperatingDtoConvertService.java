package gr.manousos.air.component.convert;

import gr.manousos.air.domain.Flight;
import gr.manousos.air.domain.dto.OperatingInstructionDto;
import org.springframework.stereotype.Component;

/**
 * Implement {@link ConvertService} for {@link Flight} to {@link OperatingInstructionDto} object.
 */
@Component
public class FlightToOperatingDtoConvertService implements
    ConvertService<Flight, OperatingInstructionDto> {

  @Override
  public OperatingInstructionDto convertTo(Flight flight) {
    return OperatingInstructionDto.builder()
        .departure(flight.getDepartureTime())
        .origin(flight.getOriginAirportCode())
        .destination(flight.getDestinationAirportCode())
        .build();
  }
}
