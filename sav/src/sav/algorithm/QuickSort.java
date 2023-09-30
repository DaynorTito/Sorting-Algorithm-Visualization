package university.jala.sav.algorithm;

import sav.RenderOperation;
import sav.SavGenerator;
import university.jala.sav.parameters.DelayPauseTime;

import java.util.Arrays;
import java.util.List;

public class QuickSort<E extends Comparable<E>> implements SortingAlgorithm<E>, SavGenerator<E> {

    private E[] array;
    private boolean ascendingOrder;
    private int numberIterations;
    private int delayPauseTime;
    private static QuickSort quickSort;

    public static <E extends Comparable<E>> QuickSort<E> getInstance(E[] array, int pauseTime, boolean ascendant) {
        if (quickSort == null) {
            quickSort = new QuickSort(array,pauseTime,ascendant);
        }
        return quickSort;
    }

    private QuickSort() {

    }
    private QuickSort(E[] array, int pauseTime, boolean ascendant) {
        this.numberIterations = 0;
        this.delayPauseTime = pauseTime;
        this.array = array;
        this.ascendingOrder = ascendant;
    }
    @Override
    public void sortItems(List<E> list, boolean ascendingOrder, RenderOperation<E> renderOperation) {
        sort(renderOperation);
    }

    @Override
    public void sort(RenderOperation<E> renderOperation) {
        numberIterations = 0;
        quickSort(0, array.length-1, renderOperation);
    }
    public void sort() {
        numberIterations = 0;
        quickSort(0, array.length-1);
    }
    @Override
    public void showSortedItems() {
        System.out.print("\nOrdering: [");
        for (int i = 0; i <array.length-1; i++)
            System.out.print(array[i]+", ");
        System.out.println(array[array.length-1]+"]\nAlgorithm: Quick Sort");
        System.out.println("Total time: "+(numberIterations*delayPauseTime)+" ms\n");
    }
    public void quickSort(int low, int high, RenderOperation<E> renderOperation) {
        if (low < high) {
            int pivotIndex = partition(low, high, renderOperation);
            quickSort(low, pivotIndex - 1, renderOperation);
            quickSort(pivotIndex + 1, high, renderOperation);
        }
    }
    public void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }
    public int partition(int low, int high, RenderOperation<E> renderOperation) {
        E pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if(this.ascendingOrder) {
                if (array[j].compareTo(pivot) < 0) {
                    i++;
                    swap(i, j);
                    renderOperation.render(Arrays.asList(array));
                }
            } else{
                if (array[j].compareTo(pivot) > 0) {
                    i++;
                    swap(i, j);
                    renderOperation.render(Arrays.asList(array));
                }
            }
            DelayPauseTime.wait(delayPauseTime);
            numberIterations++;
        }
        swap(i + 1, high);
        renderOperation.render(Arrays.asList(array));
        return i + 1;
    }
    public int partition(int low, int high) {
        E pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if(this.ascendingOrder) {
                if (array[j].compareTo(pivot) < 0) {
                    i++;
                    swap(i, j);
                }
            } else{
                if (array[j].compareTo(pivot) > 0) {
                    i++;
                    swap(i, j);
                }
            }
            DelayPauseTime.wait(delayPauseTime);
            numberIterations++;
        }
        swap(i + 1, high);
        return i + 1;
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

    public static QuickSort getQuickSort() {
        return quickSort;
    }

    public static void setQuickSort(QuickSort quickSort) {
        QuickSort.quickSort = quickSort;
    }
}
