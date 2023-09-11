package zhige;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 我们假设有10个并发访问的线程（可根据实际需要进行调整），每个线程发送100个请求。
 *
 * 在 RequestTask 类中，我们定义了并发访问的任务。在任务的 run 方法中，我们模拟了请求的处理时间，
 * 并通过调用 incrementAndGet 方法对 requestCount 计数器进行递增操作。
 *
 * 在 main 方法中，我们创建并发访问的线程，并启动它们。然后，等待指定的时间（1秒），并终止并发访问的线程。
 * 最后，我们根据计数器的值和指定的时间间隔计算QPS，并将结果打印出来。
 *
 * @author wangyongzhi
 * @date 2023/8/18
 */
public class QpsCalculator1 {

    private static final int DURATION_SECONDS = 1;
    private static final int THREAD_COUNT = 10;
    private static final int TOTAL_REQUESTS = 100;

    private static AtomicInteger requestCount = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        // 创建并发访问的线程
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new RequestTask());
        }

        // 启动并发访问的线程
        for (Thread thread : threads) {
            thread.start();
        }

        // 等待指定时间
        Thread.sleep(DURATION_SECONDS * 1000);

        // 终止并发访问的线程
        for (Thread thread : threads) {
            thread.interrupt();
        }

        // 计算QPS
        double qps = (double) requestCount.get() / DURATION_SECONDS;
        System.out.println("QPS: " + qps);
    }

    static class RequestTask implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < TOTAL_REQUESTS; i++) {
                    // 模拟请求的处理时间
                    Thread.sleep(10);

                    // 请求计数器递增
                    requestCount.incrementAndGet();
                }
            } catch (InterruptedException e) {
                // 线程被中断，结束任务
            }
        }
    }
}
