package com.company;

import com.company.enums.RomanNumeral;

import java.util.List;

public class Arabic {

    private final RomanArabicConverter romanArabicConverter = new RomanArabicConverter();

    public String execute(String inputLine) {
        try {
            String[] fromConvertor = romanArabicConverter.converted(inputLine);

            int numberOne = Integer.parseInt(fromConvertor[0]);
            String operation = fromConvertor[1];
            int numberTwo = Integer.parseInt(fromConvertor[2]);
            int result;

            switch (operation) {
                case "*":
                    result = numberOne * numberTwo;
                    break;
                case "/":
                    result = numberOne / numberTwo;
                    break;
                case "+":
                    result = numberOne + numberTwo;
                    break;
                case "-":
                    result = numberOne - numberTwo;
                    break;
                default:
                    throw new NumberFormatException();
            }


            if (!Boolean.parseBoolean(fromConvertor[3])) {
                System.out.println("Output:");
                return Integer.toString(result);
            } else {
                System.out.println("Output:");
                return arabicToRoman(result);
            }
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Строка не является математической операцией.");
        }
    }

    public String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " В римской системе нет отрицательных чисел");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (number > 0 && i < romanNumerals.size()) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }

}
