package controller;


import model.DSDonDK;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Admin
 */
public class DonDKController implements  IDonDK{

    @Override
    public List<DSDonDK> readDataFromFile(String fileName) {
        List<DSDonDK> dondks = new ArrayList<>();
        try{
           FileReader fileReader = new FileReader(fileName);
           BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] fields = line.split(",");
                if (fields.length == 3){
                    String maDon = fields[0];
                    String maHocPhan = fields[1];
                    String tenHocPhan = fields[2];
                    String loaiDon = fields[3];
                    DSDonDK dondky = new DSDonDK(maDon,maHocPhan,tenHocPhan, loaiDon, fields[4]);
                    dondks.add(dondky);
                }else{
                     System.out.println("Invalid data: " + line);
                }
            }
             bufferedReader.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return  dondks;
    }

    @Override
    public void writeDataToFile(List<DSDonDK> dondks, String fileName) {
        try{
            FileWriter writer = new FileWriter(fileName);
            for(DSDonDK donDK: dondks){
                
                String line = String.join(",",donDK.getMaDon(), donDK.getMaHocPhan(),donDK.getTenHocPhan(), donDK.getLoaiDon(), donDK.getTrangThai());
                 writer.write(line + "\n");
                 
            }
             writer.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
