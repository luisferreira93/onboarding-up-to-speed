package org.uptospeed.backend.services;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.uptospeed.backend.data.RequestData;
import org.uptospeed.backend.exceptions.CommonException;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertThrows;

@QuarkusTest
public class DataServiceImplTest {

    @Inject
    DataService victim;

    @Test
    public void testCreateTextSuccess() throws CommonException {
        victim.createText(buildSentence("Hello, everything ok?"));
    }

    @Test
    public void testCreateTextError() {
        assertThrows(
                CommonException.class,
                () -> victim.createText(buildSentence(null)),
                "Expected createText() to throw, but it didn't"
        );
    }

    private RequestData buildSentence(String text) {
        if (text == null) {
            return new RequestData();
        }
        RequestData data = new RequestData();
        data.setSentence(text);
        return data;
    }


}
