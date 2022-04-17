/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.MYSQFiles.IEspecialidadDAO;

/**
 *
 * @author Alfredo
 */
public interface IDAOManager {
    IAdminDAO getIAdminDAO();
    IEspecialidadDAO getIEspecialidadDAO();

}
