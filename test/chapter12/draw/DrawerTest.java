package chapter12.draw;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DrawerTest {
    @Test
    @DisplayName("指定したコマンドを実行する@引数あり_正しい引数")
    void testCommandCorrectArgsWithOne() {
        Drawer drawer = new Drawer();
        String[] args = {"P", "2"};
        assertEquals("2番目のペンを使います。", drawer.commandWithOneArg(Command.of("P"), args));
    }

    @Test
    @DisplayName("指定したコマンドを実行する@引数あり_引数が合わない")
    void testCommandNotOneArgs() {
        Drawer drawer = new Drawer();
        String[] args = {"P"};

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> drawer.commandWithOneArg(Command.of("P"), args));
        assertEquals("コマンド[P]:コマンドの後にパラメータ1つを入力してください。[コマンド （半角スペース）数字]", exception.getMessage());
    }

    @Test
    @DisplayName("指定したコマンドを実行する@引数あり_数字じゃない")
    void testCommandValidArgs() {
        Drawer drawer = new Drawer();
        String[] args = {"P", "A"};

        Throwable exception = assertThrows(NumberFormatException.class,
                () -> drawer.commandWithOneArg(Command.of("P"), args));
        assertEquals("コマンド[P]:パラメータは数字で入力してください。[コマンド （半角スペース）数字]", exception.getMessage());
    }

    @Test
    @DisplayName("指定したコマンドを実行する@引数あり_数字じゃない")
    void testCommandValidArgsForN() {
        Drawer drawer = new Drawer();
        String[] args = {"N", "A"};

        Throwable exception = assertThrows(NumberFormatException.class,
                () -> drawer.commandWithOneArg(Command.of("N"), args));
        assertEquals("コマンド[N]:パラメータは数字で入力してください。[コマンド （半角スペース）数字]", exception.getMessage());
    }

    @Test
    @DisplayName("指定したコマンドを実行する@引数なし")
    void testCommandCorrectArgsWithoutArg() {
        Drawer drawer = new Drawer();
        String[] args = {"D"};
        assertEquals("ペンを紙におろしました。", drawer.commandWithoutArg(Command.of("D"), args));
    }

    @Test
    @DisplayName("指定したコマンドを実行する@引数なし_引数が指定されている")
    void testCommandNotWithoutArg() {
        Drawer drawer = new Drawer();
        String[] args = {"D", "1"};
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> drawer.commandWithoutArg(Command.of("D"), args));
        assertEquals("コマンド[D]:このコマンドは引数を指定して実行することができません。[コマンド]", exception.getMessage());

    }

    @Test
    @DisplayName("指定したコマンドを実行する@引数あり")
    void testExecuteCommandWithOneArg() {
        Drawer drawer = new Drawer();
        String[] args = {"P", "2"};
        assertEquals("2番目のペンを使います。", drawer.executeCommand(Command.of("P"), args));
    }

    @Test
    @DisplayName("指定したコマンドを実行する@引数あり_エラー")
    void testExecuteCommandWithOneArgError() {
        Drawer drawer = new Drawer();
        String[] args = {"P"};
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> drawer.executeCommand(Command.of("P"), args));
        assertEquals("コマンド[P]:コマンドの後にパラメータ1つを入力してください。[コマンド （半角スペース）数字]", exception.getMessage());
    }

    @Test
    @DisplayName("指定したコマンドを実行する@引数なし")
    void testExecuteCommandWithoutArg() {
        Drawer drawer = new Drawer();
        String[] args = {"D"};
        assertEquals("ペンを紙におろしました。", drawer.executeCommand(Command.of("D"), args));
    }

}
