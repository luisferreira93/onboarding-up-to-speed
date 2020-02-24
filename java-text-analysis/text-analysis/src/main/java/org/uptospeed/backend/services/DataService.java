package org.uptospeed.backend.services;

import org.uptospeed.backend.data.RequestData;
import org.uptospeed.backend.exceptions.CommonException;

public interface DataService
{
    void createText(final RequestData text) throws CommonException;
}