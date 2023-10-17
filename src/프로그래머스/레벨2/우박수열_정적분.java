package 프로그래머스.레벨2;

import java.util.ArrayList;
import java.util.List;

public class 우박수열_정적분 {

    class Solution {

        static List<Integer> list = new ArrayList<>();
        static List<Double> result = new ArrayList<>();

        public double[] solution(int k, int[][] ranges) {
            find(k);
            findResult();

            double[] answer = new double[ranges.length];
            for(int i=0; i<answer.length; i++) {
                int n = ranges[i][0];
                int m = list.size() + ranges[i][1];
                if(m <= n) {
                    answer[i] = -1;
                } else {
                    answer[i] = getResult(n, m);
                }
            }

            return answer;
        }

        void find(int k) {
            list.add(k);
            while(k > 1) {
                if(k % 2 == 0) {
                    k /= 2;
                } else if(k % 2 == 1) {
                    k = k*3 + 1;
                }
                list.add(k);
            }
        }

        void findResult() {
            for(int i=0; i<list.size()-1; i++) {
                double h = Math.abs(list.get(i) - list.get(i+1));
                double w = 1;
                result.add(h/2 + Math.min(list.get(i), list.get(i+1)));
            }
        }

        double getResult(int start, int end) {
            double sum = 0;
            for(int i=start; i<end-1; i++) {
                sum += result.get(i);
            }
            return sum;
        }
    }
}
