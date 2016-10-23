/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class QuaeryProcessorTest {
    
    public QuaeryProcessorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of parse method, of class QuaeryProcessor.
     */
    @Test
    public void testParse() {
        System.out.println("parse");
        String line = "";
        Object[] expResult = null;
        Object[] result = QuaeryProcessor.parse(line);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of useState method, of class QuaeryProcessor.
     */
    @Test
    public void testUseState() {
        System.out.println("useState");
        String line = "";
        String use = "";
        String expResult = "";
        String result = QuaeryProcessor.useState(line, use);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
