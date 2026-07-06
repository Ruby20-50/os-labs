public class Process {

    private int pid;
    private int runtime;
    private ProsessState state;
    
    public Process(int id){
        runtime = 0;
        state = ProsessState.READY;
        this.pid = id;
    }
    public void executeOneTick(){
        runtime ++;
    }
    public String toString(){

        return "Process id: " + pid + " runtime: " + runtime + " state: " + state + "." ;
    }
    public void setState(ProsessState state) {
        this.state = state;
    }

    
}
