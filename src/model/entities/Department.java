package model.entities;

import java.io.Serial;
import java.util.Objects;
import java.io.Serializable;

public class Department implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    public Department() {
    }

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Department that)) return false;
        if (!super.equals(object)) return false;
        return getId() == that.getId();
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
