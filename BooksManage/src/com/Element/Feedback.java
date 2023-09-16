package com.Element;

public class Feedback
{
    private int id;
    private String username;
    private String content;

    public Feedback()
    {
        this.id = 0;
        this.username = "";
        this.content = "";
    }

    public Feedback(int id,String username,String content)
    {
        this.id = id;
        this.username = username;
        this.content = content;
    }

    public int getId()
    {
        return this.id;
    }
    public String getUsername()
    {
        return username;
    }
    public String getContent()
    {
        return content;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public void setContent(String content)
    {
        this.content = content;
    }
}
