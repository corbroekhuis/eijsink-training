package org.eijsink.injection.simple.annotation.jdbc;

import org.eijsink.injection.simple.annotation.Value;

import java.sql.Connection;

public class DataSource {

    @Value(key="db.url")
    public String url;
    @Value(key="db.user")
    public String user;
    @Value(key="db.password")
    public String password;

    public Connection getConnection() {

        System.out.println(
                "Connecting to database using: \n" +
                "url" + url + "\n" +
                "user: " + user + "\n" +
                        "password: " + password );

        return null;
    }
}
