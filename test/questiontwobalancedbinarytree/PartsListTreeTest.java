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
}
