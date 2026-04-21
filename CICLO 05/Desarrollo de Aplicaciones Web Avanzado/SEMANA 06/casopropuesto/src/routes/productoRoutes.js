import { Router } from "express";
import {
  crearProducto,
  obtenerProductos,
  obtenerProducto,
  actualizarProducto,
  eliminarProducto,
} from "../controllers/productoController.js";

const router = Router();

// CRUD de Productos
router.post("/", crearProducto);
router.get("/", obtenerProductos);       // Soporta ?page=&limit=&categoria=&sortPrecio=&nombre=
router.get("/:id", obtenerProducto);
router.put("/:id", actualizarProducto);
router.delete("/:id", eliminarProducto);

export default router;