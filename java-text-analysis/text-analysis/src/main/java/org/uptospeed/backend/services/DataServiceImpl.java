package org.uptospeed.backend.services;

import org.uptospeed.backend.data.LogManaging;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class DataServiceImpl implements DataService {

    @Inject
    EntityManager em;

    @Transactional
    public void createText(String text) {
        LogManaging logManaging = new LogManaging();
        logManaging.setText(text);
        em.persist(logManaging);
    }

}
