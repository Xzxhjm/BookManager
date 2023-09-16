//------续借方法
//示例数据
const data = [
    {
        ISBN: "123456789",
        BookName: "Book 1",
        Author: "Author 1",
        b_date: "2022-01-01",
        ddl: "2022-01-15"
    },
    {
        ISBN: "987654321",
        BookName: "Book 2",
        Author: "Author 2",
        b_date: "2022-02-01",
        ddl: "2022-02-15"
    }
];
function renew_books(obj){//启动时显示已经借阅的书籍信息
    const btnLine = obj.parentNode.parentNode;//获取按钮所在行
    const rowData = {//该行数据
        ISBN: btnLine.cells[0].innerHTML,
        BookName: btnLine.cells[1].innerHTML,
        Author: btnLine.cells[2].innerHTML,
        b_date: btnLine.cells[3].innerHTML,
        ddl: btnLine.cells[4].innerHTML
    };

    //-------------------------数据更新!!!!!!!!!!!!!!!!!!!!!
    const ddlDate = new Date(rowData.ddl);  // 将ddl日期转换为Date对象
    ddlDate.setDate(ddlDate.getDate() + 14);  // 将日期加上14天

    // 格式化更新后的日期
    const updatedddl = ddlDate.toISOString().split('T')[0];

    // 将更新后的日期设置回单元格
    btnLine.cells[4].innerHTML = updatedddl;

    alert("您已经成功续借");
}

window.onload=function (){
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
        var returnBtnCell = document.createElement("td");
        var returnBtn = document.createElement("button");
        returnBtn.textContent = "续借";
        returnBtn.addEventListener('click',function (){
            renew_books(this);
        });
        returnBtnCell.appendChild(returnBtn);
        row.appendChild(returnBtnCell);

        // 将表格行添加到表格的 tbody 中
        tbody.appendChild(row);
    });
}