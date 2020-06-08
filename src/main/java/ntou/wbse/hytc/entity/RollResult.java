package ntou.wbse.hytc.entity;

public class RollResult {
    private int score;

    public RollResult(){}
    public RollResult(int score){
        this.score = score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "RollResult{" +
                "score=" + score +
                '}';
    }
}
