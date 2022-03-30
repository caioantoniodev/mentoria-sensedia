package edu.mentorship.profiles;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ContextBeanCustomImpl1 implements ContextBeanCustom {

    private final String property1;
    private final String property2;
    private final String property3;

    @Override
    public Response response() {
        return new Response("profile1", property1, property2, property3);
    }
}
