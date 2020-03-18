package Prototype.example;


import java.util.Map;

public class Test {


    public static void main(String[] args) {
        //-----  Initial our prototype instance  ---------- 
        SymbolLoader myLoader = new SymbolLoader();
        Map<String, Graphic> mySymbols = myLoader.getSymbols();

        //-----  Draw a Line  -------------------------------
        Graphic myLine = (Graphic)(mySymbols.get("Line")).clone();
        myLine.DoSomething();

        Graphic myLine2 = (Graphic)(mySymbols.get("Note")).clone();
        myLine2.DoSomething();
    }
}