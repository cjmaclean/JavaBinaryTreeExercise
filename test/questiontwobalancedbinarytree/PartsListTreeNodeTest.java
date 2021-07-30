/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questiontwobalancedbinarytree;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author caspian
 */
public class PartsListTreeNodeTest {
    
    public PartsListTreeNodeTest() {
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
    
}
