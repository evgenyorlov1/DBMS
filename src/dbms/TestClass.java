/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.System.out;


/**
 *
 * @author pc
 */
public class TestClass {
        
    public static void main(String args[]) {
        JSONGeneratortest();
        
//        SingletonDBMS dbms = SingletonDBMS.getInstance();
//        //DBMS dbms = new DBMS();
//        dbms.create_database("db");   
//        compar();
//        //reg();
//        System.exit(0);
//        //ArrayList<String> tbls = dbms.show_dbs();
//               
//        dbms.create_table("db", "table1");     
//        
//        dbms.insert("db", "table1", new Record(62,52,42,'a',"22"));//0
//        dbms.insert("db", "table1", new Record(10,11,12,'b',"13"));//1
//        dbms.insert("db", "table1", new Record(2,2,2,'2',"2"));//2    
//        dbms.insert("db", "table1", new Record(6,6,6,'6',"6"));//3
//        dbms.insert("db", "table1", new Record(4,45,4,'A',"4"));//4
//        dbms.insert("db", "table1", new Record(3,3,3,'3',"3"));//5
//        dbms.insert("db", "table1", new Record(5,5,5,'o',"5"));//6                                
//        
//        ArrayList<String[]> tbls = dbms.sort("db", "table1", "char", -1);
//        
//        for(int i=0; i<tbls.size(); i++) {
//            System.out.println(tbls.get(i)[0] + ", " + tbls.get(i)[1] +  ", " + tbls.get(i)[2] +  ", " + tbls.get(i)[3] +  ", " + tbls.get(i)[4]); //+  ", " + tbls.get(i)[5]);
//        }
//    }  
//    
//    public static void reg() {
//        
//        String db = "use database";
//        String test = "This is just simple sentence";
//        
//        Pattern p = Pattern.compile("^use [a-zA-Z0-9]+$");
//        Matcher m = p.matcher(db);
//        
//        Pattern pa = Pattern.compile("(?<=This is)(.*)(?=sentence)");
//        Matcher ma = pa.matcher(test);
//        
//        Pattern pat = Pattern.compile("(?<=use )(.*)(?=$)");
//        Matcher mat = pat.matcher(db);
//        
//        
//        m.matches();
//        ma.matches();
//        mat.matches();
//        
//        //Pattern p = Pattern.compile("^use [a-zA-Z0-9]+$");
//        //Pattern name = Pattern.compile("(?<=use)(.*)(?=e)");
//        mat.find();
//        System.out.println(mat.group());
////        while(mat.find())
////            System.out.println(mat.group());
//    }
//    
//    public static void compar() {
//        String use = "use database";
//        String create_table = "db.createTable(newtable)";
//        String drop = "db.name.drop()";
//        String find = "db.name.find()";
//        String limit = "db.name.find().limit(2)";
//        String sort = "db.name.find().sort({integer:-1})";
//        String skip = "db.name.find().skip(2)";
//        Object[] input = new Object[] {true};
//        
////        Object[] useO = CommandParser.parse(use);System.out.println(useO[1]);
////        Object[] create_tableO = CommandParser.parse(create_table);System.out.println(create_tableO[1]);
////        Object[] dropO = CommandParser.parse(drop);System.out.println(dropO[1]);
////        Object[] findO = CommandParser.parse(find);System.out.println(findO[1]);
////        Object[] limitO = CommandParser.parse(limit);System.out.println(limitO[2]);
//        Object[] sortO = QuaeryProcessor.parse(sort);System.out.println(sortO[2]);
////        Object[] skipO = CommandParser.parse(skip);System.out.println(skipO[2]);
//        
//        
//        
//        System.out.println();
        
    }
    
    public static void JSONGeneratortest() {
        JSONGenerator jg = new JSONGenerator();
        
        Record record1 = new Record(1,1,1,'a', "a");
        Record record2 = new Record(2,2,2,'b',"b");
        Record record3 = new Record(3,3,3,'c',"c");
        Record record4 = new Record(4,4,4,'d',"d");
        Table tb1 = new Table("tb1");
        tb1.recordList.add(record1);
        tb1.recordList.add(record2);
        tb1.recordList.add(record3);
        tb1.recordList.add(record4);
        Table tb2 = new Table("tb2");
        tb2.recordList.add(record1);
        tb2.recordList.add(record2);
        tb2.recordList.add(record3);
        tb2.recordList.add(record4);
        Table tb3 = new Table("tb3");
        tb3.recordList.add(record1);
        tb3.recordList.add(record2);
        tb3.recordList.add(record3);
        tb3.recordList.add(record4);
        
        DataBase db = new DataBase("db1");
        db.tablesList.add(tb1);
        db.tablesList.add(tb2);
        db.tablesList.add(tb3);
                
        //String js = jg.database_to_json(db);
        
        String tb = jg.database_to_json(db);
        out.println("tb: " + tb);
        DataBase tbb = jg.json_to_database(tb);
        out.println(tbb.tablesList.get(0).name);
        //SingletonDBMS dbms = SingletonDBMS.getInstance();
        //out.println(tb);
    }
    
}
