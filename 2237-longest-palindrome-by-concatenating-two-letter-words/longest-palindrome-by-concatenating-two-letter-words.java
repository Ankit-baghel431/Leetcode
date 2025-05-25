class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        int len=0;
        boolean equalWala=false;
        for(String word:map.keySet()){
            String reversed=new StringBuilder(word).reverse().toString();
            int freq=map.get(word);
            if(word.equals(reversed)){
                len+=(freq/2)*4;
                if(freq%2==1){
                    equalWala=true;
                }   
            }
            else if(map.containsKey(reversed)){
                int pairCount=Math.min(freq,map.get(reversed));
                len+=pairCount*4;
                map.put(word,map.get(word)-pairCount);
                map.put(reversed,map.get(reversed)-pairCount);
            }
        }
        if(equalWala){
            len+=2;
        }
        return len;
    }
}