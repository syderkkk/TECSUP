package semana11;

import java.sql.*;
import java.util.Scanner;

public class JDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/tecsup";
        String username = "root";
        String password = "tecsup";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("[✅] Conexión exitosa.");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMenú");
                System.out.println("1. Registrar alumno");
                System.out.println("2. Mostrar alumnos");
                System.out.println("3. Buscar alumno por DNI");
                System.out.println("4. Borrar alumno por DNI");
                System.out.println("5. Salir");
                System.out.print("➡️ Ingrese su opción: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                if (option == 1) {
                    registrarAlumno(conn, scanner);
                } else if (option == 2) {
                    mostrarAlumnos(conn);
                } else if (option == 3) {
                    buscarAlumnoPorDNI(conn, scanner);
                } else if (option == 4) {
                    borrarAlumnoPorDNI(conn, scanner);
                } else if (option == 5) {
                    System.out.println("Saliendo del programa...");
                    break;
                } else {
                    System.out.println("[❌] Opción inválida!");
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void registrarAlumno(Connection conn, Scanner scanner) {
        System.out.print("➡️ Ingrese el código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("➡️ Ingrese los apellidos: ");
        String apellidos = scanner.nextLine();

        System.out.print("➡️ Ingrese los nombres: ");
        String nombres = scanner.nextLine();

        System.out.print("➡️ Ingrese el DNI: ");
        String dni = scanner.nextLine();

        System.out.print("➡️ Ingrese la dirección: ");
        String direccion = scanner.nextLine();

        String sql = "INSERT INTO Alumnos (Codigo, Apellidos, Nombres, DNI, Direccion) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);
            pstmt.setString(2, apellidos);
            pstmt.setString(3, nombres);
            pstmt.setString(4, dni);
            pstmt.setString(5, direccion);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("[✅] Alumno registrado correctamente!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarAlumnos(Connection conn) {
        String sql = "SELECT Codigo, Apellidos, Nombres, DNI, Direccion FROM Alumnos";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {


            if (!rs.isBeforeFirst()) {
                System.out.println("[❌] No hay alumnos para mostrar.");
                return;
            }


            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("| Código | Apellidos             | Nombres               | DNI       | Dirección                       |");
            System.out.println("|--------|-----------------------|-----------------------|-----------|---------------------------------|");

            while (rs.next()) {
                int codigo = rs.getInt("Codigo");
                String apellidos = rs.getString("Apellidos");
                String nombres = rs.getString("Nombres");
                String dni = rs.getString("DNI");
                String direccion = rs.getString("Direccion");

                System.out.printf("| %-6d | %-21s | %-21s | %-9s | %-31s |%n", codigo, apellidos, nombres, dni, direccion);
                System.out.println("--------------------------------------------------------------------------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void buscarAlumnoPorDNI(Connection conn, Scanner scanner) {
        System.out.print("➡️ Ingrese el DNI del alumno: ");
        String dni = scanner.nextLine();

        String sql = "SELECT Codigo, Apellidos, Nombres, Direccion FROM Alumnos WHERE DNI = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dni);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int codigo = rs.getInt("Codigo");
                String apellidos = rs.getString("Apellidos");
                String nombres = rs.getString("Nombres");
                String direccion = rs.getString("Direccion");

                System.out.println("[✅] Datos del alumno encontrado:");
                System.out.println("+--------+-----------------------+-----------------------+-------------------------------+");
                System.out.printf("| %-6s | %-21s | %-21s | %-29s |%n", "Código", "Apellidos", "Nombres", "Dirección");
                System.out.println("+--------+-----------------------+-----------------------+-------------------------------+");
                System.out.printf("| %-6d | %-21s | %-21s | %-29s |%n", codigo, apellidos, nombres, direccion);
                System.out.println("+--------+-----------------------+-----------------------+-------------------------------+");
            } else {
                System.out.println("No se encontró un alumno con el DNI especificado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void borrarAlumnoPorDNI(Connection conn, Scanner scanner) {
        System.out.print("➡️ Ingrese el DNI del alumno a borrar: ");
        String dni = scanner.nextLine();

        String sql = "DELETE FROM Alumnos WHERE DNI = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dni);
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("[✅] Alumno borrado correctamente!");
            } else {
                System.out.println("[❌] No se encontró un alumno con ese DNI!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
