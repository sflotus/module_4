$(document).ready(()=>{
    showlist()
    showClassList()
    $('#saveAddStudent').click( () => { 
       addNewStudent() 
    });
    $('#addNewStudent').click(()=>{
        $('addForm input').val('')
    })
})
var classList
const showlist =() =>{
    $.ajax({
        type: "Get",
        url: "http://localhost:8080/api/student",
        dataType: "Json",
        success: (data) => {           
            console.log(data)
            var content = $('#table-content')
            content.empty();
           for ( let i = 0; i<data.content.length;i++){
            content.append(`<tr>`)
            content.append(`<td>${i+1}</td>`);
            content.append(`<td id="name${data.content[i].id}">${data.content[i].name}</td>`);
            content.append(`<td>${data.content[i].email}</td>`);
            content.append(`<td>${data.content[i].address}</td>`);
            content.append(`<td >${data.content[i].studentClass.name}</td>`);
            content.append(`<a class="btn btn-outline-success"  onclick=editStudent(${data.content[i].id})>EDIT</a>
                                <a class="btn btn-outline-warning"
                                onclick=getInfo(${data.content[i].id})>DELETE</a>`)
            content.append(`</tr>`)
           }
        }
    });
}
const showClassList =()=>{
    $.ajax({
        type: "Get",
        url: "http://localhost:8080/api/class",
        dataType: "Json",
        success: (data) => {
            console.log(data)
            classList =data.content
            let content = $('#classList')
            content.empty();
            for ( let i = 0; i<data.length;i++){
            content.append(`<option value=${JSON.stringify(data[i])}>${data[i].name}</option>`)
        
           }
        }
    });
}
const addNewStudent = () =>{
        const name = $('#name').val()
        const email = $('#email').val()
        const address = $('#address').val()
        const className = JSON.parse($('#classList').val())
        const formData = {
            name: name,
            email: email,
            address: address,
            studentClass: className
        }
        console.log( JSON.stringify(formData));
       
    $.ajax({
        type:'POST',
        url:'http://localhost:8080/api/student/create',
        data: JSON.stringify(formData),
        contentType: 'application/json',
        success: (response) =>{
            Swal.fire({
                title: "Success!",
                text: response,
                icon: "success",
                confirmButtonColor: "#3085d6"
            }).then((result) =>{
                $('#cancelAddStudent').click()
                showlist()
            });
        },
        error: (xhr, status, error)=> {
            console.log(xhr.responseJSON)
        
        }

    })
   
}
function getInfo(id) {
    let name = $(`#name${id}`).text()
    Swal.fire({
        title: "Are you sure delete " + name + " ?",
        text: "You won't be able to revert this!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Yes, delete it!"
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: `http://localhost:8080/api/student/delete/${id}`,
                type: "post",
                data: id,
                success: function (data) {
                    Swal.fire({
                        title: "Success!",
                        text: "Delete Successful",
                        icon: "success",
                        confirmButtonColor: "#3085d6"
                    }).then((result) => {
                            if (result.isConfirmed) {
                                showlist()
                            }
                        }
                    );
                }
            });
        }
       
    });
}
const editStudent = (id) =>{

}