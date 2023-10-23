package baseball;

public class MatchResult {

    private final int strikeCount;
    private final int ballCount;

    public MatchResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isAllStrike() {
        return this.strikeCount == 3;
    }

    public boolean isNotAllStrike() {
        return !isAllStrike();
    }

    public String getMessage() {
        if (isNothing()) {
            return "낫싱";
        }

        if (isAllStrike()) {
            return "3스트라이크";
        }

        StringBuilder sb = new StringBuilder();
        if (this.ballCount > 0) {
            sb.append(this.ballCount);
            sb.append("볼");
        }

        if (this.strikeCount > 0) {
            if (!sb.isEmpty()) sb.append(" ");
            sb.append(this.strikeCount);
            sb.append("스트라이크");
        }

        return sb.toString();
    }

    private boolean isNothing() {
        return this.strikeCount == 0 && this.ballCount == 0;
    }
}
