public class TrafficLightSim {

  public static void main(String[] args){
      Controller c = new Controller();

      Thread ns = new LightThread(c, Controller.Dir.NORTH_SOUTH);
      Thread ew = new LightThread(c, Controller.Dir.EAST_WEST);

      ns.start();
      ew.start();

      /*ns.join();
      ew.join();
      is flagged as bug because the methods are synchronized
       */
  }
}
