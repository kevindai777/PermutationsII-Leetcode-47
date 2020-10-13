//Java Solution

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        
        List<Integer> nums2 = new ArrayList<>();
        for (int num : nums) {
            nums2.add(num);
        }
        
        backtrack(result, temp, nums2);
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, LinkedList<Integer> temp, List<Integer> nums) {
        if (nums.size() == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = 0; i < nums.size(); i++) {
            if (i != 0 && nums.get(i) == nums.get(i - 1)) {
                continue;
            }
            temp.add(nums.get(i));
            nums.remove(i);
            backtrack(result, temp, nums);
            int last = temp.removeLast();
            nums.add(i, last);
        }
    }
}