package com.ifpb.atividade.control;

import com.ifpb.atividade.model.CidadeDao;
import com.ifpb.atividade.model.ConnectionFactory;
import com.ifpb.atividade.model.EstadoDao;
import com.vividsolutions.jts.io.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Controller")

public class FrontController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        try {
            Connection conn = ConnectionFactory.getConnection();
            String estado1 = request.getParameter("estado1");
            String cidade1 = request.getParameter("cidade1");
            request.setAttribute("cidadeEscolhida1", cidade1);
            request.setAttribute("estadoEscolhido1", estado1);
            EstadoDao dao = new EstadoDao();
            CidadeDao cDao = new CidadeDao();
            List<String> estados = dao.getNomeEstados(conn);
            List<String> cidades = cDao.getCidadesEstado(conn, estado1);
            request.setAttribute("estados", estados);
            request.setAttribute("cidades", cidades);
            request.setAttribute("populacao1", cDao.getPopulacao(conn, cidade1));
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
}

