/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Role;

/**
 *
 * @author Admin
 */
public class RoleDAO {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public List<Role> getAllRoles() {
        List<Role> list = new ArrayList<>();
        try {
            String sql = "select * from Role";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role(rs.getInt(1), rs.getString(2));
                list.add(role);
            }
            return list;
        } catch (Exception e) {

        }
        return null;
    }

    public Role getRoleByID(int id) {

        try {
            String sql = "select * from Role where role_id = ?";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role(rs.getInt(1), rs.getString(2));
                return role;
            }
        } catch (Exception e) {

        }
        return null;
    }

//    public static void main(String[] args) {
//        RoleDAO rd = new RoleDAO();
//        List<Role> list = rd.getAllRoles();
//        System.out.println(list.get(0).getRoleName());
//    }
    public static void main(String[] args) {
        RoleDAO rd = new RoleDAO();

        // Test case 1: Lấy tất cả các roles
        System.out.println("--- Test getAllRoles() ---");
        List<Role> allRoles = rd.getAllRoles();
        if (allRoles != null) {
            if (!allRoles.isEmpty()) {
                System.out.println("Danh sách tất cả các roles:");
                for (Role role : allRoles) {
                    System.out.println("ID: " + role.getRoleID() + ", Tên: " + role.getRoleName());
                }
            } else {
                System.out.println("Không có role nào trong cơ sở dữ liệu.");
            }
        } else {
            System.out.println("Lỗi khi lấy danh sách roles.");
        }
        System.out.println("---------------------------\n");

        // Test case 2: Lấy role theo ID tồn tại (ví dụ: roleID = 1 là 'Admin')
        int existingRoleId = 1;
        System.out.println("--- Test getRoleByID(" + existingRoleId + ") ---");
        Role existingRole = rd.getRoleByID(existingRoleId);
        if (existingRole != null) {
            System.out.println("Role có ID = " + existingRoleId + ": ID = " + existingRole.getRoleID() + ", Tên = " + existingRole.getRoleName());
        } else {
            System.out.println("Không tìm thấy role với ID = " + existingRoleId + ".");
        }
        System.out.println("-----------------------------------\n");

        // Test case 3: Lấy role theo ID tồn tại khác (ví dụ: roleID = 2 là 'Teacher')
        int anotherExistingRoleId = 2;
        System.out.println("--- Test getRoleByID(" + anotherExistingRoleId + ") ---");
        Role anotherExistingRole = rd.getRoleByID(anotherExistingRoleId);
        if (anotherExistingRole != null) {
            System.out.println("Role có ID = " + anotherExistingRoleId + ": ID = " + anotherExistingRole.getRoleID() + ", Tên = " + anotherExistingRole.getRoleName());
        } else {
            System.out.println("Không tìm thấy role với ID = " + anotherExistingRoleId + ".");
        }
        System.out.println("-----------------------------------\n");

        // Test case 4: Lấy role theo ID không tồn tại (ví dụ: roleID = 99)
        int nonExistingRoleId = 99;
        System.out.println("--- Test getRoleByID(" + nonExistingRoleId + ") ---");
        Role nonExistingRole = rd.getRoleByID(nonExistingRoleId);
        if (nonExistingRole != null) {
            System.out.println("Role có ID = " + nonExistingRoleId + ": ID = " + nonExistingRole.getRoleID() + ", Tên = " + nonExistingRole.getRoleName());
        } else {
            System.out.println("Không tìm thấy role với ID = " + nonExistingRoleId + ".");
        }
        System.out.println("--------------------------------------");
    }
}
