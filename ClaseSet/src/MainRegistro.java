import java.util.HashSet;
import java.util.Set;

public class MainRegistro {
    public static void main(String[] args) {
        Set<Estudiante> estudiantes = new HashSet<>();

        Estudiante e1 = new Estudiante("Kim", 2001);
        Estudiante e2 = new Estudiante("Pedro", 2002);
        Estudiante e3 = new Estudiante("Ainhoa", 2001); // Duplicado por matrícula

        estudiantes.add(e1);
        estudiantes.add(e2);
        estudiantes.add(e3); // No se añade

        System.out.println("Estudiantes registrados:");
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }
    }
}
