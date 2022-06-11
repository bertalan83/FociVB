package hu.progmatic.model;

public class Worldcups {

    private int year;
    private String host;
    private String confederation;
    private String date_from;
    private String date_to;

    public Worldcups() {
    }

    public Worldcups(int year, String host, String confederation, String date_from, String date_to) {
        this.year = year;
        this.host = host;
        this.confederation = confederation;
        this.date_from = date_from;
        this.date_to = date_to;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getConfederation() {
        return confederation;
    }

    public void setConfederation(String confederation) {
        this.confederation = confederation;
    }

    public String getDate_from() {
        return date_from;
    }

    public void setDate_from(String date_from) {
        this.date_from = date_from;
    }

    public String getDate_to() {
        return date_to;
    }

    public void setDate_to(String date_to) {
        this.date_to = date_to;
    }
}
