const router = require('express').Router();

// Ruta: Inicio
router.get('/', (req, res) => {
  res.render('index', {
    title: 'Inicio',
    mensaje: 'Bienvenido a nuestra página web hecha con Express + EJS + Bootstrap'
  });
});

// Ruta: Nosotros
router.get('/nosotros', (req, res) => {
  res.render('nosotros', {
    title: 'Nosotros',
    descripcion: 'Somos una empresa dedicada al desarrollo de software de alta calidad.'
  });
});

// Ruta: Contáctenos
router.get('/contactenos', (req, res) => {
  res.render('contactenos', {
    title: 'Contáctenos',
    email: 'contacto@empresa.com',
    telefono: '+51 999 888 777'
  });
});

// Ruta: Servicios
router.get('/servicios', (req, res) => {
  res.render('servicios', {
    title: 'Servicios',
    servicios: [
      { nombre: 'Desarrollo Web', descripcion: 'Creamos sitios modernos y responsivos.' },
      { nombre: 'Aplicaciones Móviles', descripcion: 'Apps nativas y multiplataforma.' },
      { nombre: 'Consultoría TI', descripcion: 'Asesoramiento tecnológico a medida.' }
    ]
  });
});

module.exports = router;