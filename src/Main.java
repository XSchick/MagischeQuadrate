import java.util.Scanner;

public class Main {
    private static String testOperation = "showMagicNumbers";
    Scanner scan = new Scanner(System.in);
    private static String test = "4,9,2;3,5,7;8,1,6";
    //public int

    public static void main(String[] args) {
        switch (testOperation) {
            case "showMagicNumbers":
                String[] newArray = test.split(";");
                System.out.println(newArray.length);
                for (int i=0; i < newArray.length; i++){
                    System.out.println(newArray[i]);
                }

               //MagicSquare.showMagicNumbers((args[1]).length());
                break;
            case "isMagicSquare?":
                //MagicSquare magicSquareObj = new MagicSquare(args[])
                break;
            case "complement":

                break;
            default:
                System.out.println("Keine passenden Argumente");
                break;

        }
    }
}
