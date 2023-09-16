function option_change(){
    var objs=document.getElementById("search-option");
    var selectedOption = objs.options[objs.selectedIndex].value;

    const searchbar=document.getElementById("search-bar");
    if (selectedOption === "fuzzy") {
        searchbar.placeholder = '请输入搜索内容';
    } else if (selectedOption === "book-number") {
        searchbar.placeholder = "根据书号搜索";
    } else if (selectedOption === "book-title") {
        searchbar.placeholder = "根据书名搜索";
    } else if (selectedOption === "author") {
        searchbar.placeholder = "根据作者搜索";
    }
}




