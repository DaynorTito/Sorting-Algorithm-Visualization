package university.jala.sav.viewing;

import java.util.Scanner;

public class MainMenuDisplay {

    private SortingVisualizer sortingVisualizer;
    private String[] args;
    private static MainMenuDisplay mainMenuDisplay;

    public static MainMenuDisplay getInstance(String[] args) {
        if (mainMenuDisplay == null) {
            mainMenuDisplay = new MainMenuDisplay(args);
        }
        return mainMenuDisplay;
    }
    private MainMenuDisplay(String[] args) {
        this.args = args;
    }
    public void runSAV() {
        int optionSelected;
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------SAV----------------------------");
        System.out.println("Select the type of algorithm display:");
        System.out.println("\t0. Simple sorting");
        System.out.println("\t1. Basic Console Renderer");
        System.out.println("\t2. Horizontal Console Renderer");
        System.out.println("\t3. Vertical Console Renderer");
        System.out.println("\t4. Graphic Rendering");
        System.out.println("\t5. Exit");
        do {
            System.out.print("Enter the number of your choice: ");
            optionSelected = scanner.nextInt();
        } while (!(0 <= optionSelected && optionSelected <= 5));
        if (optionSelected == 5) {
            System.out.println("Closing SAV.");
            scanner.close();
            System.exit(0);
        }
        sortingVisualizer = SortingVisualizer.getInstance(args);
        sortingVisualizer.sort(optionSelected);
    }

    public SortingVisualizer getSortingVisualizer() {
        return sortingVisualizer;
    }

    public void setSortingVisualizer(SortingVisualizer sortingVisualizer) {
        this.sortingVisualizer = sortingVisualizer;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public static MainMenuDisplay getMainMenuDisplay() {
        return mainMenuDisplay;
    }

    public static void setMainMenuDisplay(MainMenuDisplay mainMenuDisplay) {
        MainMenuDisplay.mainMenuDisplay = mainMenuDisplay;
    }
}
