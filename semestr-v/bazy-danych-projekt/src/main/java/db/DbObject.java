package db;

import org.neodatis.odb.*;
import org.neodatis.odb.impl.core.query.criteria.*;
import org.neodatis.odb.core.query.*;
import org.neodatis.odb.core.query.criteria.*;

public class DbObject {
    protected int id;

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public DbObject(){

    }

    public boolean save(){
        Database.save(this);
        return true;
    }

    public boolean destroy(){
        Database.delete(this);
        return true;
    }

    public static DbObject find(String sid){
        return find(Integer.parseInt(sid));
    }

    public static DbObject find(int id){
        IQuery query = new CriteriaQuery(DbObject.class, Where.equal("id", id));
        query.setPolymorphic(true);
        try {
            return (DbObject)Database.odb.getObjects(query).getFirst();
        } catch (Exception ex) {
            return null;
        }
    }
}

