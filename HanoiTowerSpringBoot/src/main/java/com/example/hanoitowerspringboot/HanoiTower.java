package com.example.hanoitowerspringboot;

import java.util.List;

public class HanoiTower {
    private int diskTotal;
    private List<String> moves;


    private static int currentMove = 0;

    public HanoiTower(int diskTotal, List<String> moves) {
        this.diskTotal = diskTotal;
        this.moves = moves;
    }

    public int getTotalMoves() {
        return (int) (Math.pow(2, diskTotal) - 1);
    }

    public List<String> getMoves() {
        int disksToMoveToMiddle = diskTotal - 1;
        hanoiTower(disksToMoveToMiddle, 'A', 'B');
        currentMove++;
        moves.add("Move " + currentMove + ": disk " + diskTotal + " --> from A to C" );

        int disksToMoveFromMiddle = diskTotal - 1;
        hanoiTower(disksToMoveFromMiddle, 'B', 'C');
        currentMove = 0;
        return moves;
    }


    public void hanoiTower(int disk, char start, char end) {

        char freePeg = freePeg(start, end);
        if(disk==1){
            moves.add("Move 1: disk 1 --> from A to C" );
            return;
        }
        if (disk == 2) {
            currentMove++;
            moves.add("Move " + currentMove + ": disk " + 1 + " --> from " + start + " to " + freePeg );

            currentMove++;
            moves.add("Move " + currentMove + ": disk " + disk + " --> from " + start + " to " + end );

            currentMove++;
            moves.add("Move " + currentMove + ": disk " + 1 + " --> from " + freePeg + " to " + end );

            return;
        }

        int moveToMiddle = disk - 1;
        hanoiTower(moveToMiddle, start, freePeg);
        currentMove++;
        moves.add("Move " + currentMove + ": disk " + disk + " --> from " + start + " to " + end );

        int moveFromMiddle = disk - 1;
        hanoiTower(moveFromMiddle, freePeg, end);

    }

    //find the free peg
    public char freePeg(char start, char end) {
        if ((start == 'A' && end == 'B') || (start == 'B' && end == 'A')) {
            return 'C';
        } else if ((start == 'A' && end == 'C') || (start == 'C' && end == 'A')) {
            return 'B';
        }
        return 'A';
    }

    @Override
    public String toString() {
        return String.format("Hanoi Tower of %d has total %d moves:%n", diskTotal, getTotalMoves()) + getMoves();
    }

}
