package 프로그래머스.레벨2;

public class 이모티콘_할인행사 {

    class Solution {

        static int[] percents;
        static int maxPlus = 0;
        static int resultSum = 0;

        public int[] solution(int[][] users, int[] emoticons) {
            int n = emoticons.length;
            percents = new int[n];

            findCombination(emoticons, 0, users);

            int[] answer = {maxPlus, resultSum};
            return answer;
        }

        void findCombination(int[] emoticons, int idx, int[][] users) {
            if(idx == emoticons.length) {
                getResult(users, emoticons);
                return;
            }
            for(int i=10; i<=40; i+=10) {
                percents[idx] = i;
                findCombination(emoticons, idx+1, users);
            }
        }

        void getResult(int[][] users, int[] emoticons) {
            int plus = 0;
            int sum = 0;
            for(int[] user: users) {
                int price = 0;
                for(int i=0; i<emoticons.length; i++) {
                    if(percents[i] >= user[0]) {
                        price += emoticons[i]*(100-percents[i])/100;
                    }
                }

                if(price >= user[1]) {
                    plus++;
                } else {
                    sum += price;
                }
            }

            if(plus > maxPlus) {
                maxPlus = plus;
                resultSum = sum;
            } else if(plus == maxPlus && sum > resultSum) {
                resultSum = sum;
            }
        }
    }
}
