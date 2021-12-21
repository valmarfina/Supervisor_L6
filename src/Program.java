import java.util.Random;

public class Program implements Runnable {
  enum State {
    UNKNOWN,
    STOPPING,
    RUNNING,
    FATAL_ERROR
  }

  private final Object mutex = new Object();
  private State state;

  public Program(int milles) {
    this.state = State.UNKNOWN;
    System.out.println("Program created");
  }

  @Override
  public void run() {
    System.out.println("Program started");
    Thread daemonThread = new Thread(() ->
    {
      while (true) {
        synchronized (mutex) {
          switch (new Random().nextInt(5)) {
            case 0:
            case 1:
              state = State.RUNNING;
              break;
            case 2:
              state = State.STOPPING;
              break;
            case 3:
              state = State.UNKNOWN;
              break;
            case 4:
              state = State.FATAL_ERROR;
              break;
          }
          System.out.println("Program state: " + state);
          mutex.notify();
          try {
            mutex.wait();
          } catch (InterruptedException e) {
            break;
          }
        }
      }
    });
    daemonThread.setDaemon(true);
    daemonThread.start();

    while (!Thread.currentThread().isInterrupted()) ;
    daemonThread.interrupt();
    System.out.println("Program: program interrupted\n");
  }

  Object getMutex() {
    return mutex;
  }

  State getState() {
    return state;
  }
}
