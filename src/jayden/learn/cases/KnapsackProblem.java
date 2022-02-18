package jayden.learn.cases;

/*
The Problem:

The first step to solving this problem is to understand the parameters involved. You will be given:
    * the total amount of weight you can carry (weightCap)
    * the weights of all of the items in an array (weights)
    * the values of all of the items in an array (values)

Your function should return the maximum value that you will be able to carry.

*/
public class KnapsackProblem {

    /*
    The Recursive Solution:

    The brute force solution to this problem is to look at every subset of the items that has a total weight less than weightCap.
    Then you simply take the maximum of those subsets, giving you the optimized subset with the highest value possible.

    You will need an additional parameter, i, that tells us where we are in the list of items.
    With each step, we will break the problem down into sub-problems, and compare them to find the maximum value.
    There are three possibilities for every call of the function:

        1. weightCap or i are zero, meaning the knapsack can hold no weight, or there are no more items to look at.
            In either case, we return 0.
        2. The weight of the item we’re looking at exceeds weightCap, in which case we just move on,
            calling the function on the next item.
        3. If neither of the above are true, that means we have to consider whether or not
            the item we are at (i) should be included in the optimal solution.

    */
    public static int recursiveSolution(int weightCap, int[] weights, int[] values, int item) {
        if (weightCap == 0 || item == 0) {
            return 0;
        } else if (weights[item - 1] > weightCap) {
            return recursiveSolution(weightCap, weights, values, item - 1);
        } else {
            return Math.max(
                    values[item - 1] + recursiveSolution(
                            weightCap - weights[item - 1],
                            weights,
                            values,
                            item - 1),
                    recursiveSolution(weightCap, weights, values, item - 1)
            );
        }
    }

    /*
    The Dynamic Programming Approach:

    The knapsack problem is suited for dynamic programming because memoization will allow us to store information
        instead of making duplicate calls.
    We will store this information in a two-dimensional array that has a row for
        every item and weightCap + 1 number of columns where each element in the 2D array (matrix) represents a sub-problem.
    The element at the bottom right will be the optimal solution.

    But what exactly do the rows and columns represent?
    The rows represent the items we have seen.
    So if we are at row 4, then we have only seen the first 4 items, meaning the others are not being considered yet.
    The columns represent how much weight the knapsack can hold.
    If we are at column 7, then we are looking at a subset of the larger problem where our knapsack has a weight capacity of 7.
    The number stored inside matrix is the maximum value we can take
        given the weight capacity and number of items we have seen for that sub-problem.
    By the time we get to the bottom right space in matrix, we have considered every possible sub-problem
        and taken the maximum possible value.

    matrix = array with length equal to number of items
    for every number of items you can carry (index):
      fill matrix[index] with an array of length weightCap + 1
      for every weight < weightCap (weight):
        if index or weight == 0:
          set element at [index][weight] to 0
        else if the weight of element at index - 1 <= weight:
          find possible values of including and excluding the item
          set element at [index][weight] to max of those values
        else:
          set element at [index][weight] to element one above
    return element at bottom right of matrix

    */
    public static int dynamicSolution(int weightCap, int[] weights, int[] values, int item) {
        //TODO: check answer again!!!
        int index, weight;
        int[][] matrix = new int[item + 1][weightCap + 1];
        for (index = 0; index <= item; index++) {
            for (weight = 0; weight <= weightCap; weight++) {
                if (index == 0 || weight == 0) {
                    matrix[index][weight] = 0;
                } else if (weights[index - 1] <= weight) {
                    matrix[index][weight] = Math.max(
                            values[index - 1] + recursiveSolution(
                                    weightCap - weights[index - 1],
                                    weights,
                                    values,
                                    index - 1),
                            recursiveSolution(weightCap, weights, values, index - 1)
                    );
                } else {
                    matrix[index][weight] = matrix[index - 1][weight];
                }
            }
        }
        return matrix[item][weightCap];
    }
}
