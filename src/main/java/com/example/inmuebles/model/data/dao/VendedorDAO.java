package com.example.inmuebles.model.data.dao;

import com.example.inmuebles.model.Vendedor;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class VendedorDAO {
    public static void agregarVendedor(DSLContext query, Vendedor vendedor){
        Table tablaVendedor = table(name("Vendedor"));
        Field[] columnas = tablaVendedor.fields("nombre","rut","direccion","tituloProfesional","estadoCivil");
        query.insertInto(tablaVendedor, columnas[0], columnas[1],columnas[2],columnas[3],columnas[4])
                .values(vendedor.getNombre(),vendedor.getRut(),vendedor.getDireccion(),vendedor.getTituloProfesional(),vendedor.getEstadoCivil())
                .execute();
    }

    public static List obtenerVendedor(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Vendedor")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaVendedores(resultados);
    }
    public static List obtenerVendedores(DSLContext query){
        Result resultados = query.select().from(DSL.table("Vendedor")).fetch();
        return obtenerListaVendedores(resultados);
    }

    private static List obtenerListaVendedores(Result resultados){
        List<Vendedor> vendedores = new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String nombre = (String) resultados.getValue(fila,"nombre");
            String rut = (String) resultados.getValue(fila,"rut");
            String direccion = (String) resultados.getValue(fila,"direccion");
            String tituloProfesional = (String) resultados.getValue(fila,"tituloProfesional");
            String estadoCivil = (String) resultados.getValue(fila,"estadoCivil");
            vendedores.add(new Vendedor(nombre,rut,direccion,tituloProfesional,estadoCivil));
        }
        return vendedores;
    }
}