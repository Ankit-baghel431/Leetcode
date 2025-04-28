import java.util.AbstractMap;
class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = 
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() > 1) {
            Map.Entry<Character, Integer> first = maxHeap.poll();
            Map.Entry<Character, Integer> second = maxHeap.poll();
            sb.append(first.getKey());
            sb.append(second.getKey());
            if (first.getValue() - 1 > 0) {
                maxHeap.offer(new AbstractMap.SimpleEntry<>(first.getKey(), first.getValue() - 1));
            }
            if (second.getValue() - 1 > 0) {
                maxHeap.offer(new AbstractMap.SimpleEntry<>(second.getKey(), second.getValue() - 1));
            }
        }
        if (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> last = maxHeap.poll();
            if (last.getValue() > 1) {
                return "";
            }
            sb.append(last.getKey());
        }
        return sb.toString();
    }
}