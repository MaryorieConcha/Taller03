package com.example.inmuebles.controller;

import com.example.inmuebles.model.Vendedor;
import com.example.inmuebles.model.data.DBGenerator;
import com.example.inmuebles.model.data.dao.VendedorDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "VendedorServlet", value = "/vendedor")
public class VendedorServlet extends HttpServlet {

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
        RequestDispatcher respuesta = req.getRequestDispatcher("/agregarVendedor.jsp");
        respuesta.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/agregarVendedores.jsp");
        if (req.getParameter("nombre").length()!=0 && req.getParameter("rut").length()!=0 && req.getParameter("direccion").length()!=0
                && req.getParameter("tituloProfesional").length()!=0 && req.getParameter("estadoCivil").length()!=0){
            String nombre = req.getParameter("nombre");
            String rut = req.getParameter("rut");
            String direccion = req.getParameter("direccion");
            String tituloProfesional = req.getParameter("tituloProfesional");
            String estadoCivil = req.getParameter("estadoCivil");
            Vendedor vendedor = new Vendedor(nombre, rut, direccion, tituloProfesional,estadoCivil);
            try {
                if (agregarVendedor(vendedor)){
                    req.setAttribute("producto", vendedor);
                    respuesta = req.getRequestDispatcher("/index.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }

    private boolean agregarVendedor(Vendedor vendedor) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("InmueblesBD");
        List<Vendedor> vededores = VendedorDAO.obtenerVendedor(query,"nombre", vendedor.getNombre());
        if (vededores.size()!=0){
            return false;
        }
        else {
            VendedorDAO.agregarVendedor(query, vendedor);
            return true;
        }
    }
}