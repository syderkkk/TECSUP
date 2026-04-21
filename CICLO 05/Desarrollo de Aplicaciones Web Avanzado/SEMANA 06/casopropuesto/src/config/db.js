import mongoose from "mongoose";

/**
 * Establece la conexión con MongoDB usando la URI del .env
 * Termina el proceso si la conexión falla al iniciar
 */
const conectarDB = async () => {
  try {
    const conn = await mongoose.connect(process.env.MONGO_URI);
    console.log(`✅ MongoDB conectado: ${conn.connection.host}`);
  } catch (error) {
    console.error(`❌ Error al conectar MongoDB: ${error.message}`);
    process.exit(1); // Detiene el servidor si no hay BD
  }
};

export default conectarDB;