package Controlador;

import Modelo.*;
import Modelo.DAO.*;
import java.util.ArrayList;

public class Controlador {

    static ArrayList<Productos> productos = ProductosDB.selectProductos();
    static ArrayList<Supervisores> supervisores = SupervisoresDB.selectSupervisores();
    static ArrayList<Operarios> operarios = OperariosDB.selectOperarios();
    static ArrayList<OrdenesDeTrabajo> ordenesDeTrabajoList = OrdenTrabajoDB.selectOT();
    static ArrayList<Tareas> tareasList = TareasDB.selectTarea();
}
