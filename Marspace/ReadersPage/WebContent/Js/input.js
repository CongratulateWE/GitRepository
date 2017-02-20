//JScript 文件
function OnfocusTextBox(txtBox, defText) {
    txtBox.style.backgroundColor = "#FFFFE0";
    if (txtBox.value == defText) {
        txtBox.value = "";
    }
}

function OnblurTextBox(txtBox, defText) {
    txtBox.style.backgroundColor = "#FFFFFF";
    if (txtBox.value == "") {
        txtBox.value = defText;
    }
}