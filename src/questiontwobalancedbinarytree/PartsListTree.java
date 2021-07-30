/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questiontwobalancedbinarytree;

/**
 *
 * @author Caspian Maclean 30039802
 *
 * Class to hold a list of mechanical parts in a balanced binary tree.
 *
 */
public class PartsListTree {

    PartsListTreeNode root;

    public PartsListTree() {
        root = null;
    }

    private PartsListTreeNode addToNode(PartsListTreeNode node, String part) {
        if (node == null) {
            return new PartsListTreeNode(part);
        } else if (part.compareTo(node.getPart()) > 0) {
            // new part comes after, so put in the right sub tree
            PartsListTreeNode rightNode = node.getRightNode();
            rightNode = addToNode(rightNode, part);
            node.setRightNode(rightNode);
        } else {
            // new part comes before, so put in the left sub tree
            PartsListTreeNode leftNode = node.getLeftNode();
            leftNode = addToNode(leftNode, part);
            node.setLeftNode(leftNode);
        }
        return node;
    }

    public void add(String part) {
        root = addToNode(root, part);
    }

    
    
    public void remove(String part) {

    }

    private boolean nodeContains(PartsListTreeNode node, String part) {
        if (node == null) {
            return false;
        } else if (part.compareTo(node.getPart()) == 0) {
            return true;
        } else if (part.compareTo(node.getPart()) > 0) {
            // part comes after, so check in the right sub tree
            return nodeContains(node.getRightNode(), part);
        } else {
            // part comes before, so check in the left sub tree
            return nodeContains(node.getLeftNode(), part);
        }
    }
    
    
    public boolean contains(String part) {
        return nodeContains(root, part);
    }
}
