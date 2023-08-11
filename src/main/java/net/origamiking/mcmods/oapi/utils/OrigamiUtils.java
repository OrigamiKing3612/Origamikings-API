package net.origamiking.mcmods.oapi.utils;

public class OrigamiUtils {
    public static String getId(String input) {
        return input.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }
}
