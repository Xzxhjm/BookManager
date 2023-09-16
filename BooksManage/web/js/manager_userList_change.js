window.onload =function()
{   document.getElementById("pre_username").hidden=true;
    document.getElementById("pre_username").value=localStorage.getItem("pre_username");

    document.getElementById("post_username").setAttribute("placeholder",localStorage.getItem("pre_username"));
    document.getElementById("post_username").value=localStorage.getItem("pre_username");


    document.getElementById("password").setAttribute("placeholder",localStorage.getItem("password"));
    document.getElementById("password").value=localStorage.getItem("password");

    document.getElementById("name").setAttribute("placeholder",localStorage.getItem("name"));
    document.getElementById("name").value=localStorage.getItem("name");

    document.getElementById("phone").setAttribute("placeholder",localStorage.getItem("phone"));
    document.getElementById("phone").value=localStorage.getItem("phone");

    document.getElementById("email").setAttribute("placeholder",localStorage.getItem("email"));
    document.getElementById("email").value=localStorage.getItem("email");


}