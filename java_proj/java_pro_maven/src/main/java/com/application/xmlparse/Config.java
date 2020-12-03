package com.application.xmlparse;

public class Config {
    private String server;
    private String dbname;
    private String user;
    private String pass;
    private String port;

    public Config() {
    }

    public Config(String server, String dbname, String user, String pass, String port) {
        this.server = server;
        this.dbname = dbname;
        this.user = user;
        this.pass = pass;
        this.port = port;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getConnString(){
        String connString = "jdbc:mysql://" + server + ":" + port + "/"
                + dbname + "?user=" + user + "&password=" + pass
                + "&useUnicode=true&charsetEnconging='utf-8";

        return connString;
    }
}
