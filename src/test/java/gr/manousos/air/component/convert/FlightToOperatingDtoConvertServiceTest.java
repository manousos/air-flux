package gr.manousos.air.component.convert;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import gr.manousos.air.domain.Flight;
import org.junit.Before;
import org.junit.Test;

public class FlightToOperatingDtoConvertServiceTest {

  private FlightToOperatingDtoConvertService testClass;

  @Before
  public void setUp() {
    testClass = new FlightToOperatingDtoConvertService();
  }

  @Test
  public void testConvertTo() {
    Flight input = mock(Flight.class);

    assertNotNull(testClass.convertTo(input));
  }
}
