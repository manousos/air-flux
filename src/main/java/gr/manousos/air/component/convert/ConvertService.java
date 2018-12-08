package gr.manousos.air.component.convert;


/**
 * Convert object service.
 *
 * @param <T> the type of input object.
 * @param <R> the type of converted object.
 */
@FunctionalInterface
public interface ConvertService<T, R> {

  /**
   *
   */
  R convertTo(T t);
}
