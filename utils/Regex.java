package utils;

public class Regex {

    private static final String NumRegex = "(\\d)+";
    private static final String OpRegex = "(\\+|-|\\*/)";
    private static final String PlusRegex = "(\\+)+";
    private static final String MinusRegex = "(\\-)+";
    private static final String SlashRegex = "(/)+";
    private static final String StarRegex = "(\\*)+";

    public static boolean isNum(String token) {
        return token.matches(NumRegex);
    }

    public static boolean isOp(String token) {
        return token.matches(OpRegex);
    }

    public static boolean isPlus(String token) {
        return token.matches(PlusRegex);
    }

    public static boolean isMinus(String token) {
        return token.matches(MinusRegex);
    }

    public static boolean isSlash(String token) {
        return token.matches(SlashRegex);
    }

    public static boolean isStar(String token) {
        return token.matches(StarRegex);
    }
}
