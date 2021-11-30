package org.maktab.q1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @Test
    void test_convert_null_str() {
        String str = null;
        assertThrows(ConverterException.class, () -> Converter.convertStringToInt(str));
    }

    @Test
    void test_convert_empty_str() {
        String str = "";
        assertThrows(ConverterException.class, () -> Converter.convertStringToInt(str));
    }

    @Test
    void test_convert_str_with_space() {
        String str = "11 1";
        assertThrows(ConverterException.class, () -> Converter.convertStringToInt(str));
    }

    @Test
    void test_convert_str_with_non_digit_arguments() {
        String str = "q2ss22";
        assertThrows(ConverterException.class, () -> Converter.convertStringToInt(str));
    }

    @Test
    void test_convert_str_with_bigger_than_Integer_MAX() {
        String str = "9999999999999999999";
        assertThrows(ConverterException.class, () -> Converter.convertStringToInt(str));
    }

    @Test
    void test_convert_str_with_bigger_than_32767() {
        String str = "36988";
        assertThrows(ConverterException.class, () -> Converter.convertStringToInt(str));
    }

    @Test
    void test_convert_str_with_smaller_than_Integer_MIN() {
        String str = "-9999999999999999999";
        assertThrows(ConverterException.class, () -> Converter.convertStringToInt(str));
    }

    @Test
    void test_convert_str_with_smaller_than_negative_32767() {
        String str = "-46988";
        assertThrows(ConverterException.class, () -> Converter.convertStringToInt(str));
    }

    @Test
    void test_convert_str_with_acceptable_positive_num() {
        String str = "169";
        int expectedResult = 169;
        int result = 0;
        try {
            result = Converter.convertStringToInt(str);
        } catch (ConverterException e) {
            e.printStackTrace();
        }
        assertEquals(expectedResult, result);
    }

    @Test
    void test_convert_str_with_acceptable_negative_num() {
        String str = "-169";
        int expectedResult = -169;
        int result = 0;
        try {
            result = Converter.convertStringToInt(str);
        } catch (ConverterException e) {
            e.printStackTrace();
        }
        assertEquals(expectedResult, result);
    }
}