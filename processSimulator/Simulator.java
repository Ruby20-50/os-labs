
import java.util.ArrayDeque;

public class Simulator {
     private ArrayDeque<Process> ready;
     private ArrayDeque<Process> blocked;
     private Process running;

     public Simulator(){
         ready = new ArrayDeque<Process>();
         blocked = new ArrayDeque<Process>();
         running = null;
     }
     private void assign(){
         if (ready.isEmpty())
             return;
         Process first = ready.pollFirst();
         first.setState(ProsessState.RUNNING);
         running = first;
        //nimmtdenerstenProzess aus ready und machtihnRUNNING.
         //Falls ready leer ist: keine Änderung.
     }
     public void resign(){
         if(running == null)
             return;
         running.setState(ProsessState.READY);
         ready.addLast(running);
         running = null;
         //verschiebt den running-Prozess nach ready und setzt ihn
         //auf READY. Danach ist running=null. Falls running==null: keine
         //Änderung.
     }
     private void block(){
         if(running == null)
             return;
         running.setState(ProsessState.BLOCKED);
         blocked.addLast(running);
         running = null;
         //verschiebt den running-Prozess nach blocked und setzt
         //ihn auf BLOCKED. Danach ist running=null. Falls running==null:
         //keine Änderung.
     }
     private void ready(){
         if(running == null)
             return;
         Process blockedP = blocked.pollFirst();
         blockedP.setState(ProsessState.READY);
         ready.addLast(blockedP);
         //): nimmt einen Prozess aus blocked und verschiebt ihn nach
         //ready (Zustand READY). Falls blocked leer ist: keine Änderung
     }
     private void initProcesses(int n){
         for(int i = 1; i <= n; i++){
             Process p = new Process(i);
             ready.addLast(p);
         }
     }
     private void printStates(){
         System.out.println("RUNNING: " + running);
         System.out.print("READU: [ ");
         for (Process p : ready) {
             System.out.print(p.toString() + " | ");
         }
         System.out.println(" ]");

         System.out.print("BLOCKED: [ ");
         for (Process p : blocked) {
             System.out.print(p.toString() + " | ");
         }
         System.out.println(" ]");

     }
     public void run(){
         for(int i = 1; i <= 50; i++){
             if( i >= 2) {
                 ready();
                 resign();
                assign();
             }
             printStates();
             System.out.println("wait for a sec");
             if(running != null)
                running.executeOneTick();
             block();

         }
         //(i) Zustand ausgeben (running, ready und blocked)
         //(ii) 1 Sekunde warten.
         //(iii) Falls running != null: executeOneTick() aufrufen.
         //(iv) Mit Wahrscheinlichkeit blockProb=0.3 blockiert der laufende Pro
         //zess (block()), dann beginnt der nächste Runde.
         //(v) Mit Wahrscheinlichkeit unblockProb=0.1 wird ein blockierter Pro
         //zess wieder bereit (ready()).
         //(vi) Falls running != null: optional noch ein executeOneTick().
         //(vii) Kontextwechsel: resign() und danach assign()
     }
}
/*
a) Was passiert, wenn ready leer ist und running==null gilt?
* the cpu keeps waiting but does nothing
b) Warum gibt es in Ihrem Modell nur einen RUNNING-Prozess?
* I guess because the model simulate one core --> one process
c) Nennen Sie zwei Gründe, warum ein Prozess in der Praxis BLOCKED werden kann
* waiting for I/O
waiting for network response
 */
