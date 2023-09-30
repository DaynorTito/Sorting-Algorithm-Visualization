package university.jala.sav.algorithm;

import sav.RenderOperation;

public interface SortingAlgorithm<E> {
    void sort(RenderOperation<E> renderOperation);
    void showSortedItems();
}
