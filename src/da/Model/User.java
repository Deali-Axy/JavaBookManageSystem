package da.Model;


public class User {
    private int id = 0;
    private String name = "";
    private String password = "";
    private Boolean admin = false;

    public User() {
    }


    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return String.format("id: %d\n" +
                        "name: %s\n" +
                        "password: %s\n" +
                        "admin: %s\n",
                this.id, this.name, this.password, this.admin.toString());
    }
}
