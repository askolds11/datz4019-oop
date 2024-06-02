package jtm.extra09;

public class MoveGreedy implements MoveStrategy {
    @Override
    public void move(Crocodile crocodile, Board board) {
        int moves = 0;
        int candies = 0;
        int x = 0, y = 0;
        for (y = 0; y < board.getY(); y++) {
            for (x = 0; x < board.getX(); x++) {
                if ('●' == board.getCandy(x, y)) {
                    candies++;
                }
                board.setCandy(x, y, '◎');
                moves++;
            }
        }

        if (y % 2 == 0) {
            for (x = 0; x < board.getX() - 1; x++) {
                moves++;
            }
        }
        moves--;
        ((CrocodileGreedy) crocodile).setCandies(candies);
        ((CrocodileGreedy) crocodile).setMoves(moves);
    }
}
