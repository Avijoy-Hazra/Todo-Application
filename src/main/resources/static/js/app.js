$(function(){
    $("a.confirmDelete").click(function(){
        if(!confirm("Confirm deletion"))
            return false;
    })
});