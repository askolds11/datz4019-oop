package jtm.extra09;

public class CrocodileGreedy implements Crocodile {
    int moves = 1;
    int candies = 0;
    /**
     * Moves crocodile on the passed board eats candies and counts moves and
     * candies
     *
     * @param board
     */
    @Override
    public void move(Board board) {
        MoveStrategy strategy = new MoveGreedy();
        strategy.move(this, board);
    }

    /**
     * @return number of passed moves
     */
    @Override
    public int getMoves() {
        return moves;
    }

    /**
     * @return number of eaten candies
     */
    @Override
    public int getCandies() {
        return candies;
    }

    /**
     * @return type of the crocodile
     */
    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }

    void setCandies(int candies) {
        this.candies = candies;
    }

    void setMoves(int moves) {
        this.moves = moves;
    }
}
