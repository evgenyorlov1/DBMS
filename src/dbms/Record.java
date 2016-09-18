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
public class Record {
    public int integer;
    public float real;
    public long longint;
    public char symbol;
    public String html;
    
    // different parametrs can be overloaded via constructor, builder, maps or varargs
    public Record(int integer, float real, long longint, char symbol, String html) {
        this.integer = integer;
        this.real = real;
        this.longint = longint;
        this.symbol = symbol;
        this.html = html;
    }
    
    public void update(int integer, float real, long longint, char symbol, String html) {
        this.integer = integer;
        this.real = real;
        this.longint = longint;
        this.symbol = symbol;
        this.html = html;
    }
    
    public int getInteger() {
        return 0;
    }
    
    public float getReal() {
        return 0;       
    }
    
    public long getLongint() {
        return 0;
    }
    
    public char getSymbol() {
        return '2';
    }
    
    public String getHtml() {
        return "d";
    }
    
}
