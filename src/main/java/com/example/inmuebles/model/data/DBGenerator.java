package com.example.inmuebles.model.data;

import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class DBGenerator {

    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root","");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create,nombreBD);
        create = actualizarConexion(connection,nombreBD);
        crearTablaVendedor(create);
        crearTablaInmueble(create);
        relacionarTabla(create,"Inmueble","rut","Vendedor");
        DBConnector.closeConnection();

    }
    public static DSLContext conectarBD(String nombre) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombre,"root","");
        DSLContext create = DSL.using(connection);
        return create;
    }
    private static void crearBaseDato(DSLContext create, String nombreBD){
        create.createDatabaseIfNotExists(nombreBD).execute();
    }

    private static DSLContext actualizarConexion(Connection connection,String nombreBD){
        DBConnector.closeConnection();
        connection= DBConnector.connection(nombreBD,"root","");
        DSLContext create=DSL.using(connection);
        return create;
    }

    private static void crearTablaVendedor(DSLContext create){
        create.createTableIfNotExists("Vendedor").column("nombre",VARCHAR(50))
                .column("rut",VARCHAR(50))
                .column("direccion",VARCHAR(100))
                .column("tituloProfesional",VARCHAR(50))
                .column("estadoCivil",VARCHAR(50))
                .constraint(primaryKey("rut")).execute();
    }

    private static void crearTablaInmueble(DSLContext create){
        create.createTableIfNotExists("Inmueble").column("cod_inmueble",INTEGER)
                .column("tipoConstruccion",VARCHAR(100))
                .column("ciudad",VARCHAR(70))
                .column("direccion",VARCHAR(100))
                .column("precio",INTEGER)
                .constraint(primaryKey("cod_inmueble")).execute();

    }
    private static void relacionarTabla(DSLContext create, String nombreTabla, String claveForanea, String nombreTablaRelacion){
        //  create.alterTableIfExists(nombreTabla).add(foreignKey(claveForanea).references(nombreTablaRelacion)).execute();
        create.alterTableIfExists(nombreTabla).alterConstraint(foreignKey(claveForanea).references(nombreTablaRelacion)).enforced();
    }
    private static void agregarColumnaTabla(DSLContext create, String nombreTabla, String columna, DataType tipoColumna){
        create.alterTableIfExists(nombreTabla).addColumn(columna,tipoColumna);
    }

}
