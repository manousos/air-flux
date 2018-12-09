package gr.manousos.air.service;

import static org.apache.logging.log4j.util.Strings.EMPTY;
import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import gr.manousos.air.component.convert.ConvertService;
import gr.manousos.air.domain.AircraftBase;
import gr.manousos.air.domain.Flight;
import gr.manousos.air.domain.dto.OperatingInstructionDto;
import gr.manousos.air.repository.AircraftBaseRepository;
import gr.manousos.air.repository.FlightRepository;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class OperationPlanServiceImplTest {

  private OperationPlanServiceImpl testClass;

  private FlightRepository mockFlightRepo;
  private AircraftBaseRepository mockAirbaseRepo;
  private Map<String, String> mockCityMap;
  private ConvertService mockConvert;

  private AircraftBase mockAircraft;

  @Before
  public void setUp() {
    mockConvert = mock(ConvertService.class);
    mockFlightRepo = mock(FlightRepository.class);
    mockCityMap = mock(Map.class);
    mockAirbaseRepo = mock(AircraftBaseRepository.class);

    testClass = new OperationPlanServiceImpl(
        mockFlightRepo, mockAirbaseRepo, mockCityMap, mockConvert);

    mockAircraft = mock(AircraftBase.class);
  }

  @Test
  public void testGetByRegistrationCode() {
    OperatingInstructionDto expectedDto = mock(OperatingInstructionDto.class);
    Set<Entry<String, String>> entries = new HashSet<>();
    entries.add(new SimpleEntry<>("TXL", "BERLIN"));

    AircraftBase mockAircraft = mock(AircraftBase.class);
    Flight mockFlight = mock(Flight.class);

    when(mockAircraft.getCity()).thenReturn("BERLIN");
    when(mockAirbaseRepo.findByRegistration(EMPTY)).thenReturn(Optional.of(mockAircraft));
    when(mockCityMap.entrySet()).thenReturn(entries);
    when(mockFlightRepo.findAllByOriginAirportCode("TXL")).thenReturn(Arrays.asList(mockFlight));
    when(mockConvert.convertTo(mockFlight)).thenReturn(expectedDto);

    assertArrayEquals(new OperatingInstructionDto[]{expectedDto},
        testClass.getByRegistrationCode(EMPTY).toArray());
  }

  @Test(expected = RuntimeException.class)
  public void testGetByRegistrationCodeCaseNoRegistrationCode() {
    when(mockAirbaseRepo.findByRegistration(EMPTY)).thenReturn(Optional.empty());
    testClass.getByRegistrationCode(EMPTY);
  }

  @Test(expected = RuntimeException.class)
  public void testGetByRegistrationCodeCaseNotKnownCity() {
    when(mockAirbaseRepo.findByRegistration(EMPTY)).thenReturn(Optional.of(mockAircraft));

    testClass.getByRegistrationCode(EMPTY);
  }
}
