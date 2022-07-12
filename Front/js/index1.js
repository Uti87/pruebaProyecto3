function enviar() {
   
    var titulo = document.getElementById("title").value;
    var mensaje = document.querySelector('#message').value;
    var x = document.getElementById("category").selectedIndex;
    var category = document.getElementsByTagName("option")[x].value;
    var nombre = document.querySelector('#message').value.trim();
    var nombre1 = document.getElementById("title").value.trim();

    if(nombre.length>0 && nombre1.length>0){

    fetch('http://18.208.234.250:5010/demo-0.0.1-SNAPSHOT/notes', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(
            {
                "title": titulo,
                "message": mensaje,
                "category": category
            }
        )
    })
        .then(res => res.json())
        .then(data => console.log(data))

        mostrar();
        mostrar();
        limpiarCampos();

}}

function mostrar() {

    fetch('http://18.208.234.250:5010/demo-0.0.1-SNAPSHOT/notes')
        .then(res => res.json())
        .then(data => {
            document.getElementById("contenido").innerHTML = "";
            console.log(data);
            var x = document.getElementById("category").selectedIndex;
            var category = document.getElementsByTagName("option")[x].value

            for (i = 0; i <data.length; i++) {

                if(data[i].category == category){
                contenido.innerHTML +=
                    
                    `
                    <div id="hijascontenido">
                    <div id=${data[i].id}>
                    <div id ="texto1">${data[i].title}</div>
                    <div id= "texto2">${data[i].message}</div>
                    <div id= "texto3">${data[i].category}</div>
                    
                    <div class="like">
                            <button id="megusta">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
                                    <path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
                                    </svg>
                                </button>
                                <input type="number" id="input1" value="0" name="">
                                <div class="basura" onclick="borrar(${data[i].id})"><img src="img/papelera.png" alt="botonclic"></div>
                                </div>
                            </div>
                    `  
                    let megusta =document.querySelector('#megusta');
                    let input=document.querySelector('#input1');
                    megusta.addEventListener('click',()=>{
                    input.value=parseInt(input.value)+1;
                    })
                     
            }
        }})
}

function limpiarCampos (){

    document.querySelector("input").focus();
    document.querySelector("#title").value = "";
    document.querySelector("#message").value = "";
}

function limpiar (){

    document.getElementById("contenido").innerHTML="";
}

function borrar(a){

    fetch('http://18.208.234.250:5010/demo-0.0.1-SNAPSHOT/notes/' + a, {
        method: 'DELETE',
    })
        .then(res => res.json())
        .then(res => {
            console.log(res);
            
        });
        document.getElementById(a).style.display = "none"; 
}


