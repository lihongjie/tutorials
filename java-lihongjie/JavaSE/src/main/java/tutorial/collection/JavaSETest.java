package tutorial.collection;

import java.util.ArrayList;
import java.util.List;

public class JavaSETest {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(10);
        int firstEle = list.get(1);
        System.out.print(firstEle);
    }
}
