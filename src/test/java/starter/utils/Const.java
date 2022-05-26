package starter.utils;

public class Const {
    public static String freePlacePatern =
            "//*[contains(@transform, 'translate')][contains(@class, '%s free-place viewer')]";
    public static String freePlaceForFind =
            "//*[contains(@transform, 'translate')][contains(@class, 'free-place viewer')]";
    public static String placeBusyMessage =
            "Place %s is busy";
}
