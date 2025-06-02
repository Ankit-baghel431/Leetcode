class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int [] candies = new int[n];
        Arrays.fill(candies,1);
        // left to right
        for(int i = 1;i<n;i++){
            if(ratings[i-1]<ratings[i]){
                candies[i] = candies[i-1]+1;
            }
        }
        // right to left
        for(int i = n-2;i>=0;i--){
            if(ratings[i+1]<ratings[i]){
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        // count the candies
        int count = 0;
        for(int i = 0;i<n;i++){
            count += candies[i];
        }
        return count;

    }
}