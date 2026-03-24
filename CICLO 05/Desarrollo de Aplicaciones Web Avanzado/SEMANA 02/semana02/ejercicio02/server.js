const http = require("http");
const fs = require("fs");
const path = require("path");
const handlebars = require("handlebars");

const PORT = 3000;

handlebars.registerHelper('gte', (a, b) => a >= b);

const server = http.createServer((req, res) => {
    if (req.url === "/") {
        // Ruta del archivo HBS
        const filePath = path.join(__dirname, "views", "home.hbs");

        // Leer el archivo de plantilla
        fs.readFile(filePath, "utf8", (err, templateData) => {
            if (err) {
                res.statusCode = 500;
                res.end("Error interno del servidor");
                return;
            }

            // Compilar la plantilla con Handlebars
            const template = handlebars.compile(templateData);

            // Datos dinámicos a enviar
            const data = {
                title: "Servidor con Handlebars 🚀",
                welcomeMessage: "Bienvenido al laboratorio de Node.js",
                day: new Date().toLocaleDateString("es-PE"),
                students: ["Ana", "Luis", "Pedro", "María"],
            };

            // Renderizar la vista con los datos
            const html = template(data);

            res.setHeader("Content-Type", "text/html; charset=utf-8");
            res.end(html);
        });
    }
    else if (req.url === "/about") {
        // --- VISTA ABOUT ---
        renderView(res, "about.hbs", {
            title: "Acerca de la Clase",
            curso: "Desarrollo de Aplicaciones Web Avanzado",
            profesor: "Coello Palomino, Ricardo",
            fecha: new Date().toLocaleDateString("es-PE")
        });
    }
    else if (req.url === "/students") {
        // --- VISTA STUDENTS ---
        renderView(res, "students.hbs", {
            title: "Lista de Notas - Italo Mendoza",
            listado: [
                { nombre: "Ana", nota: 18 },
                { nombre: "Luis", nota: 12 },
                { nombre: "Pedro", nota: 16 },
                { nombre: "María", nota: 10 }
            ]
        });
    }
    else {
        res.statusCode = 404;
        res.end("<h1>404 - Página no encontrada</h1>");
    }
});

// Función auxiliar para no repetir código de lectura/compilación
function renderView(res, fileName, data) {
    const filePath = path.join(__dirname, "views", fileName);
    fs.readFile(filePath, "utf8", (err, templateData) => {
        if (err) {
            res.statusCode = 500;
            res.end("Error al cargar la vista");
            return;
        }
        const template = handlebars.compile(templateData);
        res.end(template(data));
    });
}

server.listen(PORT, () => {
    console.log(`Servidor corriendo en http://localhost:${PORT}`);
});