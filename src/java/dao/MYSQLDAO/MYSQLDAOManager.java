/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.MYSQLDAO;

import dao.IAdminDAO;
import dao.IDAOManager;
import dao.MYSQFiles.IEspecialidadDAO;
import dao.MYSQLDAO.MYSQLEspecialidadDAO;
import dao.MYSQLDAO.MySQLAdminDAO;
import java.util.List;
import model.AdministradorModel;
import model.EspecialidadModel;
import model.SQLFiles.SQLExecutor;

/**
 *
 * @author Alfredo
 */
public class MYSQLDAOManager implements IDAOManager {
    
    private SQLExecutor executor = null;
    private IAdminDAO administradores = null;
    private IEspecialidadDAO especialidades= null;

    
    //crea la conexion con el server, agregando la clave y contrasena del server
    // y este se envia a todos los DAO y asi no tener que poner estos datos en
    //todas las clases
    public MYSQLDAOManager() {
        this.executor = new SQLExecutor("root", "123456");
    }

    @Override
    public IAdminDAO getIAdminDAO() {
        if(administradores == null){
            administradores = new MySQLAdminDAO(executor);
            
        }
        return administradores;
    }

 
    @Override
    public IEspecialidadDAO getIEspecialidadDAO() {
        if(especialidades == null){
            especialidades = new MYSQLEspecialidadDAO(executor) {};
            
        }
        return especialidades;
    }
    
        public static void main(String [] args){
        
            MYSQLDAOManager manager = new MYSQLDAOManager();
            List<AdministradorModel> admins = manager.getIAdminDAO().obtenerTodos();
            System.out.println(admins);
            EspecialidadModel especialidad1 = new EspecialidadModel(4,"CIRUJANOMOD2");
             EspecialidadModel especialidad2 = new EspecialidadModel(5,"PSICOLOGIAMOD");
             EspecialidadModel especialidad3 = new EspecialidadModel("FISIOTERAPIA");
             EspecialidadModel especialidad4 = new EspecialidadModel("CARDIOLOGIA");
             EspecialidadModel especialidad6 = new EspecialidadModel("DERTMATOLOGIA");
            //System.out.println(especialidad1.toString());
            // manager.getIEspecialidadDAO().insetar(especialidad2);
             //manager.getIEspecialidadDAO().insetar(especialidad3);
             //manager.getIEspecialidadDAO().insetar(especialidad4);
             
              manager.getIEspecialidadDAO().modificar(especialidad2);
             manager.getIEspecialidadDAO().obtenerTodos();
             List<EspecialidadModel> especi = manager.getIEspecialidadDAO().obtenerTodos();
                

            System.out.println("IMPRIMIENDO OBTENER SOLO UNA ESPECIALIDAD :\n ");
            EspecialidadModel especialidad5 = manager.getIEspecialidadDAO().obtener(6);
            System.out.println(especialidad5.toString());
            
              //manager.getIEspecialidadDAO().eliminar(especialidad1);
            //System.out.println(especialidad2.toString());
          // System.out.println(manager.getIEspecialidadDAO().obtenerTodos());
        for (EspecialidadModel ad: especi ){
           System.out.println(ad.toString());
       }
    }

}
