
public class main {
    public static void main(String[] args) {
        testNo10171();

        testNo18108(2541);
    }
/* 10171번 문제
아래와 같이 고양이 모양을 출력한다.

\    /\
 )  ( ')
(  /  )
 \(__)|
*/
    public static void testNo10171 (){
        System.out.println("testNo10171 operating..");

        System.out.println("\\    /\\\n" +
                " )  ( ')\n" +
                "(  /  )\n" +
                " \\(__)|");
        System.out.println();
    }

/* 18108번 문제
서기 연도를 알아보고 싶은 불기 연도 y가 주어진다. (1000 ≤ y ≤ 3000)
불기 연도를 서기 연도로 변환한 결과를 출력한다.
input 2541
output 1998
*/
    public static void testNo18108 (int nibbana){
        System.out.println("testNo18108 operating..");

        if(nibbana > 3000 || nibbana < 1000){
            System.out.println("Nibbana must be enter between 1000 ~ 3000");
            return;
        }

        int difference = (2541 - 1998);

        System.out.println(nibbana - difference);
        System.out.println();
    }

/* 2798번 문제
김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다.
그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다.
그런 후에 딜러는 숫자 M을 크게 외친다.

이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다.
블랙잭 변형 게임이기 때문에,
플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.

N장의 카드에 써져 있는 숫자가 주어졌을 때,
M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.

첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다.
둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수이다.

합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.

첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.
*/
    public static void testNo2798(int N, int M, int[] _cardList){
        System.out.println("testNo2798 operating..");

        if(N < 3|| N > 100)
            return;
        if(M < 10 || M > 300000)
            return;

        for(int i = 0; i < N; i++)
            if(i > 100000)
                return;

        int[] cardList = selectionSort(_cardList);
        int[] selectedCardList = {cardList[N-3],cardList[N-2],cardList[N-1]};
        int maxReturnValue = sumList(selectedCardList);

        while(maxReturnValue > M){
            for(int i = 0; i < N-3; i++) {

            }
        }

        System.out.println(maxReturnValue);
        System.out.println();
    }

    public static int sumList (int[] pnList){
        int returnValue = 0;
        for(int i : pnList)
            returnValue += i;

        return returnValue;
    }

// 2750번 문제 : 수 정렬하기
// 1. 선택 정렬(Selection Sort)
    public static int[] selectionSort(int[] _nArray){
        int[] nArray = _nArray;
        int arrayLength = nArray.length;
        for(int i = 0; i < (arrayLength - 1); i++)
            for(int j = i +1; j < arrayLength; j++){
                if(nArray[i] > nArray[j]){
                    int temporary = nArray[j];
                    nArray[j] = nArray[i];
                    nArray[i] = temporary;
                }
            }

        return nArray;
    }
}
