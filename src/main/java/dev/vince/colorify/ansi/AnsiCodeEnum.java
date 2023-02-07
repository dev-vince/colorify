package dev.vince.colorify.ansi;

/**
 * The AnsiCodeEnum class is an enum that contains all the ANSI color codes and ANSI format codes.
 * All the codes are in the form of a String and can be applied to any String.
 * The enum also contains a method to apply the code to a String and reset the code.
 * @author dev-vince
 * @version 1.0
 * @since 1.0
 */
public enum AnsiCodeEnum {
    BLACK("\u001b[30m"),
    RED("\u001b[31m"),
    GREEN("\u001b[32m"),
    YELLOW("\u001b[33m"),
    BLUE("\u001b[34m"),
    MAGENTA("\u001b[35m"),
    CYAN("\u001b[36m"),
    WHITE("\u001b[37m"),
    BRIGHT_BLACK("\u001b[30;1m"),
    BRIGHT_RED("\u001b[31;1m"),
    BRIGHT_GREEN("\u001b[32;1m"),
    BRIGHT_YELLOW("\u001b[33;1m"),
    BRIGHT_BLUE("\u001b[34;1m"),
    BRIGHT_MAGENTA("\u001b[35;1m"),
    BRIGHT_CYAN("\u001b[36;1m"),
    BRIGHT_WHITE("\u001b[37;1m"),
    BACKGROUND_BLACK("\u001b[40m"),
    BACKGROUND_RED("\u001b[41m"),
    BACKGROUND_GREEN("\u001b[42m"),
    BACKGROUND_YELLOW("\u001b[43m"),
    BACKGROUND_BLUE("\u001b[44m"),
    BACKGROUND_MAGENTA("\u001b[45m"),
    BACKGROUND_CYAN("\u001b[46m"),
    BACKGROUND_WHITE("\u001b[47m"),
    BACKGROUND_BRIGHT_BLACK("\u001b[40;1m"),
    BACKGROUND_BRIGHT_RED("\u001b[41;1m"),
    BACKGROUND_BRIGHT_GREEN("\u001b[42;1m"),
    BACKGROUND_BRIGHT_YELLOW("\u001b[43;1m"),
    BACKGROUND_BRIGHT_BLUE("\u001b[44;1m"),
    BACKGROUND_BRIGHT_MAGENTA("\u001b[45;1m"),
    BACKGROUND_BRIGHT_CYAN("\u001b[46;1m"),
    BACKGROUND_BRIGHT_WHITE("\u001b[47;1m"),
    BOLD("\u001b[1m"),
    UNDERLINE("\u001b[4m"),
    REVERSED("\u001b[7m"),
    RESET("\u001b[0m");

    private final String code;

    /**
     * The constructor of the enum.
     * @since 1.0
     * @param code The ANSI code.
     */
    AnsiCodeEnum(final String code) {
        this.code = code;
    }

    /**
     * Returns the ANSI code assigned to the enum.
     * @since 1.0
     * @return The ANSI code.
     */
    public final String getCode() {
        return code;
    }

    /**
     * Applies the ANSI code to the given String and resets the code.
     * @since 1.0
     * @param text The String to apply the code to.
     * @return The String with the code applied.
     */
    public final String apply(final String text) {
        return code + text + RESET.getCode();
    }

    @Override
    public final String toString() {
        return code;
    }
}
