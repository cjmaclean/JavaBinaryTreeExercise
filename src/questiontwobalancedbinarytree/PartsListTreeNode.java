package questiontwobalancedbinarytree;

/**
 *
 * @author Caspian Maclean 30039802
 */
public class PartsListTreeNode {

    private String part;
    private PartsListTreeNode leftNode;
    private PartsListTreeNode rightNode;
    private int height;

    public PartsListTreeNode(String part) {
        this.part = part;
        leftNode = null;
        rightNode = null;
        updateHeight();
    }

    /**
     * @return the part
     */
    public String getPart() {
        return part;
    }

    /**
     * @param part the part to set
     */
    public void setPart(String part) {
        this.part = part;
    }

    /**
     * @return the leftNode
     */
    public PartsListTreeNode getLeftNode() {
        return leftNode;
    }

    /**
     * @param leftNode the leftNode to set
     */
    public void setLeftNode(PartsListTreeNode leftNode) {
        this.leftNode = leftNode;
        updateHeight();
    }

    /**
     * @return the rightNode
     */
    public PartsListTreeNode getRightNode() {
        return rightNode;
    }

    /**
     * @param rightNode the rightNode to set
     */
    public void setRightNode(PartsListTreeNode rightNode) {
        this.rightNode = rightNode;
        updateHeight();
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the height of a node, or 0 for null
     */
    public static int getHeight(PartsListTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return node.getHeight();
        }
    }

    // Update the nodes height based on its left and right subtrees.
    // To be called whenever left or right subtrees are set.
    private void updateHeight() {
        // One more than the height of the highest subtree.
        height = 1 + Integer.max(getHeight(getLeftNode()), getHeight(getLeftNode()));
    }

}
