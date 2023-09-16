package com.Element;
public class User
{
    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;
    public User()
    {
        this.username = "";
        this.password = "";
        this.name = "";
        this.phone = "";
        this.email = "";
    }
    public User(String username, String password, String name, String phone, String email)
    {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
    public String getName()
    {
        return name;
    }
    public String getPhone()
    {
        return phone;
    }
    public String getEmail()
    {
        return email;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
}
