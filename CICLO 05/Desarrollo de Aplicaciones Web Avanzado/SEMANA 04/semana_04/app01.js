const express = require('express');
const path = require('path');


const app = express();
const PORT = process.env.PORT || 3500;


// Ruta: saludo con validación
app.get('/hello/:username', (req, res) => {
    const { username } = req.params;


    if (!username) {
        return res.status(400).json({
            ok: false,
            message: 'Username is required'
        });
    }


    res.json({
        ok: true,
        message: `Hola ${username.toUpperCase()}`
    });
});


// Ruta: suma de números con validación
app.get('/add/:x/:y', (req, res) => {
    const { x, y } = req.params;


    const numX = Number(x);
    const numY = Number(y);


    if (isNaN(numX) || isNaN(numY)) {
        return res.status(400).json({
            ok: false,
            message: 'Parameters must be numbers'
        });
    }


    res.json({
        ok: true,
        result: numX + numY
    });
});


// Ruta: mostrar nombre y edad con validación
app.get('/name/:name/age/:age', (req, res) => {
    const { name, age } = req.params;


    const ageNumber = Number(age);


    if (isNaN(ageNumber)) {
        return res.status(400).json({
            ok: false,
            message: 'Age must be a number'
        });
    }


    res.json({
        ok: true,
        message: `El usuario ${name} tiene ${ageNumber} años`
    });
});


// Ruta base
app.get('/', (req, res) => {
    res.send('API funcionando correctamente');
});


// Manejo de rutas no encontradas
app.use((req, res) => {
    res.status(404).json({
        ok: false,
        message: 'Ruta no encontrada'
    });
});


// Iniciar servidor
app.listen(PORT, () => {
    console.log(`Servidor en el puerto ${PORT}`);
});
