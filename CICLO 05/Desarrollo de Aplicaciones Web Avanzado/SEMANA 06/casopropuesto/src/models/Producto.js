import mongoose from "mongoose";

/**
 * Schema de Producto con validaciones integradas
 * fechaCreacion se asigna automáticamente
 */
const productoSchema = new mongoose.Schema(
  {
    nombre: {
      type: String,
      required: [true, "El nombre es obligatorio"],
      trim: true,
      minlength: [2, "El nombre debe tener al menos 2 caracteres"],
      maxlength: [100, "El nombre no puede superar los 100 caracteres"],
    },
    precio: {
      type: Number,
      required: [true, "El precio es obligatorio"],
      min: [0, "El precio no puede ser negativo"],
    },
    stock: {
      type: Number,
      required: [true, "El stock es obligatorio"],
      min: [0, "El stock no puede ser negativo"],
      default: 0,
    },
    categoria: {
      type: String,
      required: [true, "La categoría es obligatoria"],
      trim: true,
    },
    fechaCreacion: {
      type: Date,
      default: Date.now, // Se asigna automáticamente al crear
    },
  },
  {
    // Agrega createdAt y updatedAt automáticamente
    timestamps: true,
    // Elimina el __v de las respuestas
    versionKey: false,
  }
);

// Índices para mejorar rendimiento en búsquedas frecuentes
productoSchema.index({ nombre: "text" }); // Búsqueda por texto
productoSchema.index({ categoria: 1 });   // Filtro por categoría
productoSchema.index({ precio: 1 });      // Ordenamiento por precio

export default mongoose.model("Producto", productoSchema);