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
}
