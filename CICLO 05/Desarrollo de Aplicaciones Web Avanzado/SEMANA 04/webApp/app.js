const express = require('express');
const path = require('path');

const app = express();
const PORT = process.env.PORT || 3000;

// Motor de plantillas EJS
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

// Archivos estáticos (CSS, imágenes, etc.)
app.use(express.static(path.join(__dirname, 'public')));

// Middlewares para leer JSON y formularios
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// Variables disponibles en todas las vistas
app.use((req, res, next) => {
  res.locals.currentPath = req.path;
  next();
});

// Rutas
const webRoutes = require('./routes/rutas');
app.use('/', webRoutes);

// Manejo de rutas no encontradas (404)
app.use((req, res) => {
  res.status(404).render('index', {
    title: 'Página no encontrada',
    mensaje: 'La página que buscas no existe.'
  });
});

// Iniciar servidor
app.listen(PORT, () => {
  console.log(`Servidor corriendo en http://localhost:${PORT}`);
});