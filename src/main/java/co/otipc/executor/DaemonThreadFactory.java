package co.otipc.executor;

import java.util.concurrent.ThreadFactory;

/**
 * Created by cuichaoguo on 16/2/27.
 */
public class DaemonThreadFactory implements ThreadFactory {

  @Override public Thread newThread(Runnable r) {
    Thread t = new Thread(r);
    t.setDaemon(true);
    return t;
  }

}
