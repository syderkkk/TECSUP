import mongoose from "mongoose";

/**
 * Middleware global de manejo de errores
 * Centraliza todas las respuestas de error de la API
 * Debe registrarse DESPUÉS de todas las rutas en app.js
 */
const errorHandler = (err, req, res, next) => {
  console.error(`[ERROR] ${err.message}`);

  // Error de cast de Mongoose (ID con formato inválido)
  if (err instanceof mongoose.Error.CastError) {
    return res.status(400).json({
      ok: false,
      mensaje: "ID inválido",
    });
  }

  // Error de validación de Mongoose (campos requeridos, min/max, etc.)
  if (err instanceof mongoose.Error.ValidationError) {
    const mensajes = Object.values(err.errors).map((e) => e.message);
    return res.status(400).json({
      ok: false,
      mensaje: "Error de validación",
      errores: mensajes,
    });
  }

  // Error de clave duplicada (unique: true en el schema)
  if (err.code === 11000) {
    const campo = Object.keys(err.keyValue)[0];
    return res.status(400).json({
      ok: false,
      mensaje: `El valor del campo '${campo}' ya existe`,
    });
  }

  // Error genérico del servidor
  return res.status(500).json({
    ok: false,
    mensaje: "Error interno del servidor",
  });
};

export default errorHandler;