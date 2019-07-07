package chapter12.draw;

public enum DrawCommand implements Command {
    P(true) {
        @Override
        public String execute(int i) {
            return String.format("%d番目のペンを使います。", i);
        }

        @Override
        public String execute() {
            throw new IllegalArgumentException(
                    String.format("コマンド[%s]:何番目のペンを使用するか指定してください。", toString()));
        }
    },
    U(false) {
        @Override
        public String execute(int i) {
            throw forbidExecutingWithArgs(toString());
        }

        @Override
        public String execute() {
            return "ペンを紙から離しました。";
        }
    },
    D(false) {
        @Override
        public String execute(int i) {
            throw forbidExecutingWithArgs(toString());
        }

        @Override
        public String execute() {
            return "ペンを紙におろしました。";
        }
    },
    Q(false) {
        @Override
        public String execute(int i) {
            throw forbidExecutingWithArgs(toString());
        }

        @Override
        public String execute() {
            return "お絵かきプログラムを終了します。";
        }
    },
    ;

    boolean needArguments;

    DrawCommand(boolean needArguments) {
        this.needArguments = needArguments;
    }

    static boolean exists(String command) {
        try {
            valueOf(command);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean needsArguments() {
        return needArguments;
    }
}
