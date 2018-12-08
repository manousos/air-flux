package gr.manousos.air.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * The generic document.
 *
 * @param <ID> the type of document id.
 */
@Getter
@Setter
public abstract class AbstractDocument<ID> {

  /**
   * The document id.
   */
  @Id
  protected ID id;

}
