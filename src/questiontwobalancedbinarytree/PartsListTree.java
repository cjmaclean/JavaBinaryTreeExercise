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
        node = balanceTree(node);
        return node;
    }

    public void add(String part) {
        root = addToNode(root, part);
    }

    private String firstPartFromNode(PartsListTreeNode node) {
        if (node.getLeftNode() == null) {
            return node.getPart();
        } else {
            return firstPartFromNode(node.getLeftNode());
        }
    }

    private PartsListTreeNode removeFromNode(PartsListTreeNode node, String part) {
        if (node == null) {
            return null;
        } else if (part.compareTo(node.getPart()) == 0) {
            // found the part, need to remove it.

            // if one subtree is null, return the other one (which may also be null)
            if (node.getLeftNode() == null) {
                return node.getRightNode();
            }
            if (node.getRightNode() == null) {
                return node.getLeftNode();
            } else {
                // otherwise take the first part in the right subtree, and
                // use it to replace the current part
                PartsListTreeNode rightNode = node.getRightNode();
                String replacement = firstPartFromNode(rightNode);
                node.setPart(replacement);
                rightNode = removeFromNode(rightNode, replacement);
                node.setRightNode(rightNode);
            }

        } else if (part.compareTo(node.getPart()) > 0) {
            // part comes after, so remove from the right sub tree
            PartsListTreeNode rightNode = node.getRightNode();
            rightNode = removeFromNode(rightNode, part);
            node.setRightNode(rightNode);
        } else {
            // new part comes before, so remove from the left sub tree
            PartsListTreeNode leftNode = node.getLeftNode();
            leftNode = removeFromNode(leftNode, part);
            node.setLeftNode(leftNode);
        }
        node = balanceTree(node);
        return node;
    }

    public void remove(String part) {
        root = removeFromNode(root, part);
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
    
    // Balancing functions
    
    static public PartsListTreeNode rotateNodeLeft(PartsListTreeNode topNode) {
        PartsListTreeNode oldRightNode = topNode.getRightNode();
        PartsListTreeNode newTopNode = oldRightNode;
        PartsListTreeNode midNode = oldRightNode.getLeftNode();
        PartsListTreeNode newLeftNode = topNode;
        newLeftNode.setRightNode(midNode);
        newTopNode.setLeftNode(newLeftNode);
        return newTopNode;
    }

    static public PartsListTreeNode rotateNodeRight(PartsListTreeNode topNode) {
        PartsListTreeNode oldLeftNode = topNode.getLeftNode();
        PartsListTreeNode newTopNode = oldLeftNode;
        PartsListTreeNode midNode = oldLeftNode.getRightNode();
        PartsListTreeNode newRightNode = topNode;
        newRightNode.setLeftNode(midNode);
        newTopNode.setRightNode(newRightNode);
        return newTopNode;
    }
    
    // Based on code provided in Programming 3 class.
    private PartsListTreeNode balanceTree(PartsListTreeNode current) {
        int currentBalanceFactor = balanceFactor(current);
        if (currentBalanceFactor > 1) {
            if (balanceFactor(current.getLeftNode()) > 0) {
                current = rotateLL(current);
            } else {
                current = rotateLR(current);
            }
        } else if (currentBalanceFactor < -1) {
            if (balanceFactor(current.getRightNode()) > 0) {
                current = rotateRL(current);
            } else {
                current = rotateRR(current);
            }
        }
        return current;
    }
    
    private int balanceFactor(PartsListTreeNode node) {
        return PartsListTreeNode.getHeight(node.getLeftNode()) -
                PartsListTreeNode.getHeight(node.getRightNode());
    }
    
    // Right subtree and right subtree of right subtree are high, so rotate left
    private PartsListTreeNode rotateRR(PartsListTreeNode parent) {
        return rotateNodeLeft(parent);
    }
    
    // Left subtree and left subtree of left subtree are high, so rotate right
    private PartsListTreeNode rotateLL(PartsListTreeNode parent) {
        return rotateNodeRight(parent);
    }
    
    // Left subtree and right subtree of left subtree are high,
    // so rotate the left subtree left, then rotate the main node right
    private PartsListTreeNode rotateLR(PartsListTreeNode parent) {
        PartsListTreeNode pivot = parent.getLeftNode();
        parent.setLeftNode(rotateNodeLeft(pivot));
        return rotateNodeRight(parent);
    }
    
    // Right subtree and left subtree of right subtree are high,
   // so rotate the right subtree right, then rotate the main node left
    private PartsListTreeNode rotateRL(PartsListTreeNode parent) {
        PartsListTreeNode pivot = parent.getRightNode();
        parent.setRightNode(rotateNodeRight(pivot));
        return rotateNodeLeft(parent);
    }
    
    // Viewing for debugging:
    
    public String formattedStringDisplay() {
        return formattedStringDisplay(root, "");
    } 

    public static String formattedStringDisplay(PartsListTreeNode node, String paddingString) {
        if (node == null) {
            return "";
        } else {
            String nextPadding = paddingString + " - ";
            return
                    formattedStringDisplay(node.getLeftNode(), nextPadding) +
                    paddingString + node.getPart() + "\n" +
                    formattedStringDisplay(node.getRightNode(), nextPadding) ;
        }
    }
    
    public boolean heightCorrect() {
        return PartsListTreeNode.heightCorrect(root);
    }
}
