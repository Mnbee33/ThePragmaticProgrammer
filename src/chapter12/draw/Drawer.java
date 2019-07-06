package chapter12.draw;

public class Drawer {
    Command findCommand(String command) {
        if (DrawCommand.exists(command)) return DrawCommand.valueOf(command);
        if (DirectionCommand.exists(command)) return DirectionCommand.valueOf(command);
        throw new IllegalArgumentException(
                String.format("入力されたコマンド[%s]は無効です。", command));
    }

    String parseCommand(String command) {
        return findCommand(command).execute();
    }
}
