package neet.blind75;

import java.util.*;

public class TopKElements {


    public static void main(String[] args) {
        int[] nums = {10,10,102,10,43,45,65,4,4,4,4,4,6,5,5,1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4};
        int noOfElements = 2;
       // System.out.print(getTopKElements(nums, 2).toString());
        System.out.print(topKFrequent(nums,2));

    }

    /*public static int[] getTopKElements(int[] nums, int noOfElements) {
        List<int[]> arr = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            arr.add(new int[]{entry.getKey(), entry.getValue()});
        arr.sort((a, b) -> b[1] - a[1]);

        int[] topKElements = new int[noOfElements];
        for (int i = 0; i < noOfElements; i++) {
            topKElements[i] = (arr.get(i)[0]);
        }

        return topKElements;


    }*/

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }
        return res;
    }

}
