package tutorial;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {

        List<String> items = new ArrayList<>();
        items.add("Pen");
        items.add("Pencil");
        items.add("Box");
        for (String s : items) {
            if (s.indexOf("P") == 0) {
                continue;
            } else {
                System.out.print(s + " ");
            }
        }

    }
}
