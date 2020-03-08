package offerbook.array;

public class ArrayQs {

    public static void main(String[] args) {
        ArrayQs arr = new ArrayQs();
        int[] numbers = {2, 1, 2, 3, 4, 5};
        arr.duplicate(numbers, numbers.length);
    }

    /**
     * 数组中重复的数字
     *
     * @param numbers
     * @param length
     * @return
     */
    public boolean duplicate(int[] numbers, int length) {
        if (numbers == null || length <= 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return false;
            }
        }

        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    System.out.println("重复数字：" + numbers[i]);
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }

    /**
     * 不修改数组找出重复的数字
     * 思想：类似二分查找，统计数组出现在每个范围内出现的次数
     * countRang被调用O（logn）次，每次需要O（n）的时间===》时间复杂度是O(nlogn)
     *
     * @param numbers
     * @param length
     */
    public int duplicate2(int[] numbers, int length) {
        if (numbers == null || length <= 0) {
            return -1;
        }
        int start = 1;
        int end = length - 1;

        while (end >= start) {
            int middle = (end - start) >> 2 + start;
            int count = countRange(numbers, length, start, middle);
            if (count == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }

            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    private int countRange(int[] numbers, int length, int start, int end) {
        if (numbers == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (numbers[i] >= start && numbers[i] <= end) {
                ++count;
            }
        }
        return count;
    }

    public boolean findFromArray2(int number) {
        int[] array = new int[5];
        int[][] array2 = new int[5][3];
        int[][] array3 = new int[4][];
        //int[][] array4 = new int[][3];//错误
        //int[][] array5 = new int[][];//错误

        //二维数组的长度为一维数组的个数
        int[][] arr = {{2, 5, 7}, {3, 6, 8}, {4, 7, 9}};
        int rows = arr.length;
        int column = arr[0].length - 1;
        int row = 0;
        boolean found = false;
        while (row < rows && column > 0) {
            if (arr[row][column] == number) {
                found = true;
                break;
            } else if (arr[row][column] > number) {
                --column;
            } else {
                ++row;
            }
        }
        return found;
    }

    public void replaceBlank(String str) {
        if (str == null) {
            return;
        }
        char[] chars = str.toCharArray();
        int length = chars.length;
        int oldLenth = 0;
        int blankNumber = 0;
        int i = 0;
        while (chars[i] != '\0') {
            ++oldLenth;
            if (' ' == chars[i]) {
                ++blankNumber;
            }
            ++i;
        }
        int newStrLength = oldLenth + blankNumber * 2;

        int newStringIndex = newStrLength;
        int oldStringIndex = oldLenth;
        while (oldStringIndex > 0) {

        }
    }
}
