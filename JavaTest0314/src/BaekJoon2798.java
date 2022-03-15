/*
첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다.
둘째 줄에는 카드에 쓰여 있는 수가 주어지며,
이 값은 100,000을 넘지 않는 양의 정수이다.

합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.

첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.

정답은 아래 경로 참조
https://st-lab.tistory.com/97
*/
import java.lang.Integer;
import java.util.Arrays;

public class BaekJoon2798 {


    public static int search1(int N, int M, int[] cards){
        int result = 0;

        // 3개를 고르기 때문에 첫번째 카드는 N - 2 까지만 순회
        for (int i = 0; i < N - 2; i++) {

            // 두 번째 카드는 첫 번째 카드 다음부터 N - 1 까지만 순회
            for (int j = i + 1; j < N - 1; j++) {

                // 세 번째 카드는 두 번째 카드 다음부터 N 까지 순회
                for (int k = j + 1; k < N; k++) {

                    // 3개 카드의 합 변수 temp
                    int temp = cards[i] + cards[j] + cards[k];

                    // M과 세 카드의 합이 같다면 temp return 및 종료
                    if (M == temp) {
                        return temp;
                    }

                    // 세 카드의 합이 이전 합보다 크면서 M 보다 작을 경우 result 갱신
                    if(result < temp && temp < M) {
                        result = temp;
                    }
                }
            }
        }

        // 모든 순회를 마치면 result 리턴
        return result;
    }

    public static void main(String[] args){
        if(args.length != 2) {
            System.out.println("Please Enter the Parameter as the Description");
            return;
        }

        int N = Integer.parseInt(args[0].split(",")[0]);
        if(N < 3 || N > 100)
            System.out.println("N should be bigger than 3 or smaller than 100");

        int M = Integer.parseInt(args[0].split(",")[1]);
        if(M < 10 || M > 300000)
            System.out.println("M should be bigger than 10 or smaller than 300,000");

        int answer = 0;

        String[] buffer = args[1].split(",");
        int[] cards = new int[N];

        for(int i = 0; i < N; i++){
            cards[i] = Integer.parseInt(buffer[i]);
        }

        Arrays.sort(cards);

        System.out.println(search1(N,M,cards));
    }
}
