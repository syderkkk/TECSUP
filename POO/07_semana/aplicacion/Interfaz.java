package Semana7.Aplicacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame {
    private JTextField txtNumero, txtNombre, txtTipoCliente, txtSaldo;
    private JTextArea txtReporte;
    private JRadioButton rbNumero, rbNombre, rbSaldo;
    private JButton btnRegistrar, btnImprimir, btnBuscar, btnEliminar;

    private String criterioOrden = "numero";

    public Interfaz(Operaciones op) {
        setTitle("Mantenimiento");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Panel principal que contiene todos los componentes
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        // Panel para la información de la cuenta (con GridBagLayout para diferentes tamaños)
        JPanel panelCuenta = new JPanel(new GridBagLayout());
        panelCuenta.setBorder(BorderFactory.createTitledBorder("Cuenta corriente"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado alrededor de los componentes

        // Etiqueta y caja de texto para Número (más pequeña)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panelCuenta.add(new JLabel("Número:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtNumero = new JTextField(10); // Caja de texto más pequeña
        panelCuenta.add(txtNumero, gbc);

        // Etiqueta y caja de texto para Nombre (más grande)
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        panelCuenta.add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtNombre = new JTextField(20); // Caja de texto más grande
        panelCuenta.add(txtNombre, gbc);

        // Etiqueta y caja de texto para Tipo de cliente (A/E)
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        panelCuenta.add(new JLabel("Tipo de cliente (A/E):"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtTipoCliente = new JTextField(5); // Tamaño ajustado
        panelCuenta.add(txtTipoCliente, gbc);

        // Etiqueta y caja de texto para Saldo
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        panelCuenta.add(new JLabel("Saldo:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtSaldo = new JTextField(10); // Tamaño ajustado
        panelCuenta.add(txtSaldo, gbc);

        mainPanel.add(panelCuenta, BorderLayout.NORTH);

        // Panel para Reporte
        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setBorder(BorderFactory.createTitledBorder("Reporte"));
        txtReporte = new JTextArea();
        txtReporte.setEditable(false);
        JScrollPane scrollReporte = new JScrollPane(txtReporte);
        panelCentro.add(scrollReporte, BorderLayout.CENTER);

        mainPanel.add(panelCentro, BorderLayout.CENTER);

        // Panel para ordenar
        JPanel panelOrdenar = new JPanel(new GridLayout(3, 1));
        panelOrdenar.setBorder(BorderFactory.createTitledBorder("Ordenar"));

        rbNumero = new JRadioButton("Nro. Cuenta");
        rbNombre = new JRadioButton("Nombre");
        rbSaldo = new JRadioButton("Saldo");

        // Grupo de botones para ordenar
        ButtonGroup grupoOrdenar = new ButtonGroup();
        grupoOrdenar.add(rbNumero);
        grupoOrdenar.add(rbNombre);
        grupoOrdenar.add(rbSaldo);

        panelOrdenar.add(rbNumero);
        panelOrdenar.add(rbNombre);
        panelOrdenar.add(rbSaldo);

        mainPanel.add(panelOrdenar, BorderLayout.EAST);

        // Panel de mantenimiento
        JPanel panelMantemiento = new JPanel();
        panelMantemiento.setLayout(new BoxLayout(panelMantemiento, BoxLayout.X_AXIS));
        panelMantemiento.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Añadir márgenes

        btnRegistrar = new JButton("Registrar");
        btnImprimir = new JButton("Imprimir");
        btnBuscar = new JButton("Buscar");
        btnEliminar = new JButton("Eliminar");

        // Añadiendo espaciado entre los botones
        panelMantemiento.add(btnRegistrar);
        panelMantemiento.add(Box.createRigidArea(new Dimension(10, 0))); // Espacio entre botones
        panelMantemiento.add(btnImprimir);
        panelMantemiento.add(Box.createRigidArea(new Dimension(10, 0)));
        panelMantemiento.add(btnBuscar);
        panelMantemiento.add(Box.createRigidArea(new Dimension(10, 0)));
        panelMantemiento.add(btnEliminar);

        mainPanel.add(panelMantemiento, BorderLayout.SOUTH);

        // Funcionalidad de los botones
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(txtNumero.getText().trim());
                double saldo = Double.parseDouble(txtSaldo.getText().trim());
                String tipoCliente = txtTipoCliente.getText().trim();
                String nombre = txtNombre.getText().trim();
                op.registrarCuenta(numero, saldo, tipoCliente, nombre);

                limpiarCampos();
                JOptionPane.showMessageDialog(null, "Cuenta registrada correctamente!");
            }
        });

        btnImprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtReporte.setText(op.imprimirCuenta());
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(txtNumero.getText().trim());
                txtReporte.setText(op.buscarCuenta(numero));

                limpiarCampos();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(txtNumero.getText().trim());
                op.eliminarCuenta(numero);

                limpiarCampos();
                JOptionPane.showMessageDialog(null, "Cuenta eliminada!");
            }
        });


        rbNumero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criterioOrden = "numero";
                op.ordenarSegunCriterio(criterioOrden);
            }
        });

        rbNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criterioOrden = "nombre";
                op.ordenarSegunCriterio(criterioOrden);
            }
        });

        rbSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criterioOrden = "saldo";
                op.ordenarSegunCriterio(criterioOrden);
            }
        });
    }

    private void limpiarCampos() {
        txtNumero.setText("");
        txtSaldo.setText("");
        txtTipoCliente.setText("");
        txtNombre.setText("");
    }
}
