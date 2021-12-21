public class Supervisor extends Thread {
  private final Program program;
  private Thread programThread;

  public Supervisor(Program program) {
    this.program = program;
    this.programThread = null;
  }

  @Override
  public void run() {
    if (programThread == null) {
      runProgram();
    }
   // Helper.pause(1000);
    while (!Thread.currentThread().isInterrupted()) {
      synchronized (program.getMutex()) {
        try {
         // program.getMutex().notify();
          program.getMutex().wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
          break;
        }

        System.out.println("Supervisor state: " + program.getState());
        switch (program.getState()) {
          case RUNNING:
            program.getMutex().notify();
            break;
          case UNKNOWN:
            runProgram();
            break;
          case STOPPING:
            runProgram();
            break;
          case FATAL_ERROR:
            interruptProgram();
            break;
        }
      }
    }
  }

  public void runProgram() {
    if (programThread != null) {
      programThread.interrupt();
    }
    programThread = new Thread(program);
    programThread.start();
  }

  public void interruptProgram() {
    synchronized (program.getMutex()) {
      programThread.interrupt();
      Thread.currentThread().interrupt();
      System.out.println("Supervisor is done");
    }
  }
}
