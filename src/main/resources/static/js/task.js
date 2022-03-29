var task = (function(){

    function getData(){
        $.ajax({
            type:"GET",
            url: "http://localhost:8080/api/task"
        }).then(function(data){
            
        });
    }
})();