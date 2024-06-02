package jtm.extra09;

public class MoveSimple implements MoveStrategy {
    @Override
    public void move(Crocodile crocodile, Board board) {
        int moves = 0;
        int candies = 0;
        int x = 0, y = 0;
        for (x = 0; x < board.getX() - 1; x++) {
            if ('●' == board.getCandy(x, y)) {
                candies++;
            }
            board.setCandy(x, y, '◎');
            moves++;
        }
        for (y = 0; y < board.getY(); y++) {
            if ('●' == board.getCandy(x, y)) {
                candies++;
            }
            board.setCandy(x, y, '◎');
            moves++;
        }
        moves--;
        ((CrocodileSimple) crocodile).setCandies(candies);
        ((CrocodileSimple) crocodile).setMoves(moves);
    }
}
