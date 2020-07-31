package cn.limy.test.面试;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CountTest {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger a = new AtomicInteger(0);
        int corePoolSize = 10;
        int maximumPoolSize = 20;

        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(5);
        ThreadFactory threadFactory = new NameTreadFactory();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
                workQueue, threadFactory, new ThreadPoolExecutor.DiscardOldestPolicy());
        executor.prestartAllCoreThreads(); // 预启动所有核心线程


        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j <5 ; j++) {
                        a.incrementAndGet();
                    }

                }
            });
        }

        Thread.sleep(10);
        executor.shutdown();
        System.out.println(a);

    }

    static class NameTreadFactory implements ThreadFactory {

        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
//            System.out.println(t.getName() + " has been created");
            return t;
        }
    }

}


