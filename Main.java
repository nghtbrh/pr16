import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = 7, width = 7, size = 3;

        String[] settings = Utils.loadSettings();
        String player1 = settings[0];
        String player2 = settings[1];
        size = Integer.parseInt(settings[2]);
        height = size * 2 + 1;
        width = size * 2 + 1;

        while (true) {
            if (height == 7) size = 3;
            else if (height == 11) size = 5;
            else if (height == 15) size = 7;
            else if (height == 19) size = 9;

            Utils.showMainMenu();
            String inputSwitch = scanner.nextLine();

            switch (inputSwitch) {
                case "1":
                    Game.playGame(height, width, size, player1, player2);
                    break;
                case "2":
                    System.out.println("Введіть ім'я першого гравця:");
                    player1 = scanner.nextLine();
                    System.out.println("Введіть ім'я другого гравця:");
                    player2 = scanner.nextLine();
                    int newSize = Utils.getGameSize(scanner);
                    if (newSize != -1) {
                        height = newSize * 2 + 1;
                        width = newSize * 2 + 1;
                        size = newSize;
                        Utils.saveSettings(player1, player2, size);
                    }
                    break;
                case "3":
                    Utils.showStats();
                    break;
                case "4":
                    if (Utils.confirmExit(scanner)) return;
                    break;
                default:
                    System.out.println("Некоректний формат вводу");
            }
        }
    }
}
