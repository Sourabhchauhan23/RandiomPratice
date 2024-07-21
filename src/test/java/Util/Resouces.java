package Util;

public enum Resouces {

    Page("/api/users"),
    Google("https://www.google.com/");

    private String resource;

    Resouces(String resource){ this.resource=resource;}

    public String getResource() {
        return resource;
    }
}
