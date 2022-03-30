package edu.mentorship.profiles;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Response {
    private final String type;
    private final String property1;
    private final String property2;
    private final String property3;
}
