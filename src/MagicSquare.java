import java.util.Arrays;

public class MagicSquare {
    int[][] magicField;

    public MagicSquare(int[][] square) {
        this.magicField = square;
    }

    public boolean isMagicSquare() {
        boolean a = false;
        return a;
    }

    public boolean isSemimagicSquare() {
        boolean b = false;
        return b;
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
