/**
 * @author xschick
 * @version 1.3
 **/

public class MagicSquare {
    /**
     * declaration of the 2d array which contains the magic square
     **/
    int[][] magicField;
    /**
     * edge length of the magic square
     **/
    int squareLength;

    /**
     * Constructor initializes:
     * 1. the magicField array, which contains the square of numbers.
     * 2. the length of the square.
     *
     * @param l edge length of the magic square
     * @param square magic square array
     **/
    public MagicSquare(int[][] square, int l) {
        this.squareLength = l;
        this.magicField = square;
    }

    /**
     * This method returns a Boolean value. This is true if the square is a magic square and false if not.
     *
     * @return true if the given square is magic, false if not
     **/
    public boolean isMagicSquare() {
        return testingRowsAndColumnSums() && testingDiaSums();
    }

    /**
     * This method returns a boolean value. This is true if the square is a semi-magic square and false if not.
     *
     * @return true if square is magic square, false if not
     */
    public boolean isSemimagicSquare() {
        return testingRowsAndColumnSums();
    }

    /**
     * Testing if all sums of rows and columns are equal to the magic number
     *
     * @return true if all sums are equal to magic number, false if not
     */
    public boolean testingRowsAndColumnSums() {
        for (int i = 0; i < this.squareLength; i++) {
            int sumRow = 0;
            int sumCol = 0;
            for (int x = 0; x < this.squareLength; x++) {
                sumRow = sumRow + this.magicField[i][x]; //Sum of the different rows
                sumCol = sumCol + this.magicField[x][i]; //Sum of the different columns
            }
            /* Is the sum of the rows and columns equal to the magic number? */
            if (!(this.calcMagicNumber() == sumRow && this.calcMagicNumber() == sumCol)) {
                return false;
            }

        }

        return true;

    }

    /**
     * Testing if the both diagonal sums are equal to the magic number
     *
     * @return true if they are equal, false if not
     */
    public boolean testingDiaSums() {
        return calcMagicNumber() == diagonalLeftSum() && calcMagicNumber() == diagonalRightSum();
    }

    /**
     * Sum up the numbers of the diagonal from top left to bottom right
     *
     * @return the sum of tbe left diagonal
     */
    public int diagonalLeftSum() {
        int sumDia1 = 0;
        for (int i = 0; i < this.squareLength; i++) {
            for (int x = 0; x < this.squareLength; x++) {
                if (i == x) {
                    sumDia1 = sumDia1 + magicField[i][x]; //Sum the diagonal from top left to bottom right
                }

            }
        }
        return sumDia1;
    }

    /**
     * Sum up the numbers of the diagonal from top right to bottom left
     *
     * @return the sum of tbe right diagonal
     */
    public int diagonalRightSum() {
        int sumDia2 = 0;
        for (int i = 0; i < this.squareLength; i++) {
            for (int x = 0; x < this.squareLength; x++) {
                if (i == x) {
                    //Sum the diagonal from top right to bottom left
                    sumDia2 = sumDia2 + magicField[x][squareLength - x - 1];
                }

            }
        }
        return sumDia2;
    }

    /**
     * Calculating the magic number with the given formula. Using n is equal to square length
     *
     * @return the magic number for n
     **/
    public int calcMagicNumber() {
        return ((squareLength * squareLength * squareLength) + squareLength) / 2;
    }

    /**
     * This method calculates all magic numbers up to the entered edge length k.
     * All the results are saved in a specially generated array.
     * When all magic numbers are calculated this array is converted to a String variable (output) for return
     *
     * @param k the maximum n
     * @return String which contains all magic numbers to n=k
     **/
    static String showMagicNumbers(int k) {
        int[] magicNumbers = new int[k];
        String output = "";
        int p = 0;
        for (int i = 0; i < k; i++) {
            p = p + 1;
            magicNumbers[i] = ((p * p * p) + p) / 2; //Calculate the magic number and store it in the array
        }
        for (int magicNumber : magicNumbers) {
            output = output + Integer.toString(magicNumber) + ",";
        }

        return output.substring(0, output.length() - 1);
    }

    /**
     * This method takes every value in out the square and apply
     * the given formula (value * (-1) + n*n+1) to complement the square
     * The complemented square is written to a new array
     **/
    public void complement() {
        //Creating an Array for the complemented Square
        int[][] compArray = new int[magicField.length][magicField.length];
        for (int i = 0; i < magicField.length; i++) {
            for (int x = 0; x < magicField.length; x++) {
                //Take a value and apply the formula to complement the value then write it in a new array
                compArray[i][x] = (magicField[i][x]) * (-1) + (magicField.length * magicField.length + 1);
            }
        }
        System.out.println(toString(compArray)); //Print the complemented square
    }

    /**
     * This method cuts a 2D Array in the right shape and
     * returns a String in a square shape without comma and square brackets
     *
     * @param compArray the complemented array created from complement()
     * @return String in shape of a square
     **/
    public String toString(int[][] compArray) {
        //String stringCompArray = null; //Initializing variable to cut the rows
        //String output = ""; //Initializing final return variable
        String compArrayAsString = "";
        for (int[] ints : compArray) {
            for (int x = 0; x < compArray.length; x++) {
                compArrayAsString = compArrayAsString + Integer.toString(ints[x]) + " ";
            }
            compArrayAsString = compArrayAsString + "\n";
        }

        return compArrayAsString;
    }

}
