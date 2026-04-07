const router = require('express').Router();
const path = require('path');


// Rutas limpias
router.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, '../public/index.html'));
});


router.get('/nosotros', (req, res) => {
    res.sendFile(path.join(__dirname, '../public/nosotros.html'));
});


router.get('/contactenos', (req, res) => {
    res.sendFile(path.join(__dirname, '../public/contactenos.html'));
});


module.exports = router;