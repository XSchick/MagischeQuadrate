/**
 * @author xschick
 * @version 1.3
 **/
public class Main {
    private static int[][] magicSquareField; //Square
    private static int siteLength; //Length of the square
    private MagicSquare theMagSquare;

    /**
     * Main method distinguishes between the different operations.
     * In the case of isMagicSquare?, the square is checked to see whether it is magical, semimagical or not magical
     *
     * @param args command-line argument
     **/
    public Main(String[] args) {
        convertToSquare(args[1]);
        theMagSquare = new MagicSquare(magicSquareField);
        switch (args[0]) {
            case "showMagicNumbers":
                //Outputs the magic numbers to the given n (args[1])
                System.out.println(MagicSquare.showMagicNumbers(Integer.parseInt(args[1])));
                break;
            case "isMagicSquare?":
                theMagSquare.setLength(siteLength);
                //Testing whether the field is a magic square, a semimagic square or not magical
                if (theMagSquare.isMagicSquare()) {
                    System.out.println("magic square");
                    break;
                }
                if (theMagSquare.isSemimagicSquare()) {
                    System.out.println("semimagic square");
                    break;
                }
                if (!(theMagSquare.isMagicSquare()) && !(theMagSquare.isSemimagicSquare())) {
                    System.out.println("not magical");
                }
                break;
            case "complement":
                theMagSquare.setLength(siteLength);
                System.out.println(theMagSquare.toString(theMagSquare.complement()));
                break;
            default:
                break;

        }
    }

    /**
     * Main method create new object of Main
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        new Main(args);
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