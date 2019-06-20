/*
Jerard Dayanghirang Guevarra
CS113
June 9th,2019
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("This program will calculate prime numbers between 1 and a selected maximum number.");
        System.out.println("Please enter your desired maximum number");
        int n = in.nextInt();
        isPrime s = new isPrime();
        System.out.println("The prime numbers between 1 and " + n + " are: ");
        s.sieve(n);
        System.out.println("This program will now calculate the prime numbers which add up to even numbers");
        System.out.println("Please enter the maximum number that you would like to calculate the prime sums for");
        int i = in.nextInt();
        int[] primeNums = new int[i];
        s.goldbach(primeNums);    }
}

class isPrime {

    public int [] sieve(int n) {
        int[] primeArray = new int[n+1];
        int[] primes = new int[n + 1];

        int[] numbers = new int[n + 1];
        for (int i = 0; i < n; i++) {
            numbers[i] = i;
        }

        for (int i = 2; i * i <= n; i++) {

            if (numbers[i] != 0) {

                for (int j = i * 2; j <= n; j += i) {
                    primeArray[j] = j;
                    numbers[j] = 0;
                }
            }
        }

        for (int j = 1; j <= n; j++) {

            if (numbers[j] != 0) {
                primes[j] = j;
                System.out.println(j);
            }
        }
        return primes;
    }
    public static void goldbach(int [] num){
        int[] primes = new int[num.length + 1];
        int[]sums = new int[num.length];
        for (int i = 1;i<= num.length-1; i++){
            sums[i] = i;
        }
        isPrime s = new isPrime();
        primes = s.sieve(num.length);
        for (int i:sums) {
            if (i%2 == 0){
                for (int j : primes) {
                    if (primes[j] >= num.length || primes[j] >= i) {
                        break;
                    }
                    int k = i - j;
                    for (int l : primes) {
                        if (primes[l] == k) {
                            System.out.println(i + " is made up of the two primes " + k + " and " + j);

                        }
                    }
                }
            }
        }

    }

}
