package pl.dominisz.cdlibrary;

public class TimeUtils {

    public static String intTimeToString(int seconds) {
        int hours;
        int minutes;
        if (seconds < 60) {

            return seconds + "sec.";
        } else {
            minutes = seconds / 60;
            seconds = Math.abs(minutes*60-seconds);
            if(minutes<60) {
                return minutes+":"+seconds;
            } else {
                hours = minutes / 60;
                minutes = Math.abs(hours*60-seconds);
                return hours +":"+minutes+":"+seconds;
            }
        }
    }
}
