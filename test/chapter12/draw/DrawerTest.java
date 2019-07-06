package chapter12.draw;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DrawerTest {
    // TODO
    // コマンドの次に数字が入力されているかどうか？
    // コマンドのnullチェックは必要か？
    // 行単位でコマンド入力を読み込む
    // 読み込んだ行を半角スペースで区切る
    // 入力値なしなら再入力を促す
    // １個目のコマンドからコマンド生成
    // 引数チェック
    // エラー：引数が必要なコマンド＋引数が１つ以外/引数が数字に変換できない
    // エラー：引数が不要なコマンド＋コマンド指定あり
    // それぞれのコマンドを実行する

    @Test
    @DisplayName("指定したコマンドを実行する@引数なし")
    void testCommand() {
        Drawer drawer = new Drawer();
        assertEquals("ペンを紙におろしました。", drawer.parseCommand("D"));
    }
}
