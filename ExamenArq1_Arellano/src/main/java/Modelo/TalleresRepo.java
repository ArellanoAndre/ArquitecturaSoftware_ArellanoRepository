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

public class TalleresRepo {
    private final List<Taller> listaTaller = new ArrayList<>();
    private int id; // si quieres autoincremento para nuevos talleres

    public TalleresRepo() {
        // Datos de ejemplo
        listaTaller.add(new Taller(1, "Desarrollo Web con React", "Ing. Laura Hernández",
                "Lunes 9:00 AM – 12:00 PM", "3 horas", "Aula B-201", 25, "Presencial"));
        listaTaller.add(new Taller(2, "Introducción a Ciberseguridad", "Mtro. Carlos Ramírez",
                "Martes 2:00 PM – 5:00 PM", "3 horas", "Aula C-101", 30, "Presencial"));
        listaTaller.add(new Taller(3, "Inteligencia Artificial y Chatbots", "Dra. Sofía López",
                "Miércoles 10:00 AM – 1:00 PM", "3 horas (1 sesión)", "Aula Magna, Edificio B", 20, "Presencial"));
    }

    public List<Taller> findAll() { return new ArrayList<>(listaTaller); }

    public Taller findById(int id) {
        Optional<Taller> t = listaTaller.stream().filter(x -> x.getId() == id).findFirst();
        return t.orElse(null);
    }

    public void add(Taller t) { listaTaller.add(t); }
    
      public Taller buscarPorId(int id) {
        for (Taller t : listaTaller) {
            if (t.getId() == id) return t;
        }
        return null;
    }
    
     // /** Datos de ejemplo (se ejecuta al iniciar el repositorio) */
    private void cargarDatosDemo() {
        listaTaller.add(new Taller(1, "Taller de Desarrollo Web con React", "Ing. Laura Hernández",
                "Lunes 9:00 AM – 12:00 PM", "3 horas", "Aula Magna A", 25, "Presencial"));

        listaTaller.add(new Taller(2, "Taller de Introducción a Ciberseguridad", "Mtro. Carlos Ramírez",
                "Martes 2:00 PM – 5:00 PM", "3 horas", "Aula Magna B", 30, "Presencial"));

        listaTaller.add(new Taller(3, "Taller de Inteligencia Artificial y Chatbots", "Dra. Sofía López",
                "Miércoles 10:00 AM – 1:00 PM", "3 horas", "Edificio B, Aula Magna de Informática", 20, "Presencial"));
    }
}

