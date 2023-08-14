package net.origamiking.mcmods.oapi.utils;

public class OrigamiStringUtils {
    public static String capitalize(String s) {
        if (s.isEmpty()) return s;

        String[] words = s.split(" ");
        StringBuilder ret = new StringBuilder(s.length());

        for (String word : words) {
            if (!word.isEmpty()) {
                int cp = word.codePointAt(0);
                int cpUpper = Character.toUpperCase(cp);
                if (cpUpper != cp) {
                    ret.appendCodePoint(cpUpper);
                    ret.append(word, Character.charCount(cp), word.length());
                } else {
                    ret.append(word);
                }
                ret.append(" ");
            }
        }

        return ret.toString().trim();
    }
}
