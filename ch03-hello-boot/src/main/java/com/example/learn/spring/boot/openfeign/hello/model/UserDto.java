package com.example.learn.spring.boot.openfeign.hello.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlRootElement(name = "UserDto")
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "userId")
    private String userId;

    @XmlElement(name = "name")
    private String name;

    @XmlTransient
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @XmlTransient
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
