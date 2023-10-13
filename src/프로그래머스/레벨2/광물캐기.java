package 프로그래머스.레벨2;

public class 광물캐기 {

    class Solution {

        static int result = Integer.MAX_VALUE;

        public int solution(int[] picks, String[] minerals) {
            int pickCount = 0;
            for(int i=0; i<3; i++) {
                pickCount += picks[i];
            }

            find(picks, minerals, 0, 0, pickCount);

            return result;
        }

        void find(int[] picks, String[] minerals, int idx, int tired, int pickCount) {
            if(idx >= minerals.length || pickCount == 0) {
                result = Math.min(result, tired);
                // System.out.println(tired);
                return;
            }
            for(int pick=0; pick<3; pick++) {  //dia, iron, stone
                if(picks[pick] > 0) {
                    picks[pick]--;
                    int tiredWhenUsingPick = pickingFive(minerals, idx, pick);
                    find(picks, minerals, idx+5, tired + tiredWhenUsingPick, pickCount-1);
                    picks[pick]++;
                }
            }
        }

        int pickingFive(String[] minerals, int idx, int pick) {
            int result = 0;
            for(int i=idx; i<idx+5; i++) {
                if(i >= minerals.length) {
                    break;
                }
                result += pick(minerals[i], pick);
            }
            return result;
        }

        int pick(String mineral, int pick) {
            switch(pick) {
                case 2:  //stone
                    if(mineral.equals("diamond")) {
                        return 25;
                    } else if(mineral.equals("iron")) {
                        return 5;
                    }
                    break;
                case 1:  //iron
                    if(mineral.equals("diamond")) {
                        return 5;
                    }
                    break;
            }
            return 1;
        }
    }
}
