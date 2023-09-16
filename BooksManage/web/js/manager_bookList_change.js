window.onload =function()
{   document.getElementById("pre_ISBN").hidden=true;
    document.getElementById("pre_ISBN").value=localStorage.getItem("pre_ISBN");

    document.getElementById("post_ISBN").setAttribute("placeholder",localStorage.getItem("pre_ISBN"));
    document.getElementById("post_ISBN").value=localStorage.getItem("pre_ISBN");


    document.getElementById("bookName").setAttribute("placeholder",localStorage.getItem("bookName"));
    document.getElementById("bookName").value=localStorage.getItem("bookName");

    document.getElementById("author").setAttribute("placeholder",localStorage.getItem("author"));
    document.getElementById("author").value=localStorage.getItem("author");

    document.getElementById("publisher").setAttribute("placeholder",localStorage.getItem("publisher"));
    document.getElementById("publisher").value=localStorage.getItem("publisher");

    document.getElementById("price").setAttribute("placeholder",localStorage.getItem("price"));
    document.getElementById("price").value=localStorage.getItem("price");

    document.getElementById("description").setAttribute("placeholder",localStorage.getItem("description"));
    document.getElementById("description").value=localStorage.getItem("description");

    document.getElementById("stock").setAttribute("placeholder",localStorage.getItem("stock"));
    document.getElementById("stock").value=localStorage.getItem("stock");
}