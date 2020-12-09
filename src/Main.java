
public class Main {
    private static int[][] magicSquareField;
    private static int siteLegth;

    public static void main(String[] args) {
        switch (args[0]) {
            case "showMagicNumbers":
                System.out.println(MagicSquare.showMagicNumbers(Integer.parseInt(args[1]))); //Outputs the magic numbers to the given n (args[1])
                break;
            case "isMagicSquare?":
                convertToSquare(args[1]);
                MagicSquare field1 = new MagicSquare(magicSquareField, siteLegth); //New MagicSquare object
                /* Testing whether the field is a magic square, a semimagic square or not magical */
                if (field1.isMagicSquare()) {
                    System.out.println("magic square");
                }
                if (field1.isSemimagicSquare()) {
                    System.out.println("semimagic square");
                }
                /*if (!(field1.isMagicSquare()) && !(field1.isSemimagicSquare())) {
                    System.out.println("not magical");
                }*/
                break;
            case "complement":
                convertToSquare(args[1]);
                MagicSquare field2 = new MagicSquare(magicSquareField, siteLegth);
                field2.complement();
                break;
            default:
                System.out.println("Keine passenden Argumente");
                break;

        }
    }

    public static void convertToSquare(String squareLine) {
        String[] rowArray = squareLine.split(";"); //Splittung input and write it to an array
        magicSquareField = new int[rowArray.length][rowArray.length]; //Initializing new 2D Array to use it as Magic Square Field
        siteLegth = rowArray.length;
        for (int i = 0; i < rowArray.length; i++) {
            String[] columArray = rowArray[i].split(","); //Splitting another time to have the individual numbers and write it to an array
            for (int x = 0; x < rowArray.length; x++) {
                magicSquareField[i][x] = Integer.parseInt(columArray[x]); //write the whole input to the rows and colums of the 2D array
            }
        }
    }
}