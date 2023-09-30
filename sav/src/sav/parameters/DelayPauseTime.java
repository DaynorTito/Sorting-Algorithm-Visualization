package university.jala.sav.parameters;

public final class DelayPauseTime {
    private DelayPauseTime(){

    }
    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
