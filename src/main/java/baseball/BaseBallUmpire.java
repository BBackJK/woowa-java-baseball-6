package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallUmpire {

    private String[] goal;

    public MatchResult doTry(String input) {
        int strikeCount = 0;
        int ballCount = 0;

        int goalCharCount = this.goal.length;
        for (int i=0; i<goalCharCount;i++) {
            String c1 = this.goal[i];
            char c2 = input.charAt(i);

            if (c1.equals(String.valueOf(c2))) {
                strikeCount++;
            } else if (input.contains(c1)) {
                ballCount++;
            }
        }

        return new MatchResult(strikeCount, ballCount);
    }

    public void startOrReset() {
        this.goal = new String[] {
                Integer.toString(Randoms.pickNumberInRange(1, 9))
                , Integer.toString(Randoms.pickNumberInRange(0, 9))
                , Integer.toString(Randoms.pickNumberInRange(0, 9))
        };
    }
}
