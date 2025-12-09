package com.skillnext2;
import java.util.Scanner;

public class Palindrome{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);   // taking user input
        System.out.print("Enter a string or number: ");
        String input = sc.nextLine();

        // Convert input to lowercase for case-insensitive check
        String original = input.toLowerCase();

        // Reverse the string
        String reversed = new StringBuilder(original).reverse().toString();

        // Check palindrome
        if (original.equals(reversed)) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }

        sc.close();
    }
}
