package university.jala.sav.algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sav.RenderOperation;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {
    private QuickSort<Integer> quickSort;

    @BeforeEach
    void setUp() {
        Integer[] intArray = {4, 2, 7, 1, 9, 8, 2, 10, 0, 15, 6};
        int pauseTime = 100;
        boolean ascendingOrder = true;
        quickSort = QuickSort.getInstance(intArray, pauseTime, ascendingOrder);
    }

    @Test
    void testCharacterMergeSort() {
        quickSort.sort();
        assertArrayEquals(new Integer[]{0, 1, 2, 2, 4, 6, 7, 8, 9, 10, 15}, quickSort.getArray());
    }
}
