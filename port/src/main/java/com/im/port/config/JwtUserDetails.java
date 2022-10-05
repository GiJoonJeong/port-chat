package com.im.port.config;

public class JwtUserDetails {
    private User user;

    private Map<String, Object> attributes;

    public JwtUserDetails(User user) {
        super();
        this.user = user;
    }

    public JwtUserDetails(User user, Map<String, Object> attributes) {
        this.user = user;
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

}
