<%%>
function ClickCheckAll(checkAll) {

	let checkBoxItem = document.getElementsByName('checkBoxItem');
	for (let i = 0; i < checkBoxItem.length; i++) {
		checkBoxItem[i].checked = checkAll.checked;
	}
}

function ClickDelete() {
	let checkBoxItem = document.getElementsByName('checkBoxItem');
	let ok = false;
	let count = 0;
	for (let i = 0; i < checkBoxItem.length; i++) {
		if (checkBoxItem[i].checked == false) {
			count++;
		}
	}
	if (checkBoxItem.length == count) {
		ok = false;
		alert("Please select customerId");
	} else {
		ok = true;
	}
	return ok;
}