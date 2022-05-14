package wordle;

import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Score {

    public static int numberOfGames = 1;

    private static int INITIALISE = 0;

    public static boolean WIN = false;

    public static HashMap<Integer, Integer> scores = new HashMap<>();

    public static int getINITIALISE() {
        return INITIALISE;
    }

    public static void setINITIALISE(int INITIALISE) {
        Score.INITIALISE = INITIALISE;
    }


}
