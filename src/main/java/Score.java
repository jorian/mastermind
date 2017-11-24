public class Score {
    private ScorePin[] score;
    private int nPins;

    Score() {
        score = new ScorePin[4];
        nPins = 0;
    }

    public void addWhitePin() {
        if (nPins <= 3) {
            ScorePin scorePin = new ScorePin();
            scorePin.setValue(0);
            score[nPins] = scorePin;
            nPins++;
        } else
            throw new IllegalStateException("score cannot have more than four score pins");
    }
}
