package starter.utils;

public class Const {
    public static String FREE_PLACE_PATTERN =
            "//*[contains(@transform, 'translate')][contains(@class, '%s free-place viewer')]";
    public static String FREE_PLACE_SEARCH_PATTERN =
            "//*[contains(@transform, 'translate')][contains(@class, 'free-place viewer')]";
    public static String MESSAGE_PLACE_BUSY =
            "Place %s is busy";
}
