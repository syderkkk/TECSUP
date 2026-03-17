const chalk = require("chalk");
const http = require("http");
const fileManager = require("./modules/fileManager");
const calc = require("./modules/calculadora");

console.log(chalk.green("Servidor iniciado correctamente"));

const server = http.createServer((req, res) => {

    if (req.url === "/notas") {
        const notas = fileManager.leerNotas();
        const prom = calc.promedio(notas);

        res.write("Notas: " + JSON.stringify(notas));
        res.write("\nPromedio: " + prom);
        res.end();
    }

    else if (req.url === "/guardar") {
        const datos = [15, 18, 20, 14];
        fileManager.guardarNotas(datos);

        res.write("Notas guardadas correctamente");
        res.end();
    }

    else {
        res.write("Ruta no encontrada");
        res.end();
    }
});

server.listen(3000, () => {
    console.log("Servidor en http://localhost:3000");
});