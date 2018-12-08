package gr.manousos.air.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The aircraft base document data.
 */
@Document
@Getter
@Setter
public class AircraftBase extends AbstractDocument<String> {

  /**
   * The model of aircraft.
   */
  private String aircraftModel;
  /**
   * The home bases of aircraft. City name.
   */
  private String city;
  /**
   * The aircraft registration code.
   */
  @Indexed
  private String registration;

}
