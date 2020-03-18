package Strategy.example;
/**
 *  The context user used
 */
public class Context {

    Strategy stra;

    public Context(Strategy stra) {
        this.stra = stra;
    }

    public void doMethod() {
        stra.method();
    }
}
