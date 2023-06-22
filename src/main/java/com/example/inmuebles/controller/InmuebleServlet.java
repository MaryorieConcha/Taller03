package com.example.inmuebles.controller;

import com.example.inmuebles.model.Inmueble;
import com.example.inmuebles.model.data.DBGenerator;
import com.example.inmuebles.model.data.dao.InmuebleDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "InmuebleServlet", value = "/inmueble")
public class InmuebleServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("InmueblesBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/agregarInmueble.jsp");
        respuesta.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/agregarInmueble.jsp");
        if (req.getParameter("cod_inmueble").length()!=0 && req.getParameter("tipoConstruccion").length()!=0 && req.getParameter("ciudad").length()!=0
                && req.getParameter("direccion").length()!=0 && req.getParameter("precio").length()!=0){
            int cod_inmueble = Integer.parseInt(req.getParameter("cod_inmueble"));
            String tipoConstruccion = req.getParameter("tipoConstruccion");
            String ciudad = req.getParameter("ciudad");
            String direccion = req.getParameter("direccion");
            int precio = Integer.parseInt(req.getParameter("precio"));
            Inmueble inmueble = new Inmueble(cod_inmueble,tipoConstruccion,ciudad,direccion,precio);
            try {
                if (agregarInmueble(inmueble)){
                    req.setAttribute("inmueble", inmueble);
                    respuesta = req.getRequestDispatcher("/index.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }

    private boolean agregarInmueble(Inmueble inmueble) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("InmueblesBD");
        List<Inmueble> inmuebles = InmuebleDAO.obtenerInmueble(query,"cod_inmueble", inmueble.getCod_inmueble());
        if (inmuebles.size()!=0){
            return false;
        }
        else {
            InmuebleDAO.agregarInmueble(query, inmueble);
            return true;
        }
    }
}