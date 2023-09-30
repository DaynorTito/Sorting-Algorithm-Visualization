import university.jala.sav.viewing.MainMenuDisplay;

public class SAV {
        public static void main(String[] args) {
            MainMenuDisplay mainMenuDisplay = MainMenuDisplay.getInstance(args);
            mainMenuDisplay.runSAV();
        }
    }