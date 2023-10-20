package 프로그래머스.레벨2;

import java.util.HashMap;
import java.util.Map;

public class 뉴스_클러스터링 {

    class Solution {

        static final String REG = "[a-z]{2,2}";

        public int solution(String str1, String str2) {
            int answer = 0;

            String input1 = str1.toLowerCase();
            String input2 = str2.toLowerCase();

            Map<String, Integer> map1 = new HashMap<>();
            Map<String, Integer> map2 = new HashMap<>();
            for(int i=0; i<input1.length()-1; i++) {
                String target = input1.substring(i, i+2);
                if(isTarget(target)) {
                    map1.put(target, map1.getOrDefault(target, 0)+1);
                }
            }
            for(int i=0; i<input2.length()-1; i++) {
                String target = input2.substring(i, i+2);
                if(isTarget(target)) {
                    map2.put(target, map2.getOrDefault(target, 0)+1);
                }
            }


            int count1 = calculateEqual(map1, map2);
            int count2 = calculateAll(map1, map2);

            if(count2 == 0) {
                answer = 65536;
            } else {
                answer = count1*65536 / count2;
            }

            return answer;
        }

        boolean isTarget(String str) {
            if(str.matches(REG)) {
                return true;
            } else {
                return false;
            }
        }

        int calculateEqual(Map<String, Integer> map1, Map<String, Integer> map2) {
            int count = 0;
            for(String key: map1.keySet()) {
                if(map2.containsKey(key)) {
                    count += Math.min(map1.get(key), map2.get(key));
                }
            }
            return count;
        }

        int calculateAll(Map<String, Integer> map1, Map<String, Integer> map2) {
            int count = 0;
            for(String key: map1.keySet()) {
                if(map2.containsKey(key)) {
                    count += Math.max(map1.get(key), map2.get(key));
                } else {
                    count += map1.get(key);
                }
            }
            for(String key: map2.keySet()) {
                if(!map1.containsKey(key)) {
                    count += map2.get(key);
                }
            }
            return count;
        }
    }
}
