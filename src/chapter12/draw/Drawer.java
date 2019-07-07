package chapter12.draw;

import java.util.Objects;
import java.util.Scanner;

public class Drawer {
    public static void main(String[] args) {
        System.out.println("★お絵かきプログラムを開始します★");
        Scanner sc = new Scanner(System.in);
        Drawer drawer = new Drawer();

        parseAndPrintCommandUntilQuit(sc, drawer);
    }

    private static void parseAndPrintCommandUntilQuit(Scanner sc, Drawer drawer) {
        boolean isOver = false;
        while (!isOver) {
            System.out.print("コマンドを入力してください：");
            String line = sc.nextLine();
            if (Objects.isNull(line) || line.isEmpty()) {
                System.out.println("コマンドが入力されていません。");
                continue;
            }
            isOver = parseAndPrintCommand(drawer, line);
        }
    }

    private static boolean parseAndPrintCommand(Drawer drawer, String line) {
        boolean isOver = false;
        String result;
        try {
            String[] input = line.split(" ");
            Command command = Command.of(input[0]);
            result = drawer.executeCommand(command, input);
            isOver = command.equals(DrawCommand.Q);
        } catch (Exception e) {
            result = e.getMessage();
        }
        System.out.println(result);
        return isOver;
    }

    String executeCommand(Command command, String[] args) {
        if (command.needsArguments()) {
            return commandWithOneArg(command, args);
        } else {
            return commandWithoutArg(command, args);
        }
    }

    String commandWithOneArg(Command command, String[] args) {
        checkArgsIsOne(args, command);
        int arg = parseInt(command, args[1]);
        return command.execute(arg);

    }

    String commandWithoutArg(Command command, String[] args) {
        checkNoArgs(command, args);
        return command.execute();
    }

    private void checkArgsIsOne(String[] args, Command command) {
        if (args.length != 2) {
            throw new IllegalArgumentException(
                    String.format("コマンド[%s]:コマンドの後にパラメータ1つを入力してください。[コマンド （半角スペース）数字]", command.toString()));
        }
    }

    private int parseInt(Command command, String s) {
        int arg;
        try {
            arg = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(String.format("コマンド[%s]:パラメータは数字で入力してください。[コマンド （半角スペース）数字]", command.toString()));
        }
        return arg;
    }

    private void checkNoArgs(Command command, String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException(
                    String.format("コマンド[%s]:このコマンドは引数を指定して実行することができません。[コマンド]", command.toString()));
        }
    }
}
