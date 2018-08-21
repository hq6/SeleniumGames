window.dot=document.getElementById(arguments[0]);
document.body.onclick = function(e) {
    console.log(e);
    dot.style.left = e.clientX + 'px';
    dot.style.top = e.clientY + 'px';
};
