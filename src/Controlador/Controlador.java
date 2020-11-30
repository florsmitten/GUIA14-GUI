package Controlador;

import Modelo.DAO.OrdenTrabajoDB;
import Modelo.DAO.ProductosDB;
import Modelo.DAO.SupervisoresDB;
import Modelo.OrdenesDeTrabajo;
import Modelo.Productos;
import Modelo.Supervisores;

import java.util.ArrayList;
import java.util.TreeSet;

public class Controlador {

    static ArrayList<Productos> productos = ProductosDB.selectProductos();
    static ArrayList<Supervisores> supervisores = SupervisoresDB.selectSupervisores();
    static ArrayList<OrdenesDeTrabajo> ordenesDeTrabajoList = OrdenTrabajoDB.selectOT();
}
