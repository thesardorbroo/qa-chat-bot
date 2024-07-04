package uz.sardorbroo.qa.utils;

import org.apache.commons.lang3.StringUtils;

public class StringMaskUtils {
    private static final String ABB_MASK = "****";
    private static final Integer DEFAULT_MAX_WIDTH = 4;

    public static String mask(String source) {
        return mask(source, DEFAULT_MAX_WIDTH);
    }

    public static String mask(String source, int maxWidth) {

        if (StringUtils.isBlank(source)) {
            throw new IllegalArgumentException("Invalid argument is passed! Source must not be blank!");
        }

        return StringUtils.abbreviate(source, ABB_MASK, maxWidth);
    }
}
