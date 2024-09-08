package DataStructure.Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementLeft {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        nextGreaterElement(arr);
    }

    public static void nextGreaterElement(int[] arr) {
        int len = arr.length;
        int[] ans = new int[len];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<len; i++) {
            if(st.empty()) {
                ans[i] = -1;
            }
            else if(st.size()>0 && st.peek() > arr[i]) {
                ans[i] = st.peek();
            }
            else if(st.size()>0 && st.peek() <= arr[i]) {
                while(st.size()>0 && st.peek() <= arr[i]) {
                    st.pop();
                }
                if(st.empty()) {
                    ans[i] = -1;
                }
                else {
                    ans[i] = st.peek();
                }
            }
            st.add(arr[i]);
        }
        System.out.println("Array values: " + Arrays.toString(ans));
    }
}
