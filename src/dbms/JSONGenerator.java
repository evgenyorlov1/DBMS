/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/**
 *
 * @author pc
 */
public class JSONGenerator {
    
    
    public String table_to_json(Table tb) {
        JSONObject resultJson = table_json_object(tb);        
        return resultJson.toJSONString();
    }
    
    public String database_to_json(DataBase db) {
        JSONObject resultJson = new JSONObject();
        JSONArray array = new JSONArray();
        resultJson.put("name", db.name);
        resultJson.put("type", "database");
        
        for(Table tb : db.tablesList) {
            JSONObject json = table_json_object(tb);
            array.add(json);
        }
        resultJson.put("tables", array);
        return resultJson.toJSONString();
    }
    
    //TODO
    public DataBase json_to_database(String json) {
        return null;
    }
    //TODO  
    public Table json_to_table(String json) {
        return null;
    }
    
    private JSONObject table_json_object(Table tb) {
        JSONObject resultJson = new JSONObject();
        
        JSONArray array = new JSONArray();
        resultJson.put("name", tb.name);
        resultJson.put("type", "table");
        for(Record record : tb.recordList) {
            JSONObject rec = new JSONObject();            
            rec.put("integer",record.integer);
            rec.put("real",record.real);
            rec.put("longint",record.longint);
            rec.put("symbol",record.symbol);
            rec.put("html",record.html);
            array.add(rec);
        }                
        resultJson.put("records", array);
        
        return resultJson;
    }
     
}
