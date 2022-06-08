package starter.utils;

public class Const {
    public static String FREE_PLACE_PATTERN =
            "//*[contains(@transform, 'translate')][contains(@class, '%s free-place viewer')]";
    public static String FREE_PLACE_SEARCH_PATTERN =
            "//*[contains(@transform, 'translate')][contains(@class, 'free-place viewer')]";
    public static String MESSAGE_PLACE_BUSY =
            "Place %s is busy";
    public static int SHORT_TIMEOUT = 10;
    public static int MEDIUM_TIMEOUT = 15;
    public static int LONG_TIMEOUT = 20;

    public static String DATE_PATERRN = "//span[contains(@aria-label, '%s, 2022')]";

    public static String HOUR_PATERRN = "//td[contains(@data-time,'%s')]/ancestor::tr[position()=1]";
}
