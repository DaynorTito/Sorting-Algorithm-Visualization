package university.jala.sav.viewing;

import sav.*;
import university.jala.sav.algorithm.BubbleSort;
import university.jala.sav.algorithm.MergeSort;
import university.jala.sav.algorithm.QuickSort;
import university.jala.sav.parameters.ListData;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingVisualizer {

    private String sortingAlgorithm;
    private ListData listData;
    private List<Integer> listInt;
    private List<Character> listChar;
    private BubbleSort bubbleSort;
    private QuickSort quickSort;
    private MergeSort mergeSort;
    private SavGenerator<Integer> savGeneratorInt;
    private SavGenerator<Character> savGeneratorChar;
    private static SortingVisualizer sortingVisualizer;


    public static SortingVisualizer getInstance(String[] args) {
        if (sortingVisualizer == null) {
            sortingVisualizer = new SortingVisualizer(args);
        }
        return sortingVisualizer;
    }
    private SortingVisualizer() {

    }
    private SortingVisualizer(String[] args) {
        listData = ListData.getInstance(args);
        boolean random = listData.getParameters().isRandom();
        boolean isInteger = (listData.getParameters().getTypeData().equalsIgnoreCase("N")) ? true:false;
        sortingAlgorithm = listData.getParameters().getAlgorithm();
        if (random && isInteger)
            initAlgorithm(listData.getArrayIntegerRandom());
        else if (random)
            initAlgorithm(listData.getArrayCharacterRandom());
        else if (isInteger)
            initAlgorithm(listData.getArrayInteger());
        else
            initAlgorithm(listData.getArrayCharacter());
    }
    public void initAlgorithm(Integer[] arrayInteger) {
        if (sortingAlgorithm.equalsIgnoreCase("B")) {
            bubbleSort = BubbleSort.getInstance(arrayInteger, listData.getParameters().getPauseTime(),
                    listData.getParameters().isAscendant());
            savGeneratorInt = bubbleSort;
        } else if (sortingAlgorithm.equalsIgnoreCase("Q")) {
            quickSort = QuickSort.getInstance(arrayInteger, listData.getParameters().getPauseTime(),
                    listData.getParameters().isAscendant());
            savGeneratorInt = quickSort;
        } else {
            mergeSort = MergeSort.getInstance(arrayInteger, listData.getParameters().getPauseTime(),
                    listData.getParameters().isAscendant());
            savGeneratorInt = mergeSort;
        }
        listInt = Arrays.asList(arrayInteger);
    }
    public void initAlgorithm(Character[] arrayCharacter) {
        if (sortingAlgorithm.equalsIgnoreCase("B")) {
            bubbleSort = BubbleSort.getInstance(arrayCharacter, listData.getParameters().getPauseTime(),
                    listData.getParameters().isAscendant());
            savGeneratorChar = bubbleSort;
        } else if (sortingAlgorithm.equalsIgnoreCase("Q")) {
            quickSort = QuickSort.getInstance(arrayCharacter, listData.getParameters().getPauseTime(),
                    listData.getParameters().isAscendant());
            savGeneratorChar = quickSort;
        } else {
            mergeSort = MergeSort.getInstance(arrayCharacter, listData.getParameters().getPauseTime(),
                    listData.getParameters().isAscendant());
            savGeneratorChar = mergeSort;
        }
        listChar = Arrays.asList(arrayCharacter);
    }
    public void sort(int typeShow) {
        if (listData.getParameters().getTypeData().equalsIgnoreCase("N")) {
            SavSettings<Integer> saveSettings = new SavSettings<>(listInt, listData.getParameters().getPauseTime(),
                    Collections.min(listInt), Collections.max(listInt), value -> value, listData.getParameters().isAscendant());
            renderIntegerBy(typeShow, saveSettings);
        } else {
            SavSettings<Character> saveSettings = new SavSettings<>(listChar, listData.getParameters().getPauseTime(),
                    Collections.min(listChar), Collections.max(listChar), value -> value, listData.getParameters().isAscendant());
            renderCharacterBy(typeShow, saveSettings);
        }
        printOrderConsole();
    }
    public void renderIntegerBy(int optionRender, SavSettings<Integer> saveSettings) {
        if (optionRender == 1)
            new BasicConsoleRenderer<Integer>().render(savGeneratorInt,saveSettings);
        else if (optionRender == 2)
            new HorizontalConsoleRenderer<Integer>().render(savGeneratorInt,saveSettings);
        else if (optionRender == 3)
            new VerticalConsoleRenderer<Integer>().render(savGeneratorInt,saveSettings);
        else if (optionRender == 4)
            new SwingRenderer<Integer>().render(savGeneratorInt,saveSettings);
        else
            simpleSorting();
    }
    public void renderCharacterBy(int optionRender, SavSettings<Character> saveSettings) {
        if (optionRender == 1)
            new BasicConsoleRenderer<Character>().render(savGeneratorChar,saveSettings);
        else if (optionRender == 2)
            new HorizontalConsoleRenderer<Character>().render(savGeneratorChar,saveSettings);
        else if (optionRender == 3)
            new VerticalConsoleRenderer<Character>().render(savGeneratorChar,saveSettings);
        else if (optionRender == 4)
            new SwingRenderer<Character>().render(savGeneratorChar,saveSettings);
        else
            simpleSorting();
    }
    public void simpleSorting() {
        if (sortingAlgorithm.equalsIgnoreCase("B"))
            bubbleSort.bubbleSort();
        else if (sortingAlgorithm.equalsIgnoreCase("Q"))
            quickSort.sort();
        else
            mergeSort.sort();
    }
    public void printOrderConsole() {
        if (sortingAlgorithm.equalsIgnoreCase("B"))
            bubbleSort.showSortedItems();
        else if (sortingAlgorithm.equalsIgnoreCase("Q"))
            quickSort.showSortedItems();
        else
            mergeSort.showSortedItems();
    }
    public String getSortingAlgorithm() {
        return sortingAlgorithm;
    }

    public void setSortingAlgorithm(String sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public ListData getListData() {
        return listData;
    }

    public void setListData(ListData listData) {
        this.listData = listData;
    }

    public List<Integer> getListInt() {
        return listInt;
    }

    public void setListInt(List<Integer> listInt) {
        this.listInt = listInt;
    }

    public List<Character> getListChar() {
        return listChar;
    }

    public void setListChar(List<Character> listChar) {
        this.listChar = listChar;
    }

    public BubbleSort getBubbleSort() {
        return bubbleSort;
    }

    public void setBubbleSort(BubbleSort bubbleSort) {
        this.bubbleSort = bubbleSort;
    }

    public QuickSort getQuickSort() {
        return quickSort;
    }

    public void setQuickSort(QuickSort quickSort) {
        this.quickSort = quickSort;
    }

    public MergeSort getMergeSort() {
        return mergeSort;
    }

    public void setMergeSort(MergeSort mergeSort) {
        this.mergeSort = mergeSort;
    }

    public SavGenerator<Integer> getSavGeneratorInt() {
        return savGeneratorInt;
    }

    public void setSavGeneratorInt(SavGenerator<Integer> savGeneratorInt) {
        this.savGeneratorInt = savGeneratorInt;
    }

    public SavGenerator<Character> getSavGeneratorChar() {
        return savGeneratorChar;
    }

    public void setSavGeneratorChar(SavGenerator<Character> savGeneratorChar) {
        this.savGeneratorChar = savGeneratorChar;
    }

    public static SortingVisualizer getSortingVisualizer() {
        return sortingVisualizer;
    }

    public static void setSortingVisualizer(SortingVisualizer sortingVisualizer) {
        SortingVisualizer.sortingVisualizer = sortingVisualizer;
    }
}
