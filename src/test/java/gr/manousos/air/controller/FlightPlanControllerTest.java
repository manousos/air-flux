package gr.manousos.air.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import gr.manousos.air.service.FlightPlanService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = {TestContext.class})
public class FlightPlanControllerTest {

  private FlightPlanController testClass;
  private FlightPlanService mockPlanService;
  /**
   * The mock mvc object.
   */
  private MockMvc mockMvc;

  @Before
  public void setUp() {
    mockPlanService = mock(FlightPlanService.class);

    testClass = new FlightPlanController(mockPlanService);

    mockMvc = MockMvcBuilders.standaloneSetup(testClass).build();
  }

  @Test
  public void testGetFlightPlan() throws Exception {

    mockMvc
        .perform(get("/api/flight-plan/all"))
        .andExpect(status().isOk());

    verify(mockPlanService).getAllFlightPlan(null);
  }
}
