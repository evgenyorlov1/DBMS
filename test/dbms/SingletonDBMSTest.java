/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import java.util.ArrayList;
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
public class SingletonDBMSTest {
    
    public SingletonDBMSTest() {
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
     * Test of getInstance method, of class SingletonDBMS.
     */
//    @Test
//    public void testGetInstance() {
//        System.out.println("getInstance");
//        SingletonDBMS expResult = null;
//        SingletonDBMS result = SingletonDBMS.getInstance();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of show_dbs method, of class SingletonDBMS.
     */
//    @Test
//    public void testShow_dbs() {
//        System.out.println("show_dbs");
//        SingletonDBMS instance = null;
//        ArrayList<String> expResult = null;
//        ArrayList<String> result = instance.show_dbs();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of show_tables method, of class SingletonDBMS.
     */
//    @Test
//    public void testShow_tables() {
//        System.out.println("show_tables");
//        String DBname = "";
//        SingletonDBMS instance = null;
//        ArrayList<String> expResult = null;
//        ArrayList<String> result = instance.show_tables(DBname);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of drop_database method, of class SingletonDBMS.
     */
//    @Test
//    public void testDrop_database() {
//        System.out.println("drop_database");
//        String DBname = "";
//        SingletonDBMS instance = null;
//        instance.drop_database(DBname);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of drop_table method, of class SingletonDBMS.
//     */
//    @Test
//    public void testDrop_table() {
//        System.out.println("drop_table");
//        String DBname = "";
//        String Tname = "";
//        SingletonDBMS instance = null;
//        instance.drop_table(DBname, Tname);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of create_database method, of class SingletonDBMS.
     */
//    @Test
//    public void testCreate_database() {
//        System.out.println("create_database");
//        String DBname = "";
//        SingletonDBMS instance = null;
//        instance.create_database(DBname);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of create_table method, of class SingletonDBMS.
     */
//    @Test
//    public void testCreate_table() {
//        System.out.println("create_table");
//        String DBname = "";
//        String Tname = "";
//        ArrayList keyType = null;
//        SingletonDBMS instance = null;
//        instance.create_table(DBname, Tname, keyType);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of save method, of class SingletonDBMS.
     */
//    @Test
//    public void testSave_String_String() {
//        System.out.println("save");
//        String DBname = "";
//        String fileName = "";
//        SingletonDBMS instance = null;
//        instance.save(DBname, fileName);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of save method, of class SingletonDBMS.
     */
    //@Test
//    public void testSave_3args() {
//        System.out.println("save");
//        String DBname = "";
//        String Tname = "";
//        String fileName = "";
//        SingletonDBMS instance = null;
//        instance.save(DBname, Tname, fileName);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of load method, of class SingletonDBMS.
     */
//    @Test
//    public void testLoad_String() {
//        System.out.println("load");
//        String file = "";
//        SingletonDBMS instance = null;
//        instance.load(file);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of load method, of class SingletonDBMS.
     */
//    @Test
//    public void testLoad_String_String() {
//        System.out.println("load");
//        String DBname = "";
//        String file = "";
//        SingletonDBMS instance = null;
//        instance.load(DBname, file);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of register method, of class SingletonDBMS.
//     */
//    @Test
//    public void testRegister() {
//        System.out.println("register");
//        User login = null;
//        SingletonDBMS instance = null;
//        boolean expResult = false;
//        boolean result = instance.register(login);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of login method, of class SingletonDBMS.
//     */
//    @Test
//    public void testLogin() {
//        System.out.println("login");
//        User login = null;
//        SingletonDBMS instance = null;
//        boolean expResult = false;
//        boolean result = instance.login(login);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of find method, of class SingletonDBMS.
//     */
//    @Test
//    public void testFind() {
//        System.out.println("find");
//        String DBname = "";
//        String Tname = "";
//        SingletonDBMS instance = null;
//        ArrayList<ArrayList<String[]>> expResult = null;
//        ArrayList<ArrayList<String[]>> result = instance.find(DBname, Tname);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of get_metadata method, of class SingletonDBMS.
//     */
//    @Test
//    public void testGet_metadata() {
//        System.out.println("get_metadata");
//        String DBname = "";
//        String Tname = "";
//        SingletonDBMS instance = null;
//        ArrayList expResult = null;
//        ArrayList result = instance.get_metadata(DBname, Tname);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of limit method, of class SingletonDBMS.
//     */
//    @Test
//    public void testLimit() {
//        System.out.println("limit");
//        String DBname = "";
//        String Tname = "";
//        int num = 0;
//        SingletonDBMS instance = null;
//        ArrayList<ArrayList<String[]>> expResult = null;
//        ArrayList<ArrayList<String[]>> result = instance.limit(DBname, Tname, num);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of skip method, of class SingletonDBMS.
//     */
//    @Test
//    public void testSkip() {
//        System.out.println("skip");
//        String DBname = "";
//        String Tname = "";
//        int num = 0;
//        SingletonDBMS instance = null;
//        ArrayList<ArrayList<String[]>> expResult = null;
//        ArrayList<ArrayList<String[]>> result = instance.skip(DBname, Tname, num);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of sort method, of class SingletonDBMS.
//     */
//    @Test
//    public void testSort() {
//        System.out.println("sort");
//        String DBname = "";
//        String Tname = "";
//        String key = "";
//        int order = 0;
//        SingletonDBMS instance = null;
//        ArrayList<ArrayList<String[]>> expResult = null;
//        ArrayList<ArrayList<String[]>> result = instance.sort(DBname, Tname, key, order);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * TODO TEST
     */
    @Test
    public void testCount() {
        System.out.println("count");
        
        String DBname = "db";
        String Tname = "tb";
        ArrayList<String[]> keyType = new ArrayList<String[]>();
        int expResult = 0;       
        final String[] q = new String[] {"quont", "integer"};
        final String[] p = new String[] {"price", "real"};        
        keyType.add(p);
        keyType.add(q);
        
        SingletonDBMS instance = SingletonDBMS.getInstance();
        instance.create_database(DBname);
        instance.create_table(DBname, Tname, keyType);
        
        ArrayList<String[]> keyValue1 = new ArrayList<String[]>();
        final String[] q1 = new String[] {"quont", "1"};
        final String[] p1= new String[] {"price", "1.1"};        
        keyValue1.add(p1);
        keyValue1.add(q1);
        
        ArrayList<String[]> keyValue2 = new ArrayList<String[]>();
        final String[] q2 = new String[] {"quont", "2"};
        final String[] p2 = new String[] {"price", "2.2"};        
        keyValue1.add(p2);
        keyValue1.add(q2);
                                
        int exResult = 2;
        int result = instance.count(DBname, Tname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * TODO TEST
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        String DBname = "db";
        String Tname = "tb";
        ArrayList<String[]> keyValue = new ArrayList<String[]>();
        
        final String[] q1 = new String[] {"quont", "1"};
        final String[] p1= new String[] {"price", "1.1"};        
        keyValue.add(p1);
        keyValue.add(q1);
        
        SingletonDBMS instance = SingletonDBMS.getInstance();
        instance.insert(DBname, Tname, keyValue);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

//    /**
//     * Test of update method, of class SingletonDBMS.
//     */
//    @Test
//    public void testUpdate() {
//        System.out.println("update");
//        ArrayList rows = null;
//        String DBname = "";
//        String Tname = "";
//        SingletonDBMS instance = null;
//        instance.update(rows, DBname, Tname);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of is_unique_name method, of class SingletonDBMS.
//     */
//    @Test
//    public void testIs_unique_name() {
//        System.out.println("is_unique_name");
//        String useState = "";
//        SingletonDBMS instance = null;
//        boolean expResult = false;
//        boolean result = instance.is_unique_name(useState);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of save_serialization method, of class SingletonDBMS.
//     */
//    @Test
//    public void testSave_serialization_String_String() throws Exception {
//        System.out.println("save_serialization");
//        String DBname = "";
//        String fileName = "";
//        SingletonDBMS instance = null;
//        instance.save_serialization(DBname, fileName);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of save_serialization method, of class SingletonDBMS.
//     */
//    @Test
//    public void testSave_serialization_3args() throws Exception {
//        System.out.println("save_serialization");
//        String DBname = "";
//        String Tname = "";
//        String fileName = "";
//        SingletonDBMS instance = null;
//        instance.save_serialization(DBname, Tname, fileName);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of load_serialization method, of class SingletonDBMS.
//     */
//    @Test
//    public void testLoad_serialization_String() throws Exception {
//        System.out.println("load_serialization");
//        String file = "";
//        SingletonDBMS instance = null;
//        instance.load_serialization(file);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of load_serialization method, of class SingletonDBMS.
//     */
//    @Test
//    public void testLoad_serialization_String_String() throws Exception {
//        System.out.println("load_serialization");
//        String DBname = "";
//        String file = "";
//        SingletonDBMS instance = null;
//        instance.load_serialization(DBname, file);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of update method, of class SingletonDBMS.
//     */
//    @Test
//    public void testUpdate_3args() {
//        System.out.println("update");
//        ArrayList rows = null;
//        String DBname = "";
//        String Tname = "";
//        SingletonDBMS instance = null;
//        instance.update(rows, DBname, Tname);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of update method, of class SingletonDBMS.
//     */
//    @Test
//    public void testUpdate_4args() {
//        System.out.println("update");
//        String _id = "";
//        ArrayList keyVal = null;
//        String DBname = "";
//        String Tname = "";
//        SingletonDBMS instance = null;
//        instance.update(_id, keyVal, DBname, Tname);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * TEST TODO
     */
//    @Test
//    public void testRemove_3args_1() {
//        System.out.println("remove");
//        String DBname = "";
//        String Tname = "";
//        String id = "";
//        SingletonDBMS instance = null;
//        instance.remove(DBname, Tname, id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of remove method, of class SingletonDBMS.
//     */
//    @Test
//    public void testRemove_3args_2() {
//        System.out.println("remove");
//        String DBname = "";
//        String Tname = "";
//        ArrayList keyValues = null;
//        SingletonDBMS instance = null;
//        instance.remove(DBname, Tname, keyValues);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
