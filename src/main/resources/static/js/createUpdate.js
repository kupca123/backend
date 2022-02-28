//let imgInput = document.getElementById('imageInput');
//    imgInput.addEventListener('change', function(e) {
//      if(e.target.files) {
//        let imageFile = e.target.files[0]; //here we get the image file
//        var reader = new FileReader();
//        reader.readAsDataURL(imageFile);
//        reader.onloadend = function (e) {
//          var myImage = new Image(); // Creates image object
//          myImage.src = e.target.result; // Assigns converted image to image object
//
//          myImage.onload = function(ev) {
//
//          loadImage(myImage);
//          }
//
//        }
//      }
//    });


   let imgInput = document.getElementById('imageInput');
    imgInput.addEventListener('change', function(e) {
      if(e.target.files) {
        let imageFile = e.target.files[0]; //here we get the image file
        var reader = new FileReader();
        reader.readAsDataURL(imageFile);
        reader.onloadend = function (e) {
//          var myImage = new Image(); // Creates image object
          var myImage = document.getElementById("newsImg") // Creates image object
          myImage.src = e.target.result; // Assigns converted image to image object

          myImage.onload = function(ev) {

          loadImage(myImage);
          }

        }
      }
    });


     const newsImg = document.getElementById("newsImg");
     newsImg.onload = function(e) {
     loadImage(newsImg);
    }

    function loadImage(image){
    var myCanvas = document.getElementById("imageCanvas"); // Creates a canvas object
                var myContext = myCanvas.getContext("2d"); // Creates a contect object
//                myCanvas.width = image.width; // Assigns image's width to canvas
//                myCanvas.height = image.height; // Assigns image's height to canvas
                myContext.drawImage(image,0,0,200, 200 * image.height / image.width); // Draws the image on canvas
                let imgData = myCanvas.toDataURL("image/jpeg",0.75); // Assigns image base64 string in jpeg format to a variable

    }

    function setEditableForm() {
        document.getElementById("saveButton").style.display = "inline";
        document.getElementById("editButton").style.display = "none";
        document.getElementById("nameInput").readOnly  = false;
        document.getElementById("categoryInput").disabled  = false;
        document.getElementById("imageInput").disabled  = false;
        document.getElementById("perexTextarea").readOnly  = false;
        document.getElementById("textOfNewsTextarea").readOnly  = false;


    }