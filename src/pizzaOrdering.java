import java.util.ArrayList;
import java.util.Scanner;



class Receipt {
    String customerName;
    String pizzaSize;
    int numberOfPizzas;
    ArrayList<ArrayList<String>> pizzas;
    double totalPrice;
    public Receipt(String customerName, String pizzaSize, int numberOfPizzas, ArrayList<ArrayList<String>> pizzas, double totalPrice){
        this.customerName = customerName;
        this.pizzaSize = pizzaSize;
        this.numberOfPizzas = numberOfPizzas;
        this.pizzas = pizzas;
        this.totalPrice = totalPrice;
    }

    public void print() {
        System.out.println("\nOrder Summary for " + customerName + ":");
        System.out.println("Pizza Size: " + pizzaSize);
        System.out.println("Number of Pizzas: " + numberOfPizzas);

        for (int i = 0; i < numberOfPizzas; i++) {
            System.out.println("Pizza " + (i + 1) + " Toppings: " + pizzas.get(i));
        }
        System.out.println("Total Cost: $" + totalPrice);

        System.out.println("\nThank you for ordering with us! Your pizza will be on its way.");
    }
}
public class pizzaOrdering {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Pizza Ordering App!");
        System.out.println("Available toppings: Pepperoni, Mushrooms, Olives, Cheese");

        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter the pizza size (Small, Medium, Large): ");
        String pizzaSize = scanner.nextLine();
        if (pizzaSize.equals("Small") || pizzaSize.equals("Medium") || pizzaSize.equals("Large") || pizzaSize.equals("small") || pizzaSize.equals("medium") || pizzaSize.equals("large")) {

            System.out.print("Enter the number of pizzas you want to order: ");
            int numberOfPizzas = scanner.nextInt();

            ArrayList<ArrayList<String>> pizzas = new ArrayList<>();

            for (int i = 0; i < numberOfPizzas; i++) {
                ArrayList<String> toppings = new ArrayList<>();
                scanner.nextLine(); // Consume the newline character

                System.out.println("Select toppings for Pizza " + (i + 1) + ":");
                System.out.println("1. Pepperoni");
                System.out.println("2. Mushrooms");
                System.out.println("3. Olives");
                System.out.println("4. Cheese");

                System.out.println("Enter 0 when done selecting toppings.");

                int toppingChoice;
                do {
                    System.out.print("Select topping (enter 0 to finish): ");
                    toppingChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (toppingChoice) {
                        case 1:
                            toppings.add("Pepperoni");
                            break;
                        case 2:
                            toppings.add("Mushrooms");
                            break;
                        case 3:
                            toppings.add("Olives");
                            break;
                        case 4:
                            toppings.add("Cheese");
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Invalid topping choice. Please select again.");
                    }

                } while (toppingChoice != 0);

                pizzas.add(toppings);
            }

            double totalPrice = calculateTotalPrice(pizzaSize, numberOfPizzas);
            Receipt thing = new Receipt(customerName, pizzaSize, numberOfPizzas, pizzas, totalPrice);
            thing.print();

            scanner.close();
        }
        else{
            System.out.println("Input Invalid. Exiting Program.");
        }
    }


    private static double calculateTotalPrice(String size, int quantity) {
        double basePrice;

        switch (size.toLowerCase()) {
            case "small":
                basePrice = 8.99;
                break;
            case "medium":
                basePrice = 12.99;
                break;
            case "large":
                basePrice = 16.99;
                break;
            default:
                basePrice = 0.0;
        }

        return basePrice * quantity;
    }
}