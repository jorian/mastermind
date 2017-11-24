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
            if (((Score) o).score[i] != null && this.score[i] != null)
                if (! (this.score[i].equals(((Score) o).score[i])) )
                    return false;
        }
        return true;
    }
}
