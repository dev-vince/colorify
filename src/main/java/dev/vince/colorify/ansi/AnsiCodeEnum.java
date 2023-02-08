package dev.vince.colorify.ansi;

import java.util.ArrayList;
import java.util.List;

/**
 * The AnsiCodeEnum class is an enum that contains all the ANSI color codes and ANSI format codes.
 * All the codes are in the form of a String and can be applied to any String.
 * The enum also contains a method to apply the code to a String and reset the code.
 *
 * @author dev-vince
 * @version 1.0
 * @since 1.0
 */
public enum AnsiCodeEnum {
    BLACK("[30m", AnsiCodeType.COLOR),
    RED("[31m", AnsiCodeType.COLOR),
    GREEN("[32m", AnsiCodeType.COLOR),
    YELLOW("[33m", AnsiCodeType.COLOR),
    BLUE("[34m", AnsiCodeType.COLOR),
    MAGENTA("[35m", AnsiCodeType.COLOR),
    CYAN("[36m", AnsiCodeType.COLOR),
    WHITE("[37m", AnsiCodeType.COLOR),
    BRIGHT_BLACK("[30;1m", AnsiCodeType.COLOR),
    BRIGHT_RED("[31;1m", AnsiCodeType.COLOR),
    BRIGHT_GREEN("[32;1m", AnsiCodeType.COLOR),
    BRIGHT_YELLOW("[33;1m", AnsiCodeType.COLOR),
    BRIGHT_BLUE("[34;1m", AnsiCodeType.COLOR),
    BRIGHT_MAGENTA("[35;1m", AnsiCodeType.COLOR),
    BRIGHT_CYAN("[36;1m", AnsiCodeType.COLOR),
    BRIGHT_WHITE("[37;1m", AnsiCodeType.COLOR),
    BACKGROUND_BLACK("[40m", AnsiCodeType.BACKGROUND),
    BACKGROUND_RED("[41m", AnsiCodeType.BACKGROUND),
    BACKGROUND_GREEN("[42m", AnsiCodeType.BACKGROUND),
    BACKGROUND_YELLOW("[43m", AnsiCodeType.BACKGROUND),
    BACKGROUND_BLUE("[44m", AnsiCodeType.BACKGROUND),
    BACKGROUND_MAGENTA("[45m", AnsiCodeType.BACKGROUND),
    BACKGROUND_CYAN("[46m", AnsiCodeType.BACKGROUND),
    BACKGROUND_WHITE("[47m", AnsiCodeType.BACKGROUND),
    BACKGROUND_BRIGHT_BLACK("[40;1m", AnsiCodeType.BACKGROUND),
    BACKGROUND_BRIGHT_RED("[41;1m", AnsiCodeType.BACKGROUND),
    BACKGROUND_BRIGHT_GREEN("[42;1m", AnsiCodeType.BACKGROUND),
    BACKGROUND_BRIGHT_YELLOW("[43;1m", AnsiCodeType.BACKGROUND),
    BACKGROUND_BRIGHT_BLUE("[44;1m", AnsiCodeType.BACKGROUND),
    BACKGROUND_BRIGHT_MAGENTA("[45;1m", AnsiCodeType.BACKGROUND),
    BACKGROUND_BRIGHT_CYAN("[46;1m", AnsiCodeType.BACKGROUND),
    BACKGROUND_BRIGHT_WHITE("[47;1m", AnsiCodeType.BACKGROUND),
    BOLD("[1m", AnsiCodeType.FORMAT),
    UNDERLINE("[4m", AnsiCodeType.FORMAT),
    REVERSED("[7m", AnsiCodeType.FORMAT),
    RESET("[0m", AnsiCodeType.FORMAT);

    private final AnsiCodeType type;
    private final String code;


    /**
     * The constructor of the enum.
     *
     * @param code The ANSI code.
     * @since 1.0
     */
    AnsiCodeEnum(final String code, final AnsiCodeType type) {
        this.code = code;
        this.type = type;
    }

    /**
     * Returns the ANSI code assigned to the enum.
     *
     * @return The ANSI code.
     * @since 1.0
     */
    public final String getCode() {
        return "\u001b" + code;
    }

    /**
     * Returns the type of the ANSI code.
     *
     * @return The type of the ANSI code.
     * @since 1.0
     */
    public final AnsiCodeType getType() {
        return type;
    }

    /**
     * Applies the ANSI code to the given String and resets the code.
     *
     * @param text The String to apply the code to.
     * @return The String with the code applied.
     * @since 1.0
     */
    public final String apply(final String text) {
        return code + text + RESET.getCode();
    }

    @Override
    public final String toString() {
        return getCode();
    }

    /**
     * Returns a list of all the ANSI codes of the given type.
     *
     * @param type The type of the ANSI codes.
     * @return A list of all the ANSI codes of the given type.
     * @since 1.0
     */
    public static final List<AnsiCodeEnum> getAnsiCodesByType(final AnsiCodeType type){
        final List<AnsiCodeEnum> list = new ArrayList<>();

        for (AnsiCodeEnum ansiCodeEnum : AnsiCodeEnum.values()) {
            if (ansiCodeEnum.getType() == type) {
                list.add(ansiCodeEnum);
            }
        }

        return list;
    }

    public enum AnsiCodeType{
        COLOR,
        FORMAT,
        BACKGROUND
    }
}
