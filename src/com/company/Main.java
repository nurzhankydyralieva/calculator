package com.company;

import java.util.Scanner;

public class Main {
    public final Arabic arabic = new Arabic();

    public String calculate(String inputLine) {
        return arabic.execute(inputLine);
    }

    public static void main(String[] args) {
        System.out.println("Введите два числа \nInput:");
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        String inputLine = scanner.nextLine();
        System.out.println(main.calculate(inputLine));

    }
}
