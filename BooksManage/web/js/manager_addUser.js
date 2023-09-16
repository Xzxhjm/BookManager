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

//-----------------------------------------显示搜索结果
function borrow_books(){

}
function show_res(){
    //获取当前搜索条件
    var objs=document.getElementById("search-option");
    var selectedOption = objs.options[objs.selectedIndex].value;
    //获取搜索框内容
    var search_bar = document.getElementById("search-bar");
    search_text = search_bar.value;//-------------------------------获取搜索内容
    alert(search_text);

    //获取表体
    const tablebody =document.getElementById("res-table-body")
    tablebody.innerHTML="";
    const books=[];
    //数据存入books-------------------------------需要连接实现部分
    if (selectedOption === "fuzzy") {
        const book={
            isbn: '0987654321',
            bookName: 'Book1',
            author: 'Author1',
            publisher: 'Publisher1',
            price: '9.99',
            content: 'Lorem Ipsum',
            stock: '50'
        };
        books.push(book);
    } else if (selectedOption === "book-number") {
        const book={
            isbn: '0987654321',
            bookName: 'Book2',
            author: 'Author2',
            publisher: 'Publisher2',
            price: '10.9',
            content: 'helloworld!',
            stock: '50'
        };
        books.push(book);
    } else if (selectedOption === "book-title") {

    } else if (selectedOption === "author") {

    }

    //----------------插入行
    books.forEach(function (book){
        const newRow = document.createElement('tr');
        newRow.innerHTML = `
    <td>${book.isbn}</td>
    <td>${book.bookName}</td>
    <td>${book.author}</td>
    <td>${book.publisher}</td>
    <td>${book.price}</td>
    <td>${book.content}</td>
    <td>${book.stock}</td>
  `;

    });
}

//---------------------------------已经借阅书籍----------------
//示例数据

const data = [
    {
        ISBN: "123456789",
        BookName: "Book 1",
        Author: "Author 1",
        publisher:"123",
        price:"99",
        stock:"10"
    },
    {
        ISBN: "987654321",
        BookName: "Book 2",
        Author: "Author 2",
        publisher:"123",
        price:"99",
        stock:"10"
    }
];
//------续借方法
function renew_books(obj){//启动时显示已经借阅的书籍信息
    const btnLine = obj.parentNode.parentNode;//获取按钮所在行
    const info = btnLine.textContent;
    alert("您已经成功续借"+info);
}

window.onload=function (){
    /*$.post("SearchAllBookServlet", $("#AddBook").serialize(), function (data) {

    })*/
    const tbody = document.getElementById("my-table-body");

    data.forEach((item)=>{
        // 创建新的表格行
        const row = document.createElement("tr");

        // 添加数据到新行
        Object.values(item).forEach((value) => {
            const cell = document.createElement("td");
            cell.textContent = value;
            row.appendChild(cell);
        });

        // “续借”按钮


        // 将表格行添加到表格的 tbody 中
        tbody.appendChild(row);
    });
}