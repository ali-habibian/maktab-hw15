package org.maktab.q1;

public class Converter {
    public static int convertStringToInt(String str) throws ConverterException {

        if (str == null || str.isEmpty())
            throw new ConverterException("String must not be empty");

        int digitCount = 0;
        if (Character.isDigit(str.charAt(0)) || str.charAt(0) == '-')
            digitCount++;

        for (int i = 1; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)))
                digitCount++;
        }

        boolean allIsDigit = false;
        if (digitCount == str.length())
            allIsDigit = true;
        else
            throw new ConverterException("String contains non numerical argument");

        int parseInt = 0;
        if (allIsDigit) {
            try {
                parseInt = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                throw new ConverterException("Number must between -32767 and 32767");
            }
            if (parseInt >= -32767 && parseInt <= 32767)
                return parseInt;
            else
                throw new ConverterException("Number must between -32767 and 32767");
        }
        return 0;
    }
}
