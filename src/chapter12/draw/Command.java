package chapter12.draw;

public interface Command {

    static Command of(String command) {
        if (DrawCommand.exists(command)) return DrawCommand.valueOf(command);
        if (DirectionCommand.exists(command)) return DirectionCommand.valueOf(command);
        throw new IllegalArgumentException(
                String.format("入力されたコマンド[%s]は無効です。", command));
    }

    boolean needsArguments();

    String execute();

    String execute(int i);

    default IllegalArgumentException forbidExecutingWithArgs(String command) {
        return new IllegalArgumentException(
                String.format("コマンド[%s]:このコマンドは引数を指定して実行することができません。", command));
    }
}
