/**
 * Авторо программы - HomeWork_4, СергейЯ. Дата создания: 10.10.16.
 * Программа - Крестики-нолики в объектном стиле.
 * Плюс класс работяга
 */
import java.util.*;

class HomeWork_4{

    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public static void main(String[] args) {
        new HomeWork_4().go();
    }

    void go() {
        // Задание 1
        Hunky[] Wokers = new Hunky[5];
        Wokers[0] = new Hunky("Super Den","manager","fdsfsd@ya.ru","111-111-111",6000,30);
        Wokers[1] = new Hunky("Super Men","janitor","fdsfsd@ya.ru","333-444-555",5000,150);
        Wokers[2] = new Hunky("Puper Den","manager","fdsfsd@ya.ru","111-111-111",6000,60);
        Wokers[3] = new Hunky("Luper Den","simanter","fdsfsd@ya.ru","111-111-111",6000,55);
        Wokers[4] = new Hunky("Ruder Den","cater","fds@ya.ru","111-111-111",6000,34);
        
        for (int i = 0; i < 4; i++) 
           if (Wokers[i].age > 40) Wokers[i].show(); 
            
        // Задание 2
        TicTacToe Play_start = new TicTacToe('x', 'o', '.', 3, 3);
        Play_start.run();

    }

    // класс рабочих
    class Hunky {
        String fio, function, email, telefon;
        int money, age;

        Hunky (String fio, String function, String email, String telefon, int money, int age) {
            this.fio = fio;
            this.function = function;
            this.email = email;
            this.telefon = telefon;
            this.money = money;
            this.age = age;
        }

        void show() {
            System.out.println(fio +", должность:"+ function +", email:"+ email +", tel:"+ telefon +", ЗП:"+ money +", возраст:"+ age);
        }

    }

    // класс игры крестики-нолики
    class TicTacToe {
        char PLAYER_DOT, AI_DOT, EMPTY_DOT;
        int FIELD_SIZE, DOT_FOR_WIN;
        char[][] field;

        TicTacToe (char PLAYER_DOT, char AI_DOT, char EMPTY_DOT, int FIELD_SIZE, int DOT_FOR_WIN  ) {
            this.PLAYER_DOT = PLAYER_DOT;
            this.AI_DOT = AI_DOT;
            this.EMPTY_DOT = EMPTY_DOT;
            this.FIELD_SIZE = FIELD_SIZE;
            this.DOT_FOR_WIN = DOT_FOR_WIN;
            this.field = new char[FIELD_SIZE][FIELD_SIZE];
        }

        void run() {
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
}
