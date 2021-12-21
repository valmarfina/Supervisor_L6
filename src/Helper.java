public class Helper {
  public static void pause(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException error) {
      error.printStackTrace();
    }
  }
}