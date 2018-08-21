window.dot=document.getElementById(arguments[0]);
document.body.onclick = function(e) {
    console.log(e);
    dot.style.left = (e.clientX - dot.width / 2) + 'px';
    dot.style.top = (e.clientY - dot.height / 2) + 'px';
};
