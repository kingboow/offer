package algorithm;

import java.util.Stack;

/**
 * 快速排序
 *
 * @author kingbo
 * @create 2017-07-04 18:02
 **/
public class QuickSort {
    private Stack<Integer> stack = new Stack<Integer>();

    /**
     * 利用栈的非递归快速排序
     * @param items
     * @param l
     * @param r
     */
    public void sort_stack(int[] items, int l, int r) {
        int i;
        push2(r, l); //向栈推入r和l

        while(!stackempty()) { //只要栈不空就一直循环
            l = pop(); r = pop();
            if(r <= l) continue;
            i = partition(items, l, r);
            //较大的一侧先入栈，可以保证栈的最大深度在lgN以内
            if(i-l > r-i) {
                push2(i-1, l); push2(r, i+1);
            } else {
                push2(r, i+1); push2(i-1, l);
            }
        }
    }

    //依次向栈推入a和b
    private void push2(int a, int b) {
        stack.push(a);
        stack.push(b);
    }

    private boolean stackempty() {
        return stack.isEmpty();
    }

    private int pop() {
        return stack.pop();
    }

    //对下标从l到r之间的items进行处理：
    private int partition(int[] items, int l, int r) {
        int i = l - 1, j = r;
        int v = items[r];
        while(true) {
            while(items[++i] < v);
            while(v < items[--j])
                if(j ==l) break;
            if(i >= j) break;
            exchange(items, i, j);
        }
        exchange(items, i, r);
        return i;
    }

    //交换
    private void exchange(int[] items, int a, int b) {
        int t;
        t = items[a];
        items[a] = items[b];
        items[b] = t;
    }

    //测试
    public static void main(String[] args) {
        int[] items = {12, 21, 13, 12, 11, 15, 17, 22};

        QuickSort qs = new QuickSort();
        qs.sort_stack(items, 0, items.length-1);

        for(int i=0; i<items.length; i++) {
            System.out.print(items[i] + " ");
        }
    }
}
