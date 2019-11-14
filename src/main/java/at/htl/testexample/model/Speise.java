package at.htl.testexample.model;

import javax.persistence.*;

@Entity
@Table(name = "MY_SPEISE")
@NamedQueries({
        @NamedQuery(
                name = "Speise.getAll",
                query = "select s from Speise s"
        )
})
public class Speise {

    @Id @GeneratedValue
    private Long id;
    private String speise;
    @ManyToOne
    private Wochentag wochentag;

    public Speise() {
    }

    public Speise(String speise, Wochentag wochentag) {
        this.speise = speise;
        this.wochentag = wochentag;
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

    public Wochentag getWochentag() {
        return wochentag;
    }

    public void setWochentag(Wochentag wochentag) {
        this.wochentag = wochentag;
    }
}
