    <footer class="py-5 bg-dark">
        <div class="container">
            <p class="m-0 text-center text-white">2019 - Tous droits réservés -</p>
        </div>
      <!-- /.container -->
      <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
       <script>
        $(document).ready(function(){

        $("nav li a").click(function(){
           $("nav li a").find(".active").removeClass("active");
           $(this).addClass("active");
           
           console.log("je fais des choses " + this);
        });
      });
       
    </script>
    </footer>

    
   
