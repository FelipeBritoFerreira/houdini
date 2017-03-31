/**
 * Created by FBF0113 on 09/02/2017.
 */

var btEnviar = '<button type="submit" class="btn btn-default">Enviar</button>';
var btEnviando = '<button type="submit" class="btn btn-default">Enviando...</button>';
var erroEnvioMensagem = '<div class="alert alert-danger alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Desculpe o transtorno.</strong> Entre em contato pelo  <a href="https://www.instagram.com/houdini.art.br/?hl=pt-br" target="_blank" > Instagram </a>   <i class="fa fa-smile-o"></i> </div>';
var msgEnviada = '<div class="alert alert-success alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>Obrigado pelo contato, responderei em breve. <i class="fa fa-smile-o"></i> </div>';

var progressBarGaleria ='<div class="col-sm-4"></div><div class="alert alert-success col-sm-4" role="alert">buscando <img  src="/img/sunny.gif"  > galerias</div><div class="col-sm-4"></div>';




//Busca o nome das galerias assim que faz load do HTML
angular.module('home',[])


    //Controller que popula os thumbnails na tela
    .controller('galeriasThumbnails', function($scope, $http) {

        var nomesGalerias; var galerias = [];
        $http.get('http://localhost:9090/galeria/listarNomes').then(function(response) {
            nomesGalerias = response.data;
            angular.forEach(nomesGalerias, function(value, key) {
                $http.get('http://localhost:9090/galeria/buscarPorNome?nomeGaleria='+value).then(function(response) {
                    galerias.push(response.data);
                })
            })
            console.log(galerias);
            $scope.sortType = 'nomeGaleria';
            $scope.sortReverse = false;
            $scope.galeria = galerias;

        });
    })


    .controller('galeriaImagensNomes', function($scope, $http) {
        $http.get('http://localhost:9090/galeria/listarNomes').then(function (response) {
            $scope.listaNomeGalerias = response.data;
        })
    })


    .controller('informacoesGaleriaClick', ['$scope', '$http', function ($scope, $http) {
        $scope.buscarInformacoes = function () {
            var nomeGaleria = $('#nomeGaleria').val();
            $http.get('http://localhost:9090/galeria/buscarPorNome?nomeGaleria='+nomeGaleria).then(function (response) {
                $scope.informacoes = response.data;
            })
        }

    }])




;












$(document).ready(function($) {


    //envio email
    $('#div-bt-enviar').html(btEnviar);
    $("#email-form").submit(function(event) {
        $('#div-bt-enviar').html(btEnviando);
        //Previne o envio do formulario via browser
        event.preventDefault();
        enviarEmail();
    });
    //#envio email



    //envio arquivo
    $("#form-arquivo").submit(function(event) {
        //Previne o envio do formulario via browser
        event.preventDefault();
        enviarArquivos();
    });


    //Parar todos os videos quando qualquer modal for fechado
    $('.modal').on('hide.bs.modal', function () {

        var idModal =  ($(this).attr('id'));

        $('#'+idModal + ' iframe').each( function(index, value) {
            var idThis = $(this).attr('id');
            $('#'+idThis).attr('src', $('#'+idThis).attr('src'));
        });
    });




    //Adiciona arquivos à div
    var cont = 0;
    $('.adicionar-arquivo').click(function (e) {
        cont = cont + 1;
        e.preventDefault();
        var input = '<div class="input-group" id="divwrapper-'+cont+'"><div class="input-group-addon text-center" id="teste" style="padding: 0"> <span id="span-remover-'+cont+'" class="remover-arquivo" style="color: darkred" onclick="removerArquivo(this)">remover</span></div><input type="file" name="arquivoupload"></div>'
        $('.input-fields-wrapper').append(input);

    })




});



function removerArquivo(elemento) {

    var id = elemento.id;

    alert(id);
}




/**
 * Busca uma galeria
 *
 * @param nomeGaleria
 */
function buscarGaleria(nomeGaleria) {

    $.ajax({
        type : "GET",
        url : "/galeria/listarImagens?nomeGaleria="+nomeGaleria,
        beforeSend : function() {
            $("#galeria-loader").html(progressBarGaleria);
        },
        success : function(data) {
            $("#galeria-loader").html(data);
        },
        error : function(e) {
            $("#galeria-loader").html("Erro ao buscar a galeria");
            console.log(e);
        }
    })
    ;


}






/**
 * Envia email
 *
 */
function enviarEmail() {

    var objeto = {}
    objeto["nome"] = $("#nome").val();
    objeto["email"] = $("#email").val();
    objeto["assunto"] = $("#assunto").val();
    objeto["mensagem"] = $("#mensagem").val();

    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/email",
        data : JSON.stringify(objeto),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            respostaEnvioEmail(data);
        },
        error : function(e) {
            respostaEnvioEmail(e);
        }
    });

}



/**
 * Obtém a resposta do envio do email
 *
 * @param data
 */
function respostaEnvioEmail(data) {
    var json = JSON.parse(  JSON.stringify(data, null, 4)  );

    if (!json.erro) {//caso sucesso no envio
        $('#div-bt-enviar').html(btEnviar);
        $('#feedback').html(msgEnviada);
        $("#email-form")[0].reset();
    } else {
        $('#div-bt-enviar').html(btEnviar);
        $('#feedback').html(erroEnvioMensagem);
    }


}




/**
 * Envia arquivos para o serviço
 *
 */
function enviarArquivos() {

    var file = $('[name="arquivos"]');
    var nomeGaleria = $('[name="nomeGaleria"]');

    var dataForm = new FormData(document.getElementById("form-arquivo"));

    $.ajax({
        type : "POST",
        contentType : false,
        enctype: "multipart/form-data",
        url : "/galeria/upload",
        data : dataForm,
        dataType : 'json',
        processData: false,
        timeout : 100000,
        success : function(data) {
            alert("sucesso");
            $('#form-arquivo')[0].reset();
        },
        error : function(e) {
            console.log(e);
            $('#form-arquivo')[0].reset();
        }
    });

}



