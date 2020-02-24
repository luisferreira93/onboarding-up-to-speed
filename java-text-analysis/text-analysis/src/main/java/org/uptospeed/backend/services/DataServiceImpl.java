package org.uptospeed.backend.services;

import org.uptospeed.backend.data.LogManaging;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public class DataService {

    @Inject
    EntityManager em;

    @Transactional
    public void createText(String text) {
        LogManaging logManaging = new LogManaging();
        logManaging.setText(text);
        em.persist(text);
    }

}
