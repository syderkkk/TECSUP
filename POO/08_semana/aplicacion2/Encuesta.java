package semana8.aplicacion2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Encuesta {

    private String usuario;
    private String sexo;
    private String email;
    private String buscador;

    // Metodos set/get
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getBuscador() {
        return buscador;
    }

    public void setBuscador(String buscador) {
        this.buscador = buscador;
    }

    Properties properties = new Properties();

    public void guardarArchivo(String archivo) {
        properties.setProperty("usuario", this.usuario);
        properties.setProperty("sexo", this.sexo);
        properties.setProperty("email", this.email);
        properties.setProperty("buscador", this.buscador);

        try (FileOutputStream fileOut = new FileOutputStream(archivo)){
            properties.store(fileOut, "Datos de la encuesta");
            System.out.println("Datos guardados exitosamente en el archivo: " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }

    public void imprimirValores() {
        System.out.println("+-----------------+----------+--------------------------+---------------------+");
        System.out.printf("| %-15s | %-8s | %-24s | %-19s |\n", "Usuario", "Sexo", "Email", "Buscador");
        System.out.println("+-----------------+----------+--------------------------+---------------------+");
        System.out.printf("| %-15s | %-8s | %-24s | %-19s |\n", usuario, sexo, email, buscador);
        System.out.println("+-----------------+----------+--------------------------+---------------------+");
    }
}
