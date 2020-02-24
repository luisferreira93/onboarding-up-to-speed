package org.uptospeed.backend.services;

import org.uptospeed.backend.data.LogManaging;
import org.uptospeed.backend.data.RequestData;
import org.uptospeed.backend.exceptions.CommonException;
import org.uptospeed.backend.exceptions.CommonExceptionConstants;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;

@ApplicationScoped
public class DataServiceImpl implements DataService {

    @Inject
    EntityManager em;

    @Transactional
    public void createText(RequestData text) throws CommonException {
        validateRequest(text);
        LogManaging logManaging = new LogManaging();
        logManaging.setTextPhrase(text.getSentence());
        logManaging.setRequestTime(new Date());
        em.persist(logManaging);
    }

    private void validateRequest(RequestData text) throws CommonException {
        if (text.getSentence() == null) {
            throw new CommonException(CommonExceptionConstants.WRONG_FORMAT,
                    "Wrong request format, it must have the following format:\n" +
                    "{\n" +
                    "      \"sentence\": \"text phrase\"\n" +
                    "}\n");
        }
    }

}
