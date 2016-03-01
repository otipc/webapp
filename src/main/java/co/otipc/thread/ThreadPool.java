package co.otipc.thread;

import java.util.concurrent.*;

/**
 * Created by cuichaoguo on 16/2/29.
 */
public class ThreadPool {

  private ExecutorService pool= Executors.newScheduledThreadPool(5);

  /**
   * 该池共5个执行线程, 可接受的task数据不限, 等待任务的超时时间是3小时
   */
  private ExecutorService workersPool =
      new ThreadPoolExecutor(5, 5, 30, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(),
          new ThreadFactory() {
            public Thread newThread(Runnable r) {
              Thread s = Executors.defaultThreadFactory().newThread(r);
              s.setDaemon(true);
              return s;
            }
          });

  public static void main(String[] args){

  }

}
