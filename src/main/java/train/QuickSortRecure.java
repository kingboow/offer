package train;

/**
 * 快排-递归
 *
 * @author kingbo
 * @create 2017-07-21 11:47
 **/
public class QuickSortRecure {
    public static void main(String[] args) {
        int[] array = {49, 38, 65, 97, 76, 13, 27};
        int left = 0;
        int right = array.length - 1;
        quickSort(array, left, right);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static void quickSort(int[] array, int left, int right) {
        int preKey ;
        if (left<right){
            preKey = getMiddleValue(array,left,right);
            quickSort(array,left,preKey-1);
            quickSort(array,preKey+1 ,right);
        }
    }

    public static int getMiddleValue(int [] array, int left, int right) {
        int preValue = array[left];
        while (left < right){
            while (left<right && array[right] >= preValue){
                right--;
            }
            array[left] = array[right];
            while (left<right && array[left] <= preValue){
                ++left;
            }
            array[right]=array[left];
        }
        array[left]=preValue;
        return left;
    }
}
