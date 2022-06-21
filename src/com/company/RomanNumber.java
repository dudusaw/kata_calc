package com.company;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

class RomanNumber {

    private final static TreeMap<Integer, String> map = new TreeMap<>();
    private final static Map<String, Integer> inverseMap;

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        inverseMap = map.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }

    public static String toRoman(int number) {
        if (number > 3999) {
            throw new RuntimeException("слишком большое число");
        }
        int l = map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number - l);
    }

    public static int toArabic(String roman) {
        if (!isRoman(roman)) {
            throw new RuntimeException("неправильный формат римского числа");
        }

        int res = 0;
        for (int i = 0; i < roman.length();) {
            if (i + 1 < roman.length()) {
                String substr = roman.substring(i, i + 2);
                if (inverseMap.containsKey(substr)) {
                    res += inverseMap.get(substr);
                    i += 2;
                    continue;
                }
            }
            res += inverseMap.get(String.valueOf(roman.charAt(i)));
            i++;
        }
        return res;
    }

    public static boolean isRoman(String val) {
        int commonCount = 0;
        for (int i = 0; i < val.length(); i++) {
            if (!inverseMap.containsKey(String.valueOf(val.charAt(i)))) {
                return false;
            }

            if (i > 0 && val.charAt(i) == val.charAt(i - 1)) {
                commonCount++;
                if (commonCount >= 3) {
                    return false;
                }
            }
        }
        return true;
    }

}