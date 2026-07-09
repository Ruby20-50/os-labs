public class LightThread extends Thread{

    private Controller c;
    private Controller.Dir myDir;

    public LightThread(Controller c, Controller.Dir myDir){
        this.c = c;
        this.myDir = myDir;
    }
    @Override
    public void run(){
        try{
        c.waitUntilGreen(myDir);

        c.switchTo(myDir, Controller.Phase.GREEN);
        c.print();
        Thread.sleep(2000);

        c.switchTo(myDir, Controller.Phase.RED);
        c.print();
        Thread.sleep(2000);

        if(myDir == Controller.Dir.NORTH_SOUTH){
            c.setGreenDir(Controller.Dir.EAST_WEST);
        }else{
            c.setGreenDir(Controller.Dir.NORTH_SOUTH);
        }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();

        }
    }
}
