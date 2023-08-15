package net.origamiking.mcmods.oapi.utils;

public class OrigamiUtils {
    public static String getId(String input) {
        return input.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }

    public static String getName(String input) {
        String[] words = input.split("_");
        StringBuilder formatted = new StringBuilder();

        for (String word : words) {
            formatted.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
        }

        return formatted.toString().trim();
    }
}
