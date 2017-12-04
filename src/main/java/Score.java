public class Score {
    private ScorePin[] score;
    private int nPins;

    Score() {
        score = new ScorePin[4];
        nPins = 0;
    }

    public void addPin(int value) {
        if (nPins <= 3) {
            ScorePin scorePin = new ScorePin();
            scorePin.setValue(value);
            score[nPins] = scorePin;
            nPins++;
        } else
            throw new IllegalStateException("score cannot have more than four score pins");
    }


    public Score winningScore() {
        for (int i = 0; i < 4; i++) {
            ScorePin scorePin = new ScorePin();
            scorePin.setValue(1);
            score[i] = scorePin;
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        assert o instanceof Score;

        for (int i = 0; i < 4; i++) {

            /*
            First check if both score pins are set (ie: not null).
            If so, check their values. If not the same, return false.
             */
            if (((Score) o).score[i] != null && this.score[i] != null) {
                if (! (this.score[i].equals(((Score) o).score[i])) )
                    return false;
            }

            /*
            If code 1 has 3 values and code 2 has 2 values, we need to make sure that
            the two codes are not equal.

            If one score pin is null but the other isn't, then the codes are not equal.
             */
            if ( (((Score) o).score[i] == null && this.score[i] != null) ||
                    (((Score) o).score[i] != null && this.score[i] == null)  )
                return false;

        }
        return true;
    }

    @Override
    public String toString() {

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (score[i] != null)
                output.append(score[i].value);
        }
        return output.toString();
    }
}
