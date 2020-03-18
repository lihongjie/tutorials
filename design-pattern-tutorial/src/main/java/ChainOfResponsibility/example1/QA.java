package ChainOfResponsibility.example1; /**
 *  A member of the chain
 *  The resposibility of ChainOfResponsibility.example1.QA is test
 */

public class QA implements Chain {
    private Chain nextChain = null;
    private String responsibility = "ChainOfResponsibility.example1.Bridge.src.example.Decorator.example.Facade.example.FlyWeight.example.Mediator.example.Observer.example.Interpreter.example.State.example.TemplateMethod.example.Strategy.example.Test";
    
    public QA() {
    }
    public void addChain(Chain c) {
        nextChain = c;
    }
    
    public Chain getChain() {
        return nextChain;
    }
    
    public void sendToChain(String mesg) {
        if(mesg.equals(responsibility)) {
            System.out.println("A ChainOfResponsibility.example1.QA  -->  ChainOfResponsibility.example1.Bridge.src.example.Decorator.example.Facade.example.FlyWeight.example.Mediator.example.Observer.example.Interpreter.example.State.example.TemplateMethod.example.Strategy.example.Test");
        } else {
            if(nextChain != null) {
                nextChain.sendToChain(mesg);
            }
        }
    }
    
}