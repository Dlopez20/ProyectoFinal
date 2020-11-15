<%-- 
    Document   : index
    Created on : 11/08/2020, 15:53:07
    Author     : paiz2
--%>

<%@page import="modeloCita.Cita" %>
<%@page import="modeloCita.Paciente" %>
<%@page import="modeloCita.Sucursal" %>
<%@page import="modeloCita.Habitacion" %>
<%@page import="modeloCita.Personal" %>
<%@page import="modelo.Conexion" %>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Sistema Medico MediUmG</title>
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
                <a class="navbar-brand js-scroll-trigger" href="secundario.jsp">Clinica Medica MediUMG</a>
                <button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="somos.jsp">Quienes Somos</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="servicios.jsp">Servicios</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="index_cita.jsp">Crea tu Cita</a></li>
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
                <h1 class="masthead-heading text-uppercase mb-0">MediUMG</h1>
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
      
    <div class="container">
          <div class="modal fade" id="modal_cita" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
            <form action="sr_cita" method="post" class="form-group">
               <label for="lbl_id" ><b>ID</b></label>
                <input type="text" name="txt_id" id="txt_id" class="form-control" value="0"  readonly>
                <label for="lbl_fecha_cita" ><b>Fecha_cita</b></label>
                <input type="date" name="txt_fecha_cita" id="txt_fecha_cita" class="form-control" required>
                <label for="lbl_fecha_salida" ><b>Fecha_salida</b></label>
                <input type="date"  name="txt_fecha_salida" id="txt_fecha_salida" class="form-control" required>
                <label for="lbl_paciente" ><b>Paciente</b></label>
                <select name="drop_paciente" id="drop_paciente" class="form-control">
                    <% 
                        Paciente paciente = new Paciente();
                        HashMap<String,String> drop = paciente.drop_paciente();
                         for (String i:drop.keySet()){
                             out.println("<option value='" + i + "'>" + drop.get(i) + "</option>");
                         }
                    %>
                </select>
                <label for="lbl_sucursal" ><b>Sucursal</b></label>
                <select name="drop_sucursal" id="drop_sucursal" class="form-control">
                    <% 
                        Sucursal sucursal = new Sucursal();
                        HashMap<String,String> drop1 = sucursal.drop_sucursal();
                         for (String i:drop1.keySet()){
                             out.println("<option value='" + i + "'>" + drop1.get(i) + "</option>");
                         }
                         
                    
                    %>
                </select>
                <label for="lbl_habitacion" ><b>Habitacion</b></label>
                <select name="drop_habitacion" id="drop_habitacion" class="form-control">
                    <% 
                        Habitacion habitacion = new Habitacion();
                        HashMap<String,String> drop2 = habitacion.drop_habitacion();
                         for (String i:drop2.keySet()){
                             out.println("<option value='" + i + "'>" + drop2.get(i) + "</option>");
                         }
                         
                    
                    %>
                </select>
                <label for="lbl_personal" ><b>Personal</b></label>
                <select name="drop_personal" id="drop_personal" class="form-control">
                    <% 
                        Personal personal = new Personal();
                        HashMap<String,String> drop3 = personal.drop_personal();
                         for (String i:drop3.keySet()){
                             out.println("<option value='" + i + "'>" + drop3.get(i) + "</option>");
                         }
                         
                    
                    %>
                </select>
                
                
                <br>
                <button name="btn_agregar" id="btn_agregar"  value="agregar" class="btn btn-primary btn-lg">Agregar</button>
                <button type="button" class="btn btn-warning btn-lg" data-dismiss="modal">Cerrar</button>
            </form>
        </div>
      </div>
      
    </div>
  </div>
        
        
           
    <table class="table table-striped">
    <thead>
        <tr>
            <th>  <h1>Formulario Cita</h1>
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modal_cita" onclick="limpiar()">Nuevo</button>
        </th>
        </tr>
      <tr>
        <th>Fecha_cita</th>
        <th>Fecha_salida</th>
        <th>Paciente</th>
        <th>Sucursal</th>
        <th>Habitacion</th>
        <th>Personal</th>
      </tr>
    </thead>
    <tbody id="tbl_cita">
        <% 
        Cita cita = new Cita();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla = cita.leer();
        for (int t=0;t<tabla.getRowCount();t++){
            out.println("<tr data-id=" + tabla.getValueAt(t,0) + " data-id_p=" + tabla.getValueAt(t,1) + " data-id_s=" + tabla.getValueAt(t,2) + " data-id_h=" + tabla.getValueAt(t,3) + " data-id_pe=" + tabla.getValueAt(t,4) + ">");
            out.println("<td>" + tabla.getValueAt(t,5) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,6) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,7) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,8) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,9) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,10) + "</td>");
            out.println("</tr>");
        
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
       $("#drop_paciente").val(0);
       $("#drop_sucursal").val(0);
       $("#drop_habitacion").val(0);
       $("#drop_personal").val(0);
       $("#txt_fecha_cita").val('');
       $("#txt_fecha_salida").val('');
    }
    
    $('#tbl_cita').on('click','tr td',function(evt){
       var target,id,id_p,id_s,id_h,id_pe,fecha_cita,fecha_salida; 
       target = $(event.target);
       id = target.parent().data('id');
       id_p = target.parent().data('id_p');
       id_s = target.parent().data('id_s');
       id_h = target.parent().data('id_h');
       id_pe = target.parent().data('id_pe');
       fecha_cita = target.parent("tr").find("td").eq(0).html();
       fecha_salida = target.parent("tr").find("td").eq(1).html();
       $("#txt_id").val(id);
       $("#drop_paciente").val(id_p);
       $("#drop_sucursal").val(id_s);
       $("#drop_habitacion").val(id_h);
       $("#drop_personal").val(id_pe);
       $("#txt_fecha_cita").val(fecha_cita);
       $("#txt_fecha_salida").val(fecha_salida);
       $("#modal_cita").modal('show');
    });
    
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
    </body>
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
    
    
    
</html>
