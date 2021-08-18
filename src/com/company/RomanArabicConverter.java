package com.company;

import com.company.enums.RomanNumeral;
import com.company.exceptions.CustomException;
import com.company.exceptions.NotMathematicalOperation;

import java.util.List;

class RomanArabicConverter {

    public String[] converted(String input) {
        String[] taskArray = new String[4];
        String[] inputArray = input.split(" ");

        for (int i = 0; i < inputArray.length; i++) {
            try {
                taskArray[i] = inputArray[i];
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        }
        taskArray[3] = "false";

        try {
            int numberOne, numberTwo;
            String operation;

            if (isItInteger(taskArray[0]) && isItInteger(taskArray[2])) {
                numberOne = Integer.parseInt(taskArray[0]);
                operation = taskArray[1];
                numberTwo = Integer.parseInt(taskArray[2]);
            } else {
                numberOne = romanToArabic(taskArray[0]);
                operation = taskArray[1];
                numberTwo = romanToArabic(taskArray[2]);
                taskArray[3] = "true";
            }
            if (numberOne > 10 || numberTwo > 10 || numberOne < 1 || numberTwo < 1) {
                throw new CustomException("Ошибка! Число больше, чем 'X' или меньше '0'");
            }
            taskArray[0] = Integer.toString(numberOne);
            taskArray[1] = operation;
            taskArray[2] = Integer.toString(numberTwo);
            return taskArray;

        } catch (CustomException e) {
            throw new CustomException("Ошибка! Число больше, чем 'X' или меньше '0'");

        }
    }

    private boolean isItInteger(String number) {
        try {
            int i = Integer.parseInt(number);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    public int romanToArabic(String input) {

        String romanNumeral = input.toUpperCase();
        int result = 0;

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }
        if (romanNumeral.length() > 0) {
            throw new NotMathematicalOperation(input + " Используются одновременно разные систесы счисления");
        }

        return result;
    }
}