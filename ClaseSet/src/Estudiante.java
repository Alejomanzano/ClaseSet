import java.util.Objects;

public class Estudiante {
    private String nombre;
    private int matricula;

    public Estudiante(String nombre, int matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Estudiante)) return false;
        Estudiante otro = (Estudiante) obj;
        return matricula == otro.matricula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre='" + nombre + "', matricula=" + matricula + '}';
    }
}
ndkdj
import java.util.*;

public class AutomovilController {
    private ArrayList<Automovil> lista = new ArrayList<>();

    public AutomovilController() {
        lista.add(new Automovil(1, "Toyota", "1.6L", 15000f));
        lista.add(new Automovil(2, "Chevrolet", "1.4L", 13000f));
        lista.add(new Automovil(3, "Toyota", "2.0L", 22000f));
        lista.add(new Automovil(4, "Kia", "1.2L", 12000f));
    }

    public void agregarActualizarAuto(int codigo, String marca, String cilindraje, float precio) {
        for (Automovil auto : lista) {
            if (auto.getCodigo() == codigo) {
                auto.setMarca(marca);
                auto.setCilindraje(cilindraje);
                auto.setPrecio(precio);
                return;
            }
        }
        lista.add(new Automovil(codigo, marca, cilindraje, precio));
    }

    public ArrayList<Automovil> filtrarYOrdenar(String marca, float precioMin) {
        ArrayList<Automovil> resultado = new ArrayList<>();
        for (Automovil a : lista) {
            if (a.getMarca().equalsIgnoreCase(marca) && a.getPrecio() > precioMin) {
                resultado.add(a);
            }
        }
        resultado.sort((a1, a2) -> Float.compare(a2.getPrecio(), a1.getPrecio()));
        return resultado;
    }

    public int contarRecursivo(String marca) {
        return contarRecursivoAux(0, marca);
    }

    private int contarRecursivoAux(int index, String marca) {
        if (index == lista.size()) return 0;
        int suma = lista.get(index).getMarca().equalsIgnoreCase(marca) ? 1 : 0;
        return suma + contarRecursivoAux(index + 1, marca);
    }

    public String mostrarLista() {
        StringBuilder sb = new StringBuilder();
        for (Automovil auto : lista) {
            sb.append(auto.toString());
        }
        return sb.toString();
    }

    public Set<String> obtenerMarcas() {
        Set<String> marcas = new TreeSet<>();
        for (Automovil auto : lista) {
            marcas.add(auto.getMarca());
        }
        return marcas;
    }
}

public class Automovil {
    private int codigo;
    private String marca;
    private int cilindraje;
    private float precio;

    public Automovil(int codigo, String marca, int cilindraje, float precio) {
        this.codigo = codigo;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.precio = precio;
    }

    public Automovil(int codigo, int marca, String cilindraje, float precio) {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }



    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "codigo=" + codigo +
                ", marca='" + marca + '\'' +
                ", cilindraje=" + cilindraje +
                ", precio=" + precio +
                '}';
    }
}
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTextField txtCodigo;
    private JComboBox cbMarca;
    private JComboBox cbCilindraje;
    private JTextField txtPrecio;
    private JTextArea txtArea;
    private JButton btnAgregar;
    private AutomovilController automovilController = new AutomovilController();

    public Ventana() {
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(txtCodigo.getText().toString());
                String marca = cbMarca.getActionCommand().toString();
                int cilindraje = Integer.parseInt(cbCilindraje.getSelectedItem().toString());
                float precio = Float.parseFloat(txtPrecio.getText().toString());
                automovilController = new AutomovilController(codigo,marca,cilindraje,precio);

                txtArea.setText(automovilController.toString());

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class AutomovilController {
    private ArrayList<Automovil> lista = new ArrayList<>();

    public AutomovilController() {

    }

    public AutomovilController(int codigo, String marca, int cilindraje, float precio) {
    }

    public void agregarActualizarAuto(int codigo, String marca, int cilindraje, float precio) {
        for (Automovil auto : lista) {
            if (auto.getCodigo() == codigo) {
                auto.setMarca(marca);
                auto.setCilindraje(cilindraje);
                auto.setPrecio(precio);
                return;
            }
        }
        lista.add(new Automovil(codigo, marca, cilindraje, precio));
    }

    public ArrayList<Automovil> filtrarYOrdenar(String marca, float precioMin) {
        ArrayList<Automovil> resultado = new ArrayList<>();
        for (Automovil a : lista) {
            if (a.getMarca().equalsIgnoreCase(marca) && a.getPrecio() > precioMin) {
                resultado.add(a);
            }
        }
        resultado.sort((a1, a2) -> Float.compare(a2.getPrecio(), a1.getPrecio()));
        return resultado;
    }

    public int contarRecursivo(String marca) {
        return contarRecursivoAux(0, marca);
    }

    private int contarRecursivoAux(int index, String marca) {
        if (index == lista.size()) return 0;
        int suma = lista.get(index).getMarca().equalsIgnoreCase(marca) ? 1 : 0;
        return suma + contarRecursivoAux(index + 1, marca);
    }

    public String mostrarLista() {
        StringBuilder sb = new StringBuilder();
        for (Automovil auto : lista) {
            sb.append(auto.toString());
        }
        return sb.toString();
    }

    public Set<String> obtenerMarcas() {
        Set<String> marcas = new TreeSet<>();
        for (Automovil auto : lista) {
            marcas.add(auto.getMarca());
        }
        return marcas;
    }

}
