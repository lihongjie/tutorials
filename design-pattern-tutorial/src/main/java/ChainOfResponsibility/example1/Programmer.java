package ChainOfResponsibility.example1; /**
 *  A member of the chain
 *  The resposibility of ChainOfResponsibility.example1.Programmer is coding
 */

public class Programmer implements Chain {
    private Chain nextChain = null;
    private String responsibility = "Coding";
    
    public Programmer() {
    }
    public void addChain(Chain c) {
        nextChain = c;
    }
    
    public Chain getChain() {
        return nextChain;
    }
    
    public void sendToChain(String mesg) {
        if(mesg.equals(responsibility)) {
            System.out.println("A ChainOfResponsibility.example1.Programmer  -->  Coding");
        } else {
            if(nextChain != null) {
                nextChain.sendToChain(mesg);
            }
        }
    }
    
}
