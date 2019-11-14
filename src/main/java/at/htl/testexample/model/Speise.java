package at.htl.testexample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MY_SPEISE")
public class Speise {

    @Id @GeneratedValue
    private Long id;
    private String speise;

    public Speise() {
    }

    public Speise(String speise) {
        this.speise = speise;
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getSpeise() {
        return speise;
    }

    public void setSpeise(String speise) {
        this.speise = speise;
    }

    @Override
    public String toString() {
        return String.format("%d: %s", id, speise);
    }
}
