package da.Util;


import static qfx.util.QMath.*;

public class ISBN {
    public static String generate() {
        return String.format(
                "ISBN-%d/%d-%d-%d-%d-%d",
                random(10, 99),
                random(100, 999),
                random(0, 9),
                random(10000, 99999),
                random(100, 999),
                random(0, 9));
    }
}
