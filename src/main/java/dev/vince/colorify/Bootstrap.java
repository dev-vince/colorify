package dev.vince.colorify;

import java.util.List;

import dev.vince.colorify.ansi.AnsiCodeEnum;
import dev.vince.colorify.ansi.AnsiCodeEnum.AnsiCodeType;
import dev.vince.colorify.format.AnsiFormat;

public final class Bootstrap {
    public static void main(String[] args) {
        final AnsiFormat titleFormat = new AnsiFormat(AnsiCodeEnum.BOLD);
        System.out.println(titleFormat.format(Colorify.NAME + " v" + Colorify.VERSION + " example program"));
        System.out.println();

        final List<AnsiCodeEnum> formatCodes = AnsiCodeEnum.getAnsiCodesByType(AnsiCodeType.FORMAT);
        final List<AnsiCodeEnum> colorCodes = AnsiCodeEnum.getAnsiCodesByType(AnsiCodeType.COLOR);

        colorCodes.addAll(AnsiCodeEnum.getAnsiCodesByType(AnsiCodeType.BACKGROUND));

        final int MESSAGE_SPACE = 30;

        for(AnsiCodeEnum code : colorCodes){
            final AnsiFormat colorFormat = new AnsiFormat(code);

            System.out.print(colorFormat.format(code.name()));

            for(int i = 0; i < MESSAGE_SPACE - code.name().length(); i++) {
                System.out.print(" ");
            }

            for(AnsiCodeEnum formatCode : formatCodes){
                if(formatCode != AnsiCodeEnum.RESET) {
                    final AnsiFormat formatFormat = new AnsiFormat(code, formatCode);
                    System.out.print(formatFormat.format(formatCode.name()));

                    for(int i = 0; i < MESSAGE_SPACE - formatCode.name().length(); i++) {
                        System.out.print(" ");
                    }
                }
            }
            
            System.out.print("\n");
        }
    }
}
