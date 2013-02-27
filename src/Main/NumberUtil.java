package Main;

import java.text.DecimalFormat;

/**
 *
 * @author Peter
 */
public class NumberUtil {

    /**
     * Rounds a double to two decimals
     * @param d
     * @return 
     */
    public static String roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return twoDForm.format(d);
    }
}
