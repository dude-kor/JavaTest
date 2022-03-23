package SubClass;

public class CustomThread extends Thread{
    @Override
    public void run(){
        int sum = 0;
        for(int index = 0; index < 10; index ++){
            sum+= index;
            System.out.println(sum);
        }
        System.out.println(Thread.currentThread() + " Final Sum Value : "+sum);
    }

    public static void main(String args[]){
        Thread subThread1 = new CustomThread();

        // 익명 객체 생성
        Thread subThread2 = new Thread(){
            public void run(){
                int sum = 0;
                for(int index = 0; index < 10; index ++){
                    sum+= index;
                    System.out.println(sum);
                }
                System.out.println(Thread.currentThread() + " Final Sum Value : "+sum);
            }
        };

        subThread1.start();
        subThread2.start();
    }
}
