package Modelo.DAO;

import Controlador.Conexion;
import Modelo.OrdenesDeTrabajo;
import Modelo.Productos;
import Modelo.Supervisores;
import Modelo.Tareas;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class OrdenTrabajoDB {

    public static ArrayList<OrdenesDeTrabajo> selectOT() {

        ArrayList<OrdenesDeTrabajo> OT = new ArrayList<OrdenesDeTrabajo>();
        Productos producto = new Productos();
        ArrayList<Tareas> tareas = new ArrayList<Tareas>();
        Supervisores supervisor = new Supervisores();

        try {
            Connection conn = Conexion.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT codigoOT, fechaRegistracion, codigoProducto, cantidadRequerida, fechaFinalizacion," +
                    "descripcion, urgente, responsables, documentoSupervisor, codigoTarea FROM OrdenesDeTrabajo");

            while (rs.next()) {

                producto= selectProducto(rs.getInt("codigoProducto"));
                tareas = selectTarea(rs.getInt("codigoTarea"));
                supervisor = selectSupervisor(rs.getLong("documentoSupervisor"));

                Calendar fechaRegistracion = Calendar.getInstance();
                fechaRegistracion.setTime(rs.getDate("fechaRegistracion"));

                Calendar fechaFinalizacion = Calendar.getInstance();
                fechaFinalizacion.setTime(rs.getDate("fechaFinalizacion"));

                OT.add(new OrdenesDeTrabajo(rs.getInt("codigoOT"), fechaRegistracion, producto,
                        rs.getInt("cantidadRequerida"), fechaFinalizacion, rs.getString("descripcion"),
                        rs.getBoolean("urgente"), rs.getString("responsables"), supervisor,tareas));
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return OT;
    }

    private static Supervisores selectSupervisor(long documentoSupervisor) {

        Supervisores supervisor = new Supervisores();
        return supervisor;
    }

    private static ArrayList<Tareas> selectTarea(int codigoTarea) {

        ArrayList<Tareas> tareas = new ArrayList<Tareas>();
        return tareas;
    }

    private static Productos selectProducto(int codigoProducto) {

        Productos producto = new Productos();
        return producto;
    }

    public static void deleteOT(int codigoOT) {

        try {
            Connection conn = Conexion.getConnection();
            CallableStatement stmt;

            stmt = conn.prepareCall("{call deleteOT(?)}");
            stmt.setInt(1, codigoOT);
            stmt.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
