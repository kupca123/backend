var elements = document.getElementById('newsTable').rows;
for(var i = 0; i < elements.length; i++)
{
(elements)[i].addEventListener("click", function(){

let idCell = this.cells.namedItem("idCell").innerHTML;

window.location.replace("/admin/news/editNews/" + idCell);

});
}

