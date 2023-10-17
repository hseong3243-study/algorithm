package 프로그래머스.레벨2;

public class 다음_큰_숫자 {

    class Solution {

        public int solution(int n) {
            int answer = 0;

            answer = find(n);

            return answer;
        }

        int find(int n) {
            int result = n+1;
            String nBi = Integer.toString(n, 2);
            int nOneCount = countOne(nBi);
            while(true) {
                String resultBi = Integer.toString(result, 2);
                if(nOneCount == countOne(resultBi)) {
                    break;
                }
                result++;
            }
            return result;
        }

        int countOne(String n) {
            return n.replace("0", "").length();
        }
    }

}
