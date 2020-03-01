package com.example.ub_app;



public class Todoup {

    private static String Fromm;
    private static String Too;
    private String name;
    private String registerno;
    private String source;
    private String destination;
    private String bustype;

    public Todoup() {

    }
    public static void passdis(String a, String b){
        Fromm=a;
        Too=b;

    };

    public Todoup(String name, String registerno, String source, String destination, String bustype) {
        this.name = name;
        this.registerno = registerno;
        this.source = source;
        this.destination = destination;
        this.bustype = bustype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisterno() {
        return registerno;
    }

    public void setRegisterno(String registerno) {
        this.registerno = registerno;
    }

    public String getSource() {

        source=Fromm;
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        destination=Too;
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getBustype() {
        return bustype;
    }

    public void setBustype(String bustype) {
        this.bustype = bustype;
    }

}