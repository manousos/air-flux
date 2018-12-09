package gr.manousos.air.controller;

import gr.manousos.air.domain.dto.FlightPlanDto;
import gr.manousos.air.service.FlightPlanService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/flight-plan/")
public class FlightPlanController {

  private final FlightPlanService flightPlanServiceImpl;

  public FlightPlanController(FlightPlanService flightPlanServiceImpl) {
    this.flightPlanServiceImpl = flightPlanServiceImpl;
  }

  @RequestMapping("all")
  public ResponseEntity<List<FlightPlanDto>> getFlightPlan(
      @RequestParam(required = false) String airport) {
    return ResponseEntity.ok(flightPlanServiceImpl.getAllFlightPlan(airport));
  }

}
