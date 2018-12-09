package gr.manousos.air.controller;

import gr.manousos.air.domain.dto.OperatingInstructionDto;
import gr.manousos.air.service.OperationPlanService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/operation-plan")
public class OperationPlanController {

  private final OperationPlanService operationPlanServiceImpl;

  public OperationPlanController(
      OperationPlanService operationPlanServiceImpl) {
    this.operationPlanServiceImpl = operationPlanServiceImpl;
  }

  @RequestMapping("get/{registrationCode}")
  public ResponseEntity<List<OperatingInstructionDto>> getOperationPlan(
      @PathVariable String registrationCode) {
    return ResponseEntity.ok(operationPlanServiceImpl.getByRegistrationCode(registrationCode));
  }
}
