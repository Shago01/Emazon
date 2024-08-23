
package com.Emazon.stock_mircoservice.domine.models;
import com.Emazon.stock_mircoservice.domine.exception.EmptyFieldException;
import com.Emazon.stock_mircoservice.domine.exception.InvalidLengthMaxDescription;
import com.Emazon.stock_mircoservice.domine.exception.InvalidLengthMaxName;
import com.Emazon.stock_mircoservice.domine.utils.Constants;


public class Category {
    private long id;
    private final String name;
    private final String description;

    public Category(String name, String description) {
        if(name == null || name.trim().isEmpty()){
           throw  new EmptyFieldException();
        }
        if(description == null || description.trim().isEmpty()){
            throw  new EmptyFieldException();
        }
        if(name.length() > Constants.LENGTH_MAX_NAME){
            throw new InvalidLengthMaxName();
        }
        if(description.length() > Constants.LENGTH_MAX_DESCRIPTION){
            throw new InvalidLengthMaxDescription();
        }
        this.name = name;
        this.description = description;
    }

    public Category(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
