package DesignPatterns.Behavioral.Strategy;

public class StrategyPattern {

    // Strategy
    interface SortingStrategy {
        void sort(int[] array);
    }

    // Strategy 1
    static class BubbleSort implements SortingStrategy {
        @Override
        public void sort(int[] array) {
            System.out.println("Sorting using Bubble Sort");
        }
    }

    // Strategy 2
    static class MergeSort implements SortingStrategy {
        @Override
        public void sort(int[] array) {
            System.out.println("Sorting using Merge Sort");
        }
    }

    // Strategy 3
    static class QuickSort implements SortingStrategy {
        @Override
        public void sort(int[] array) {
            System.out.println("Sorting using Quick Sort");
        }
    }

    // Context
    static class SortingContext {
        private SortingStrategy sortingStrategy;

        public SortingContext(SortingStrategy sortingStrategy) {
            this.sortingStrategy = sortingStrategy;
        }

        public void setSortingStrategy(SortingStrategy sortingStrategy) {
            this.sortingStrategy = sortingStrategy;
        }

        public void performSort(int[] array) {
            sortingStrategy.sort(array);
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 3};

        SortingContext context = new SortingContext(new BubbleSort());
        context.performSort(array);

        // Change strategy at runtime
        context.setSortingStrategy(new MergeSort());
        context.performSort(array);

        context.setSortingStrategy(new QuickSort());
        context.performSort(array);
    }
}

// this can be useful when user have to change the context on bases on load like if array is of length 100 then use bubble else set strtegy to merge somethinglike that
// when have to take decision on runtime