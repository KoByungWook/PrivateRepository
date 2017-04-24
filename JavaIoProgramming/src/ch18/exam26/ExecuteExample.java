package ch18.exam26;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteExample {
    public static void main(String[] args) throws IOException {
         //스레드 풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        
        for(int i=0; i<10000; i++) {
            //작업 생성 코드
            Runnable task = () -> {
                System.out.println(Thread.currentThread().getName() + "작업 처리");
            };
            //작업 큐에 넣기
            executorService.submit(task);
        }
        
//스레드 풀 종료
        executorService.shutdown();
    }
      
}
