import Producto from "../models/Producto.js";

// ─────────────────────────────────────────────
// POST /api/productos — Crear producto
// ─────────────────────────────────────────────
export const crearProducto = async (req, res, next) => {
  try {
    const producto = await Producto.create(req.body);
    return res.status(201).json({
      ok: true,
      data: producto,
    });
  } catch (error) {
    next(error); // Delega al middleware de errores
  }
};

// ─────────────────────────────────────────────
// GET /api/productos — Listar con filtros, paginación, orden y búsqueda
// Query params: page, limit, categoria, sortPrecio, nombre
// ─────────────────────────────────────────────
export const obtenerProductos = async (req, res, next) => {
  try {
    const {
      page = 1,
      limit = 5,
      categoria,
      sortPrecio, // "asc" | "desc"
      nombre,     // búsqueda parcial por nombre
    } = req.query;

    // Construcción dinámica del filtro
    const filtro = {};

    if (categoria) {
      filtro.categoria = categoria;
    }

    if (nombre) {
      // Búsqueda insensible a mayúsculas/minúsculas
      filtro.nombre = { $regex: nombre, $options: "i" };
    }

    // Ordenamiento por precio
    const orden = {};
    if (sortPrecio === "asc") orden.precio = 1;
    if (sortPrecio === "desc") orden.precio = -1;

    const pageNum = Math.max(1, Number(page));
    const limitNum = Math.min(50, Math.max(1, Number(limit))); // Máximo 50 por página

    const [productos, total] = await Promise.all([
      Producto.find(filtro)
        .sort(orden)
        .skip((pageNum - 1) * limitNum)
        .limit(limitNum),
      Producto.countDocuments(filtro),
    ]);

    return res.json({
      ok: true,
      total,
      pagina: pageNum,
      totalPaginas: Math.ceil(total / limitNum),
      data: productos,
    });
  } catch (error) {
    next(error);
  }
};

// ─────────────────────────────────────────────
// GET /api/productos/:id — Obtener un producto por ID
// ─────────────────────────────────────────────
export const obtenerProducto = async (req, res, next) => {
  try {
    const producto = await Producto.findById(req.params.id);

    if (!producto) {
      return res.status(404).json({
        ok: false,
        mensaje: "Producto no encontrado",
      });
    }

    return res.json({
      ok: true,
      data: producto,
    });
  } catch (error) {
    next(error);
  }
};

// ─────────────────────────────────────────────
// PUT /api/productos/:id — Actualizar producto
// ─────────────────────────────────────────────
export const actualizarProducto = async (req, res, next) => {
  try {
    const producto = await Producto.findByIdAndUpdate(
      req.params.id,
      req.body,
      {
        new: true,          // Devuelve el documento actualizado
        runValidators: true, // Ejecuta las validaciones del schema
      }
    );

    if (!producto) {
      return res.status(404).json({
        ok: false,
        mensaje: "Producto no encontrado",
      });
    }

    return res.json({
      ok: true,
      data: producto,
    });
  } catch (error) {
    next(error);
  }
};

// ─────────────────────────────────────────────
// DELETE /api/productos/:id — Eliminar producto
// ─────────────────────────────────────────────
export const eliminarProducto = async (req, res, next) => {
  try {
    const producto = await Producto.findByIdAndDelete(req.params.id);

    if (!producto) {
      return res.status(404).json({
        ok: false,
        mensaje: "Producto no encontrado",
      });
    }

    return res.json({
      ok: true,
      mensaje: "Producto eliminado correctamente",
    });
  } catch (error) {
    next(error);
  }
};