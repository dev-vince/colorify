package dev.vince.colorify;

import dev.vince.colorify.ansi.AnsiCodeEnum;
import dev.vince.colorify.format.AnsiFormat;
import dev.vince.colorify.util.AnsiUtil;

public final class Bootstrap {
    public static void main(String[] args) {
        final AnsiFormat format = new AnsiFormat(AnsiCodeEnum.CYAN, AnsiCodeEnum.BOLD);
        System.out.println(format.format("Hello, World!"));
        System.out.println("\u001b[5m" +"asdasd");

        while (true) {}
    }
}
