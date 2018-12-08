package gr.manousos.air.service;

import static org.apache.logging.log4j.util.Strings.EMPTY;
import static org.junit.Assert.assertArrayEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import gr.manousos.air.component.convert.ConvertService;
import gr.manousos.air.domain.Flight;
import gr.manousos.air.domain.dto.FlightPlanDto;
import gr.manousos.air.repository.FlightRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class FlightPlanServiceImplTest {

  private FlightPlanServiceImpl testClass;

  private FlightRepository mockFlightRepo;
  private ConvertService mockConvert;

  private FlightPlanDto expectedDto;
  private Flight mockFlight;
  private List<Flight> flights;

  @Before
  public void setUp() {
    mockConvert = mock(ConvertService.class);
    mockFlightRepo = mock(FlightRepository.class);

    testClass = new FlightPlanServiceImpl(mockFlightRepo, mockConvert);

    expectedDto = mock(FlightPlanDto.class);
    mockFlight = mock(Flight.class);
    flights = Arrays.asList(mockFlight);
  }

  @Test
  public void testGetAllFlightPlan() {
    when(mockFlightRepo.findAllByOriginAirportCode("MUC")).thenReturn(flights);
    when(mockConvert.convertTo(mockFlight)).thenReturn(expectedDto);

    assertArrayEquals(Arrays.asList(expectedDto).toArray(),
        testClass.getAllFlightPlan("MUC").toArray());
    verify(mockFlightRepo, never()).findAll();

  }

  @Test
  public void testGetAllFlightPlanCaseAll() {

    when(mockFlightRepo.findAll()).thenReturn(flights);
    when(mockConvert.convertTo(mockFlight)).thenReturn(expectedDto);

    assertArrayEquals(Arrays.asList(expectedDto).toArray(),
        testClass.getAllFlightPlan(EMPTY).toArray());
    verify(mockFlightRepo, never()).findAllByOriginAirportCode(anyString());

  }

  @Test
  public void testCreateFlightPlanFromFlight() {
  }
}
