/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DAOTime;
import interdisciplinar.Time;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author yurib
 */
public class TimeController {
        public int salvarTime(Time time) {
        return new DAOTime().salvarTime(time);
    }
    public boolean excluirByIdTime(int id) {
    return new DAOTime().excluirByIdTime(id);
}
public List<String> listarTimes() {
    try {
        return new DAOTime().listarTimes();
    } catch (SQLException e) {
        e.printStackTrace();
        return new ArrayList<>();  // retorna lista vazia se der erro
    }
}
public Time buscarPorNome(String nomet) {
    try {
        return new DAOTime().buscarPorNome(nomet);
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}
}
