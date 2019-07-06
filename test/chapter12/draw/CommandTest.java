package chapter12.draw;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {
    @Test
    @DisplayName("存在するコマンドか判定する@DrawCommand")
    void testExistsDrawCommand() {
        assertTrue(DrawCommand.exists("P"));
        assertTrue(DrawCommand.exists("D"));
        assertTrue(DrawCommand.exists("U"));

        assertFalse(DrawCommand.exists("N"));
    }

    @Test
    @DisplayName("存在するコマンドか判定する@DirectionCommand")
    void testExistsDirectionCommand() {
        assertTrue(DirectionCommand.exists("N"));
        assertTrue(DirectionCommand.exists("E"));
        assertTrue(DirectionCommand.exists("W"));
        assertTrue(DirectionCommand.exists("S"));

        assertFalse(DirectionCommand.exists("P"));
    }

    @Test
    @DisplayName("入力値と一致するコマンドを検索する")
    void testFindCommand() {
        Command command = Command.of("P");
        assertEquals("P", command.toString());

        command = Command.of("N");
        assertEquals("N", command.toString());
    }

    @Test
    @DisplayName("一致するコマンドがなければエラーにする")
    void testNotFoundCommand() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> Command.of("A"));
        assertEquals("入力されたコマンド[A]は無効です。", exception.getMessage());
    }


    @Test
    @DisplayName("引数が必要なコマンドかどうか判定する")
    void testCheckArgument() {
        Command p = Command.of("P");
        assertTrue(p.needsArguments());

        Command u = Command.of("U");
        assertFalse(u.needsArguments());
    }

    @Test
    @DisplayName("Pを実行する")
    void testPcommandExecute(){
        Command p = Command.of("P");
        assertEquals("2番目のペンを使います。", p.execute(2));

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> p.execute());
        assertEquals("コマンド[P]:何番目のペンを使用するか指定してください。", exception.getMessage());
    }

    @Test
    @DisplayName("方角のコマンドを実行する")
    void testDirectionCommandExecute(){
        Command n = Command.of("N");
        assertEquals("北方向にペンを2cm動かしました。", n.execute(2));

        Command e = Command.of("E");
        assertEquals("東方向にペンを3cm動かしました。", e.execute(3));

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> n.execute());
        assertEquals("コマンド[N]:ペンを何cm動かすか指定してください。", exception.getMessage());

    }

    @Test
    @DisplayName("Uを実行する")
    void testUcommandExecute(){
        Command u = Command.of("U");
        assertEquals("ペンを紙から離しました。", u.execute());

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> u.execute(1));
        assertEquals("コマンド[U]:このコマンドは引数を指定して実行することができません。", exception.getMessage());

    }

    @Test
    @DisplayName("Dを実行する")
    void testDcommandExecute(){
        Command d = Command.of("D");
        assertEquals("ペンを紙におろしました。", d.execute());

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> d.execute(1));
        assertEquals("コマンド[D]:このコマンドは引数を指定して実行することができません。", exception.getMessage());

    }
}
