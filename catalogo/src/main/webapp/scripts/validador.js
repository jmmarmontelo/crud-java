/**
 * 
 */
 
 function validar(){
	let nome = frmFilme.nome.value
	let ano = frmFilme.ano.value
	if(nome === ""){
		alert('Preencha o campo nome')
		frmFilme.nome.focus()
		return false
	}else if(ano === ""){
		alert('Preencha o campo ano')
		frmFilme.ano.focus()
		return false
	}else{
		document.forms["frmFilme"].submit()
	}
}