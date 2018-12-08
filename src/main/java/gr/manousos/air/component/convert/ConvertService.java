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
   * Convert the given object T to R object.
   *
   * @param t the input object.
   * @return the converted object.
   */
  R convertTo(T t);
}
