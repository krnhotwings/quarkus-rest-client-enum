package org.acme;

import org.jboss.resteasy.reactive.RestForm;

public class MyBean {

    @RestForm
    MyEnum myEnum;

    public MyEnum getMyEnum() {
        return myEnum;
    }
}
