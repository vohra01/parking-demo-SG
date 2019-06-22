package com.kunal.spring.security.oauth2.repository;

import com.kunal.spring.security.oauth2.model.Notification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Notification> find(Long cost) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Notification> query = builder.createQuery(Notification.class);
        Root<Notification> root = query.from(Notification.class);
        query.select(root).distinct(true).where(builder.equal(root.get("cost"), cost)).orderBy();
        TypedQuery<Notification> allQuery = entityManager.createQuery(query);

        return allQuery.getResultList();
    }

    @Override
    public void create(Notification notification) {
        entityManager.persist(notification);
    }


}
