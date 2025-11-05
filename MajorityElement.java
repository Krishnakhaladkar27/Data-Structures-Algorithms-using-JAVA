//Given an array arr[] consisting of n integers, the task is to find all the array elements which occurs more than floor(n/3) times.
import java.util.*;

public class MajorityElement {
    
    public List<Integer> findMajority(int[] arr) {
        int n = arr.length;
        Integer candidate1 = null, candidate2 = null;
        int count1 = 0, count2 = 0;
        
        for (int num : arr) {
            if (Objects.equals(candidate1, num)) {
                count1++;
            }else if (Objects.equals(candidate2, num)) {
                count2++;
            }else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : arr) {
            if (Objects.equals(candidate1, num)) count1++;
            else if  (Objects.equals(candidate2, num)) count2++;
        }
        
        int threshold = n / 3;
        List<Integer> result = new ArrayList<>();
        if (count1 > threshold) result.add(candidate1);
        if (candidate2 != null && !Objects.equals(candidate2, candidate1) && count2 > threshold) result.add(candidate2);
        
        Collections.sort(result);
        return result;
    }
    
}
      