/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questiontwobalancedbinarytree;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Caspian Maclean 30039802
 */
public class PartsListTreeTest {

    /**
     * Test an empty parts list tree.
     */
    @Test
    public void testEmptyTree() {
        PartsListTree tree = new PartsListTree();
        assertFalse(tree.contains("gearbox"));
    }

    /**
     * Test of add method, of class PartsListTree.
     */
    @Test
    public void testAdd() {
        PartsListTree tree = new PartsListTree();
        tree.add("piston");
        tree.add("axle");
        assertTrue(tree.contains("piston"));
        assertTrue(tree.contains("axle"));
    }

    /**
     * Test of remove method, of class PartsListTree.
     */
    @Test
    public void testRemove() {
        PartsListTree tree = new PartsListTree();
        tree.add("piston");
        tree.add("axle");
        tree.remove("piston");
        assertFalse(tree.contains("piston"));
        assertTrue(tree.contains("axle"));
    }

    /**
     * Test of contains method, of class PartsListTree.
     */
    @Test
    public void testContains() {
        PartsListTree tree = new PartsListTree();
        tree.add("piston");
        tree.add("axle");
        assertTrue(tree.contains("piston"));
        assertTrue(tree.contains("axle"));
        assertFalse(tree.contains("gearbox"));
        assertFalse(tree.contains("acksell"));
    }

    public PartsListTreeNode exampleBalancedTreeNode() {
        PartsListTreeNode axle = new PartsListTreeNode("axle");
        PartsListTreeNode belt = new PartsListTreeNode("belt");
        PartsListTreeNode cog = new PartsListTreeNode("cog");
        PartsListTreeNode connectingRod = new PartsListTreeNode("connecting rod");
        PartsListTreeNode cylinder = new PartsListTreeNode("cylinder");
        PartsListTreeNode diff = new PartsListTreeNode("diff");
        PartsListTreeNode gasket = new PartsListTreeNode("gasket");
        belt.setLeftNode(axle);
        belt.setRightNode(cog);
        diff.setLeftNode(cylinder);
        diff.setRightNode(gasket);
        connectingRod.setLeftNode(belt);
        connectingRod.setRightNode(diff);
        return connectingRod;
    }

    public PartsListTree exampleBalancedTree() {
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



}
