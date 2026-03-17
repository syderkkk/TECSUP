const fs = require("fs");
const path = require("path");

const ruta = path.join(__dirname, "../data/notas.json");

function guardarNotas(data) {
    fs.writeFileSync(ruta, JSON.stringify(data, null, 2));
}

function leerNotas() {
    if (!fs.existsSync(ruta)) return [];
    const contenido = fs.readFileSync(ruta);
    return JSON.parse(contenido);
}

module.exports = {
    guardarNotas,
    leerNotas
};