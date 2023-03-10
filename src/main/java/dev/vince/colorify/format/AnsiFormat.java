package dev.vince.colorify.format;

import dev.vince.colorify.ansi.AnsiCodeEnum;
import dev.vince.colorify.util.AnsiUtil;

/**
 * The AnsiFormat class is a class that allows you to format a String with ANSI color codes.
 * Each AnsiFormat has a Array of AnsiColorEnum that will be applied to the String.
 * The class also contains a method to apply the color to a String and reset the color.
 * @see AnsiCodeEnum
 * @see AnsiFormat#format(String)
 * @author dev-vince
 * @version 1.0
 * @since 1.0
 */
public final class AnsiFormat {
    private static boolean hasEnabledAnsiSupportWin = System.getProperty("os.name").contains("Windows") ? false : true;

    private final AnsiCodeEnum[] keys;

    /**
     * Initializes a new AnsiFormat with the specified AnsiColorEnums to use to format the String.
     * Will also enable Windows 10 ANSI support.
     * @since 1.0
     * @see AnsiCodeEnum
     * @param keys the AnsiColorEnums to use to format the String.
     */
    public AnsiFormat(final AnsiCodeEnum... keys) {
        this.keys = keys;
        if(!hasEnabledAnsiSupportWin) {
            AnsiUtil.enableAnsiSupportWin();
            hasEnabledAnsiSupportWin = true;
        }
    }


    /**
     * Formats the specified String with the AnsiColorEnums of the AnsiFormat.
     * @since 1.0
     * @see AnsiCodeEnum
     * @param text the String to format.
     * @return the formatted String.
     */
    public String format(final String text) {
        final StringBuilder builder = new StringBuilder();

        for(final AnsiCodeEnum key : this.keys) {
            builder.append(key.getCode());
        }

        builder.append(text);
        builder.append(AnsiCodeEnum.RESET.getCode());
        return builder.toString();
    }
    
}
