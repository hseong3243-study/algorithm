package 프로그래머스.레벨2;

public class 점프와_순간_이동 {

    public class Solution {
        public int solution(int n) {
            int ans = 0;

            while(n != 0) {
                if(n%2==0) {
                    n /= 2;
                } else {
                    n--;
                    ans++;
                }
            }

            return ans;
        }
    }
}
