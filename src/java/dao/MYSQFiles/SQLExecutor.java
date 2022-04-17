package model.SQLFiles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLExecutor {
    SQLConnector dbConnector;
    PreparedStatement stmt;
    ResultSet rs;

    public SQLExecutor(String user, String password){
        try{dbConnector = SQLConnector.getInstance(user, password);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }

    public void prepareStatement(String[] parametros) {
        try{
            stmt = dbConnector.getConnection().prepareStatement(parametros[0]);
            for(int i = 1; i<parametros.length; i++){
                stmt.setString(i, parametros[i]);
            }
            stmt.executeUpdate(); //delete, update, insert

        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public ResultSet ejecutaQuery(String sql){
        try{
            stmt = dbConnector.getConnection().prepareStatement(sql);
            rs = stmt.executeQuery();

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return rs;
    }

    public SQLConnector getDbConnector() {
        return dbConnector;
    }

    public void setDbConnector(SQLConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    public PreparedStatement getStmt() {
        return stmt;
    }

    public void setStmt(PreparedStatement stmt) {
        this.stmt = stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }



    
}
