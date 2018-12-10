package com.ifpb.atividade.model;

import com.vividsolutions.jts.io.ParseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDao {
    public List<String> getCidadesEstado(Connection conn, String estado) throws SQLException, ParseException {
        List<String> cidades = new ArrayList<String>();
        String sql = "select im.nome\n from info_municipio im, info_estado ie\n" +
                "where (im.estado_id = ie.id) and (ie.nome ilike ?)";
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(sql);
        pstm.setString(1, estado);
        ResultSet rs = pstm.executeQuery();
        if(rs != null){
            while(rs.next()){
                cidades.add(rs.getString("nome"));
            }
            return cidades;
        }
        else{
            return null;
        }
    }

    public Integer getPopulacao(Connection conn, String cidade) throws SQLException {
        String sql = "select populacao_2010 from info_municipio where nome ilike ?";
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(sql);
        pstm.setString(1, cidade);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()){
            return Integer.parseInt(rs.getString("populacao_2010"));
        }
        return 0;
    }
}
