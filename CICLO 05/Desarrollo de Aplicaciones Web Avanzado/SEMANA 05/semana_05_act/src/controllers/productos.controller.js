import { pool } from '../config/database.js';

export const getProductos = async (req, res) => {
    const [rows] = await pool.query('CALL sp_listar_productos()');
    res.json(rows[0]);
};

export const getProducto = async (req, res) => {
    const [rows] = await pool.query('CALL sp_obtener_producto(?)', [req.params.id]);
    if (rows[0].length === 0)
        return res.status(404).json({ mensaje: 'Producto no encontrado' });
    res.json(rows[0][0]);
};

export const createProducto = async (req, res) => {
    const { nombre, precio, stock, categoria_id } = req.body;

    // Validaciones
    if (!nombre) return res.status(400).json({ mensaje: 'El nombre del producto es obligatorio' });
    if (!precio || precio <= 0) return res.status(400).json({ mensaje: 'El precio debe ser mayor a 0' });
    if (stock === undefined || stock < 0) return res.status(400).json({ mensaje: 'El stock debe ser >= 0' });

    // Verificar que la categoría existe
    const [cat] = await pool.query('SELECT id FROM categorias WHERE id = ?', [categoria_id]);
    if (cat.length === 0) return res.status(404).json({ mensaje: 'Categoría inexistente' });

    const [result] = await pool.query(
        'CALL sp_insertar_producto(?, ?, ?, ?)',
        [nombre, precio, stock, categoria_id]
    );
    res.status(201).json({ id: result[0][0].id, nombre, precio, stock, categoria_id });
};

export const updateProducto = async (req, res) => {
    const { nombre, precio, stock, categoria_id } = req.body;

    if (!nombre) return res.status(400).json({ mensaje: 'El nombre del producto es obligatorio' });
    if (!precio || precio <= 0) return res.status(400).json({ mensaje: 'El precio debe ser mayor a 0' });
    if (stock === undefined || stock < 0) return res.status(400).json({ mensaje: 'El stock debe ser >= 0' });

    const [cat] = await pool.query('SELECT id FROM categorias WHERE id = ?', [categoria_id]);
    if (cat.length === 0) return res.status(404).json({ mensaje: 'Categoría inexistente' });

    const [result] = await pool.query(
        'CALL sp_actualizar_producto(?, ?, ?, ?, ?)',
        [req.params.id, nombre, precio, stock, categoria_id]
    );
    if (result[0][0].afectados === 0)
        return res.status(404).json({ mensaje: 'Producto no encontrado' });
    res.json({ mensaje: 'Producto actualizado' });
};

export const deleteProducto = async (req, res) => {
    const [result] = await pool.query('CALL sp_eliminar_producto(?)', [req.params.id]);
    if (result[0][0].afectados === 0)
        return res.status(404).json({ mensaje: 'Producto no encontrado' });
    res.json({ mensaje: 'Producto eliminado' });
};