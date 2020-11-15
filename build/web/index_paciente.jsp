<%-- 
    Document   : index
    Created on : 7/10/2020, 20:42:03
    Author     : Dlope
--%>

<%@page import="modeloPaciente.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Paciente</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    </head>
    
    
    
    
    <body>
        
        <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
    
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="principal.jsp">Bienvenido Administrador de MEDIUMG</a>
                <button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="index_paciente.jsp">PACIENTES</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="index_personal.jsp">PERSONAL</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="index_medicina.jsp">MEDICINA</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Masthead-->
        <header class="masthead bg-primary text-white text-center">
            <div class="container d-flex align-items-center flex-column">
                <!-- Masthead Avatar Image-->
                <img class="masthead-avatar mb-5" src="assets/img/avataaars.svg" alt="" />
                <!-- Masthead Heading-->
                <h1 class="masthead-heading text-uppercase mb-0">Formulario Paciente</h1>
                <!-- Icon Divider-->
                <div class="divider-custom divider-light">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Masthead Subheading-->
                <p class="masthead-subheading font-weight-light mb-0">En donde tu SALUD es lo mas importanter</p>
            </div>
        </header>
   
        
        <div class="modal fade" id="modal_paciente" role="dialog">
    <div class="modal-dialog">
    
        
       <div class="modal-content">
        
        <div class="modal-body">
           <form action="sr_paciente" method="post" class="form-group">
                <label for="lbl_id" ><b>ID</b></label>
                <input type="text" name="txt_id" id="txt_id" class="form-control" value="0" readonly> 
                <label for="lbl_dpi"><b>DPI</b> </label>
                <input type="text" name="txt_dpi" id="txt_dpi" class="form-control" placeholder="Ejemplo: 3448176950301" required>
                <label for="lbl_nombres"><b> Nombres</b> </label>
                <input type="text" name="txt_nombres" id="txt_nombre" class="form-control" placeholder="Ejemplo: Denis Donaldo" required>
                <label for="lbl_apellidos"><b> Apellidos</b> </label>
                <input type="text" name="txt_apellidos" id="txt_apellidos" class="form-control" placeholder="Ejemplo: Lopez Archila" required>
                <label for="lbl_fn"><b> Fecha de Nacimiento</b> </label>
                <input type="date" name="txt_fn" id="txt_fn" class="form-control" required>
                <label for="lbl_genero"><b> Genero</b> </label>
                <input type="text" name="txt_genero" id="txt_genero" class="form-control" placeholder="Ejemplo: Femenino o Masculino" required>
                <label for="lbl_direccion"><b>Direccion</b> </label>
                <input type="text" name="txt_direccion" id="txt_direccion" class="form-control" placeholder="Ejemplo: Antigua Guatemala" required>
                <label for="lbl_telefono"><b> Telefono</b> </label>
                <input type="text" name="txt_telefono" id="txt_telefono" class="form-control" placeholder="Ejemplo: 12345678" required>
                <br>
                <button  name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">Agregar</button>
                <button  name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success">Modificar</button>
                <button  name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger" onclick="javascript:if(!confirm('¿Desea Eliminar?'))return false">eliminar</button>
                <button  name="button" class="btn btn-warning" data-dismiss="modal">Cerrar</button>

            </form>
            
        </div>
      
      </div>
      
    </div>
  </div>
  
</div>
           
            
      

<table class="table">
  <thead class="thead-light">
      <tr>
          <td>
               <div class="container">
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modal_paciente" onclick="limpiar()">Nuevo</button>
          </td>
      </tr>
    <tr>
      <th>DPI</th>
      <th>Nombres</th>
      <th>Apellidos</th>
      <th>Nacimiento</th>
      <th>Genero</th>
      <th>Direccion</th>
      <th>Telefono</th>
    </tr>
  </thead>
  <tbody id="tbl_paciente">
  
      <% 
        Paciente paciente = new Paciente();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla = paciente.leer();
        for (int t=0;t<tabla.getRowCount();t++){
          out.println("<tr data-id="+ tabla.getValueAt(t,0)+">");
          out.println("<td>"+ tabla.getValueAt(t,1) +"</td>");
          out.println("<td>"+ tabla.getValueAt(t,2) +"</td>");
          out.println("<td>"+ tabla.getValueAt(t,3) +"</td>");
          out.println("<td>"+ tabla.getValueAt(t,4) +"</td>");
          out.println("<td>"+ tabla.getValueAt(t,5) +"</td>");
          out.println("<td>"+ tabla.getValueAt(t,6) +"</td>");
          out.println("<td>"+ tabla.getValueAt(t,7) +"</td>");
          out.println(" </tr>");
          }
          %>
      
  </tbody>
</table>
            
        </div>
        
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script type="text/javascript">
    function limpiar(){
        $("#txt_id").val(0);
       $("#txt_dpi").val('');
       $("#txt_nombre").val('');
       $("#txt_apellidos").val('');
       $("#txt_fn").val('');
       $("#txt_genero").val('');
       $("#txt_direccion").val('');
       $("#txt_telefono").val('');  
    }
    
    $('#tbl_paciente').on('click','tr td',function(evt){
        var target,id,dpi,nombres,apellidos,nacimiento,genero,direccion,telefono;
        target = $(event.target);
        id = target.parent().data('id');
        dpi = target.parent("tr").find("td").eq(0).html();
        nombres = target.parent("tr").find("td").eq(1).html();
        apellidos = target.parent("tr").find("td").eq(2).html();
        nacimiento = target.parent("tr").find("td").eq(3).html();
        genero = target.parent("tr").find("td").eq(4).html();
        direccion = target.parent("tr").find("td").eq(5).html();
        telefono = target.parent("tr").find("td").eq(6).html();
        $("#txt_id").val(id);
        $("#txt_dpi").val(dpi);
        $("#txt_nombre").val(nombres);
        $("#txt_apellidos").val(apellidos);
        $("#txt_fn").val(nacimiento);
        $("#txt_genero").val(genero);
        $("#txt_direccion").val(direccion);
        $("#txt_telefono").val(telefono);
        $("#modal_paciente").modal('show');
        
    } );
    
</script>
      <button type="button" class="btn btn-info btn-lg" >
          <%
    HttpSession sesion = request.getSession();
    String usuario;
    String nivel;
    
    if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel")!=null){
    usuario = sesion.getAttribute("user").toString();
    nivel =sesion.getAttribute("nivel").toString();
    out.println("<a href='index.jsp?cerrar=true'><h5>Cerrar sesion</h5></a>");
   
    
    }else{
        out.println("<script>location.Replace('index.jsp')</script>");
        }
    
    %>
        </button>

 <!-- Copyright Section-->
        <div class="copyright py-4 text-center text-white">
            <div class="container"><small>Copyright © MEDIUMG GRUPO #5 DENIS LOPEZ - RONY GOMEZ - HERBER OCHOA - ALEJANDRA RAMOS - RICARDO MEJIA 2020</small></div>
        </div>
        <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes)-->
        <div class="scroll-to-top d-lg-none position-fixed">
            <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top"><i class="fa fa-chevron-up"></i></a>
        </div>
        
        
        <!-- Bootstrap core JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Contact form JS-->
        <script src="assets/mail/jqBootstrapValidation.js"></script>
        <script src="assets/mail/contact_me.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    
    </body>
</html>
