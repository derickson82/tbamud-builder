/**
 * 
 */
package jerik.util;

/**
 * @author dan
 *
 */
public class StringUtil {

  public static String trimToNull(String str) {
    return (str == null || (str = str.trim()).length() == 0) ? null : str;
  }
}
