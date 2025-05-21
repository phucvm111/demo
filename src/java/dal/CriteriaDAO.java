/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Criteria;

/**
 *
 * @author win
 */
public class CriteriaDAO extends DBContext {

    private Connection connection;
    private PreparedStatement st;
    private ResultSet rs;

    public ArrayList<Criteria> getAllCriteria() {
        ArrayList<Criteria> criterias = new ArrayList<>();
        try {
            String sql = "SELECT [criteria_id]\n"
                    + "      ,[content]\n"
                    + "  FROM [criteria]";
            connection = new DBContext().getConnection();
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Criteria cr = new Criteria();

                cr.setCriteria_id(rs.getInt("criteria_id"));
                cr.setContent(rs.getString("content"));
                criterias.add(cr);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CriteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CriteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return criterias;
    }

    public void insertCriteria(Criteria criteria) {
        try {
            String sql = "INSERT INTO [criteria]\n"
                    + "           ([content]         \n"
                    + "     VALUES\n"
                    + "           (?)";
            connection = new DBContext().getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, criteria.getContent());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CriteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CriteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCriteria(Criteria criteria) {
        try {
            String sql = "UPDATE [criteria]\n"
                    + "   SET[content] = ?\n"
                    + " WHERE [criteria_id] = ?";
            connection = new DBContext().getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, criteria.getContent());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CriteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CriteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        CriteriaDAO cd = new CriteriaDAO();

        System.out.println("--- Test CriteriaDAO Functions ---");

        // --- Test getAllCriteria() ---
        System.out.println("\n--- Test getAllCriteria() ---");
        ArrayList<Criteria> allCriteria = cd.getAllCriteria();
        if (allCriteria != null) {
            System.out.println("Danh sách tất cả các tiêu chí:");
            for (Criteria criteria : allCriteria) {
                System.out.println("ID: " + criteria.getCriteria_id() + ", Nội dung: " + criteria.getContent());
            }
            System.out.println("Tổng số tiêu chí: " + allCriteria.size());
        } else {
            System.out.println("Lỗi khi lấy tất cả các tiêu chí.");
        }

        // --- Test insertCriteria(Criteria criteria) ---
        System.out.println("\n--- Test insertCriteria(Criteria criteria) ---");
        Criteria newCriteria = new Criteria();
        newCriteria.setContent("Tiêu chí mới từ test");
        cd.insertCriteria(newCriteria);
        System.out.println("Đã cố gắng thêm tiêu chí: " + newCriteria.getContent());

        // --- Test updateCriteria(Criteria criteria) ---
        System.out.println("\n--- Test updateCriteria(Criteria criteria) ---");
        // Để test update, chúng ta cần một ID tồn tại. Lấy ID của tiêu chí đầu tiên nếu có.
        if (allCriteria != null && !allCriteria.isEmpty()) {
            Criteria firstCriteria = allCriteria.get(0);
            Criteria criteriaToUpdate = new Criteria();
            criteriaToUpdate.setCriteria_id(firstCriteria.getCriteria_id());
            criteriaToUpdate.setContent("Nội dung đã được cập nhật từ test");
            cd.updateCriteria(criteriaToUpdate);
            System.out.println("Đã cố gắng cập nhật tiêu chí có ID " + firstCriteria.getCriteria_id() + " thành: " + criteriaToUpdate.getContent());
        } else {
            System.out.println("Không có tiêu chí nào để cập nhật.");
        }
    }
    
    
}
