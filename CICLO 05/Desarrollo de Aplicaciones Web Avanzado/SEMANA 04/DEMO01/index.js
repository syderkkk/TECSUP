const express = require('express');
const path = require('path');


const app = express();
const PORT = process.env.PORT || 3000;


// Servir archivos estáticos
app.use(express.static(path.join(__dirname, 'public')));


// Rutas
const webRoutes = require('./routes/web.js');
app.use('/', webRoutes);


// 404
app.use((req, res) => {
    res.status(404).sendFile(path.join(__dirname, 'public', 'index.html'));
});


// Servidor
app.listen(PORT, () => {
    console.log(`Server running on port ${PORT}`);
});
