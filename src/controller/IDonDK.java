/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;
import model.DSDonDK;
import java.util.List;
/**
 *
 * @author Admin
 */
public interface IDonDK {
        List<DSDonDK> readDataFromFile(String fileName);
       void writeDataToFile(List<DSDonDK> dondks, String fileName);
}
