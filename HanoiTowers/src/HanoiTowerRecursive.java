import java.util.Scanner;

public class HanoiTowerRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalDisks = Integer.parseInt(scanner.nextLine());

        int movesNeededForSolving = (int) (Math.pow(2, totalDisks) - 1);
        System.out.println("Total moves: " + movesNeededForSolving);

        int disksToMoveToMiddle = totalDisks - 1;
        hanoiTower(disksToMoveToMiddle, 'A', 'B');

        System.out.println("Move disk " + totalDisks + ": from A to C");

        int disksToMoveFromMiddle = totalDisks - 1;
        hanoiTower(disksToMoveFromMiddle, 'B', 'C');

    }

    public static void hanoiTower(int disk, char start, char end) {
        //start - the source peg
        //end - the destination peg
        //freePeg - the third peg, that is used as a buffer
        char freePeg = freePeg(start, end);

        if (disk == 2) {
            System.out.println("Move disk " + 1 + ": from " + start + " to " + freePeg);
            System.out.println("Move disk " + disk + ": from " + start + " to " + end);
            System.out.println("Move disk " + 1 + ": from " + freePeg + " to " + end);
            return;
        }

        int moveToMiddle = disk - 1;
        hanoiTower(moveToMiddle, start, freePeg);

        System.out.println("Move disk " + disk + ": from " + start + " to " + end);

        int moveFromMiddle = disk - 1;
        hanoiTower(moveFromMiddle, freePeg, end);
    }

    //find the free peg
    public static char freePeg(char start, char end) {
        if ((start == 'A' && end == 'B') || (start == 'B' && end == 'A')) {
            return 'C';
        } else if ((start == 'A' && end == 'C') || (start == 'C' && end == 'A')) {
            return 'B';
        }
        return 'A';
    }
}
