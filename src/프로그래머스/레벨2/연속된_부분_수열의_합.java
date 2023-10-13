package 프로그래머스.레벨2;

public class 연속된_부분_수열의_합 {

    class Solution {

        public int[] solution(int[] sequence, int k) {
            int prevStart = 0;
            int prevEnd = Integer.MAX_VALUE;
            int start = 0;
            int end = 0;

            int result = sequence[0];
            while(end < sequence.length && start < sequence.length) {
                if(result < k) {
                    if(end == sequence.length-1) {
                        break;
                    }
                    end++;
                    result += sequence[end];
                } else if(result > k) {
                    result -= sequence[start];
                    start++;
                } else {
                    if(end-start < prevEnd-prevStart) {
                        prevStart = start;
                        prevEnd = end;
                    }

                    result -= sequence[start];
                    start++;
                }
            }
            int[] answer = new int[2];
            answer[0] = prevStart;
            answer[1] = prevEnd;
            return answer;
        }
    }
}
