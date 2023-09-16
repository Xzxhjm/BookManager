package com.Element;

public class Result
{
    private boolean flag;
    private String msg;
    private String username;
    public Result()
    {
        flag = false;
        msg = "";
        username = "";
    }
    public Result(boolean flag, String msg, String username)
    {
        this.flag = flag;
        this.msg = msg;
        this.username = username;
    }
    public boolean isFlag()
    {
        return flag;
    }
    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }
    public String getMsg()
    {
        return msg;
    }
    public void setMsg(String msg)
    {
        this.msg = msg;
    }
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
}
