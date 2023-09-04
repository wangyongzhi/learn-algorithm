package zhige;
import java.util.concurrent.atomic.AtomicLong;
/**
 * @author wangyongzhi
 * @date 2023/8/18
 */
public class QpsCalculator2 {

        private static final long DURATION = 1000; // 统计的时间间隔，单位为毫秒
        private static AtomicLong counter = new AtomicLong(0); // 记录请求数的原子变量
        private static long qps = 0; // QPS值

        public static void main(String[] args) throws InterruptedException {
            // 启动一个线程进行计数器的增加
            Thread counterThread = new Thread(() -> {
                while (true) {
                    counter.incrementAndGet(); // 每次执行请求时，递增计数器
                }
            });
            counterThread.start();

            // 启动一个线程计算并输出QPS值
            Thread qpsThread = new Thread(() -> {
                while (true) {
                    long count = counter.getAndSet(0); // 获取并重置计数器的值，相当于统计最近一段时间内的请求数
                    qps = count * 1000 / DURATION; // 计算QPS
                    System.out.println("Current QPS: " + qps);

                    try {
                        Thread.sleep(DURATION); // 等待指定的时间间隔
                    } catch (InterruptedException e) {
                        // 处理线程中断异常
                        e.printStackTrace();
                    }
                }
            });
            qpsThread.start();

            // 主线程等待一段时间，用于观察QPS计算的输出
            Thread.sleep(10000);

            // 停止计数器和QPS计算线程
            counterThread.interrupt();
            qpsThread.interrupt();
        }

}
