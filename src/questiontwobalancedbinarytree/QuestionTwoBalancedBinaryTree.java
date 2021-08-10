package questiontwobalancedbinarytree;

import java.util.Scanner;

/**
 *
 * @author Caspian Maclean 30039802 30/7/2021
 *
 * Balanced Binary Tree example
 *
 * Question 2 – You are required to make a mechanical parts list sorted
 * alphabetically. You need to create a balanced binary search tree for a
 * dictionary of no less than 10 words. You must be able to search the list, add
 * and remove from the list.
 */
public class QuestionTwoBalancedBinaryTree {

    static private PartsListTree parts = initialPartsTree();

    // Create a parts list of at least 10 words, matching the program requirements
    public static PartsListTree initialPartsTree() {
        PartsListTree tree = new PartsListTree();

        // Start with the first and last items, so the tree will need rebalancing
        tree.add("valve");

        tree.add("axle");
        tree.add("hose");
        tree.add("belt");
        tree.add("gasket");
        tree.add("cam");
        tree.add("driveshaft");
        tree.add("cog");
        tree.add("diff");
        tree.add("connecting rod");
        tree.add("cylinder");

        return tree;
    }

    public static void main(String[] args) {

        System.out.println(parts.formattedStringDisplay());

        System.out.println("");
        System.out.println("Please enter a command: a for add,"
                + " s for search, r for remove, or q to quit program:");

        Scanner sc = new Scanner(System.in);
        while (true) {
            // Loop until breaking out of loop due to a "q" command.

            String commandString = sc.next();
            String inputWord = "";

            if (commandString.equals("q")) {
                break;
            } else if (commandString.equals("a")) {
                System.out.println("Please enter part to add");
                inputWord = sc.next();
                parts.add(inputWord);
            } else if (commandString.equals("s")) {
                System.out.println("Please enter part to search for");
                inputWord = sc.next();
                if (parts.contains(inputWord)) {
                    System.out.println("Found it!");
                } else {
                    System.out.println("That's not in the parts list");
                }

            } else if (commandString.equals("r")) {
                System.out.println("Please enter part to remove");
                inputWord = sc.next();
                parts.remove(inputWord);

            } else {
                System.out.println("Command not understood. Enter q to quit program.");
            }

        }

    }

}
