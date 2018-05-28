package matrix6;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class visitorData {
    
    String id, name ,statas;

    public visitorData(String id, String name, String statas) {
        this.id = id;
        this.name = name;
        this.statas = statas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatas() {
        return statas;
    }

    public void setStatas(String statas) {
        this.statas = statas;
    }
    
    
}
