package Interpreter.example;

/**
 *  The interface of our Interpreter.example.BooleanExp Interpreter
 *  Interpreter.example.BooleanExp definition is:
 *      Interpreter.example.BooleanExp ::= Interpreter.example.VariableExp | Constant | Interpreter.example.OrExp | Interpreter.example.AndExp
 *                               | Interpreter.example.NotExp | '(' Interpreter.example.BooleanExp ')'
 *      Interpreter.example.AndExp ::= Interpreter.example.BooleanExp 'and' Interpreter.example.BooleanExp
 *      Interpreter.example.OrExp ::= Interpreter.example.BooleanExp 'or' Interpreter.example.BooleanExp
 *      Interpreter.example.NotExp ::= Interpreter.example.BooleanExp 'not' Interpreter.example.BooleanExp
 *      Constant ::= 'true' | 'false'
 *      Interpreter.example.VariableExp ::= 'A' | 'B' | ... | 'Z'
 */

public interface BooleanExp {
    public abstract boolean Evaluate(Context c);
    public abstract BooleanExp Replace(String var, BooleanExp exp);
    public abstract BooleanExp Copy();
}