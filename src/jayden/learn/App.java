package jayden.learn;

import jayden.learn.cases.PizzaDelivery;
import jayden.learn.cases.RestaurantOrders;
import jayden.learn.ds.BinarySearch;
import jayden.learn.ds.LinkedList;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        System.out.println("\n\n\n");
        //testNthLastNode();
        //testFindMiddle();
        //testBinarySearch();
        //testQueue();
        testStack();
    }

    private static void testStack() {
        String[] pizzas = {"pepperoni", "cheese", "veggie", "meat", "hawaiian", "margherita"};
        PizzaDelivery pizzaDelivery = new PizzaDelivery();
        pizzaDelivery.assign(pizzas);
        pizzaDelivery.deliver();
    }

    private static void testQueue() {
        String[] orders = {
                "green curry", "pad thai", "gyoza", "cucumber salad",
                "pad see ew", "brown rice", "red curry", "salad rolls"
        };
        RestaurantOrders foodOrders = new RestaurantOrders();
        foodOrders.assign(orders);
    }

    private static void testBinarySearch() {
        int[] searchable = {1, 3, 5, 7, 8, 10, 12};
        int target = 3;
        System.out.printf("The index of value [%d] in the list %s is %d%n",
                target, Arrays.toString(searchable), BinarySearch.search(searchable, target)
        );
        target = 7;
        System.out.printf("The index of value [%d] in the list %s is %d%n",
                target, Arrays.toString(searchable), BinarySearch.search(searchable, target)
        );
        target = 10;
        System.out.printf("The index of value [%d] in the list %s is %d%n",
                target, Arrays.toString(searchable), BinarySearch.search(searchable, target)
        );
        target = 6;
        System.out.printf("The index of value [%d] in the list %s is %d%n",
                target, Arrays.toString(searchable), BinarySearch.search(searchable, target)
        );
    }

    private static void testFindMiddle() {
        LinkedList list = generateAscendLinkedList(7);
        list.printList();
        System.out.println("Find the middle of the list:\t" + list.findMiddle());
        list = generateAscendLinkedList(6);
        list.printList();
        System.out.println("Find the middle of the list:\t" + list.findMiddle());
        list = generateAscendLinkedList(0);
        list.printList();
        System.out.println("Find the middle of the list:\t" + list.findMiddleAlt());
        list = generateAscendLinkedList(11);
        list.printList();
        System.out.println("Find the middle of the list (alternative one):\t" + list.findMiddleAlt());
        list = generateAscendLinkedList(12);
        list.printList();
        System.out.println("Find the middle of the list (alternative one):\t" + list.findMiddleAlt());
        list = generateAscendLinkedList(0);
        list.printList();
        System.out.println("Find the middle of the list (alternative one):\t" + list.findMiddleAlt());
    }

    private static void testNthLastNode() {
        LinkedList list = generateDescendLinkedList(10);
        list.printList();
        int ind = 0;
        System.out.println("Find the last index [" + ind + "] value in the list:\t" + list.nthLastValue(ind));
        ind = 5;
        System.out.println("Find the last index [" + ind + "] value in the list:\t" + list.nthLastValue(ind));
        ind = 2;
        System.out.println("Find the last index [" + ind + "] value in the list:\t" + list.nthLastValue(ind));
        ind = 9;
        System.out.println("Find the last index [" + ind + "] value in the list:\t" + list.nthLastValue(ind));
        ind = 11;
        System.out.println("Find the last index [" + ind + "] value in the list:\t" + list.nthLastValue(ind));
    }

    private static LinkedList generateAscendLinkedList(int length) {
        LinkedList list = new LinkedList();
        for (int i = length; i >= 1; i--) {
            list.addToHead(i);
        }
        return list;
    }

    private static LinkedList generateDescendLinkedList(int length) {
        LinkedList list = new LinkedList();
        for (int i = length; i >= 1; i--) {
            list.addToTail(i);
        }
        return list;
    }
}
