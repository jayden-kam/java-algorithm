package jayden.learn;

import jayden.learn.cases.Factorial;
import jayden.learn.cases.PizzaDelivery;
import jayden.learn.cases.RestaurantOrders;
import jayden.learn.ds.*;

import java.util.Arrays;
import java.util.Random;

public class App {

    public static void main(String[] args) {
        //testNthLastNode();
        //testFindMiddle();
        //testBinarySearch();
        //testQueue();
        //testStack();
        //testHashMap();
        //testIterativeFactorial(10);
        //testIterativeFactorial(5);
        //testIterativeFactorial(0);
        //testRecursiveFactorial(10);
        //testRecursiveFactorial(5);
        //testRecursiveFactorial(0);
        //testRecursiveInLinkedList();
        //testTree();
        //testBinarySearchTree();
        testMinHeap();
    }

    private static void testMinHeap() {
        MinHeap minHeap = new MinHeap();
        // Populate minHeap with 10 random numbers
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println("-------------");
            int int_random = r.nextInt(40);
            System.out.println("Adding value [" + int_random + "]");
            minHeap.add(int_random);
        }
        // Display the heap after bubbling up
        System.out.println("-------------");
        System.out.println("BUBBLED UP: " + minHeap);
        for (int i = 0; i < 10; i++) {
            System.out.println("--------------");
            minHeap.pop();
            System.out.println("HEAPIFIED: " + minHeap);
        }
    }

    private static void testBinarySearchTree() {
        int rootValue = (int) (Math.random() * 100);
        System.out.println("Creating Binary Search Tree rooted at value " + rootValue + ".");
        BinarySearchTree tree = new BinarySearchTree(rootValue);
        tree.print();
        for (int i = 0; i < 10; i++) {
            int addedValue = (int) (Math.random() * 100);
            tree.insert(addedValue);
            System.out.println("Add value " + addedValue + " to Binary Search Tree.");
            tree.print();
        }
        System.out.println("Printing the inorder depth-first traversal:");
        tree.depthFirstTraversal();
        System.out.println();
    }

    private static void testTree() {
        TreeNode animals = new TreeNode("Animals");
        TreeNode reptile = new TreeNode("Reptiles");
        TreeNode mammals = new TreeNode("Mammals");
        animals.addChild(reptile);
        animals.addChild(mammals);
        reptile.addChild("Lizard");
        reptile.addChild("Snake");
        TreeNode equine = new TreeNode("Equine");
        TreeNode bovine = new TreeNode("Bovine");
        TreeNode marsupial = new TreeNode("Marsupial");
        mammals.addChild(equine);
        mammals.addChild(bovine);
        mammals.addChild(marsupial);
        equine.addChild("Horse");
        equine.addChild("Zebra");
        bovine.addChild("Husky");
        TreeNode koala = new TreeNode("Koala");
        marsupial.addChild(koala);
        koala.addChild("TEST");
        Tree animalTree = new Tree(animals);
        animals.removeChild("Husky");
        bovine.addChild("Cow");
        marsupial.addChild("Kangaroo");
        animalTree.print();
        System.out.println("Max depth is " + animalTree.maxDepth());
        int level = 1;
        System.out.println("Printing Level " + level);
        animalTree.printAt(level);
        System.out.println();
        level = 2;
        System.out.println("Printing Level " + level);
        animalTree.printAt(level);
        System.out.println();
        level = 3;
        System.out.println("Printing Level " + level);
        animalTree.printAt(level);
        System.out.println();
        level = 4;
        System.out.println("Printing Level " + level);
        animalTree.printAt(level);
        System.out.println();
        System.out.println("Printing DFS Traversal:");
        animalTree.depthFirstTraversal(animals);
        System.out.println();
        System.out.println("Printing BFS Traversal:");
        animalTree.breadthFirstTraversal();
    }

    private static void testRecursiveInLinkedList() {
        LinkedList list = generateAscendLinkedList(9);
        int number = 10;
        System.out.print(number + " " + (list.isExist(number) ? "exists" : "doesn't") + " in list ");
        list.printList();
    }

    private static void testIterativeFactorial(int number) {
        System.out.println(number + "! = " + Factorial.iterativeFactorial(number));
    }

    private static void testRecursiveFactorial(int number) {
        System.out.println(number + "! = " + Factorial.recursiveFactorial(number));
    }

    private static void testHashMap() {
        HashMap birdCensus = new HashMap(15);
        String mandarinDuck = "mandarin duck";
        birdCensus.assign(mandarinDuck, "Central Park Pond");
        String monkParakeet = "monk parakeet";
        birdCensus.assign(monkParakeet, "Brooklyn College");
        String hornedOwl = "horned owl";
        birdCensus.assign(hornedOwl, "Pelham Bay Park");
        System.out.println("The [" + mandarinDuck + "] has been found in [" + birdCensus.retrieve(mandarinDuck) + "].");
        System.out.println("The [" + monkParakeet + "] has been found in [" + birdCensus.retrieve(monkParakeet) + "].");
        System.out.println("The [" + hornedOwl + "] has been found in [" + birdCensus.retrieve(hornedOwl) + "].");
        String birdFlew = mandarinDuck;
        birdCensus.delete(birdFlew);
        System.out.println("The [" + birdFlew + "] has flown away!");
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
