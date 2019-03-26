package by.babanin;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

//@Dependent
@Named
@SessionScoped
public class ExampleBean implements Serializable {
    private boolean logged;

    private String login;

    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public void doLogin() {
        logged = true;
    }
}

