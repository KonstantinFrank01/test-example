package at.htl.testexample;

import at.htl.testexample.model.Speise;
import at.htl.testexample.model.Wochentag;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@ApplicationScoped
public class InitBean {

    @PersistenceContext
    EntityManager em;

    @Transactional
    private void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((getClass().getResourceAsStream("/data.csv"))));
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(";");
                List<Wochentag> wochentage = this.em
                        .createNamedQuery("Wochentag.getTag", Wochentag.class)
                        .setParameter("DAY", row[0])
                        .getResultList();
                Wochentag aktuellerTag;
                if (wochentage.size() != 1) {
                    aktuellerTag = new Wochentag(row[0]);
                    this.em.persist(aktuellerTag);
                } else {
                    aktuellerTag = wochentage.get(0);
                }
                this.em.persist(new Speise(row[1], aktuellerTag));
                this.em.persist(new Speise(row[2], aktuellerTag));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
