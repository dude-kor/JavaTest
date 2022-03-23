package ThreadPool;

import java.io.IOException;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.SynchronousQueue;

import java.util.List;

public class ThreadPool {
    /*
    // 스레드 풀 생성
    // 1. 자동으로 스레드 수 생성
    ExecutorService executorServiceWithCached = Executors.newCachedThreadPool();

    // 2. 원하는 개수만큼 생성
    ExecutorService executorServiceWithNum = Executors.newFixedThreadPool(2);

    // 3. 최대치로 생성
    ExecutorService executorServiceWithMax = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    // 4. 완전 수동
    // ThreadPoolExecutor(코어 스레드 수, 최대 스레드 개수, 활용 시간, 활용 시간 단위, 큐)
    ExecutorService getExecutorServiceWithCustom = new ThreadPoolExecutor(3,100,129L,TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
*/
/*
    // 스레드 풀 종료
    // 1. 작업 큐에 대기하고 있는 모든 작업이 끝난 뒤 스레드를 종료
    try{
        executorServiceWithCached.shutdown();
    }catch(IOException e){
        e.printStackTrace();
    }

    //  2. 즉시 중지
    //  작업 큐에 남아있는 작업의 목록을 리턴
    List<Runnable> runable = executorServiceWithCached.shutdownNow();

    // 3. 예약 중지
    // 시간 내 중지 하지 못한 작업은 false로 리턴
    try{
        boolean isFinish = executorServiceWithCached.awaitTermination(10, TimeUnit.seconds);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
*/
    public enum CreateThread{
        AUTO,SELECT,MAX,MANUEL
    }

    public static ExecutorService createThread(CreateThread _index){
        switch(_index){
            // 1. 자동으로 스레드 수 생성
            case AUTO :
                return Executors.newCachedThreadPool();
            // 2. 원하는 개수만큼 생성
            case SELECT:
                return Executors.newFixedThreadPool(2);
            // 3. 최대치로 생성
            case MAX:
                return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            // 4. 완전 수동
            // ThreadPoolExecutor(코어 스레드 수, 최대 스레드 개수, 활용 시간, 활용 시간 단위, 큐)
            case MANUEL:
                return new ThreadPoolExecutor(3,100,129L,TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
            default:
                System.out.println("Failed to create");
                return null;
        }
    }

    public static void main(String args[]){
        // 스레드 풀 생성
        ExecutorService executorService = createThread(CreateThread.AUTO);

        // Runnable 구현 객체 (익명 구현 객체 사용)
        Runnable runnableTask = ()->{
            for(int index = 0; index < 10; index++){
                System.out.println("Processing from Runnable("+index+")");
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        // Callable 구현
        Callable<Boolean> callableTask = ()->{
            Boolean isFinish = true;
            for(int index = 0; index < 10; index++){
                System.out.println("Processing from Callable("+index+")");
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }

            return isFinish;
        };

        // 1. 리턴 값이 없는 단순 Runnable를 처리합니다.
        executorService.execute(runnableTask);
    }
}
