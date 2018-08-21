var img = document.createElement("img");
img.src = 'data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" version="1.1" width="64" height="64"> <circle r="30" cx="32" cy="32" style="fill:red;stroke:gray;stroke-width:0.1"/> </svg>';
img.id = "reddotpointer";
img.style.position = "absolute";
document.body.appendChild(img);
return img;
