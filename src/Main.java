import java.util.Arrays;
import java.util.Scanner;


public class Main {
    private static String testOperation = "complement";

    private static String test = "4,9,2;3,5,7;8,1,6";
    private static String testeingabe = "9";

    public static void main(String[] args) {

        String[] rowArray = test.split(";"); //Splittung input and write it to an array
        int[][] magicSquareField = new int[rowArray.length][rowArray.length]; //Initializing new 2D Array to use it as Magic Square Field
        for (int i = 0; i < rowArray.length; i++) {
            String[] columArray = rowArray[i].split(","); //Splitting another time to have the individual numbers and write it to an array
            for (int x = 0; x < rowArray.length; x++) {
                magicSquareField[i][x] = Integer.parseInt(columArray[x]); //write the whole input to the rows and colums of the 2D array
                //System.out.println(magicSquareField.length);
            }
        }

       switch (testOperation) {
            case "showMagicNumbers":
                System.out.println(MagicSquare.showMagicNumbers(Integer.parseInt(testeingabe))); //Outputs the magic numbers to the given n (args[1])
                break;
            case "isMagicSquare?":
                MagicSquare field1 = new MagicSquare(magicSquareField); //New MagicSquare object
                /* Testing whether the field is a magic square, a semimagic square or not magical */
                if (field1.isMagicSquare()) {
                    System.out.println("magic square");
                }
                if (field1.isSemimagicSquare()) {
                    System.out.println("semimagic square");
                }
                if (!(field1.isMagicSquare()) && !(field1.isSemimagicSquare())) {
                    System.out.println("not magical");
                }

                break;
            case "complement":
                MagicSquare field2 = new MagicSquare(magicSquareField);
                field2.complement();


                break;
            default:
                System.out.println("Keine passenden Argumente");
                break;

        }
    }
}
