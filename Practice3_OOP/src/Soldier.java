public class Soldier {
    private int id_soldier;
    private Rank rank;
    private int[] scores = new int[4];

    public Soldier() {
    }

    public Soldier(int id_soldier, Rank rank) {
        this.id_soldier = id_soldier;
        this.rank = rank;
    }

    public int getId_soldier() {
        return id_soldier;
    }

    public void setId_soldier(int id_soldier) {
        this.id_soldier = id_soldier;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }


}
