function Fill_JSON(req){
    var  xx = eval('('+req.responseText+')');
    var rc = "";
    for (var i = 0; i < xx.X.length; i++){
        rc += (xx.X[i].rand +" ");
    }
    return (rc);
}

$(document).ready(function() {
    $("#btnSubmit").click(function(e) {
        $.ajax({
            type: "POST",
            url: "http://localhost:8081/lab20/sss_json",
            beforeSend: function(request) {
                request.setRequestHeader("XRand-N", $("#numb").val());
            },
            // success: function(req) {
            //     let s = document.getElementById('jquery');
            //     s.firstChild.data = Fill_JSON(req);
            //     console.log(s);
            //     s.className ="h1";
            // },
            // error: function(req) {
            //     alert('error');
            // },
            complete: function (req) {
                let s = document.getElementById('jquery');
                s.firstChild.data = Fill_JSON(req);
                console.log(req);
                s.className ="h1";
            }
        });
    });
});
