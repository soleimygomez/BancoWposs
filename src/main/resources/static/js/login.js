
/*******************************
 ********* VARIABLES *********** 
 *******************************/
// /* Representa si quiere loguearse (0) o quiere recuperar contraseña (1)*/
// var _STATU_LOGIN = 0;
// var _STATU_BTN_SING_IN = 0;

// const contenedor_login__ = document.getElementById('container-login__log-in');
// const container_signin__ = document.getElementById('container-login__sign-in');
// const container_forgot__ = document.getElementById('container-login__forgot');

// /*******************************
//  ********** FUCTIONS *********** 
//  *******************************/
// /**
//  * Función que permite avanzar el estado del login.
//  */
// function statuLogin() {
//   if (_STATU_LOGIN == 0) {

//     contenedor_login__.classList.add('hidden');
//     container_forgot__.classList.add('visible');
//     container_signin__.classList.remove('visible');
//     _STATU_LOGIN = 1;

//   } else {
//     contenedor_login__.classList.remove('hidden');
//     container_forgot__.classList.remove('visible');
//     container_signin__.classList.remove('visible');
//     _STATU_LOGIN = 0;
//   }
// }

// /**
//  * Función que permite avanzar el estado del login.
//  */
// function statuLoginNew() {

//   if (_STATU_LOGIN == 0) {
//     contenedor_login__.classList.add('hidden');
//     container_forgot__.classList.remove('visible');
//     container_signin__.classList.add('visible');
//     _STATU_LOGIN = 1;
//   }
// }

// /*******************************
//  *********** REQUESTS ********** 
//  *******************************/

// /**
// * REQUESTS LOGIN 
// */
// jQuery(document).on('submit', '#login__form', function (event) {

//   event.preventDefault();

//   const btn_login = document.getElementById('login__btn-login');
//   const loader_google = document.getElementById('login-login-loader-google');

//   var _URL_ = document.getElementById("login__btn-login").placeholder;
//   _URL_ = _URL_ + 'controllers/requests/login/validate-user.php';

//   jQuery.ajax({

//     url: _URL_,
//     type: 'POST',
//     dataType: 'json',
//     data: $(this).serialize(),

//     beforeSend: function () {
//       btn_login.classList.add('hidden-display');
//       loader_google.classList.add('visible-display');
//     }

//   })
//     .done(function (respuesta) {
//       if (!respuesta.error) {
//         if (respuesta.tipo_usuario == 1) {
//           window.location = "views/admi/index.php";
//         } else {
//           window.location = "egresado";
//         }

//       } else {
//         Swal.fire({
//           title: respuesta.title,
//           showClass: {
//             popup: 'animated fadeInDown faster'
//           },
//           hideClass: {
//             popup: 'animated fadeOutUp faster'
//           },
//           text: respuesta.text,
//           icon: respuesta.alert,
//           footer: respuesta.footer,
//           backdrop: true,
//           timer: 5000,
//           timerProgressBar: true,
//         });
//       }

//       btn_login.classList.remove('hidden-display');
//       loader_google.classList.remove('visible-display');

//     })
//     .fail(function (respuesta) {
//       btn_login.classList.remove('hidden-display');
//       loader_google.classList.remove('visible-display');

//       console.log(respuesta);
//       Swal.fire({
//         title: "Error Interno",
//         showClass: {
//           popup: 'animated fadeInDown faster'
//         },
//         hideClass: {
//           popup: 'animated fadeOutUp faster'
//         },
//         text: 'Vuelva a intentarlo',
//         icon: 'error',
//         footer: 'Status: ' + respuesta.status,
//         backdrop: true,
//         timer: 5000,
//         timerProgressBar: true,
//       });
//     })
//     .always(function () {
//       console.log("REQUESTS LOGIN COMPLETED!");
//     });
// });

// // /**
// // * REQUESTS SIGNIN 

// // jQuery(document).on('submit', '#sign-in__form', function (event) {

// //   event.preventDefault();

// //   //const btn_login = document.getElementById('login__btn-sign-in');
// //   // const loader_google = document.getElementById('sign-in-loader-google');

// //   // const container_password = document.getElementById('login__sign-in__password');
// //   // const container_codigo = document.getElementById('login__sign-in__codigo');

// //   // var _URL_ = document.getElementById("login__btn-sign-in").placeholder;
// //   // var _URL_2;

// //   // if (_STATU_BTN_SING_IN == 0) {
// //   //   _URL_2 = _URL_ +'controllers/requests/login/confirm-registration.php';
// //   // } else {
// //   //   _URL_2 = _URL_ +'controllers/requests/login/registration-pass.php';
// //   // }

// //   console.log(_URL_2);

// //   jQuery.ajax({

// //     url: _URL_2,
// //     type: 'POST',
// //     dataType: 'json',
// //     data: $(this).serialize(),
// //     beforeSend: function () {

// //       btn_login.classList.add('hidden-display');
// //       loader_google.classList.add('visible-display');
// //     }
// //   })
// //     .done(function (respuesta) {

// //       if (!respuesta.error) {

// //         if (respuesta.login) {
// //         } else {
// //           if (_STATU_BTN_SING_IN == 0) {
// //             if (respuesta.estado == 0) {
// //               _STATU_BTN_SING_IN = 1;
// //             }
// //           } else {
// //             if (respuesta.change) {
// //               _STATU_BTN_SING_IN = 0;
// //             }
// //             Swal.fire({
// //               title: respuesta.title,
// //               showClass: {
// //                 popup: 'animated fadeInDown faster'
// //               },
// //               hideClass: {
// //                 popup: 'animated fadeOutUp faster'
// //               },
// //               text: respuesta.text,
// //               icon: respuesta.alert,
// //               footer: respuesta.footer,
// //               backdrop: true,
// //               timer: 5000,
// //               timerProgressBar: true,
// //             });
// //           }
// //         }
// //       } else {
// //         Swal.fire({
// //           title: respuesta.title,
// //           showClass: {
// //             popup: 'animated fadeInDown faster'
// //           },
// //           hideClass: {
// //             popup: 'animated fadeOutUp faster'
// //           },
// //           text: respuesta.text,
// //           icon: respuesta.alert,
// //           footer: respuesta.footer,
// //           backdrop: true,
// //           timer: 5000,
// //           timerProgressBar: true,
// //         });
// //       }

// //       btn_login.classList.remove('hidden-display');
// //       loader_google.classList.remove('visible-display');

// //       if (_STATU_BTN_SING_IN == 1) {
// //         container_password.classList.remove('hidden-display');
// //         container_codigo.classList.add('hidden-display');
// //       } else {
// //         container_password.classList.add('hidden-display');
// //         container_codigo.classList.remove('hidden-display');
// //       }

// //     })
// //     .fail(function (respuesta) {
// //       btn_login.classList.remove('hidden-display');
// //       loader_google.classList.remove('visible-display');
// //       Swal.fire({
// //         title: "Error Interno",
// //         showClass: {
// //           popup: 'animated fadeInDown faster'
// //         },
// //         hideClass: {
// //           popup: 'animated fadeOutUp faster'
// //         },
// //         text: 'Vuelva a intentarlo',
// //         icon: 'error',
// //         footer: 'Status: ' + respuesta.status,
// //         backdrop: true,
// //         timer: 5000,
// //         timerProgressBar: true,
// //       });
// //     })
// //     .always(function () {
// //       console.log("REQUESTS LOGIN COMPLETED!");
// //     });
// // });

// // */
// // /**
// // * REQUESTS FORGOT PASSWORD
// // */
// // jQuery(document).on('submit', '#forgot__form', function (event) {

// //   event.preventDefault();

// //   const btn_login = document.getElementById('login__btn-forgot');
// //   const loader_google = document.getElementById('forgot-loader-google');

// //   var _URL_ = document.getElementById("login__btn-forgot").placeholder;

// //   jQuery.ajax({

// //     url: _URL_+'controllers/requests/login/recover-password.php',
// //     type: 'POST',
// //     dataType: 'json',
// //     data: $(this).serialize(),
// //     beforeSend: function () {

// //       btn_login.classList.add('hidden-display');
// //       loader_google.classList.add('visible-display');
// //     }
// //   })
// //     .done(function (respuesta) {

// //       console.log(respuesta);

// //       if (!respuesta.error) {
// //         if (respuesta.login) {
// //           if (respuesta.tipo_usuario == 1) {
// //             window.location = "admi";
//           } else {
//             window.location = "egresado";
//           }
//         }
//       }

//       Swal.fire({
//         title: respuesta.title,
//         showClass: {
//           popup: 'animated fadeInDown faster'
//         },
//         hideClass: {
//           popup: 'animated fadeOutUp faster'
//         },
//         text: respuesta.text,
//         icon: respuesta.alert,
//         footer: respuesta.footer,
//         backdrop: true,
//         timer: 5000,
//         timerProgressBar: true,
//       });

//       btn_login.classList.remove('hidden-display');
//       loader_google.classList.remove('visible-display');
//     })
//     .fail(function (respuesta) {
//       btn_login.classList.remove('hidden-display');
//       loader_google.classList.remove('visible-display');
//       Swal.fire({
//         title: "Error Interno",
//         showClass: {
//           popup: 'animated fadeInDown faster'
//         },
//         hideClass: {
//           popup: 'animated fadeOutUp faster'
//         },
//         text: 'Vuelva a intentarlo',
//         icon: 'error',
//         footer: 'Status: ' + respuesta.status,
//         backdrop: true,
//         timer: 5000,
//         timerProgressBar: true,
//       });
//     })
//     .always(function () {
//       console.log("REQUESTS FORGOT PASSWORD COMPLETED!");
//     });
// });



