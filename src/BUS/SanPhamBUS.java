/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class SanPhamBUS {

    private List<SanPhamDTO> spBUS;

    public SanPhamBUS() {
        spBUS = null;
    }

    public List<SanPhamDTO> getSpBUS() {
        return spBUS;
    }

    public void list() {
        SanPhamDAO spDAO = new SanPhamDAO();
        spBUS = new ArrayList<>();
        spBUS = spDAO.findAll();
    }

    public void add(SanPhamDTO spDTO) {
        spBUS.add(spDTO);
        SanPhamDAO spDAO = new SanPhamDAO();
        try {
            spDAO.save(spDTO);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String id) {
        int idSP = Integer.parseInt(id);
        for (SanPhamDTO spDTO : spBUS) {
            if (spDTO.getId_SP() == idSP) {
                spBUS.remove(spDTO);
                SanPhamDAO spDAO = new SanPhamDAO();
                try {
                    spDAO.delete(idSP);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public void set(SanPhamDTO spDTO) {
        for (int i = 0; i < spBUS.size(); i++) {
            if (spBUS.get(i).getId_SP() == spDTO.getId_SP()) {
                spBUS.set(i, spDTO);
                SanPhamDAO spDAO = new SanPhamDAO();
                try {
                    spDAO.update(spDTO);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

}
