

import java.io.*;
import java.util.*;
import java.lang.*;

/**
 * Created by taylor on 5/13/15.
 */
public class ArraySorter {
    private SortStrategy strategy;

    public ArraySorter(SortStrategy simple){
        this.strategy = simple;
    }

    public void sorted(){
        strategy.sort();
    }

    public static void main(String args[]){
        int choice = 0;
        Integer[] a1 = {12, 5, 73, 99, 45, 60, 12};
        BubbleSort b = new BubbleSort(a1);
        MergeSort m = new MergeSort(a1);
        ArraySorter bs = new ArraySorter(b);
        ArraySorter ms = new ArraySorter(m);

        Scanner scanner = new Scanner(System.in);
        while (choice != 1 && choice != 2){
            System.out.println("Please select (1)Print to command line, or (2)Print to file: ");
            choice = Integer.parseInt(scanner.nextLine());
        }
        scanner.close();

        PrintWriter text = new PrintWriter(System.out);

        if (choice == 2){
            try {
                text = new PrintWriter("sorted.txt");
            } catch ( IOException A){
                A.printStackTrace(System.out);
            }
        }

        long startTimeBS = System.nanoTime();
        bs.sorted();
        long endTimeBS = System.nanoTime();

        long startTimeMS = System.nanoTime();
        ms.sorted();
        long endTimeMS = System.nanoTime();

        text.write("Bubble Sort:" + Arrays.toString(b.sort()) + "\tTime: " + (endTimeBS - startTimeBS) + " nanoseconds\n");
        text.write("Merge Sort: " + Arrays.toString(m.sort()) + "\tTime: " + (endTimeMS - startTimeMS) + " nanoseconds\n");
        text.close();

    }
}
