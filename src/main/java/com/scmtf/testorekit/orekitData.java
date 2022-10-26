package com.scmtf.testorekit;

import org.orekit.data.ClasspathCrawler;
import org.orekit.data.DataContext;
import org.orekit.data.DataProvidersManager;
import org.orekit.errors.OrekitException;

import java.io.IOException;

/**
 * Provides utility function for loading orekit daa manager from
 * orekit-data.zip file.
 * @author scmtf scm.tensorflow@gmail.com
 */
public final class orekitData {
    //public static final String OREKIT_RESOURCE_PATH = "orekit-data.zip";
    public static final String OREKIT_RESOURCE_PATH = "orekit-data";
    public static final String OREKIT_DATA_ENVIRONMENT_VARIABLE_NAME = "LOCAL_OREKIT_DATA_PATH";
    public static final String OREKIT_DATA_RUNTIME_PROPERTY_NAME = "JVM_VAR_OREKIT_DATA_PATH";

    /**
     * Utility class that is not meant to be instantiated
     */
    private orekitData(){
        throw new AssertionError("Do not instantiate utility class: orekitData");
    }

    public static DataProvidersManager initialize() {
        try {
            // load from resource zip located in class (slow and overhead)
            final DataProvidersManager manager = DataContext.getDefault().getDataProvidersManager();
            manager.addProvider(new ClasspathCrawler(OREKIT_RESOURCE_PATH));
            return manager;
        } catch (OrekitException oe) {
            System.err.println(oe.getLocalizedMessage());
            System.exit(1);
        }
        return null;
    }
}
