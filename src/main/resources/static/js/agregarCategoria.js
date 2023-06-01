//Call the dataTables jQuery plugin
$(document).ready(function() {
//on ready

});


//funcion para guardar una nueva categoria
async function agregarCategoria(){
     let datos ={};

     if( ( document.getElementById('nombreCategoria').value)!= ""){
        datos.catNombre = document.getElementById('nombreCategoria').value;
     }

     if((document.getElementById('presupuestoCategoria').value)!= 0){
        datos.catPresupuesto = document.getElementById('presupuestoCategoria').value;
     }

    const request = await fetch('guardar-categoria', {
        method: 'POST',
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)

    });

    location.reload();
}
