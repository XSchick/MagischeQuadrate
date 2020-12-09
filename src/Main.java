/**
 * @author xschick
 * @version 1.3
 **/
public class Main {
    private static int[][] magicSquareField;
    private static int siteLength; //Length of the square
    private MagicSquare theMagSquare;

    /**
     * Main method distinguishes between the different operations.
     * In the case of isMagicSquare?, the square is checked to see whether it is magical, semimagical or not magical
     *
     * @param args command-line argument
     **/
    public static void main(String[] args) {
        switch (args[0]) {
            case "showMagicNumbers":
                //Outputs the magic numbers to the given n (args[1])
                System.out.println(MagicSquare.showMagicNumbers(Integer.parseInt(args[1])));
                break;
            case "isMagicSquare?":
                convertToSquare(args[1]);
                MagicSquare field1 = new MagicSquare(magicSquareField); //New MagicSquare object
                field1.setLength(siteLength);
                //Testing whether the field is a magic square, a semimagic square or not magical
                if (field1.isMagicSquare()) {
                    System.out.println("magic square");
                    break;
                }
                if (field1.isSemimagicSquare()) {
                    System.out.println("semimagic square");
                    break;
                }
                if (!(field1.isMagicSquare()) && !(field1.isSemimagicSquare())) {
                    System.out.println("not magical");
                }
                break;
            case "complement":
                convertToSquare(args[1]);
                MagicSquare field2 = new MagicSquare(magicSquareField);
                field2.setLength(siteLength);
                System.out.println(field2.toString(field2.complement()));
                break;
            default:
                System.out.println("");
                break;

        }
    }

    /**
     * This method converts a series of numbers to a 2D array
     *
     * @param squareLine the input square field from the command-line argument
     **/
    public static void convertToSquare(String squareLine) {
        String[] rowArray = squareLine.split(";"); //Splitting input and write it to an array
        //Initializing new 2D Array to use it as Magic Square Field
        magicSquareField = new int[rowArray.length][rowArray.length];
        siteLength = rowArray.length;
        for (int i = 0; i < rowArray.length; i++) {
            //Splitting another time to have the individual numbers and write it to an array
            String[] columnArray = rowArray[i].split(",");
            for (int x = 0; x < rowArray.length; x++) {
                //Write the whole input to the rows and columns of the 2D array
                magicSquareField[i][x] = Integer.parseInt(columnArray[x]);
            }
        }
    }
}