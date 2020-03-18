package Prototype.example;

/*
 *  A Symbol Loader to register all prototype instance
 */

import java.util.*;

public class SymbolLoader {

    private Map<String, Graphic> symbols = new HashMap<>();

    public SymbolLoader() {
        symbols.put("Line", new LineSymbol());
        symbols.put("Note", new NoteSymbol());
    }

    public Map<String, Graphic> getSymbols() {
        return symbols;
    }
}