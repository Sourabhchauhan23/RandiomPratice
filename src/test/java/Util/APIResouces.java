package Util;

public enum APIResouces {

    Page("/api/users");

    private String resource;

    APIResouces(String resource){ this.resource=resource;}

    public String getResource() {
        return resource;
    }
}
