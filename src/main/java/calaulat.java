import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Claculat {
    private int numberOfGuests;
    private List<Product> products = new ArrayList<>();

    public Claculat(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void addProducts() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите название товара или 'Завершить' для окончания: ");
            String productName = scanner.nextLine();

            if (productName.equalsIgnoreCase("завершить")) {
                break;
            } else if (productName.equalsIgnoreCase("Завершить")) {
                break;
            } else if (productName.equalsIgnoreCase("ЗАВЕРШИТЬ")) {
                break;
            } else if (productName.equalsIgnoreCase("заВЕрШиТь")) {
                break;
            }

            System.out.print("Введите стоимость товара в рублях: ");
            double productPrice = scanner.nextDouble();

            if (productPrice <= 0) {
                System.out.println("Некорректный ввод. Цена товара должна быть положительной.");
                continue;
            }

            products.add(new Product(productName, productPrice));
            System.out.println("Товар успешно добавлен!");
            scanner.nextLine();
        }
    }

    public void calculateAndDisplay() {
        double totalBill = 0;

        for (Product product : products) {
            totalBill += product.getPrice();
        }

        double amountPerPerson = totalBill / numberOfGuests;

        System.out.println("\nДобавленные товары:");
        for (Product product : products) {
            System.out.println(product.getName() + " - " + formatPrice(product.getPrice()));
        }

        System.out.println("\nОбщий счёт: " + formatPrice(totalBill));
        System.out.println("Сумма на человека: " + formatPrice(amountPerPerson));
    }
    private String formatPrice(double price) {
        double roundedPrice = Math.floor(price * 100) / 100;
        long integerPart = (long) roundedPrice;
        long lastTwoDigits = integerPart % 100;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            return roundedPrice + " рублей";
        } else if (lastTwoDigits % 10 == 1) {
            return roundedPrice + " рубль";
        } else if (lastTwoDigits % 10 >= 2 && lastTwoDigits % 10 <= 4) {
            return roundedPrice + " рубля";
        } else {
            return roundedPrice + " рублей";
        }
    }
}