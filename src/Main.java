public class Main
{
  public static void main(String[] args)
  {
    Supervisor supervisor = new Supervisor(new Program(500));
    supervisor.start();
  }
}
