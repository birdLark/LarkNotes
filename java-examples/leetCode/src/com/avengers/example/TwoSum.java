package com.avengers.example;

import com.sun.deploy.util.StringUtils;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和求解
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arrays= {2, 7, 11, 15};
        int target =26;

        TwoSum.twoSum(arrays,target);
    }

    public static int[]  twoSum(int[] arrays ,int target) {
        Map<Integer,int[]> result = new HashMap<Integer,int[]>();

        for(int i =0;i<arrays.length;i++){
            for(int j=i;j<arrays.length;j++){
                result.put(arrays[i]+arrays[j], new int[]{i,j});
            }
        }
        return result.get(target) == null? null : result.get(target);
    }
}
