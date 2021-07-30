package questiontwobalancedbinarytree;

/**
 *
 * @author Caspian Maclean 30039802
 */
public class PartsListTreeNode {

    private String part;
    private PartsListTreeNode leftNode;
    private PartsListTreeNode rightNode;

    public PartsListTreeNode(String part) {
        this.part = part;
        leftNode = null;
        rightNode = null;
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
    }
}
