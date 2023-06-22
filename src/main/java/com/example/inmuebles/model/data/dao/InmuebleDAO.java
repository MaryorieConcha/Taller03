package com.example.inmuebles.model.data.dao;

import com.example.inmuebles.model.Inmueble;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class InmuebleDAO {
    public static void agregarInmueble(DSLContext query, Inmueble inmueble){
        Table tablaInmueble = table(name("Inmueble"));
        Field[] columnas = tablaInmueble.fields("cod_inmueble","tipoConstruccion","ubicacionGeografica","precio");
        query.insertInto(tablaInmueble, columnas[0], columnas[1],columnas[2],columnas[3])
                .values(inmueble.getCod_inmueble(),inmueble.getTipoConstruccion(),inmueble.getCiudad(),inmueble.getPrecio())
                .execute();
    }

    public static List obtenerInmueble(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Inmueble")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaVendedores(resultados);
    }
    public static List obtenerInmuebles(DSLContext query){
        Result resultados = query.select().from(DSL.table("Inmueble")).fetch();
        return obtenerListaVendedores(resultados);
    }

    private static List obtenerListaVendedores(Result resultados){
        List<Inmueble> inmuebles = new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            int cod_inmueble = (int) resultados.getValue(fila,"cod_inmueble");
            String tipoConstruccion = (String) resultados.getValue(fila,"tipoConstruccion");
            String ciudad = (String) resultados.getValue(fila,"ciudad");
            String direccion = (String) resultados.getValue(fila,"direccion");
            int precio = (int) resultados.getValue(fila,"precio");
            inmuebles.add(new Inmueble(cod_inmueble,tipoConstruccion,ciudad,direccion,precio));
        }
        return inmuebles;
    }
}