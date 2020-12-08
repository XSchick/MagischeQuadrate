import java.util.Arrays;

public class MagicSquare {
    public MagicSquare(int[][] square){

    }
    //public boolean isMagicSquare(){}
    static String showMagicNumbers(int k){
        int[] magicNumbers = new int[k];
        int p = 0;
        for (int i=0; i<k; i++){
            p =p+1;
            magicNumbers[i] = ((p*p*p)+p)/2;
        }
        String output = Arrays.toString(magicNumbers);
        output = output.substring(1, output.length()-1);
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
