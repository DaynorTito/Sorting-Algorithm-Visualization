package university.jala.sav.algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sav.RenderOperation;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {
    private BubbleSort<Integer> integerBubbleSort;

    @BeforeEach
    void setUp() {
        Integer[] intArray = {4, 2, 7, 1, 9, 8, 2, 10, 0, 15, 6};
        int pauseTime = 100;
        boolean ascendingOrder = true;

        integerBubbleSort = BubbleSort.getInstance(intArray, pauseTime, ascendingOrder);
    }

    @Test
    void testIntegerBubbleSort() {
        integerBubbleSort.bubbleSort();
        assertArrayEquals(new Integer[]{0, 1, 2, 2, 4, 6, 7, 8, 9, 10, 15}, integerBubbleSort.getArray());
    }

}
