package com.crud.empleados.controller;

import com.crud.empleados.exeptions.ResourceNotFoundException;
import com.crud.empleados.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.crud.empleados.repository.EmpleadoRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200/")
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository repository;

    @GetMapping("/saludo")
    public String Hola(){
        return "Que onda morro";
    }

    //Obtener lista de Empleados
    @GetMapping("/empleados")
    public List<Empleado> getEmployes(){
        return repository.findAll();
    }

    //Agregar Empleado
    @PostMapping("/empleados")
    public void saveEmploye(@RequestBody Empleado empleado){ repository.save(empleado); }

    //Obtener un unico Empleado
    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> getEmpleado(@PathVariable Long id){
        Empleado empleado = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employe No. "+id+" Not Found "));
        return ResponseEntity.ok(empleado);
    }

    //Actualizar Empleado
    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable Long id, @RequestBody Empleado empleadoEdit){
        //Encontrar el empleado con ese Id y preparar posible excepcion
        Empleado empleado = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employe No. "+id+" Not Found."));

        //Cargar data al nuevo empelado
        empleado.setNombre(empleadoEdit.getNombre());
        empleado.setApellidos(empleadoEdit.getApellidos());
        empleado.setEmail(empleadoEdit.getEmail());

        //Actualizar
            Empleado empleadoActualizado = repository.save(empleado);
            return ResponseEntity.ok(empleadoActualizado);
    }

    //Eliminar el Empleado
    @DeleteMapping("/empleados/{id}")
    public void deleteEmpleado(@PathVariable Long id){
            repository.deleteById(id);
    }

}
