const BASE_URL='Http://132.226.117.54:81'
//const BASE_URL='http://localhost:8080'
function MostraInformacionCategory(){
     $.ajax({
         url : BASE_URL + "/api/Category/all",
        //url: "http://localhost:8080/api/Category/all",
        type: "GET",
        datatype: "JSON",
    
         success: function (respuesta) {
            pintarRespuestaCategory(respuesta);
       } 
    }
 ); 
}
function pintarRespuestaCategory(items){
    $("#resultCategory").empty();
     let myTable = "<table border =3 >";
     myTable += "<caption> CATEGORY </caption>";
     myTable += "<tr><th>CODE</th> <th> NAME</th> <th> DESCRIPTION </th> </tr>"
     for (i=0; i<items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].id + "</td>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].description + "</td>";
        myTable+="<td><button onclick='borrarCategory("+items[i].id+")'>Borrar</button>";
        myTable+="<td><button onclick='actualizarCategory("+items[i].id+")'>Actualizar</button>";

        
        myTable += "</tr>";
}
myTable += "</table>";
$("#resultCategory").append(myTable);
}
function InsertarInformaconCategory(){
    $("#resultCategory").empty();
    let myData = {
        name:        $("#nameCategory").val(),
        description: $("#descriptionCategory").val()
    }
    let dataToSend = JSON.stringify(myData);
    $.ajax({
       url: BASE_URL + "/api/Category/save",
        //url: '/api/Category/save',
        type: "POST",
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function (respuesta) {
            alert("Insercion exitosa");
        },
        error: function (xhr, status) {
            alert('Operacion no satisfactoria' + xhr.status);
        }
    }
    );
}

function actualizarCategory(idElemento){

    $("#resultCategory").empty();

    let myData ={id:idElemento, name:$("#nameCategory").val(),description:$("#descriptionCategoryCategory").val()}
    let dataToSend = JSON.stringify(myData);

    $.ajax ({
           // url: BASE_URL + '/api/Category/update',
            URL : BASE_URL + '/api/Category/update',
            type: 'PUT',
            data: dataToSend,
            datatype: "JSON",
            contentType: 'application/json',
            success:function(respuesta){
            alert("Actualizacion exitosa");
            },
            error:function(xhr,status){
            alert('Operacion no satisfactoria,'+ xhr.status );
            }
        }
    );
}
function borrarCategory(idElemento){
    
    $.ajax ({
            url: BASE_URL + '/api/Category/' + idElemento,
          //url: '/api/Category/'+idElemento,
            type: 'DELETE',
            datatype: "JSON",
            success: function(respuesta){
            // console.log(respuesta);
            alert("Borrado exitoso");
            },
            error:function(xhr,status){                                
            alert('Operacion no satisfactoria,'+ xhr.status );
            }
        }
    );
}
