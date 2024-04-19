package org.acme;

import org.jboss.logging.Logger;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum MyEnum {
    TEST("test");

    private final String value;
    private static final Logger LOG = Logger.getLogger(MyEnum.class);

    MyEnum(final String value) {
        this.value = value;
    }

    // @JsonCreator
    public static MyEnum fromString(final String value) {
        // Input doesn't matter for this example. Just return TEST.

        LOG.infof("Getting enum from input: %s", value);

        return TEST;
    }

    @Override
    public String toString() {
        LOG.info("Hitting MyEnum#toString()...");

        return value;
    }
}
