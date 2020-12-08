import java.util.Arrays;

public class MagicSquare {
    public MagicSquare(int[][] square){

    }
    //public boolean isMagicSquare(){}

    /**This method calculates all magic numbers up to the entered edge length k.
     * All the results are saved in a specially generated array.
     * When all magic numbers are calculated this array is converted to a String variable (output) for return**/
    static String showMagicNumbers(int k){
        int[] magicNumbers = new int[k];
        int p = 0;
        for (int i=0; i<k; i++){
            p =p+1;
            magicNumbers[i] = ((p*p*p)+p)/2; //Calculate the magic number and store it in the array
        }
        String output = Arrays.toString(magicNumbers); //Convert the array to a String
        output = output.substring(1, output.length()-1); //Cut the two square brackets
        return output;
    }
   /* public static double calcMagicNumber(int n){
        double sum = ((n*n*n)+1)/2;
        return sum;
    }*/
    //public boolean isSemimagicSquare(){}
    //public void complement(){}
    //public String toString(){}

}
