package org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.strategyPattern;


// We define multiple algorithms and let client application pass the algorithm to be
// used as a parameter. One of the best example of strategy pattern is
// Collections.sort() method that takes Comparator parameter.
// Based on the different implementations of Comparator interfaces, the Objects
// are getting sorted in different ways.
public class StrategyDemo {

    public static void main(String[] args){
        int[] arr = {5,2,7,9,1};
        SortingContext sortingContext1 = new SortingContext(new BubbleSorting());
        sortingContext1.performSorting(arr);

        SortingContext sortingContext2 = new SortingContext(new QuickSorting());
        sortingContext2.performSorting(arr);

        SortingContext sortingContext3 = new SortingContext(new MergeSorting());
        sortingContext3.performSorting(arr);
    }
}


interface SortingStrategy{
    void sort(int[] arr);
}

class BubbleSorting implements SortingStrategy{
    @Override
    public void sort(int[] arr){
        System.out.println("bubble Sort logic implemented");
    }
}

class QuickSorting implements SortingStrategy{
    @Override
    public void sort(int[] arr){
        System.out.println("quick Sort logic implemented");
    }
}

class MergeSorting implements SortingStrategy{
    @Override
    public void sort(int[] arr){
        System.out.println("merge Sort logic implemented");
    }
    
}

class SortingContext{
    private SortingStrategy sortingStrategy;

    public SortingContext(SortingStrategy sortingStrategy){
        this.sortingStrategy = sortingStrategy;
    }

    public SortingStrategy setSortingStrategy(SortingStrategy sortingStrategy) {
        return this.sortingStrategy = sortingStrategy;
    }

    public void performSorting(int[] arr){
        sortingStrategy.sort(arr);
    }
}


