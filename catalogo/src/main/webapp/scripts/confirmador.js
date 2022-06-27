
 function confirmar(id){
	let resposta = confirm("confirma a exclusão deste filme ?")
	if(resposta === true){
		//alert(id)
		window.location.href = "delete?id=" + id
	}
}