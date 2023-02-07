package dev.vince.colorify.util;

import com.sun.jna.Function;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;

import dev.vince.colorify.ansi.AnsiCodeEnum;

/**
 * The AnsiUtil class contains methods to manages Ansi codes and ANSI support on Windows.
 * @author dev-vince
 * @version 1.0
 * @since 1.0
 */
public final class AnsiUtil {
    private AnsiUtil() {}

    /**
     * Enables ANSI support on Windows. (For command prompt, specifically)
     * @since 1.0
     */
    public static void enableAnsiSupportWin() {
        final String LIB_NAME = "kernel32";
        final Function GetStdHandleFunc = Function.getFunction(LIB_NAME, "GetStdHandle");
        final WinDef.DWORD STD_OUTPUT_HANDLE = new WinDef.DWORD(-11);
        final WinNT.HANDLE hOut = (WinNT.HANDLE) GetStdHandleFunc.invoke(WinNT.HANDLE.class, new Object[]{STD_OUTPUT_HANDLE});

        final WinDef.DWORDByReference p_dwMode = new WinDef.DWORDByReference(new WinDef.DWORD(0));
        final Function GetConsoleModeFunc = Function.getFunction(LIB_NAME, "GetConsoleMode");
        GetConsoleModeFunc.invoke(WinDef.BOOL.class, new Object[]{hOut, p_dwMode});

        final int ENABLE_VIRTUAL_TERMINAL_PROCESSING = 4;
        final WinDef.DWORD dwMode = p_dwMode.getValue();
        dwMode.setValue(dwMode.intValue() | ENABLE_VIRTUAL_TERMINAL_PROCESSING);
        final Function SetConsoleModeFunc = Function.getFunction(LIB_NAME, "SetConsoleMode");
        SetConsoleModeFunc.invoke(WinDef.BOOL.class, new Object[]{hOut, dwMode});
    }

    /**
     * Removes all ANSI codes from a String.
     * @since 1.0
     * @param input The String to remove the ANSI codes from.
     * @return The String without the ANSI codes.
     */
    public static String stripAnsiCodes(final String input){
        String mutatedInput = input;
        for(AnsiCodeEnum color : AnsiCodeEnum.values()){
            mutatedInput = mutatedInput.replace(color.getCode(), "");
        }
        return mutatedInput;
    }
}