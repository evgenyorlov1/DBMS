/*
 * Class stores single record.
 * @param integer database stores integer value
 * @param real database stores real value
 * @param longint database stores longint value
 * @param symbol database stores char value
 * @param html database stores html value
 */
package dbms;

/**
 *
 * @author pc
 */
public class Record  {
    public int integer;
    public float real;
    public long longint;
    public char symbol;
    public String html;
    public static String[] metadata = {"Integer","Real","Longint","Char","HTML"};
    
    // different parametrs can be overloaded via constructor, builder, maps or varargs
    public Record(int integer, float real, long longint, char symbol, String html) {
        try {
            this.integer = integer;
            this.real = real;
            this.longint = longint;
            this.symbol = symbol;
            this.html = html;
        } catch(Exception e) {System.out.println("Record.Record: " + e);}
    }
    
    // updates everything; switch to update some value
    public void update(int integer, float real, long longint, char symbol, String html) {
        try {
            this.integer = integer;
            this.real = real;
            this.longint = longint;
            this.symbol = symbol;
            this.html = html;
        } catch(Exception e) {System.out.println("Record.update: " + e);}
    }
        
    public String[] get() {
        return new String[] {String.valueOf(this.integer), 
            String.valueOf(this.real), 
        String.valueOf(this.longint),
        String.valueOf(this.symbol),
        String.valueOf(this.html)};
    }
    
}
