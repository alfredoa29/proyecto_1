/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.MYSQLDAO;

import dao.IAdminDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.AdministradorModel;
import model.SQLFiles.SQLExecutor;

/**
 *
 * @author Alfredo
 */
public class MySQLAdminDAO implements IAdminDAO {

    private SQLExecutor executor;

    public MySQLAdminDAO(SQLExecutor executor) {
        this.executor = executor;
    }
    
    @Override
    public void insetar(AdministradorModel a) {
        
                AdministradorModel administrador  = a;
       // SQLExecutor executor = new SQLExecutor("root", "123456");
        String valores[] = new String[2];
        valores[0] = "insert into administrador(idadministrador) values(?)";
        valores[1] = Integer.toString((administrador.getId()));

        executor.prepareStatement(valores);
    }

    @Override
    public void modificar(AdministradorModel a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(AdministradorModel a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AdministradorModel> obtenerTodos() {
                List<AdministradorModel> list  = new ArrayList<>();
       // SQLExecutor executor = new SQLExecutor("root", "123456");
        ResultSet rs = executor.ejecutaQuery("SELECT * FROM administrador");

        try {
            while (rs.next()){
                AdministradorModel comodin = new AdministradorModel();
                comodin.setId(rs.getInt("idadministrador"));
                list.add(comodin);

            }
        }catch (SQLException ex){
        }

        return list;
    }

    @Override
    public AdministradorModel obtener(Integer id) {
       
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    }
