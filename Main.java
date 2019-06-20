package sample;
/*
Jerard Dayanghirang Guevarra
CS113
June 9th,2019
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner;

        System.out.println("This program will calculate prime numbers between 1 and a selected maximum number.");
        System.out.println("Please enter your desired maximum number");
        int n = in.nextInt();
        isPrime s = new isPrime();
        System.out.println("The prime numbers between 1 and " + n + " are ");
        s.sieve(n);
        System.out.println("This program will now calculate the prime numbers which add up to even numbers");
        System.out.println("Please enter the maximum number that you would like to calculate the prime sums for");
        int i = in.nextInt();
        int[] primeNums = new int[i];
        s.goldbach(primeNums);    }
}

class isPrime {
    /*
    Implement the Sieve of Eratosthenes and use it to find all prime
    numbers less than or equal to one million. Use the result to
    prove Goldbach's Conjecture for all even integers between four and
    one million, inclusive.

    Implement a method with the following declaration:

    public static void sieve(int[] array);
    This function takes an integer array as its argument. The array
    should be initialized to the values 1 through 1000000. The
    function modifies the array so that only the prime numbers remain;
    all other values are zeroed out.
    This function must be written to accept an integer array of any
    size. You must should output for all primes numbers between 1 and
    1000000, but when I test your function it may be on an array of a
    different size.

    Implement a method with the following declaration:

    public static void goldbach(int[] array);
    This function takes the same argument as the previous method
    and displays each even integer between 4 and 1000000 with two
    prime numbers that add to it.
    The goal here is to provide an efficient implementation. This
    means no multiplication, divisioni, or modulus when determining if
    a number is prime. It also means that the second method must find
    two primes efficiently.

    Output for your program: All prime numbers between 1 and 1000000
    and all even numbers between 4 and 1000000 and the two prime
    numbers that sum up to it.

    DO NOT provide output or a session record for this project!
    */
    public static int[] primeArray = new int[1000001];
    public static int[] primes = new int[1000001];
    public static void sieve(int n) {

        int[] numbers = new int[n + 1];
        for (int i = 0; i < n; i++) {
            numbers[i] = i;
        }

        for (int i = 2; i * i <= n; i++) {
            /*
            This will test to see if the number is divisible by the integer i
            If i proves to be a multiple of j then j's value will be converted to 0
            This is to symbolize crossing out the value such as in the example from class
             */
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
    }
    public static void goldbach(int [] num){
        /*
            This function takes the same argument as the previous method
            and displays each even integer between 4 and 1000000 with two
            prime numbers that add to it.
            The goal here is to provide an efficient implementation. This
            means no multiplication, divisioni, or modulus when determining if
            a number is prime. It also means that the second method must find
            two primes efficiently.

            Output for your program: All prime numbers between 1 and 1000000
            and all even numbers between 4 and 1000000 and the two prime
            numbers that sum up to it.
         */
        int[]sums = new int[1000000];
        for (int i = 1;i<= 1000000-1; i++){
            sums[i] = i;
        }
        isPrime s = new isPrime();
        s.sieve(1000000);
        for (int i:sums) {
            if (i%2 == 0){
                for (int j : primes) {
                    if (primes[j] >= 1000000 || primes[j] >= i) {
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