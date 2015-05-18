import java.util.Arrays;
/**
 * Created by taylor on 5/13/15.
 */
public class MergeSort implements SortStrategy {
    private Integer[] array;
    private Integer[] temp;
    private int length;

    public MergeSort(Integer needSort[]){
        this.array = needSort;
        this.length = needSort.length;
        this.temp = new Integer[this.length];
    }

    public Integer[] sort(){
        executeMerge(0, length - 1);
        return this.array;
    }

    private void executeMerge(int lower, int higher){
        if (lower < higher){
            int mid = lower + (higher - lower) / 2;
            executeMerge(lower, mid);
            executeMerge(mid + 1, higher);
            combine(lower, mid, higher);
        }
    }

    private void combine(int lower, int mid, int higher){

        for(int i = lower; i <= higher; i++){
            temp[i] = array[i];
        }
        int i = lower;
        int j = mid + 1;
        int k = lower;
        while (i <= mid && j <= higher) {
            if (temp[i] <= temp[j]){
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= mid){
            array[k] = temp[i];
            k++;
            i++;
        }
    }

    public static void main(String args[]){
        Integer[] inputArr = {12, 5, 73, 99, 45, 60, 12};
        MergeSort ms = new MergeSort(inputArr);
        System.out.println("Merge sorted: " + Arrays.toString(ms.sort()));

    }
}
