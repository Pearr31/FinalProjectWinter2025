package org.example.foodsystem.DiscountManager;

import java.util.HashSet;
import java.util.Set;

public class DiscountManager {
    private static Set<String> validCodes = new HashSet<>();

    /**
     * adds discount code
     * @param code set discount code
     */
    public static void addCode(String code) {
        validCodes.add(code);
    }

    /**
     * checks if discount code is valid
     *
     * @param code inputted code
     * @return true if valid, false if not
     */
    public static boolean isValidCode(String code) {
        return code != null && validCodes.contains(code);
    }

}
