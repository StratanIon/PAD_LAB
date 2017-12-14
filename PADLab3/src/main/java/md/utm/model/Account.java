package md.utm.model;

public class Account {
    private int id;
    private String firstname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Account() {
    }

    public Account(int id, String firstname) {
        this.id = id;
        this.firstname = firstname;
    }
}
