package ntou.wbse.hytc.entity;

public class DiceRequest {

    private int four;
    private int six;
    private int eight;
    private int ten;
    private int twelve;
    private int twenty;
    private int hundred;

    public void setFour(int four) {
        this.four = four;
    }

    public void setSix(int six) {
        this.six = six;
    }

    public void setEight(int eight) {
        this.eight = eight;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public void setTwelve(int twelve) {
        this.twelve = twelve;
    }

    public void setTwenty(int twenty) {
        this.twenty = twenty;
    }

    public void setHundred(int hundred) {
        this.hundred = hundred;
    }

    public int getFour() {
        return four;
    }

    public int getSix() {
        return six;
    }

    public int getEight() {
        return eight;
    }

    public int getTen() {
        return ten;
    }

    public int getTwelve() {
        return twelve;
    }

    public int getTwenty() {
        return twenty;
    }

    public int getHundred() {
        return hundred;
    }

    @Override
    public String toString() {
        return "DiceRequest{" +
                "four=" + four +
                ", six=" + six +
                ", eight=" + eight +
                ", ten=" + ten +
                ", twelve=" + twelve +
                ", twenty=" + twenty +
                ", hundred=" + hundred +
                '}';
    }
}
