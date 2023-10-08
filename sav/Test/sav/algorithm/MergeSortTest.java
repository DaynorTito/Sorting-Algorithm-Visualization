package university.jala.sav.algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sav.RenderOperation;

import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {
    private MergeSort<Character> charMergeSort;

    @BeforeEach
    void setUp() {
        Character[] charArray = {'z', 'a', 'b', 'd', 'c'};
        int pauseTime = 100;
        boolean ascendingOrder = true;

        charMergeSort = MergeSort.getInstance(charArray, pauseTime, ascendingOrder);
    }

    @Test
    void testCharacterMergeSort() {
        charMergeSort.sort();

        assertArrayEquals(new Character[]{'a', 'b', 'c', 'd', 'z'}, charMergeSort.getArray());
    }
}
