import { pool } from '../config/database.js';

export const getCategorias = async (req, res) => {
    const [rows] = await pool.query('CALL sp_listar_categorias()');
    res.json(rows[0]);
};

export const createCategoria = async (req, res) => {
    const { nombre } = req.body;
    if (!nombre) return res.status(400).json({ mensaje: 'El nombre es obligatorio' });
    const [result] = await pool.query('CALL sp_insertar_categoria(?)', [nombre]);
    res.status(201).json({ id: result[0][0].id, nombre });
};

export const updateCategoria = async (req, res) => {
    const { nombre } = req.body;
    if (!nombre) return res.status(400).json({ mensaje: 'El nombre es obligatorio' });
    const [result] = await pool.query('CALL sp_actualizar_categoria(?, ?)', [req.params.id, nombre]);
    if (result[0][0].afectados === 0)
        return res.status(404).json({ mensaje: 'Categoría no encontrada' });
    res.json({ mensaje: 'Categoría actualizada' });
};

export const deleteCategoria = async (req, res) => {
    const [result] = await pool.query('CALL sp_eliminar_categoria(?)', [req.params.id]);
    if (result[0][0].afectados === 0)
        return res.status(404).json({ mensaje: 'Categoría no encontrada' });
    res.json({ mensaje: 'Categoría eliminada' });
};