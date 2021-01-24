package com.github.apz.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SampleScopeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, Object> maps;

    public SampleScopeBean() {
        this.maps = new HashMap<String, Object>();
    }

    public Object get(String key) {
        return maps.get(key);
    }

    public Object put(String key, Object value) {
        return maps.put(key, value);
    }

    public Object remove(String key) {
        return maps.remove(key);
    }

}