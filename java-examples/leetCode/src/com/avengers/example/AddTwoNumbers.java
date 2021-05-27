package com.avengers.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddTwoNumbers {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>() {{
            add(2); add(4);add(3);
        }};
        List<Integer> list2 = new ArrayList<Integer>() {{
            add(5);add(6);add(4);
        }};

        AddTwoNumbers.addTwoNumbers(list1,list2);
    }

    public static List<Integer> addTwoNumbers(List<Integer> list1,List<Integer> list2){
        int sum = 0 ;
        List<Integer> result = new ArrayList<>();
        //累计求和
        for(int i = list1.size()-1;i>=0;i--){
            sum+=Math.pow(10,i)*list1.get(i);
        }
        for(int i = list2.size()-1;i>=0;i--){
            sum+=Math.pow(10,i)*list2.get(i);
        }
        //将每位取出来
        while (true){
            result.add(sum%10);
            sum = sum/10;
            if (sum == 0 )
                break;
        }
        //倒序
        Collections.reverse(result);
        return result;
    }
}
