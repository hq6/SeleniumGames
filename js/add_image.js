var img = document.createElement("img");
img.src = 'data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" version="1.1" width="16" height="16"> <circle r="7" cx="8" cy="8" style="fill:red;stroke:gray;stroke-width:0.1"/> </svg>';
img.id = "reddotpointer";
img.style.zIndex = "1000";
img.style.position = "absolute";
return document.body.appendChild(img);
