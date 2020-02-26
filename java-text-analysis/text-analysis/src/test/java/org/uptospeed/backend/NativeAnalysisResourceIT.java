package org.uptospeed.backend;

import io.quarkus.test.junit.NativeImageTest;
import org.uptospeed.backend.webservices.AnalysisResourceTest;

@NativeImageTest
public class NativeAnalysisResourceIT extends AnalysisResourceTest {

    // Execute the same tests but in native mode.
}