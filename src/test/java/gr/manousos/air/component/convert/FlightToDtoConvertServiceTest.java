package gr.manousos.air.component.convert;

import static java.time.Instant.now;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import gr.manousos.air.domain.AircraftBase;
import gr.manousos.air.domain.Flight;
import gr.manousos.air.repository.AircraftBaseRepository;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class FlightToDtoConvertServiceTest {

  private FlightToDtoConvertService testClass;
  private Map<String, String> mockAirportsMap;
  private AircraftBaseRepository mockRepo;

  @Before
  public void setUp() {
    mockRepo = mock(AircraftBaseRepository.class);
    mockAirportsMap = mock(Map.class);

    testClass = new FlightToDtoConvertService(mockAirportsMap, mockRepo);
  }

  @Test
  public void testConvertTo() {
    Flight input = mock(Flight.class);
    AircraftBase mockAirBase = mock(AircraftBase.class);

    when(input.getDepartureTime()).thenReturn(now());
    when(mockAirportsMap.get(input.getDestinationAirportCode())).thenReturn("MLO");
    when(mockRepo.findByCity("MLO")).thenReturn(mockAirBase);

    assertNotNull(testClass.convertTo(input));
  }
}
