package tutorial;

public class SwitchTest {


    public static void main(String[] args) {


        int cardVal = 18;
        switch (cardVal) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                System.out.println("Hit");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Double");
                break;
            case 15:
            case 16:
                System.out.println("Surrender");
                break;
            default:
                 System.out.println("Stand");
        }
    }
}
