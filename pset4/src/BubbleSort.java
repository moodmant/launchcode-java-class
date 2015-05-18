import java.util.Arrays;
/**
 * Created by taylor on 5/13/15.
 */
public class BubbleSort implements SortStrategy {

    private Integer array[];

    public BubbleSort(Integer needSort[]){
        this.array = needSort;
    }

    public Integer[] sort(){

        for(int j = this.array.length; j > 0; j--){
            for (int i = 0; i < (this.array.length - 1); i++) {
                if (this.array[i] > this.array[i + 1]) {
                    int x = this.array[i];
                    this.array[i] = this.array[i + 1];
                    this.array[i + 1] = x;
                }
            }
        }
        return this.array;
    }

    public static void main(String args[]) {
        Integer[] a = {12, 5, 73, 99, 45, 60, 12};
        BubbleSort bs = new BubbleSort(a);
        System.out.println("Bubble Sorted: " + Arrays.toString(bs.sort()));
    }
}
