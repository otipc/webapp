package co.otipc.executor;

import java.util.concurrent.*;

/**
 * Created by cuichaoguo on 16/2/27.
 */
public class ThreadService {

  /**
   * 该池共5个执行线程, 可接受的task数据不限, 等待任务的超时时间是3小时
   */
  public ExecutorService pool =
      new ThreadPoolExecutor(5, 5, 30, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(),
          new ThreadFactory() {
            public Thread newThread(Runnable r) {
              Thread s = Executors.defaultThreadFactory().newThread(r);
              s.setDaemon(true);
              return s;
            }
          });

//  public ExecutorService exec = Executors.newCachedThreadPool();

  public ExecutorService exec = Executors.newFixedThreadPool(5);


  public static void main(String[] args) {

    ThreadService service = new ThreadService();

    for (int i = 0; i < 10; i++) {

      service.exec.execute(new TestThread());

    }

    service.exec.shutdown();

  }

  public static class TestThread implements Runnable {

    private int i = 0;

    @Override public void run() {

      while (i < 30) {

        String name = Thread.currentThread().getName();
        System.out.println(name + " 第 " + i + " 次");
        try {
          Thread.sleep(100);
        } catch (Exception e) {
          e.printStackTrace();
        }
        i++;

      }

    }
  }

}
