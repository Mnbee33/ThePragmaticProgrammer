package chapter12.draw;

public enum DirectionCommand implements Command {
    N(true, "北"),
    E(true, "東"),
    S(true, "西"),
    W(true, "南"),
    ;

    boolean needArguments;
    String direction;

    static boolean exists(String command) {
        try {
            valueOf(command);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    DirectionCommand(boolean needArguments, String direction) {
        this.needArguments = needArguments;
        this.direction = direction;
    }

    @Override
    public boolean needsArguments() {
        return needArguments;
    }

    @Override
    public String execute(int i) {
        return String.format("%s方向にペンを%dcm動かしました。", direction, i);
    }

    @Override
    public String execute() {
        throw new IllegalArgumentException(
                String.format("コマンド[%s]:ペンを何cm動かすか指定してください。", toString()));
    }
}
