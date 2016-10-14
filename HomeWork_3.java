/**
 * Авторо программы - HomeWork_3, СергейЯ. Дата создания: 10.10.16.
 * Программа - Крестики-нолики
 */
import java.util.*;

class HomeWork_3 {

    final char PLAYER_DOT = 'x';
    final char AI_DOT = 'o';
    final char EMPTY_DOT = '.';
    final int FIELD_SIZE = 5;
    final int DOT_FOR_WIN = 4;
    char[][] field = new char[FIELD_SIZE][FIELD_SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public static void main(String[] args) {
        new HomeWork_3().go();
    }

    void go() {
        initField();
        printField();
        while (true) {
            turnPlayer();
            printField();
            if (checkWin(PLAYER_DOT)) {
                System.out.println("You won!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Sorry draw...");
                break;
            }
            turnAI();
            printField();
            if (checkWin(AI_DOT)) {
                System.out.println("AI won!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Sorry draw...");
                break;
            }
        }
    }

    void turnPlayer() {
        int x, y;
        do {
            System.out.println("Enter coordinates X Y (1-"+FIELD_SIZE+"):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellEmpty(x, y));
        field[x][y] = PLAYER_DOT;
    }

    void turnAI() {
        int x, y;
        do {
            x = rand.nextInt(FIELD_SIZE);
            y = rand.nextInt(FIELD_SIZE);
        } while (!isCellEmpty(x, y));
        field[x][y] = AI_DOT;
    }

    boolean isCellEmpty(int x, int y) {
        if (x < 0 || y < 0 || x > FIELD_SIZE - 1 || y > FIELD_SIZE - 1) return false;
        if (field[x][y] == EMPTY_DOT) return true;
        return false;
    }

    boolean isFieldFull() {
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++)
                if (field[i][j] == EMPTY_DOT) return false;
        return true;
    }

    boolean checkWin(char ch) {
        // check horizontals
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0, countDot = 0; j < FIELD_SIZE; j++) {
                if (field[i][j] == ch) countDot++;
                if (countDot >= DOT_FOR_WIN) return true;
            }
        // check verticals
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0, countDot = 0; j < FIELD_SIZE; j++) {
                if (field[j][i] == ch) countDot++;
                if (countDot >= DOT_FOR_WIN) return true;
            }
        // check diag
        for (int i = 0, countDot = 0; i < FIELD_SIZE; i++) {
            if (field[i][i] == ch) countDot++;
            if (countDot >= DOT_FOR_WIN) return true;
        }
        for (int i = 0, j = FIELD_SIZE - 1, countDot = 0; i < FIELD_SIZE; i++, j--) {
            if (field[i][j] == ch) countDot++;
            if (countDot >= DOT_FOR_WIN) return true;
        }
        return false;
    }

    void initField() {
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++)
                field[i][j] = EMPTY_DOT;
    }

    void printField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++)
                System.out.print(field[i][j]);
            System.out.println();
        }
    }
}