/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class RandomTheFuck {

    /**
     * @param args the command line arguments
     */
    private static BigInteger RandomBigInteger(int n, Random rnd) {
        BigInteger r;
        r = new BigInteger(n, rnd);

        return r;
    }

    public static void main(String[] args) {

        System.out.print("Enter ids: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
//        String input = "a b c d e";
        String[] str = input.split("\\s+");
        System.out.println(Arrays.toString(str));

        if (str.length <= 1) {
            System.out.println("input less than 2 id, can not generate random result");
        } else {

            long currentMem1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            Random random1 = new Random(System.currentTimeMillis() ^ currentMem1);

            int n;
            do {
                n = random1.nextInt();
            } while (n <= 0);

            long currentMem2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            Random random2 = new Random(System.currentTimeMillis() ^ currentMem2);

            BigInteger x = RandomBigInteger(n, random2);

            BigInteger result = x.mod(new BigInteger(String.valueOf(str.length - 1)));
            Integer re = new Integer(result.toString());
            System.out.println(re + ": " + str[re]);

        }
    }

}
