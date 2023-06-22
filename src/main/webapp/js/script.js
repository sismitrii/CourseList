function get(id) {
	return document.getElementById(id);
}

function validate(id) {
	let valid = true;
  let listName;  
  if(get("listName"+id) != null) {
		listName = get("listName"+id).value;
	  if(listName != null && listName != "") {
			alert(listName);
		} else {
			alert("Le nom de la liste ne peux pas être vide");
			valid = false;
		}
	}
	
  if(!valid) {
      return false;
  }
  else {
    if (confirm('Êtes vous sûr de vouloir renommer la liste en "' + listName + '" ?')) {
			get('list'+ id).submit();
		}
  }
}

function validateNewArticle() {
	
}

function confirmListDeletion(id) {
	let result = false
	if(confirm('Êtes vous sûr de vouloir supprimer la liste ?')) {
		get('deleteListForm'+ id).submit();
		result = true;
	}
	return result;
}

function toggleEditName(bool){
		const editNameIcon = get("editNameIcon");
		const validateName = get("validateName");
		const resetName = get("resetName");
		const listName = get("listName");
		
	if (bool == true){
		editNameIcon.hidden = true;
		validateName.hidden = false;
		resetName.hidden = false;
		listName.disabled = false;
	} else if (bool == false){
		editNameIcon.hidden = false;
		validateName.hidden = true;
		resetName.hidden = true;
		get("manageListForm").reset();
		listName.disabled = true;
	}
}

function changeName(){
	
	if(confirm(`Êtes vous sûr de vouloir changer le nom de la liste ?`)) {
		get('rename').value = 1;
		get('manageListForm').submit();
		return true;
	}
	return false
}


function confirmListReset() {
	var result = false
	if(confirm('Êtes vous sûr de vouloir réinitialiser la liste ?')) {
		get('listReset').submit();
		result = true;
	}
	return result;
}
