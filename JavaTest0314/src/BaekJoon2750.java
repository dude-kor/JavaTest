/*
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다.
둘째 줄부터 N개의 줄에는 수 주어진다.
이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

풀이는 Trial, 정답은 아래 경로 참조
https://st-lab.tistory.com/105
*/
import java.lang.Integer;

// ArraySort
import java.util.Arrays;

// CountingSort
import java.io.IOException;

public class BaekJoon2750 {
    public int[] Trial(int N, int[] _list){
        System.out.println("Trial processing");

        int buffer = 0;
        int[] list = _list;

        for(int repeat : list){
            for(int i = 0; i < (N - 1); i++) {
                if (list[i] > list[i + 1]) {
                    buffer = list[i + 1];
                    list[i + 1] = list[i];
                    list[i] = buffer;
                }
            }
        }

        return list;
    }

    public int[] InsertionSort(int N, int[] _list){
        System.out.println("InsertionSort processing");

        int buffer = 0;
        int[] list = _list;

        for(int i = 0; i < N-1; i++){
            for(int j = i + 1; j < N; j++){
                if(list[i] > list[j]){
                    buffer = list[j];
                    list[j] = list[i];
                    list[i] = buffer;
                }
            }
        }

        return list;
    }

    public int[] ArraySort(int N, int[] _list){
        System.out.println("ArraySort processing");

        int[] list = _list;

        Arrays.sort(list);

        return list;
    }

    public int[] SelectionSort(int N, int[] _list){
        System.out.println("SelectionSort processing");

        int[] list = _list;
        int minIndex = 0;
        int buffer = 0;

        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                if(list[minIndex] > list[j]){
                    minIndex = j;
                }
            }

            buffer = list[i];
            list[i] = list[minIndex];
            list[minIndex] = buffer;
        }

        return list;
    }

    // 조금 더 자세한 설명은 https://st-lab.tistory.com/104 참조
    public int[] CountingSort(int N, int[] _list) throws IOException {
        System.out.println("CountingSort processing");

        int[] list = _list;
        int index = 0;
        /*
            range : -1000 ~1000
            0 은 index[1000] 을 의미
        */
        boolean[] arr = new boolean[2001];

        for(int i =0; i < N; i++){
            arr[list[i] + 1000] = true;
        }

        for(int i = 0; i < 2001; i++) {
            if(arr[i]) {
                list[index] = i - 1000;
                index++;
            }
        }

        return list;
    }

    public void printList(int[] list){
        int listLength = list.length;

        System.out.print("(");

        for(int i = 0; i < listLength-1; i++){
            System.out.print(list[i]);
            System.out.print(',');
        }

        System.out.print(list[listLength-1]);
        System.out.println(")");
    }

    public void printTimeDifference(long startTime){
        float timeDifference = System.currentTimeMillis() - startTime;
        System.out.printf("소요시간: %.3f(m)\n\n",timeDifference/1000);
    }

    public static void main(String[] args){
        if(args.length == 0) return;

        int N = Integer.parseInt(args[0]);

        if(N == 0) return;

        int[] list = new int[N];

        for(int i = 0; i < N; i++)
            list[i] = Integer.parseInt(args[i + 1]);

        BaekJoon2750 bj2750 = new BaekJoon2750();

        long startTime = System.currentTimeMillis();
        int[] trial = bj2750.Trial(N, list);
        bj2750.printTimeDifference(startTime);
        bj2750.printList(trial);

        startTime = System.currentTimeMillis();
        int[] selectionSort = bj2750.SelectionSort(N,list);
        bj2750.printTimeDifference(startTime);
        bj2750.printList(selectionSort);

        startTime = System.currentTimeMillis();
        int[] InsertionSort = bj2750.InsertionSort(N,list);
        bj2750.printTimeDifference(startTime);
        bj2750.printList(InsertionSort);

        startTime = System.currentTimeMillis();
        int[] arraySort = bj2750.ArraySort(N,list);
        bj2750.printTimeDifference(startTime);
        bj2750.printList(arraySort);

        try{
            startTime = System.currentTimeMillis();
            int [] countingSort = bj2750.CountingSort(N, list);
            bj2750.printTimeDifference(startTime);
            bj2750.printList(countingSort);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}