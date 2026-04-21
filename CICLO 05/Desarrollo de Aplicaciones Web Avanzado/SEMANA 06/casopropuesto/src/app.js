import express from "express";
import dotenv from "dotenv";
import cors from "cors";
import morgan from "morgan";

import conectarDB from "./config/db.js";
import productoRoutes from "./routes/productoRoutes.js";
import errorHandler from "./middlewares/errorHandler.js";

dotenv.config();

const app = express();

// ── Conexión a la base de datos ──────────────
conectarDB();

// ── Middlewares globales ──────────────────────
app.use(cors());                          // Habilitar CORS para el frontend
app.use(morgan("dev"));                   // Log de peticiones HTTP en consola
app.use(express.json());                  // Parsear body JSON
app.use(express.urlencoded({ extended: true })); // Parsear body form-urlencoded

// ── Rutas ────────────────────────────────────
app.use("/api/productos", productoRoutes);

// Ruta raíz para verificar que el servidor está vivo
app.get("/", (req, res) => {
  res.json({ ok: true, mensaje: "API de Productos funcionando 🚀" });
});

// Ruta no encontrada (404 de ruta, no de recurso)
app.use((req, res) => {
  res.status(404).json({ ok: false, mensaje: "Ruta no encontrada" });
});

// ── Middleware de errores (siempre al final) ──
app.use(errorHandler);

// ── Iniciar servidor ──────────────────────────
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`🚀 Servidor corriendo en http://localhost:${PORT}`);
});