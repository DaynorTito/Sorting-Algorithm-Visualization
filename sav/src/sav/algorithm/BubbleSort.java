package university.jala.sav.algorithm;

import sav.RenderOperation;
import sav.SavGenerator;
import university.jala.sav.parameters.DelayPauseTime;

import java.util.Arrays;
import java.util.List;

public class BubbleSort<E extends Comparable<E>> implements SortingAlgorithm<E>, SavGenerator<E> {
    private E[] array;
    private boolean ascendingOrder;
    private int numberIterations;
    private int delayPauseTime;
    private static BubbleSort bubbleSort;

    public static <E extends Comparable<E>> BubbleSort<E> getInstance(E[] array, int pauseTime, boolean ascendant) {
        if (bubbleSort == null) {
            bubbleSort = new BubbleSort(array,pauseTime,ascendant);
        }
        return bubbleSort;
    }

    private BubbleSort() {

    }
    private BubbleSort(E[] array, int pauseTime, boolean ascendant) {
        this.numberIterations = 0;
        this.delayPauseTime = pauseTime;
        this.array = array;
        this.ascendingOrder = ascendant;
    }
    @Override
    public void sortItems(List<E> list, boolean b, RenderOperation<E> renderOperation) {
        sort(renderOperation);
    }

    @Override
    public void sort(RenderOperation<E> renderOperation) {
        numberIterations = 0;
        bubbleSort(renderOperation);
    }

    @Override
    public void showSortedItems() {
        System.out.print("\nOrdering: [");
        for (int i = 0; i <array.length-1; i++)
            System.out.print(array[i]+", ");
        System.out.println(array[array.length-1]+"]\nAlgorithm: Bubble Sort (Default)");
        System.out.println("Total time: "+(numberIterations*delayPauseTime)+" ms\n");
    }
    public void bubbleSort(RenderOperation<E> renderOperation) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if(this.ascendingOrder) {
                    if (array[j].compareTo(array[j + 1]) > 0) {
                        swap(j, j + 1);
                        renderOperation.render(Arrays.asList(array));
                    }
                } else{
                    if (array[j].compareTo(array[j + 1]) < 0) {
                        swap(j, j + 1);
                        renderOperation.render(Arrays.asList(array));
                    }
                }
                DelayPauseTime.wait(delayPauseTime);
                numberIterations++;
            }
        }
        renderOperation.render(Arrays.asList(array));
    }
    public void bubbleSort() {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if(this.ascendingOrder) {
                    if (array[j].compareTo(array[j + 1]) > 0)
                        swap(j, j + 1);
                } else{
                    if (array[j].compareTo(array[j + 1]) < 0)
                        swap(j, j + 1);
                }
                DelayPauseTime.wait(delayPauseTime);
                numberIterations++;
            }
        }
    }
    public void swap(int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public E[] getArray() {
        return array;
    }

    public void setArray(E[] array) {
        this.array = array;
    }

    public boolean isAscendingOrder() {
        return ascendingOrder;
    }

    public void setAscendingOrder(boolean ascendingOrder) {
        this.ascendingOrder = ascendingOrder;
    }

    public int getNumberIterations() {
        return numberIterations;
    }

    public void setNumberIterations(int numberIterations) {
        this.numberIterations = numberIterations;
    }

    public int getDelayPauseTime() {
        return delayPauseTime;
    }

    public void setDelayPauseTime(int delayPauseTime) {
        this.delayPauseTime = delayPauseTime;
    }

    public static BubbleSort getBubbleSort() {
        return bubbleSort;
    }

    public static void setBubbleSort(BubbleSort bubbleSort) {
        BubbleSort.bubbleSort = bubbleSort;
    }
}
