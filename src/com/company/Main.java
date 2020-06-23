package com.company;

import java.util.Scanner;

public class Main {public static int createSecretNumber(){
    return (int) (Math.random() * ((9999 - 1000) + 1)) + 1000;
}
    public static boolean theyAreEqual(int guessedNumber, int secretNumber){
        return guessedNumber == secretNumber;
    }
    public static String compare(int guessedNumber, int secretNumber){
        if (guessedNumber > secretNumber){
            return "El numero secreto es mas pequenio!";
        } else{
            return "El numero secreto es mas grande!";
        }
    }
    public static void solve(int guessedNumber, int secretNumber, int attempts, Scanner reader){
        while (!theyAreEqual(guessedNumber, secretNumber) && guessedNumber != -1){
            attempts++;
            System.out.println(compare(guessedNumber, secretNumber));
            guessedNumber = reader.nextInt();
        }
        success(guessedNumber, secretNumber, attempts);
    }

    public static void success(int guessedNumber, int secretNumber, int attempts){
        if (theyAreEqual(guessedNumber, secretNumber)){
            attempts++;
            System.out.println("Exito!");
            System.out.println("Realizaste " + attempts + " intentos");
        }
        if (guessedNumber == -1){
            System.out.println("Fin del programa");
            System.out.println("Numero de Intentos: ");
            System.out.println(attempts);
            System.out.println("El numero secreto era: " + secretNumber);
        }
    }
    public static void main(String[] args) {

        int guessedNumber;
        int secretNumber = createSecretNumber();
        System.out.println("Intenta adivinar el siguiente numero de 4 digitos:");
        System.out.println("XXXX");
        int attempts = 0;

        Scanner reader = new Scanner(System.in);
        guessedNumber = reader.nextInt();

        solve(guessedNumber, secretNumber, attempts, reader);
    }
}
