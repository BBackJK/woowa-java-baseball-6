package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallManager {
    private final BaseBallUmpire umpire;

    public BaseBallManager() {
        this.umpire = new BaseBallUmpire();
    }

    public void start() {
        this.println("숫자 야구 게임을 시작합니다.");
        this.umpire.startOrReset();
        while (true) {
            MatchResult result = this.doPlay();
            this.println(result.getMessage());
            if ( result.isNotAllStrike() ) {
                continue;
            }
            GameCommand command = this.readCommandForEnd();
            this.println(command.getVal());
            if (command.isReStart()) {
                this.start();
            }
            break;
        }
    }

    private MatchResult doPlay() {
        this.print("숫자를 입력해주세요. : ");
        String offerValue = readGameInput();
        this.println(offerValue);
        return this.umpire.doTry(offerValue);
    }

    private GameCommand readCommandForEnd() {
        this.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        this.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String command = this.readCommandInput();
        return "1".equals(command)
                ? GameCommand.RESTART
                : GameCommand.END;
    }

    private String readGameInput() {
        String input = Console.readLine();
        this.validationGameInput(input);
        return input;
    }

    private String readCommandInput() {
        String input = Console.readLine();
        this.validationCommandInput(input);
        return input;
    }

    private void validationGameInput(String x) {
        if (x == null || x.length() != 3) {
            Console.close();
            throw new IllegalArgumentException();
        }
    }

    private void validationCommandInput(String x) {
        if (!("1".equals(x) || "2".equals(x))) {
            Console.close();
            throw new IllegalArgumentException();
        }
    }

    private void print(String msg) {
        System.out.print(msg);
    }
    private void println(String msg) {
        System.out.println(msg);
    }
}
