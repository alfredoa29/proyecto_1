/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.MYSQLDAO;

import dao.MYSQFiles.IEspecialidadDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.EspecialidadModel;
import model.SQLFiles.SQLExecutor;

/**
 *
 * @author Alfredo
 */
public class MYSQLEspecialidadDAO implements IEspecialidadDAO {
   
      final String GETONE = "SELECT idespecialidades, nombre FROM especialidades where idespecialidades = ?";
      final String DELETE = "DELETE FROM especialidades WHERE idespecialidades = ?";
      final String UPDATE = "UPDATE especialidades set nombre = ? where idespecialidades = ?";
private SQLExecutor executor;

    public MYSQLEspecialidadDAO(SQLExecutor executor) {
        this.executor = executor;
    }

    @Override
    public void insetar(EspecialidadModel a) {
         EspecialidadModel especialidad  = a;
       // SQLExecutor executor = new SQLExecutor("root", "123456");
       //AQUI NO SE PONE EL ID, YA QUE EL SERVER LO CREÓ Y SABE CUAL  MODIFICAR
        String valores[] = new String[2];
        valores[0] = "insert into especialidades(nombre) values(?)";
        valores[1] = especialidad.getNombre();

        executor.prepareStatement(valores);
    }

    @Override
    public void modificar(EspecialidadModel a) {
          try {
              EspecialidadModel especialidadModel = a;
              
              executor.setStmt(executor.getDbConnector().getConnection().prepareStatement(UPDATE)) ;
              executor.getStmt().setString(1,a.getNombre() );
              executor.getStmt().setInt(2, a.getId());
                if(executor.getStmt().executeUpdate()==0){
                throw new SQLException("ESPECIALIDAD PSOBILEMENTE NO ACtualizada");
            }
          } catch (SQLException ex) {
              Logger.getLogger(MYSQLEspecialidadDAO.class.getName()).log(Level.SEVERE, null, ex);
          }  finally {
        if (executor.getStmt() != null){
            try{
                executor.getStmt().close();
            } catch (SQLException ex) {
                Logger.getLogger(MYSQLEspecialidadDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
          }
    }
    
    @Override
    public void eliminar(EspecialidadModel a) {
       EspecialidadModel comodin = new EspecialidadModel();
    try {
        
        //ResultSet rs = null;
  
        executor.setStmt(executor.getDbConnector().getConnection().prepareStatement(DELETE)) ;
        //se saca el id del objeto y se le asigna el id a la fila en la base de datps
        //hay que darle una pista a la base de cual es el id que se quiere eliminar
        executor.getStmt().setInt(1, a.getId());
        //rs = executor.getStmt().executeQuery();
            if(executor.getStmt().executeUpdate()==0){
                throw new SQLException("ESPECIALIDAD PSOBILEMENTE NO ELIMINADA");
            }


        }catch (SQLException ex){
        } finally {
        if (executor.getStmt() != null){
            try{
                executor.getStmt().close();
            } catch (SQLException ex) {
                Logger.getLogger(MYSQLEspecialidadDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }

    @Override
    public List<EspecialidadModel> obtenerTodos() {
                List<EspecialidadModel> list  = new ArrayList<>();
       // SQLExecutor executor = new SQLExecutor("root", "123456");
        ResultSet rs = executor.ejecutaQuery("SELECT * FROM especialidades");

        try {
            while (rs.next()){
                EspecialidadModel comodin = new EspecialidadModel();
                comodin.setId(rs.getInt("idespecialidades"));
                comodin.setNombre(rs.getString("nombre"));
                list.add(comodin);

            }
        }catch (SQLException ex){
        }

        return list;
    }

    @Override
    public EspecialidadModel obtener(Integer id) {
        
      
       EspecialidadModel comodin = new EspecialidadModel();
    try {
        
        ResultSet rs = null;
  
        executor.setStmt(executor.getDbConnector().getConnection().prepareStatement(GETONE)) ;
        executor.getStmt().setInt(1, id);
        rs = executor.getStmt().executeQuery();

         while (rs.next()){
         comodin.setId(rs.getInt("idespecialidades"));
         comodin.setNombre(rs.getString("nombre"));
         }


        }catch (SQLException ex){
        }
        
    return comodin;
    }
    
}