public enum Rank {
    Lieutenant(1), Sergent(2), Corporal(3);
    private int rank_val;

    Rank(int rank_val) {
        this.rank_val = rank_val;
    }

    public int getRank_val() {
        return rank_val;
    }


}
