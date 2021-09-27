import java.util.Random;
import java.util.Scanner;


public class Main {

    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome to shooting test");
        System.out.println("how many soldiers have you got?");
        int number = scanner.nextInt();
        Soldier[] soldiers = creationSoldiers(number);
        boolean repeat = true;
        int testNumber = 1;
        while (repeat) {
            System.out.println("Shooting test [" + testNumber + "]");
            System.out.println("-------------------------------------------------------");
            for (Soldier s : soldiers) {
                int[] scores = new int[4];
                for (int i = 0; i < 4; i++) {
                    int sc = new Random().nextInt(10 - 0 + 1) + 0;
                    scores[i] = sc;
                }
                s.setScores(scores);
                System.out.println("Soldier id: [" + s.getId_soldier() + "]");
                System.out.println("============================================");
                for (int i = 0; i < s.getScores().length; i++) {
                    System.out.println("Bullet " + (i + 1) + ": [" + findScore(s.getScores(), i) + "]");

                }

                int sum = sumScore(s.getScores());
                System.out.println("Final Score : [" + sum + "]");
                System.out.println("Initial Rank : [" + s.getRank() + "]");
                int changedRank = determineRank(sum, s.getRank());
                System.out.println("Final Rank : [" + findRank(changedRank) + "]");
                System.out.println("********************************************");
            }
            float percentage = (float) ((count * 100) / number);
            System.out.println("Shooting test [" + testNumber + "] result : "
                    + percentage + " % are Corporals");
            System.out.println("----------------------------------------------------");
            if (percentage > 60.0f) {
                count = 0;
                testNumber++;
            } else {
                repeat = false;
            }
        }
    }

    public static Soldier[] creationSoldiers(int a) {
        Soldier[] soldiers = new Soldier[a];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < soldiers.length; i++) {
            System.out.println("enter id for soldier: ");
            int id = scanner.nextInt();
            System.out.println("enter rank number for soldier: ");
            System.out.println("1.Lieutenant , 2.Sergent, 3.Corporal");
            int rankVal = scanner.nextInt();
            Rank rank = findRank(rankVal);
            soldiers[i] = new Soldier(id, rank);
        }
        return soldiers;
    }

    public static int findScore(int[] a, int i) {
        for (int j = 0; j < a.length; j++) {
            return a[i];
        }
        return -1;
    }

    public static int sumScore(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    public static int determineRank(int a, Rank rank) {

        if (a < 28) {
            if (rank.getRank_val() == 3) {
                countFailure();
                return Rank.Corporal.getRank_val();

            } else {
                int f = rank.getRank_val() + 1;
                if (f == 3) {
                    countFailure();
                    return f;
                } else {
                    return f;
                }
            }
        }
        if (a >= 28) {
            if (rank.getRank_val() == 1)
                return Rank.Lieutenant.getRank_val();
            else {
                return rank.getRank_val() - 1;
            }
        }
        return -1;
    }

    public static Rank findRank(int a) {
        switch (a) {
            case 1:
                return Rank.Lieutenant;
            case 2:
                return Rank.Sergent;
            case 3:
                return Rank.Corporal;
        }
        return null;
    }

    public static int countFailure() {
        count++;
        return count;
    }
}
