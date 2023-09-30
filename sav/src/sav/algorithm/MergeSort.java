package university.jala.sav.algorithm;

import sav.RenderOperation;
import sav.SavGenerator;
import university.jala.sav.parameters.DelayPauseTime;

import java.util.Arrays;
import java.util.List;

public class MergeSort<E extends Comparable<E>> implements SortingAlgorithm<E>, SavGenerator<E> {

    private E[] array;
    private E[] copy;
    private boolean ascendingOrder;
    private int numberIterations;
    private int delayPauseTime;
    private static MergeSort mergeSort;


    public static <E extends Comparable<E>> MergeSort<E> getInstance(E[] array, int pauseTime, boolean ascendant) {
        if (mergeSort == null) {
            mergeSort = new MergeSort<>(array,pauseTime,ascendant);
        }
        return mergeSort;
    }

    private MergeSort() {

    }
    private MergeSort(E[] array, int pauseTime, boolean ascendant) {
        this.numberIterations = 0;
        this.delayPauseTime = pauseTime;
        this.array = array;
        this.copy = (E[]) new Comparable[array.length];
        this.ascendingOrder = ascendant;
    }
    @Override
    public void sortItems(List<E> list, boolean b, RenderOperation<E> renderOperation) {
        sort(renderOperation);
    }

    @Override
    public void sort(RenderOperation<E> renderOperation) {
        numberIterations = 0;
        mergeSort(0, array.length-1,renderOperation);
    }
    public void sort() {
        numberIterations = 0;
        mergeSort(0, array.length-1);
    }
    @Override
    public void showSortedItems() {
        System.out.print("\nOrdering: [");
        for (int i = 0; i <array.length-1; i++)
            System.out.print(array[i]+", ");
        System.out.println(array[array.length-1]+"]\nAlgorithm: Merge Sort");
        System.out.println("Total time: "+(numberIterations*delayPauseTime)+" ms\n");
    }
    public void mergeSort(int left, int right, RenderOperation<E> renderOperation) {
        if(left == right)
            return;
        int middle = (left + right) / 2;
        mergeSort(left, middle, renderOperation);
        mergeSort(middle + 1, right, renderOperation);
        for(int i = left; i <= right; i++)
            copy[i] = array[i];
        int Left = left;
        int Right = middle + 1;
        for(int i = left; i <= right; i++) {
            if(Left > middle) {
                array[i] = copy[Right++];
                renderOperation.render(Arrays.asList(array));
            } else if(Right > right) {
                array[i] = copy[Left++];
                renderOperation.render(Arrays.asList(array));
            } else {
                if (this.ascendingOrder) {
                    if (copy[Left].compareTo(copy[Right]) < 0) {
                        array[i] = copy[Left++];
                        renderOperation.render(Arrays.asList(array));
                    } else
                        array[i] = copy[Right++];
                } else{
                    if (copy[Left].compareTo(copy[Right]) > 0) {
                        array[i] = copy[Left++];
                        renderOperation.render(Arrays.asList(array));
                    } else
                        array[i] = copy[Right++];
                }
            }
            DelayPauseTime.wait(delayPauseTime);
            numberIterations++;
        }
    }

    public void mergeSort(int left, int right) {
        if(left == right)
            return;
        int middle = (left + right) / 2;
        mergeSort(left, middle);
        mergeSort(middle + 1, right);
        for(int i = left; i <= right; i++)
            copy[i] = array[i];
        int Left = left;
        int Right = middle + 1;
        for(int i = left; i <= right; i++) {
            if(Left > middle)
                array[i] = copy[Right++];
            else if(Right > right)
                array[i] = copy[Left++];
            else {
                if (this.ascendingOrder) {
                    if (copy[Left].compareTo(copy[Right]) < 0)
                        array[i] = copy[Left++];
                    else
                        array[i] = copy[Right++];
                } else{
                    if (copy[Left].compareTo(copy[Right]) > 0)
                        array[i] = copy[Left++];
                    else
                        array[i] = copy[Right++];
                }
            }
            DelayPauseTime.wait(delayPauseTime);
            numberIterations++;
        }
    }

    public E[] getArray() {
        return array;
    }

    public void setArray(E[] array) {
        this.array = array;
    }

    public E[] getCopy() {
        return copy;
    }

    public void setCopy(E[] copy) {
        this.copy = copy;
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

    public static MergeSort getMergeSort() {
        return mergeSort;
    }

    public static void setMergeSort(MergeSort mergeSort) {
        MergeSort.mergeSort = mergeSort;
    }
}
