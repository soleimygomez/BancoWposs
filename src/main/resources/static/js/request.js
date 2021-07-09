
/*******************************
 *********** REQUESTS ********** 
 *******************************/

/**
* REQUESTS EGRESADOS PDF
*/
jQuery(document).on('click', '#btn-view-pdf-egresado', function (event) {

    event.preventDefault();

    var URL_ = document.getElementById("btn-view-pdf-egresado").placeholder;

    var add_tbody= document.getElementById("tbody-egresado-add-pdf-view");
    var table= document.getElementById("container-form-pdf-egresado");
    var desde = document.getElementById("desdefecha_egresado").value;
    var hasta = document.getElementById("hastafecha_egresado").value;

    URL_ = URL_ + "controllers/requests/pdf/egresado-view.php";

    console.log(URL_);

    if (desde == null || desde == 0 || hasta == null || hasta == 0) {
        Swal.fire({
            title: "Todos los campos son obligatorios.",
            showClass: {
                popup: 'animated fadeInDown faster'
            },
            hideClass: {
                popup: 'animated fadeOutUp faster'
            },
            text: "Digite la fecha inicio y fecha fin.",
            icon: "info",
            footer: "Todos los campos son obligatorios.",
            backdrop: true,
            timer: 5000,
            timerProgressBar: true,
        });
    } else {
        jQuery.ajax({

            url: URL_,
            type: 'POST',
            dataType: 'json',
            data: { "desde_fecha": desde, "hasta_fecha": hasta },

            beforeSend: function () {
            }

        })
            .done(function (respuesta) {

                if (respuesta.error) {
                    Swal.fire({
                        title: respuesta.title,
                        showClass: {
                            popup: 'animated fadeInDown faster'
                        },
                        hideClass: {
                            popup: 'animated fadeOutUp faster'
                        },
                        text: respuesta.text,
                        icon: respuesta.alert,
                        footer: respuesta.footer,
                        backdrop: true,
                        timer: 5000,
                        timerProgressBar: true,
                    });
                    table.classList.remove('visible-table');
                } else {

                    console.log(respuesta);
                    const json = JSON.parse(respuesta.egresados);
                    var tbody = "";
                    var contador= 1;

                    for (var i in json) {
                        var actualizado="NO";
                        if(json[i].actualizado==1){
                            actualizado="SI";
                        }

                        tbody+= "<tr>"+
                                    "<td>"+ contador+"</td>"+
                                    "<td>"+json[i].nombre+" "+json[i].apellido +"</td>"+
                                    "<td>"+ json[i].codigo+"</td>"+
                                    "<td>"+ json[i].email+"</td>"+
                                    "<td>"+ actualizado +"</td>"+
                                 "</tr>";
                        contador++;
                    }
                    add_tbody.innerHTML=tbody;
                    table.classList.add('visible-table');
                }


            })
            .fail(function (respuesta) {
                console.log(respuesta);
                Swal.fire({
                    title: "Error Interno",
                    showClass: {
                        popup: 'animated fadeInDown faster'
                    },
                    hideClass: {
                        popup: 'animated fadeOutUp faster'
                    },
                    text: 'Vuelva a intentarlo',
                    icon: 'error',
                    footer: 'Status: ' + respuesta.status,
                    backdrop: true,
                    timer: 5000,
                    timerProgressBar: true,
                });
                table.classList.remove('visible-table');
            })
            .always(function () {
                console.log("REQUESTS EGRESADOS PDF COMPLETED!");
            });
    }
});


/**
* REQUESTS REUNIÓN PDF
*/
jQuery(document).on('click', '#btn-view-pdf-reunion', function (event) {

    event.preventDefault();

    var URL_ = document.getElementById("btn-view-pdf-reunion").placeholder;

    var add_tbody= document.getElementById("tbody-reunion-add-pdf-view");
    var table= document.getElementById("container-form-pdf-reunion");
    var desde = document.getElementById("desdefecha_reunion").value;
    var hasta = document.getElementById("hastafecha_reunion").value;

    URL_ = URL_ + "controllers/requests/pdf/reunion-view.php";

    console.log(URL_);

    if (desde == null || desde == 0 || hasta == null || hasta == 0) {
        Swal.fire({
            title: "Todos los campos son obligatorios.",
            showClass: {
                popup: 'animated fadeInDown faster'
            },
            hideClass: {
                popup: 'animated fadeOutUp faster'
            },
            text: "Digite la fecha inicio y fecha fin.",
            icon: "info",
            footer: "Todos los campos son obligatorios.",
            backdrop: true,
            timer: 5000,
            timerProgressBar: true,
        });
    } else {
        jQuery.ajax({

            url: URL_,
            type: 'POST',
            dataType: 'json',
            data: { "desde_fecha": desde, "hasta_fecha": hasta },

            beforeSend: function () {
            }

        })
            .done(function (respuesta) {

                if (respuesta.error) {
                    Swal.fire({
                        title: respuesta.title,
                        showClass: {
                            popup: 'animated fadeInDown faster'
                        },
                        hideClass: {
                            popup: 'animated fadeOutUp faster'
                        },
                        text: respuesta.text,
                        icon: respuesta.alert,
                        footer: respuesta.footer,
                        backdrop: true,
                        timer: 5000,
                        timerProgressBar: true,
                    });
                    table.classList.remove('visible-table');
                } else {
                    const json = JSON.parse(respuesta.reuniones);
                    var tbody = "";
                    var contador= 1;

                    for (var i in json) {

                        tbody+= "<tr>"+
                                    "<td>"+ contador+"</td>"+
                                    "<td>"+json[i].tema+"</td>"+
                                    "<td>"+ json[i].fecha+"</td>"+
                                    "<td>"+ json[i].cupo_disponible+"/"+json[i].cupo+"</td>"+
                                 "</tr>";
                        contador++;
                    }
                    add_tbody.innerHTML=tbody;
                    table.classList.add('visible-table');
                }
            })
            .fail(function (respuesta) {
                console.log(respuesta);
                Swal.fire({
                    title: "Error Interno",
                    showClass: {
                        popup: 'animated fadeInDown faster'
                    },
                    hideClass: {
                        popup: 'animated fadeOutUp faster'
                    },
                    text: 'Vuelva a intentarlo',
                    icon: 'error',
                    footer: 'Status: ' + respuesta.status,
                    backdrop: true,
                    timer: 5000,
                    timerProgressBar: true,
                });
                table.classList.remove('visible-table');
            })
            .always(function () {
                console.log("REQUESTS EGRESADOS PDF COMPLETED!");
            });
    }
});


/**
* REQUESTS CAPACITACIÓN PDF
*/
jQuery(document).on('click', '#btn-view-pdf-capacitacion', function (event) {

    event.preventDefault();

    var URL_ = document.getElementById("btn-view-pdf-capacitacion").placeholder;

    var add_tbody= document.getElementById("tbody-capacitacion-add-pdf-view");
    var table= document.getElementById("container-form-pdf-capacitacion");
    var desde = document.getElementById("desdefecha_capacitacion").value;
    var hasta = document.getElementById("hastafecha_capacitacion").value;

    URL_ = URL_ + "controllers/requests/pdf/capacitacion-view.php";

    console.log(URL_);

    if (desde == null || desde == 0 || hasta == null || hasta == 0) {
        Swal.fire({
            title: "Todos los campos son obligatorios.",
            showClass: {
                popup: 'animated fadeInDown faster'
            },
            hideClass: {
                popup: 'animated fadeOutUp faster'
            },
            text: "Digite la fecha inicio y fecha fin.",
            icon: "info",
            footer: "Todos los campos son obligatorios.",
            backdrop: true,
            timer: 5000,
            timerProgressBar: true,
        });
    } else {
        jQuery.ajax({

            url: URL_,
            type: 'POST',
            dataType: 'json',
            data: { "desde_fecha": desde, "hasta_fecha": hasta },

            beforeSend: function () {
            }

        })
            .done(function (respuesta) {

                if (respuesta.error) {
                    Swal.fire({
                        title: respuesta.title,
                        showClass: {
                            popup: 'animated fadeInDown faster'
                        },
                        hideClass: {
                            popup: 'animated fadeOutUp faster'
                        },
                        text: respuesta.text,
                        icon: respuesta.alert,
                        footer: respuesta.footer,
                        backdrop: true,
                        timer: 5000,
                        timerProgressBar: true,
                    });
                    table.classList.remove('visible-table');
                } else {
                    console.log(respuesta.capacitaciones);
                    const json = JSON.parse(respuesta.capacitaciones);
                    var tbody = "";
                    var contador= 1;

                    for (var i in json) {

                        tbody+= "<tr>"+
                                    "<td>"+ contador+"</td>"+
                                    "<td>"+json[i].tema+"</td>"+
                                    "<td>"+ json[i].fecha_inicio+"</td>"+
                                    "<td>"+ json[i].cupo_disponible+" / "+json[i].cupo_total+"</td>"+
                                 "</tr>";
                        contador++;
                    }
                    add_tbody.innerHTML=tbody;
                    table.classList.add('visible-table');
                }
            })
            .fail(function (respuesta) {
                console.log(respuesta);
                Swal.fire({
                    title: "Error Interno",
                    showClass: {
                        popup: 'animated fadeInDown faster'
                    },
                    hideClass: {
                        popup: 'animated fadeOutUp faster'
                    },
                    text: 'Vuelva a intentarlo',
                    icon: 'error',
                    footer: 'Status: ' + respuesta.status,
                    backdrop: true,
                    timer: 5000,
                    timerProgressBar: true,
                });
                table.classList.remove('visible-table');
            })
            .always(function () {
                console.log("REQUESTS EGRESADOS PDF COMPLETED!");
            });
    }
});

/**
* REQUESTS UPDATE PHOTO
*/
jQuery(document).on('submit', '#update_photo_user_log', function (event) {

    event.preventDefault();

    var image= document.getElementById('image_update').placeholder;

    var _URL=image+"usuario/updatePhoto";

    jQuery.ajax({

        url: _URL,
        type: 'FILE',
        dataType: 'json',
        data: $(this),

        beforeSend: function () {
        }

    })
        .done(function (respuesta) {

            Swal.fire({
                title: respuesta.title,
                showClass: {
                    popup: 'animated fadeInDown faster'
                },
                hideClass: {
                    popup: 'animated fadeOutUp faster'
                },
                text: respuesta.text,
                icon: respuesta.alert,
                footer: respuesta.footer,
                backdrop: true,
                timer: 5000,
                timerProgressBar: true,
            });

        })
        .fail(function (respuesta) {
            console.log(respuesta);
            Swal.fire({
                title: "Error Interno",
                showClass: {
                    popup: 'animated fadeInDown faster'
                },
                hideClass: {
                    popup: 'animated fadeOutUp faster'
                },
                text: 'Vuelva a intentarlo',
                icon: 'error',
                footer: 'Status: ' + respuesta.status,
                backdrop: true,
                timer: 5000,
                timerProgressBar: true,
            });
        })
        .always(function () {
            console.log("REQUESTS UPDATE PHOTO COMPLETED!");
        });
});


/**
* REQUESTS UPDATE INFO
*/
jQuery(document).on('submit', '#update_info_user_log', function (event) {

    event.preventDefault();

    var __URL__= document.getElementById('btn-update-info-log').placeholder;
    var _URL=__URL__+"usuario/updateInfo";

    jQuery.ajax({

        url: _URL,
        type: 'POST',
        dataType: 'json',
        data: $(this).serialize(),

        beforeSend: function () {
        }

    })
        .done(function (respuesta) {

            Swal.fire({
                title: respuesta.title,
                showClass: {
                    popup: 'animated fadeInDown faster'
                },
                hideClass: {
                    popup: 'animated fadeOutUp faster'
                },
                text: respuesta.text,
                icon: respuesta.alert,
                footer: respuesta.footer,
                backdrop: true,
                timer: 5000,
                timerProgressBar: true,
            });
        })
        .fail(function (respuesta) {
            console.log(respuesta);
            Swal.fire({
                title: "Error Interno",
                showClass: {
                    popup: 'animated fadeInDown faster'
                },
                hideClass: {
                    popup: 'animated fadeOutUp faster'
                },
                text: 'Vuelva a intentarlo',
                icon: 'error',
                footer: 'Status: ' + respuesta.status,
                backdrop: true,
                timer: 5000,
                timerProgressBar: true,
            });
        })
        .always(function () {
            console.log("REQUESTS UPDATE INFO COMPLETED!");
        });
});

