/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Arell
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServicioAcademico {
    private final List<Alumno> listaAlumnos = new ArrayList<>();
    private int id; // si luego quieres dar de alta alumnos

    public ServicioAcademico() {
        // Datos de ejemplo
        listaAlumnos.add(new Alumno(229842, "Isaac Andre Arellano", "5°",
                "Ingeniería en Software", "andre.02@potros.edu.mx"));
        listaAlumnos.add(new Alumno(20251024567L > Integer.MAX_VALUE ? 123456789 : 102345678,  // por si usabas antes 11 dígitos
                "Luis Fernando García Pérez", "3°",
                "Ingeniería en Sistemas Computacionales", "luis.garcia@cetis69.edu.mx"));
        // agrega más si quieres…
    }

    public Alumno findById(int id) {
        Optional<Alumno> a = listaAlumnos.stream().filter(x -> x.getId() == id).findFirst();
        return a.orElse(null);
    }

    public List<Alumno> findAll() {
        return new ArrayList<>(listaAlumnos);
    }
     public Alumno buscarPorId(int id) {
        for (Alumno a : listaAlumnos) {
            if (a.getId() == id) return a;
        }
        return null;
    }
    
     //  /** Carga alumnos de ejemplo para pruebas */
    private void cargarDatosDemo() {
        listaAlumnos.add(new Alumno(229842, "Isaac Andre Arellano", "5°", "Ingeniería en Software", "andre.02@potros.edu.mx"));
        listaAlumnos.add(new Alumno(20250467, "Luis Fernando García Pérez", "3°", "Ingeniería en Software", "lf.garcia@potros.edu.mx"));
        listaAlumnos.add(new Alumno(20250321, "María Fernanda López Díaz", "1°", "Ingeniería en Software", "m.fernanda@potros.edu.mx"));
        listaAlumnos.add(new Alumno(20250488, "Carlos Alberto Ramírez Soto", "3°", "Ingeniería en Software", "car.ramirez@potros.edu.mx"));
    }
}

