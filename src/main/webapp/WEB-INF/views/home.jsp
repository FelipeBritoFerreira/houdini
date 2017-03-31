<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>





<html lang="en">



<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Houdini</title>


    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />

    <link rel="stylesheet" href="css/houdini.css">


    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">

    <!-- Theme CSS -->
    <link href="css/grayscale.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


    <script src="/resources/assets/gallery/jquery.blueimp-gallery.min.js"></script>

    <link rel="stylesheet" href="resources/assets/gallery/blueimp-gallery.min.css">
    <link rel="stylesheet" href="resources/assets/animate/animate.css">
    <link rel="stylesheet" href="resources/assets/animate/set.css">


    <script src="/js/angular.1.6.3.min.js"></script>


</head>






<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

<!-- Navigation -->
<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                Menu <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand page-scroll" href="https://www.instagram.com/houdini.art.br/?hl=pt-br" target="_blank" >
                <i class="fa fa-instagram"></i>
            </a>
            <a class="navbar-brand page-scroll" href="#page-top">
                <i class="fa fa-home"></i>
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
            <ul class="nav navbar-nav">
                <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                <li class="hidden">
                    <a href="#page-top"></a>
                </li>
                <li>
                    <a class="page-scroll" href="#about">Houdini</a>
                </li>
                <li>
                    <a class="page-scroll" href="#cases">Cases</a>
                </li>
                <li>
                    <a class="page-scroll" href="#contact">Contato</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>



<!-- Intro Header -->
<header class="intro">
    <div class="intro-body">
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                </div>
            </div>
        </div>
    </div>
</header>






<!-- About Section -->
<section id="about" class="container content-section text-center">

    <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
            <h2>Houdini</h2>
            <p><strong>Houdini</strong> Houdini é um estúdio criativo que desenvolve experiências de marca, Ilustrações 3d, Arquitetura e Efeitos Visuais.</p>
            <p>Nossa proposta é entender e desenvolver com criatividade e tecnologia, traduzindo conceitos, materializando sonhos e ideias com know how e objetividade.</p>
            <p>Fique à vontade. Navegue e nos conte um pouco do que o trouxe até nos. :) </p>
        </div>
    </div>
</section>




<!-- Cases Section -->
<section id="cases" class="content-section text-center">

    <h2>Cases</h2>

    <div class="container">

        <!-- works -->
        <div id="galeria"  class=" clearfix grid ensaio-galeria">


            <!-- CAMPANHAS -->
            <div id="galeria-0" data-toggle="modal" data-target="#galeria_campanhas">
                <figure class="effect-oscar  wowload fadeInUp">
                    <img src="img/galeria/campanhas/capa.jpg" alt="Nissan"/>
                    <figcaption>
                        <p class="posicao-uma-linha">
                            <span class="titulo-thumbnail">Campanhas</span>
                        </p>
                    </figcaption>
                </figure>
            </div>

            <!-- ArchViz -->
            <div data-toggle="modal" data-target="#galeria_archviz">
                <figure class="effect-oscar  wowload fadeInUp">
                    <img src="/img/galeria/archviz/capa.jpg" />
                    <figcaption>
                        <p class="posicao-uma-linha">
                            <span class="titulo-thumbnail">CGI & Archviz</span>
                        </p>
                    </figcaption>
                </figure>
            </div>

            <!-- Rock in Rio -->
            <div data-toggle="modal" data-target="#galeria_rockinrio">
                <figure class="effect-oscar  wowload fadeInUp">
                    <img src="/img/galeria/rockinrio/capa.jpg" />
                    <figcaption>
                        <p class="posicao-uma-linha">
                            <span class="titulo-thumbnail">Rock in Rio</span>
                        </p>
                    </figcaption>
                </figure>
            </div>


            <!-- NISSAN -->
            <div id="galeria-1" data-toggle="modal" data-target="#galeria_nissan">
                <figure class="effect-oscar  wowload fadeInUp">
                    <img src="img/galeria/nissan/capa.jpg" />
                    <figcaption>
                        <p class="posicao-duas-linha">
                            <span class="titulo-thumbnail">Nissan Rio 2016</span>
                        </p>
                    </figcaption>
                </figure>
            </div>

            <!-- MANO A MANO -->
            <div id="galeria-2" data-toggle="modal" data-target="#galeria_manoamano">
                <figure class="effect-oscar  wowload fadeInUp">
                    <img src="/img/galeria/manoamano/capa.jpg" alt="Mano a Mano"/>
                    <figcaption>
                        <p class="posicao-uma-linha">
                            <span class="titulo-thumbnail">Mano a Mano</span>
                        </p>
                    </figcaption>
                </figure>
            </div>

            <!-- VINHOS DE PORTUGUAL -->
            <div id="galeria-3" data-toggle="modal" data-target="#galeria_vinhosdeportugal">
                <figure class="effect-oscar  wowload fadeInUp">
                    <img src="/img/galeria/vinho/capa.jpg" alt="Vinho"/>
                    <figcaption>
                        <p class="posicao-duas-linha">
                            <span class="titulo-thumbnail">Vinhos de Portugal</span>
                        </p>
                    </figcaption>
                </figure>
            </div>

            <!-- VERAO O GLOBO -->
            <div id="galeria-4" data-toggle="modal" data-target="#galeria_veraooglobo">
                <figure class="effect-oscar  wowload fadeInUp">
                    <img src="/img/galeria/verao/capa.jpg" alt="Vinho"/>
                    <figcaption>
                        <p class="posicao-duas-linha">
                            <span class="titulo-thumbnail">Verão O Globo</span>
                        </p>
                    </figcaption>
                </figure>
            </div>

            <!-- RODA SKOL-->
            <div data-toggle="modal" data-target="#galeria_rodaskol">
                <figure class="effect-oscar  wowload fadeInUp">
                    <img src="/img/galeria/rodaskol/capa.jpg" alt="Roda Skol"/>
                    <figcaption>
                        <p class="posicao-duas-linha">
                            <span class="titulo-thumbnail">Roda Gigante Skol</span>
                        </p>
                    </figcaption>
                </figure>
            </div>

            <!-- FRIBOI-->
            <div data-toggle="modal" data-target="#galeria_friboi">
                <figure class="effect-oscar  wowload fadeInUp">
                    <img src="/img/galeria/friboi/capa.jpg" alt="Friboi"/>
                    <figcaption>
                        <p class="posicao-uma-linha">
                            <span class="titulo-thumbnail">Friboi</span>
                        </p>
                    </figcaption>
                </figure>
            </div>




        </div>
        <!-- works -->

    </div>
</section>










<!-- SECTION -CONTATO -->
<section id="contact" class="contact-section container content-section text-center">

    <div class="row">
        <div class="col-xs-4"></div>
        <div class="col-xs-4">
            <h2>Contato</h2>
            <p>Fique à vontade para entrar em contato conosco.
                <br>Ideias? Sugestões? Parcerias? Conta pra gente!</p>
        </div>
        <div class="col-xs-4"></div>
    </div>


    <div class="row"><!-- GRID DO FORM -->
        <div class="col-xs-4"></div>
        <div class="col-xs-4">
            <form id="email-form">

                <div class="row ">
                    <div class="col-xs-12">
                        <div class="form-group">
                            <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome">
                        </div>
                    </div>
                </div>
                <div class="row ">
                    <div class="col-xs-12">
                        <div class="form-group">
                            <input type="email" class="form-control" id="email" name="email" placeholder="Email">
                        </div>
                    </div>
                </div>
                <div class="row ">
                    <div class="col-xs-12">
                        <div class="form-group">
                            <input type="text" class="form-control" id="assunto" name="assunto" placeholder="Assunto">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="form-group">
                            <textarea class="form-control" rows="9" name="mensagem" id="mensagem" placeholder="Mensagem"></textarea>
                        </div>
                    </div>
                </div>

                <div id="div-bt-enviar"></div>

            </form>

            <br>

            <div id="feedback"></div>

        </div>
        <div class="col-xs-4"></div>
    </div><!-- GRID DO FORM -->

    <%--<div class="row"><!-- GRID DAS MIDIAS SOCIAIS -->--%>
        <%--<ul style="margin-top: 4%" class="list-inline banner-social-buttons">--%>
            <%--<li>--%>
                <%--<a href="https://www.instagram.com/houdini.art.br/?hl=pt-br" target="_blank" class="btn-lg"><i class="fa fa-instagram fa-fw"></i></a>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<a href="" class="btn-lg"><i class="fa fa-facebook fa-fw disabled"></i></a>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<a href="" class="btn-lg"><i class="fa fa-twitter fa-fw disabled"></i></a>--%>
            <%--</li>--%>
        <%--</ul>--%>
    <%--</div><!-- GRID DAS MIDIAS SOCIAIS -->--%>

</section>






<!-- Footer -->
<footer style="margin-top: 10%">
    <div class="container text-center">
        <p>Copyright 2017 &copy; houdini </p>
    </div>
</footer>






<!-- jQuery -->
<script src="vendor/jquery/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Plugin JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>


<!-- Theme JavaScript -->
<script src="js/grayscale.min.js"></script>

<!-- gallery -->
<script src="resources/assets/gallery/jquery.blueimp-gallery.min.js"></script>

<!-- custom script -->
<script src="resources/assets/script.js"></script>

<script src="/js/houdini.js"></script>




<jsp:include page="modal_manoamano.jsp" />
<jsp:include page="modal_vinhos.jsp" />
<jsp:include page="modal_nissan.jsp" />
<jsp:include page="modal_verao.jsp" />
<jsp:include page="modal_rodaskol.jsp" />
<jsp:include page="modal_friboi.jsp" />
<jsp:include page="modal_bacardi.jsp" />
<jsp:include page="modal_riotur.jsp" />
<jsp:include page="modal_campanhas.jsp" />
<jsp:include page="modal_rockinrio.jsp" />
<jsp:include page="modal_archviz.jsp" />



</body>


</html>
