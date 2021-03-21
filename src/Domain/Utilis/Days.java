package Domain.Utilis;

import java.util.Map;

public class Days {

    /**
     * Map day into weekday or weekend
     */
    public static final Map<String, String> days = Map.of(
            "MO", "weekday",
            "TU", "weekday",
            "WE", "weekday",
            "TH", "weekday",
            "FR", "weekday",
            "SA", "weekend",
            "SU", "weekend"
    );
}
