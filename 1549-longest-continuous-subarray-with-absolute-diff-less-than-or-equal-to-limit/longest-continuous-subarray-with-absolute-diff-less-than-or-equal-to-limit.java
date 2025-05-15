class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxque = new LinkedList<>();
        Deque<Integer> minque = new LinkedList<>();
        int left = 0;
        int result = 0;
        for(int right = 0;right<nums.length;right++){
            while(!maxque.isEmpty() && nums[right] > maxque.peekLast()){
                maxque.pollLast();
            }
            maxque.addLast(nums[right]);
            while(!minque.isEmpty() && nums[right] < minque.peekLast()){
                minque.pollLast();
            }
            minque.addLast(nums[right]);
            while (!maxque.isEmpty() && !minque.isEmpty() && maxque.peekFirst() - minque.peekFirst() > limit) {
                if(maxque.peekFirst() == nums[left]) maxque.pollFirst();
                if(minque.peekFirst() == nums[left]) minque.pollFirst();
                left++;
            }
            result = Math.max(result,right-left+1);
        }
        return result;
    }
}