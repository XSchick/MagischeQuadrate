import java.util.Arrays;
/**
 * @author xschick
 * @version 1.3
 * **/

public class MagicSquare {
    /** declaration of the 2d array which contains the magic square **/
    int[][] magicField;
    /** edge length of the magic square**/
    int squareLength;

    /**
     * Constructor initializes:
     * 1. the magicField array, which contains the square of numbers.
     * 2. the length of the square.
     * @param l edge lenghth of the magic square
     * @param square magic square array
     **/
    public MagicSquare(int[][] square, int l) {
        this.squareLength = l;
        this.magicField = square;
    }

    /**
     * Testing wheather all rows, colums and diagonals have the same sum, called magic number.
     **/
    public boolean isMagicSquare() {
        boolean a = false;
        int sumDia1 = 0;
        int sumDia2 = 0;
        for (int i = 0; i < this.squareLength; i++) {
            int sumRow = 0;
            int sumCol = 0;
            //System.out.println("test");
            for (int x = 0; x < this.squareLength; x++) {
                sumRow = sumRow + this.magicField[i][x]; //Sum of the diffrent rows
                sumCol = sumCol + this.magicField[x][i]; //Sum of the diffrent colums
                if (x == i) {
                    sumDia1 = sumDia1 + magicField[i][x]; //Sum the diagonal from top left to bottom right
                    sumDia2 = sumDia2 + magicField[x][squareLength - x - 1]; //Sum the diagonal from top right to bottom left
                }
            }
            /* Is the sum of the rows and colums equal to the magic number? */
            if (!(this.calcMagicNumber() == sumRow && this.calcMagicNumber() == sumCol)) {
                return false;
            }

        }
        // Is the sum of the two diagonals equal to the magic number?
        if (!(this.calcMagicNumber() == sumDia1 && this.calcMagicNumber() == sumDia2)) {
            return false;
        }

        return true;
    }

    public boolean isSemimagicSquare() {
        boolean b = false;
        return b;
    }

    /**
     * Calculating the magic number with the given formula. Using n is equal to square length
     **/
    public int calcMagicNumber() {
        return ((squareLength * squareLength * squareLength) + squareLength) / 2;
    }

    /**
     * This method calculates all magic numbers up to the entered edge length k.
     * All the results are saved in a specially generated array.
     * When all magic numbers are calculated this array is converted to a String variable (output) for return
     **/
    static String showMagicNumbers(int k) {
        int[] magicNumbers = new int[k];
        int p = 0;
        for (int i = 0; i < k; i++) {
            p = p + 1;
            magicNumbers[i] = ((p * p * p) + p) / 2; //Calculate the magic number and store it in the array
        }
        String output = Arrays.toString(magicNumbers); //Convert the array to a String
        output = output.substring(1, output.length() - 1); //Cut the two square brackets
        return output;
    }

    /**
     * This method takes every value in out the square and apply the given formula (value * (-1) + n*n+1) to complement the square
     * The complemented square is written to a new array
     **/
    public void complement() {
        int[][] compArray = new int[magicField.length][magicField.length]; //Creating an Array for the complemented Square
        for (int i = 0; i < magicField.length; i++) {
            for (int x = 0; x < magicField.length; x++) {
                compArray[i][x] = (magicField[i][x]) * (-1) + (magicField.length * magicField.length + 1); //Take a value and apply the formula to complement the value then write it in a new array
            }
        }
        System.out.println(toString(compArray)); //Print the complemented square
    }

    /**
     * This method cuts a 2D Array in the right shape and returns a String without comma and square brackets
     **/

    public String toString(int compArray[][]) {
        String stringCompArray = null; //Initializing variable to cut the rows
        String output = ""; //Initializing final return varibale
        for (int y = 0; y < compArray.length; y++) {
            stringCompArray = Arrays.toString(compArray[y]); //Write row y as a String in variable stringCompArray
            stringCompArray = stringCompArray.substring(1, stringCompArray.length() - 1); //Cutting the square brackets
            stringCompArray = stringCompArray.replace(",", ""); //Cutting the comma between in the rows
            output = output + stringCompArray + "\n"; //Creating a String with the diffrent rows for the return

        }
        return output;
    }

}
