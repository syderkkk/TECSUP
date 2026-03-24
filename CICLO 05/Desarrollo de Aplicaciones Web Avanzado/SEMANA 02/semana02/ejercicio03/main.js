const http = require("http");
const repo = require("./repository/studentsRepository");

const PORT = 4000;

function isNonEmptyString(value) {
  return typeof value === "string" && value.trim().length > 0;
}

function validateStudentForCreate(student) {
  const requiredFields = ["name", "email", "course", "phone"];
  const missing = requiredFields.filter(field => !isNonEmptyString(student[field]));
  return {
    isValid: missing.length === 0,
    missing
  };
}

const server = http.createServer((req, res) => {
  // Configuración de cabecera para todas las respuestas (JSON)
  res.setHeader("Content-Type", "application/json; charset=utf-8");
  const { method, url } = req;

  // --- RUTA: GET /students (Listar todos) ---
  if (url === "/students" && method === "GET") {
    res.statusCode = 200;
    res.end(JSON.stringify(repo.getAll()));
  }

  // --- RUTA: GET /students/:id (Obtener uno por ID) ---
  else if (url.startsWith("/students/") && method === "GET") {
    const id = parseInt(url.split("/")[2]);
    const student = repo.getById(id);

    if (student) {
      res.statusCode = 200;
      res.end(JSON.stringify(student));
    } else {
      res.statusCode = 404;
      res.end(JSON.stringify({ error: "Estudiante no encontrado" }));
    }
  }

  // --- RUTA: POST /students (Crear nuevo) ---
  else if (url === "/students" && method === "POST") {
    let body = "";
    req.on("data", chunk => (body += chunk));
    req.on("end", () => {
      try {
        const payload = JSON.parse(body);
        const validation = validateStudentForCreate(payload);

        if (!validation.isValid) {
          res.statusCode = 400;
          res.end(
            JSON.stringify({
              error: "Campos obligatorios faltantes o vacios",
              required: ["name", "email", "course", "phone"],
              missing: validation.missing
            })
          );
          return;
        }

        const newStudent = repo.create(payload);
        res.statusCode = 201;
        res.end(JSON.stringify(newStudent));
      } catch (e) {
        res.statusCode = 400;
        res.end(JSON.stringify({ error: "JSON inválido" }));
      }
    });
  }

  // --- RUTA: PUT /students/:id (Actualizar) ---
  else if (url.startsWith("/students/") && method === "PUT") {
    const id = parseInt(url.split("/")[2]);
    let body = "";
    req.on("data", chunk => (body += chunk));
    req.on("end", () => {
      try {
        const updated = repo.update(id, JSON.parse(body));
        if (updated) {
          res.statusCode = 200;
          res.end(JSON.stringify(updated));
        } else {
          res.statusCode = 404;
          res.end(JSON.stringify({ error: "Estudiante no encontrado" }));
        }
      } catch (e) {
        res.statusCode = 400;
        res.end(JSON.stringify({ error: "JSON inválido" }));
      }
    });
  }

  // --- RUTA: POST /ListByStatus (Listar por estado) ---
  else if (url === "/ListByStatus" && method === "POST") {
    let body = "";
    req.on("data", chunk => (body += chunk));
    req.on("end", () => {
      try {
        const payload = JSON.parse(body || "{}");
        if (!isNonEmptyString(payload.status)) {
          res.statusCode = 400;
          res.end(JSON.stringify({ error: "Debe enviar el campo status" }));
          return;
        }

        const students = repo.listByStatus(payload.status);
        res.statusCode = 200;
        res.end(JSON.stringify(students));
      } catch (e) {
        res.statusCode = 400;
        res.end(JSON.stringify({ error: "JSON inválido" }));
      }
    });
  }

  // --- RUTA: POST /ListByGrade (Listar por promedio/nota) ---
  else if (url === "/ListByGrade" && method === "POST") {
    let body = "";
    req.on("data", chunk => (body += chunk));
    req.on("end", () => {
      try {
        const payload = JSON.parse(body || "{}");
        const hasGpa = payload.gpa !== undefined;
        const hasGrade = payload.grade !== undefined;

        if (!hasGpa && !hasGrade) {
          res.statusCode = 400;
          res.end(JSON.stringify({ error: "Debe enviar gpa o grade" }));
          return;
        }

        const students = repo.listByGrade(payload);
        res.statusCode = 200;
        res.end(JSON.stringify(students));
      } catch (e) {
        res.statusCode = 400;
        res.end(JSON.stringify({ error: "JSON inválido" }));
      }
    });
  }

  // --- RUTA: DELETE /students/:id (Eliminar) ---
  else if (url.startsWith("/students/") && method === "DELETE") {
    const id = parseInt(url.split("/")[2]);
    const deleted = repo.remove(id);

    if (deleted) {
      res.statusCode = 200;
      res.end(JSON.stringify(deleted));
    } else {
      res.statusCode = 404;
      res.end(JSON.stringify({ error: "Estudiante no encontrado" }));
    }
  }

  // --- RUTA NO ENCONTRADA ---
  else {
    res.statusCode = 404;
    res.end(JSON.stringify({ error: "Ruta no encontrada" }));
  }
});

// Iniciar el servidor
server.listen(PORT, () => {
  console.log(`API corriendo en http://localhost:${PORT}`);
});