import java.util.Arrays;

public class MagicSquare {#
    int[][] magicField;

    public MagicSquare(int[][] square) {
        this.magicField = square;
    }

    public boolean isMagicSquare() {
        return a;
    }
    public boolean isSemimagicSquare() {
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
    //public void complement(){}
    //public String toString(){}

}
