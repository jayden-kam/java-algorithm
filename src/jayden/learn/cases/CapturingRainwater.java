package jayden.learn.cases;

/*
The Problem:

Imagine a very heavy rainstorm over a highway with many potholes.
The rainwater will collect in the empty holes in the road, creating puddles.
Each puddle can only get as high as the road directly surrounding it.
Any excess water will just flow away from the pothole.

The capturing rainwater problem asks you to imagine that rainwater has fallen over a histogram, a chart consisting of a series of bars.
It asks you to calculate how much rainwater would get trapped in the spaces between these bars.

The Concept:

The foundation of this problem is that the amount of rainwater at any given index is the difference between
1) the shorter bar of the highest bar to the left of the index vs. the highest bar to the right and
2) the height of the bar at the given index.

waterAtIndex = Math.min(highestLeftBound, highestRightBound) - heightOfIndex;

*/
public class CapturingRainwater {

    /*
    The naive solution to the problem is to:
    1. Traverse every element in the array
    2. Find the highest left bound for the current index
    3. Find the highest right bound for the current index
    4. Take the lower of these two values
    5. Subtract the height of the current index from that lower value
    6. Add the difference to the total amount of water captured
    */
    public static int naiveSolution(int[] heights) {
        long start = System.currentTimeMillis();
        int water = 0;
        for (int index = 0; index < heights.length; index++) {
            int leftBound = heights[index], rightBound = heights[index];
            for (int i = 0; i < index; i++) {
                leftBound = Math.max(leftBound, heights[i]);
            }
            for (int i = index + 1; i < heights.length; i++) {
                rightBound = Math.max((rightBound), heights[i]);
            }
            int waterAtIndex = Math.min(leftBound, rightBound) - heights[index];
            water += waterAtIndex;
        }
        long end = System.currentTimeMillis();
        System.out.println("Time consumption: " + (end - start));
        return water;
    }

    /*
    The Optimized Solution:

    totalWater = 0
    leftPointer = 0
    rightPointer = heights.length - 1
    leftBound = 0
    rightBound = 0

    while leftPointer < rightPointer:
        if the element at leftPointer <= the element at rightPointer:
            -set leftBound to max value between leftPointer element and leftBound
            -add difference between leftBound & the element at leftPointer to totalWater
            -move leftPointer forward by one
        else:
            -set rightBound to max value between rightPointer element and rightBound
            -add difference between rightBound & the element at rightPointer to totalWater
            -move rightPointer back by one
    return totalWater
    */
    public static int efficientSolution(int[] heights) {
        long start = System.currentTimeMillis();
        int water = 0, leftPointer = 0, rightPointer = heights.length - 1, leftBound = 0, rightBound = 0;
        while (leftPointer < rightPointer) {
            if (heights[leftPointer] <= heights[rightPointer]) {
                leftBound = Math.max(leftBound, heights[leftPointer]);
                water += leftBound - heights[leftPointer];
                leftPointer++;
            } else {
                rightBound = Math.max(rightBound, heights[rightPointer]);
                water += rightBound - heights[rightPointer];
                rightPointer--;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Time consumption: " + (end - start));
        return water;
    }
}
