import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPeople = 0;
        while (true) {
            System.out.print("Введите количество людей в чеке: \n");
            if (scanner.hasNextInt()) {
                numOfPeople = scanner.nextInt();
                scanner.nextLine();
                if (numOfPeople <= 1) {
                    System.out.println("Количесвто людей в чеке должно быть больше 1, повторите ввод.");
                } else {
                    break;
                }
            } else {
                System.out.println("Неверный ввод, нужно целочисленное значение");
                scanner.nextLine();
            }
        }
        Claculat calculator = new Claculat(numOfPeople);
        calculator.addProducts();
        calculator.calculateAndDisplay();

        scanner.close();
    }
}

