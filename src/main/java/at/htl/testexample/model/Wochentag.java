package at.htl.testexample.model;

import javax.persistence.*;

@Entity
@Table(name = "MY_WOCHENTAG")
public class Wochentag {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    Long id;
    private String tag;

    public Wochentag() {
    }

    public Wochentag(String tag) {
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return String.format("%d: %s", id, tag);
    }
}
