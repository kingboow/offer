package train;


/**
 * 求数组中两个数相加等于一个定值
 *
 * @author kingbo
 * @create 2017-07-21 14:22
 **/
public class ArraySumTest {
    public static void main(String[] args) {
        int[] array1 = {10,2,7,4,5,6,3,8,9,1,4};
//        excuteHash(array1,8);
        int[] array2 = {1,2,3,4,5,6,7,8,9,10};
        excute3(array2,8);
    }

    private static void excuteHash(int [] array,int tem){
        int size = array.length;
        int hash[] = new int[size];
        for (int i :array){
            hash[i%tem] =1;
        }
        for (int i = 0; i < array.length; i++) {
            int val = tem-array[i];
            if(val>=array[i] && hash[val%tem]==1){
                System.out.println(array[i]+","+val);
            }
        }
    }

    private static void excute2(int[] array2, int m) {
        int left = 0;
        int right = array2.length-1;
        while (left<right){
            if (array2[left]+array2[right] == m){
                System.out.println(array2[left]+","+array2[right]);
                left++;right--;
            }else if (array2[left]+array2[right] > m){
                right--;
            }else{
                left++;
            }
        }
    }
    private static void excute3 (int [] array ,int m){
        for (int i = 0; i < array.length; i++) {
            int tem = m -array[i];
            if(tem>array[i]){
                if (binarySearchTest(array,tem)!= -1){
                    System.out.println(tem+","+array[i]);
                }
            }
        }
    }

    private static int binarySearchTest(int[] array, int tem) {
        if (array.length==0){
            return -1;
        }
        int first = 0;
        int last = array.length-1;
        int mid ;
        while (first<=last){
            mid = (first+last)/2;
            if (array[mid]==tem){
                return mid;
            }else if (array[mid]>tem){
                last=mid-1;
            }else{
                first=mid+1;
            }

        }
        return -1;
    }


}
