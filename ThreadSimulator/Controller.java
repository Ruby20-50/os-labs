public class Controller {
    public enum Dir {
        NORTH_SOUTH,
        EAST_WEST
    }
    public enum Phase {
        RED,
        YELLOW,
        GREEN
    }

    private Dir greenDir = Dir.NORTH_SOUTH;
    private Phase ns = Phase.GREEN;
    private Phase ew = Phase.RED;

    public synchronized void waitUntilGreen(Dir d) throws InterruptedException{
            while(greenDir != d){
                wait();
            }
    }
    public synchronized void switchTo(Dir d, Phase newPhase){
        if(d == Dir.NORTH_SOUTH){
        ns = newPhase;
        }else{
            ew = newPhase;
        }
        notifyAll();
    }
    public synchronized void setGreenDir(Dir d){
        greenDir = d;
        notifyAll();
    }
    public synchronized void print(){
        System.out.println("NS: " + ns + " | EW: " + ew);
    }

}
