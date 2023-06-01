// Call the dataTables jQuery plugin
$(document).ready(function() {

   cargarCategorias();

});



//funcion para mostrar categorias con sus caracteriscticas y botones
async function cargarCategorias(){

  const request = await fetch('categoria', {
   method: 'GET',
   headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }

  });
  const categorias = await request.json();

  let listadoHtml = "";

  for(let categoria of categorias){

    let botonEliminar = '<button type="button" class="btn btn-danger btn-circle btn-lg" data-toggle="modal" data-target="#modalEliminar" onclick="abrirModalEliminar('+categoria.catId+')"><i class="fas fa-trash"></i></button>';
    let botonModificar = '<a onclick="cargarCategoria('+categoria.catId+')"  class="btn btn-info btn-circle btn-lg" data-toggle="modal" data-target="#exampleModalCenter"><i class="fas fa-info-circle"></i></a>'
    let categoriaHtml = '<tr> <td>'+categoria.catId+'</td> <td>'
    +categoria.catNombre+'</td><td>'+categoria.catPresupuesto
    +'</td><td>'+botonEliminar+'</td><td>'+botonModificar+'</td></tr>';

    listadoHtml += categoriaHtml;


  }
    document.querySelector('#categorias tbody').outerHTML = listadoHtml;

}



let categoriaSeleccionadaId;  // Variable global para almacenar el ID de la categoría seleccionada


//Permite abrir el modal para confirmar la eliminacion del elemento seleccionado
function abrirModalEliminar(id) {

    $('#modalEliminar').modal('show');  // Abre el modal de confirmación

    categoriaSeleccionadaId = id;  // Almacena el ID de la categoría seleccionada
}


//funcion para eliminar una categoria seleccionada
async function eliminarCategoria( ){

    // Utiliza la variable categoriaSeleccionadaId para obtener el ID de la categoría seleccionada
    const id = categoriaSeleccionadaId;

    const request = await fetch('eliminar-categoria/'+id, {
       method: 'DELETE',
       headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }

      });

    location.reload();
}


//funcion para cargar la categoria que se va a modificar
async function cargarCategoria(id) {

    const request = await fetch('categoria/' + id, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

  const CategoriaLoad = await  request.json();

  document.getElementById("idCat").value = CategoriaLoad.catId;
  document.getElementById("nombreCat").value = CategoriaLoad.catNombre;
  document.getElementById("PresupuestoCat").value = CategoriaLoad.catPresupuesto;

}


//funcion para actualizar los cambios de una categoria
async function modificarCategoria(){
    let datos = {};

    datos.catId = document.getElementById("idCat").value;

    if( ( document.getElementById('nombreCat').value)!= ""){
        datos.catNombre = document.getElementById("nombreCat").value;
    }

    if((document.getElementById("PresupuestoCat").value)!= 0){
        datos.catPresupuesto = document.getElementById("PresupuestoCat").value;
    }

    const request = await fetch('modificar-categoria',{
        method:'POST',
        headers: {
             'Accept': 'application/json',
             'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    location.reload();
}








