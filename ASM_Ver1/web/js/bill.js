function pagger(id,pageindex,totalpage)
{
    container = document.getElementById(id);
    var result = '';
    result += 'Trang:<input id="pageindex_input" type="text" value="'+pageindex+'"/> Tổng Số Trang: '+totalpage;
    container.innerHTML = result;
    
    var input = document.getElementById("pageindex_input");

    input.addEventListener("keyup", function(event) {
      if (event.keyCode === 13) {
            window.location.href = 'bill?page='+input.value; 
      }
    });
}

