/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questiontwobalancedbinarytree;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author caspian
 */
public class PartsListTreeNodeTest {

    public PartsListTreeNodeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getHeight method, of class PartsListTreeNode.
     */
    @Test
    public void testGetHeight_0args() {
        PartsListTreeNode node1 = new PartsListTreeNode("wheel");
        PartsListTreeNode node2 = new PartsListTreeNode("differential");
        PartsListTreeNode node3 = new PartsListTreeNode("gearbox");
        node2.setRightNode(node3);
        node1.setLeftNode(node2);
        assertEquals(3, node1.getHeight());
    }

    /**
     * Test of getHeight method, of class PartsListTreeNode.
     */
    @Test
    public void testGetHeight_PartsListTreeNode() {
        PartsListTreeNode node1 = new PartsListTreeNode("gearbox");
        PartsListTreeNode node2 = new PartsListTreeNode("wheel");
        PartsListTreeNode node3 = new PartsListTreeNode("differential");
        node1.setLeftNode(node2);
        node1.setRightNode(node3);
        assertEquals(2, node1.getHeight());
    }

    /**
     * Test of heightCorrect method, of class PartsListTreeNode.
     */
    @Test
    public void testHeightCorrect_0args() {
 
        System.out.println("heightCorrect");
        PartsListTreeNode instance = new PartsListTreeNode("differential");
        boolean expResult = true;
        boolean result = instance.heightCorrect();
        assertEquals(expResult, result);
        
        // Changing the height of the subnodes later will confuse the height
        PartsListTreeNode node2 = new PartsListTreeNode("gearbox");
        instance.setRightNode(node2);
        PartsListTreeNode node3 = new PartsListTreeNode("wheel");
        node2.setRightNode(node3);
        
        expResult = false;
        result = PartsListTreeNode.heightCorrect(instance);
        assertEquals(expResult, result);        
    }

    /**
     * Test of heightCorrect method, of class PartsListTreeNode.
     */
    @Test
    public void testHeightCorrect_PartsListTreeNode() {
        System.out.println("heightCorrect");

        // Test null case
        PartsListTreeNode node = null;
        boolean expResult = true;
        boolean result = PartsListTreeNode.heightCorrect(node);
        assertEquals(expResult, result);

        node = new PartsListTreeNode("differential");
        expResult = true;
        result = PartsListTreeNode.heightCorrect(node);
        assertEquals(expResult, result);

        // Changing the height of the subnodes later will confuse the height
        PartsListTreeNode node2 = new PartsListTreeNode("gearbox");
        node.setRightNode(node2);
        PartsListTreeNode node3 = new PartsListTreeNode("wheel");
        node2.setRightNode(node3);
        
        expResult = false;
        result = PartsListTreeNode.heightCorrect(node);
        assertEquals(expResult, result);        

    }

}
