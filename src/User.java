/**
 * Created by reegl on 29.09.2016.
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private int id;
    private String name;
    private String login;
    private String password;

    User(int id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = Hash.makeHash(password);

    }
    public String getpass() {
        return password;
    }

    public void sethash() {
        password=Hash.makeHash(password);
    }

    public void setpass(String s) {

        password =  Hash.makeHash(s);
    }


}

