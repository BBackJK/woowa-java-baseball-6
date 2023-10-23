package baseball;

public enum GameCommand {

    RESTART("1"),
    END("2")
    ;

    private String command;

    GameCommand(String command) {
        this.command = command;
    }

    public boolean isReStart() {
        return "1".equals(this.command);
    }

    public boolean isEnd() {
        return "2".equals(this.command);
    }

    public String getVal() {
        return this.command;
    }
}
