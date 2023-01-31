package problems.workout;

/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Two {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};

        int np1 = 0, np2 = 0;

        int[] result = new int[nums1.length + nums2.length];

        int i=0;
        while(np1 < nums1.length && np2 < nums2.length){
            if(nums1[np1] < nums2[np2]){
                result[i] = nums1[np1];
                np1+=1;
            } else {
                result[i] = nums2[np2];
                np2+=1;
            }
            i+=1;
        }

        while(np1 == nums1.length && np2 < nums2.length){
            result[i] = nums2[np2];
            np2+=1;
            i+=1;
        }

        while(np1 < nums1.length && np2 == nums2.length){
            result[i] = nums1[np1];
            np1+=1;
            i+=1;
        }

        System.out.println(Arrays.toString(result));

        if(result.length == 1){
            System.out.println(Arrays.toString(result));
            // return result[0];
        }

        boolean isEven = (nums1.length + nums2.length) % 2 == 0;

        int median = (nums1.length + nums2.length) / 2;

        double resultant = 0;

        // System.out.println(median);

        if(isEven){
            resultant = Double.valueOf((result[median-1] + result[median]) / 2.0f);
        } else {
            resultant =  Double.valueOf(result[median]);
        }

        System.out.println(resultant);

        // System.out.println((nums1.length + nums2.length) / 2.0f);

    }
}

