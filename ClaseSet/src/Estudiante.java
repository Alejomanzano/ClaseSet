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
