package org.arthur.ss5_orm.repository.imple;

import org.arthur.ss5_orm.model.MusicApp;
import org.arthur.ss5_orm.repository.IMusicAppRepo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MusicAppRepo implements IMusicAppRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MusicApp> getList() {
        TypedQuery<MusicApp> query = entityManager.createQuery("FROM MusicApp", MusicApp.class);
        return query.getResultList();
    }

    @Override
    public List<MusicApp> search(String input) {
        TypedQuery<MusicApp> query = entityManager.createQuery("from MusicApp where singer like :input", MusicApp.class);
        query.setParameter("input", "%" + input + "%");
        return query.getResultList();
    }

    @Override
    @Transactional
    @Modifying
    public Boolean addNew(MusicApp musicApp) {
        try {
            entityManager.persist(musicApp);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    @Modifying
    public Boolean update(MusicApp musicApp) {
        try {
            entityManager.merge(musicApp);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    @Modifying
    public Boolean delete(MusicApp musicApp) {
        try {
            entityManager.merge(musicApp);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
