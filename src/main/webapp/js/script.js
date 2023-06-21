function get(id) {
	return document.getElementById(id);
}

function validate(id) {
	var valid = true;
  var listName;  
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