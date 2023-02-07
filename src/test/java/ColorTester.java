import dev.vince.colorify.ansi.AnsiCodeEnum;
import dev.vince.colorify.format.AnsiFormat;
import dev.vince.colorify.util.AnsiUtil;

public class ColorTester {
    public static void main(String[] args){
        final AnsiFormat format = new AnsiFormat(AnsiCodeEnum.CYAN, AnsiCodeEnum.BOLD);
        final String text = format.format("Hello, World!");
        System.out.println(text);
        System.out.println(AnsiUtil.stripAnsiCodes(text));

    }
}
