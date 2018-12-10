package com.ifpb.atividade.model;

import com.vividsolutions.jts.io.ParseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDao {
    public List<String> getNomeEstados(Connection conn) throws SQLException, ParseException {
        List<String> estados = new ArrayList<String>();
        String sql = "SELECT nome FROM info_estado";
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        if(rs != null){
            while(rs.next()){
                estados.add(rs.getString("nome"));
            }
            return estados;
        }
        else{
            return null;
        }
    }
}
