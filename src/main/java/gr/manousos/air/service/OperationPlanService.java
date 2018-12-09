package gr.manousos.air.service;

import gr.manousos.air.domain.dto.OperatingInstructionDto;
import java.util.List;

/**
 * Services for operation plan.
 */
public interface OperationPlanService {

  /**
   * Get all operating instruction by aircraft registration code.
   *
   * @param registrationCode the aircraft registration code.
   * @return a list of operating instructions.
   */
  List<OperatingInstructionDto> getByRegistrationCode(String registrationCode);
}
