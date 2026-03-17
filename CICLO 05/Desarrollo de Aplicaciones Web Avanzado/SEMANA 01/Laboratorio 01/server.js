const http = require("http");
const operaciones = require("./operaciones.js");

http.createServer((req, res) => {
    res.writeHead(200, { 'Content-Type': 'text/plain; charset=utf-8' });
    res.write("Áreas calculadas usando operaciones.js:\n");
    res.write("Área de un cuadrado de lado 4: " + operaciones.areaCuadrado(4) + "\n");
    res.write("Área de un triángulo de base 3 y altura 5: " + operaciones.areaTriangulo(3, 5) + "\n");
    res.write("Área de un círculo de radio 2: " + operaciones.areaCirculo(2).toFixed(2) + "\n");
    res.end();
}).listen(3000);

console.log("Servidor corriendo en puerto 3000");