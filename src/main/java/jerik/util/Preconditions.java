/**
 * 
 */
package jerik.util;

/**
 * @author dan
 *
 */
public class Preconditions {

  public static void checkNotNull(Object value, String name) {
    if (value == null) {
      throw new NullPointerException(name + " == null");
    }
  }
  
  public static void checkNotNull(String value, String name) {
    checkNotNull((Object)StringUtil.trimToNull(value), name);
  }
  
  public static void checkPositive(int value, String name) {
    if (value < 0) {
      throw new IllegalArgumentException(name + " must be positive");
    }
  }
}
