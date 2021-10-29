package jayden.learn.cases;

import jayden.learn.ds.Stack;

public class PizzaDelivery {

    private final Stack deliveryGal;
    private final Stack pizzaHouse;

    public PizzaDelivery() {
        // 1. Instantiate deliveryGal and pizzaHouse stacks below
        this.deliveryGal = new Stack(5);
        this.pizzaHouse = new Stack();
    }

    public void assign(String[] pizzas) {
        for (String pizza : pizzas) {
            try {
                // 2. Push pizzas onto deliveryGal and print the update
                this.deliveryGal.push(pizza);
                System.out.println(pizza + " pizza added to deliveryGal stack.");
            } catch (Error e) {
                // 3. Push pizzas onto pizzaHouse and print the update
                this.pizzaHouse.push(pizza);
                System.out.println("deliveryGal left to make deliveries! " + pizza + " pizza added to pizzaHouse stack.");
            }
        }
        System.out.println("\nDELIVERIES ARE UNDERWAY...\n");
    }

    public void deliver() {
        int numPizzas = this.deliveryGal.getSize();
        for (int i = 0; i < numPizzas; i++) {
            // 4. Pop off each pizza from deliveryGal and print the update
            Object pizzaType = this.deliveryGal.pop();
            System.out.println(pizzaType + " pizza delivered!");
        }
    }
}
