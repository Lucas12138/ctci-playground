import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Write a method to return all subsets of a set.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-10-14 2:03 AM
 */
public class PowerSet {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();

        if (nums == null) {
            return subsets;
        }


        if (nums.length == 0) {
            subsets.add(subset);
            return subsets;
        }
        Arrays.sort(nums);
        subsetDFS(subsets, subset, nums, 0);
        return subsets;
    }

    public void subsetDFS(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int startIndex) {
        subsets.add(new ArrayList<>(subset));

        for (int i = startIndex; i < nums.length; i += 1) {
            if (startIndex != i && nums[i] == nums[i - 1]) {
                continue;
            }

            subset.add(nums[i]);
            subsetDFS(subsets, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 2};
        List<List<Integer>> subsets = subsetsWithDup(nums);
        List<Integer> subset1 = new ArrayList<>();
        List<Integer> subset2 = new ArrayList<>();
        subset2.add(1);
        List<Integer> subset3 = new ArrayList<>();
        subset3.add(2);
        List<Integer> subset4 = new ArrayList<>();
        subset4.add(1);
        subset4.add(2);
        List<Integer> subset5 = new ArrayList<>();
        subset5.add(1);
        subset5.add(1);
        List<Integer> subset6 = new ArrayList<>();
        subset6.add(1);
        subset6.add(1);
        subset6.add(2);
        assertEquals(subsets.size(), 6);
        assertEquals(subsets.contains(subset1), true);
        assertEquals(subsets.contains(subset2), true);
        assertEquals(subsets.contains(subset3), true);
        assertEquals(subsets.contains(subset4), true);
        assertEquals(subsets.contains(subset5), true);
        assertEquals(subsets.contains(subset6), true);
    }
}
