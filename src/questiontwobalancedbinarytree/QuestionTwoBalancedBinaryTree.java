package questiontwobalancedbinarytree;

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

    public static PartsListTree exampleBalancedTree() {
        // Add in order for it to balance without rotations:

        PartsListTree tree = new PartsListTree();

        //top node
        tree.add("connecting rod");

        //second level nodes
        tree.add("belt");
        tree.add("diff");

        // third level nodes
        tree.add("axle");
        tree.add("cog");
        tree.add("cylinder");
        tree.add("gasket");

        return tree;
    }

    // Create a parts list of at least 10 words, matching the program requirements
    public static PartsListTree initialPartsTree() {
        // Add in order for it to balance without rotations:

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
        PartsListTree example1 = exampleBalancedTree();
        System.out.println(example1.formattedStringDisplay());
        
        System.out.println("balance challenge");
        PartsListTree example2 = initialPartsTree();
        System.out.println(example2.formattedStringDisplay());
        
        System.out.println("are the heights correct");
        System.out.println(example2.heightCorrect());
    }

}
