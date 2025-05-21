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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.GoogleAccount;
import model.Role;

/**
 *
 * @author Admin
 */
public class AccountDAO extends DBContext {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    RoleDAO rd = new RoleDAO();
//    AccountDAO ad = new AccountDAO();

    public ArrayList<Account> getAccountByAcId2() {
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            String sql = "select * from Account \n"
                    + "where account_id not in \n"
                    + "		(select teacher_id from Class) \n"
                    + "		and role_id = (select role_id from Role where role_name = 'teacher')";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setAccountID(rs.getInt("account_id"));
                a.setFirstName(rs.getString("first_name"));
                a.setLastName(rs.getString("last_name"));
                a.setGender(rs.getBoolean("gender"));
                a.setEmail(rs.getString("email"));
                a.setPassword(rs.getString("password"));
                a.setDob(rs.getString("dob"));
                a.setPhoneNumber(rs.getString("phone_number"));
                a.setAddress(rs.getString("address"));
                a.setImg(rs.getString("img"));
//                a.setRoleId(rs.getInt("role_id"));
                Role r = rd.getRoleByID(rs.getInt("role_id"));
                a.setRole(r);
                accounts.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accounts;
    }

    public ArrayList<Account> getAccountByAcId(int id) {
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            String sql = "SELECT [account_id]\n"
                    + "      ,[first_name]\n"
                    + "      ,[last_name]\n"
                    + "      ,[gender]\n"
                    + "      ,[email]\n"
                    + "      ,[password]\n"
                    + "      ,[dob]\n"
                    + "      ,[phone_number]\n"
                    + "      ,[address]\n"
                    + "      ,[img]\n"
                    + "      ,[role_id]\n"
                    + "  FROM [Account] where [role_id]=?";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setAccountID(rs.getInt("account_id"));
                a.setFirstName(rs.getString("first_name"));
                a.setLastName(rs.getString("last_name"));
                a.setGender(rs.getBoolean("gender"));
                a.setEmail(rs.getString("email"));
                a.setPassword(rs.getString("password"));
                a.setDob(rs.getString("dob"));
                a.setPhoneNumber(rs.getString("phone_number"));
                a.setAddress(rs.getString("address"));
                a.setImg(rs.getString("img"));
//                a.setRoleId(rs.getInt("role_id"));
                Role r = rd.getRoleByID(rs.getInt("role_id"));
                a.setRole(r);
                accounts.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accounts;
    }

    public ArrayList<Account> getAccountByName(String name) {
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            String sql = "SELECT [account_id]\n"
                    + "      ,[first_name]\n"
                    + "      ,[last_name]\n"
                    + "      ,[gender]\n"
                    + "      ,[email]\n"
                    + "      ,[password]\n"
                    + "      ,[dob]\n"
                    + "      ,[phone_number]\n"
                    + "      ,[address]\n"
                    + "      ,[img]\n"
                    + "      ,[role_id]\n"
                    + "  FROM [Account] where last_name like ?";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setAccountID(rs.getInt("account_id"));
                a.setFirstName(rs.getString("first_name"));
                a.setLastName(rs.getString("last_name"));
                a.setGender(rs.getBoolean("gender"));
                a.setEmail(rs.getString("email"));
                a.setPassword(rs.getString("password"));
                a.setDob(rs.getString("dob"));
                a.setPhoneNumber(rs.getString("phone_number"));
                a.setAddress(rs.getString("address"));
                a.setImg(rs.getString("img"));
                Role r = rd.getRoleByID(rs.getInt("role_id"));
                a.setRole(r);
//                Role r = rd.getRoleByID(rs.getInt("role_id"));
//                a.setRole(r);
                accounts.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accounts;
    }

    public List<Account> getAllParentInfor() {
        RoleDAO rd = new RoleDAO();
        List<Account> list = new ArrayList<>();
        try {
            String sql = "select * from Account where role_id = 2";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account t = new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rd.getRoleByID(rs.getInt(11))
                );
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public List<Account> getAllAccounts() {
        List<Account> list = new ArrayList<>();
        try {
            String sql = "select * from Account";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setAccountID(rs.getInt(1));
                a.setFirstName(rs.getString(2));
                a.setLastName(rs.getString(3));
                a.setGender(rs.getBoolean(4));
                a.setEmail(rs.getString(5));
                a.setPassword(rs.getString(6));
                a.setDob(rs.getString(7));
                a.setPhoneNumber(rs.getString(8));
                a.setAddress(rs.getString(9));
                a.setImg(rs.getString(10));
                Role r = rd.getRoleByID(rs.getInt(11));
                a.setRole(r);
                list.add(a);
            }
            return list;
        } catch (Exception e) {

        }
        return null;
    }

    public List<String> getAllEmail() {
        List<String> list = new ArrayList<>();
        String sql = "select email from Account";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String t = rs.getString("email");
                list.add(t);
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Account getAccountByMailPass(String mail, String pass) {
        try {
            String sql = "select * from Account a\n"
                    + "where email = ? and password = ?";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, mail);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setAccountID(rs.getInt(1));
                a.setFirstName(rs.getString(2));
                a.setLastName(rs.getString(3));
                a.setGender(rs.getBoolean(4));
                a.setEmail(rs.getString(5));
                a.setPassword(rs.getString(6));
                a.setDob(rs.getString(7));
                a.setPhoneNumber(rs.getString(8));
                a.setAddress(rs.getString(9));
                a.setImg(rs.getString(10));
                Role r = rd.getRoleByID(rs.getInt(11));
                a.setRole(r);
                return a;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public Account getAccountByID(int id) {
        try {
            String sql = "select * from Account where account_id = ?";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setAccountID(rs.getInt(1));
                a.setFirstName(rs.getString(2));
                a.setLastName(rs.getString(3));
                a.setGender(rs.getBoolean(4));
                a.setEmail(rs.getString(5));
                a.setPassword(rs.getString(6));
                a.setDob(rs.getString(7));
                a.setPhoneNumber(rs.getString(8));
                a.setAddress(rs.getString(9));
                a.setImg(rs.getString(10));
                Role r = rd.getRoleByID(rs.getInt(11));
                a.setRole(r);
                return a;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<Account> getAllTeacherInfor() {
        List<Account> list = new ArrayList<>();
        RoleDAO rd = new RoleDAO();
        try {
            String sql = "select * from Account where role_id = 3";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account t = new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rd.getRoleByID(rs.getInt(11))
                );
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public void addAccount(Account a) {
        String sql = "insert into account values(?,?,?,?,?,?,?,?,?,?)";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, a.getFirstName());
            ps.setString(2, a.getLastName());
            ps.setBoolean(3, a.isGender());
            ps.setString(4, a.getEmail());
            ps.setString(5, a.getPassword());
            ps.setString(6, a.getDob());
            ps.setString(7, a.getPhoneNumber());
            ps.setString(8, a.getAddress());
            ps.setString(9, a.getImg());
            ps.setInt(10, a.getRole().getRoleID());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public GoogleAccount getGoogleAccountByID(String id) {
        String sql = "select * from GoogleAccount where google_id = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                AccountDAO ad = new AccountDAO();
                Account a = ad.getAccountByID(rs.getInt(1));
                GoogleAccount ga = new GoogleAccount(a,
                        rs.getString(2));
                return ga;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public void addGoogleAccount(GoogleAccount ga) {
        String sql = "insert into GoogleAccount values\n"
                + "(?, ?)";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, ga.getAccount().getAccountID());
            ps.setString(2, ga.getGoogleID());
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void deleteAccount(int id) {
        try {
            String sql = "DELETE FROM [Account]\n"
                    + "      WHERE account_id=?";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateAccount(Account account) {
        try {
            String sql = " UPDATE [dbo].[Account]\n"
                    + "   SET [first_name] = ? \n"
                    + "      ,[last_name] = ? \n"
                    + "      ,[gender] = ? \n"
                    + "      ,[email] = ? \n"
                    + "      ,[password] = ? \n"
                    + "      ,[dob] = ? \n"
                    + "      ,[phone_number] = ? \n"
                    + "      ,[address] = ? \n"
                    + "      ,[img] = ?    ,\n"
                    + "	 [role_id] = ? \n"
                    + " WHERE account_id = " + String.valueOf(account.getAccountID()) + " ";
//            connection = new DBContext().getConnection();
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
//            PreparedStatement pre = connection.prepareStatement(sql);
//            st.setInt(11, account.getAccountID());
            ps.setString(1, account.getFirstName());
            ps.setString(2, account.getLastName());
            ps.setBoolean(3, account.isGender());
            ps.setString(4, account.getEmail());
            ps.setString(5, account.getPassword());
            ps.setString(6, account.getDob());
            ps.setString(7, account.getPhoneNumber());
            ps.setString(8, account.getAddress());
            ps.setString(9, account.getImg());
            ps.setInt(10, account.getRole().getRoleID());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(account.toString());
    }

    public Account getAccountByEmail(String email) {
        try {
            String sql = "select * from Account where email = ?";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);

            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setAccountID(rs.getInt(1));
                a.setFirstName(rs.getString(2));
                a.setLastName(rs.getString(3));
                a.setGender(rs.getBoolean(4));
                a.setEmail(rs.getString(5));
                a.setPassword(rs.getString(6));
                a.setDob(rs.getString(7));
                a.setPhoneNumber(rs.getString(8));
                a.setAddress(rs.getString(9));
                a.setImg(rs.getString(10));
                Role r = rd.getRoleByID(rs.getInt(11));
                a.setRole(r);
                return a;
            }
        } catch (Exception e) {

        }
        return null;
    }

    public void updateParent(Account parent) {
        List<Account> list = new ArrayList<>();
        try {
            String sql = "UPDATE [Account]"
                    + "   SET [first_name] = ?"
                    + "      ,[last_name] = ?"
                    + "      ,[gender] = ?"
                    + "      ,[email] = ?"
                    + "      ,[password] = ?"
                    + "      ,[dob] = ?"
                    + "      ,[phone_number] = ?"
                    + "      ,[address] = ?"
                    + "      ,[img] = ?"
                    + "      ,[role_id] = ?"
                    + " WHERE [account_id]=?";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, parent.getFirstName());
            ps.setString(2, parent.getLastName());
            ps.setBoolean(3, parent.isGender());
            ps.setString(4, parent.getEmail());
            ps.setString(5, parent.getPassword());
            ps.setString(6, parent.getDob());
            ps.setString(7, parent.getPhoneNumber());
            ps.setString(8, parent.getAddress());
            ps.setString(9, parent.getImg());
            ps.setInt(10, parent.getRole().getRoleID());
            ps.setInt(11, parent.getAccountID());
            ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

//    public static void main(String[] args) {
//        AccountDAO dao = new AccountDAO();

//        AccountDAO d = new AccountDAO();
//            Account a = new Account();
//            a.setFirstName("Alex");
//            a.setLastName("Thunder");
//            a.setGender(true);
//            a.setEmail("alex@123");
//            a.setPassword("1234");
//            a.setDob("01/01/1999");
//            a.setPhoneNumber("0000000000");
//            a.setAddress("Please input new address");
//            a.setImg(null);
//            
//            Role role = new Role(2, "parent");
//            a.setRole(role);
//            
//            d.addAccount(a);
//            d.addGoogleAccount(new GoogleAccount(d.getAccountByEmail("alex@123"), "123123"));
//        List<Account> list = dao.getAllAccounts();
//        for (Account a : list) {
//            System.out.println(a.getFirstName());
//        }
//
//        System.out.println(dao.getAccountByMailPass("admin@gmail.com", "1234").getRole().getRoleName());
//
//        GoogleAccount a = dao.getGoogleAccountByID("12345");
//        System.out.println(a.getGoogleID());
//        List<String> lists = dao.getAllEmail();
//        for (String l : lists ) {
//            System.out.println(l);
//        }
//        GoogleAccount a = new GoogleAccount(account, googleID)
//        dao.addGoogleAccount(a);
//        System.out.println(role);
//    }
    public static void main(String[] args) {
    AccountDAO ad = new AccountDAO();
    RoleDAO rd = new RoleDAO(); // Cần RoleDAO để tạo đối tượng Role

    System.out.println("--- Test AccountDAO Functions ---");

    // --- Test getAllAccounts() ---
    System.out.println("\n--- Test getAllAccounts() ---");
    List<Account> allAccounts = ad.getAllAccounts();
    if (allAccounts != null) {
        System.out.println("Danh sách tất cả các tài khoản:");
        for (Account acc : allAccounts) {
            System.out.println("ID: " + acc.getAccountID() + ", Tên: " + acc.getFirstName() + " " + acc.getLastName() + ", Email: " + acc.getEmail() + ", Role: " + (acc.getRole() != null ? acc.getRole().getRoleName() : "null"));
        }
        System.out.println("Tổng số tài khoản: " + allAccounts.size());
    } else {
        System.out.println("Lỗi khi lấy tất cả các tài khoản.");
    }

    // --- Test getAccountByID(int id) ---
    System.out.println("\n--- Test getAccountByID(int id) ---");
    int testAccountId = 1; // Thay bằng một ID account có thật trong DB
    Account accountById = ad.getAccountByID(testAccountId);
    if (accountById != null) {
        System.out.println("Tìm thấy tài khoản với ID = " + testAccountId + ": " + accountById.getFirstName() + " " + accountById.getLastName() + ", Email: " + accountById.getEmail() + ", Role: " + (accountById.getRole() != null ? accountById.getRole().getRoleName() : "null"));
    } else {
        System.out.println("Không tìm thấy tài khoản với ID = " + testAccountId + ".");
    }

    int nonExistentAccountId = 999; // ID заведомо không tồn tại
    Account nonExistentAccount = ad.getAccountByID(nonExistentAccountId);
    if (nonExistentAccount == null) {
        System.out.println("Đúng: Không tìm thấy tài khoản với ID = " + nonExistentAccountId + ".");
    } else {
        System.out.println("Sai: Tìm thấy tài khoản không tồn tại với ID = " + nonExistentAccountId + ".");
    }

    // --- Test getAccountByEmail(String email) ---
    System.out.println("\n--- Test getAccountByEmail(String email) ---");
    String testEmail = "alice.nguyen@example.com"; // Thay bằng một email có thật trong DB
    Account accountByEmail = ad.getAccountByEmail(testEmail);
    if (accountByEmail != null) {
        System.out.println("Tìm thấy tài khoản với email = " + testEmail + ": " + accountByEmail.getFirstName() + " " + accountByEmail.getLastName() + ", ID: " + accountByEmail.getAccountID() + ", Role: " + (accountByEmail.getRole() != null ? accountByEmail.getRole().getRoleName() : "null"));
    } else {
        System.out.println("Không tìm thấy tài khoản với email = " + testEmail + ".");
    }

    String nonExistentEmail = "nonexistent@example.com";
    Account nonExistentAccountByEmail = ad.getAccountByEmail(nonExistentEmail);
    if (nonExistentAccountByEmail == null) {
        System.out.println("Đúng: Không tìm thấy tài khoản với email = " + nonExistentEmail + ".");
    } else {
        System.out.println("Sai: Tìm thấy tài khoản không tồn tại với email = " + nonExistentEmail + ".");
    }

    // --- Test getAccountByMailPass(String mail, String pass) ---
    System.out.println("\n--- Test getAccountByMailPass(String mail, String pass) ---");
    String testMail = "alice.nguyen@example.com"; // Thay bằng email có thật
    String testPass = "password123"; // Thay bằng password đúng
    Account accountByMailPass = ad.getAccountByMailPass(testMail, testPass);
    if (accountByMailPass != null) {
        System.out.println("Đăng nhập thành công với email = " + testMail + " và password = " + testPass + ". Tài khoản: " + accountByMailPass.getFirstName() + " " + accountByMailPass.getLastName() + ", Role: " + (accountByMailPass.getRole() != null ? accountByMailPass.getRole().getRoleName() : "null"));
    } else {
        System.out.println("Đăng nhập thất bại với email = " + testMail + " và password = " + testPass + ".");
    }

    String wrongPass = "wrongpassword";
    Account wrongLogin = ad.getAccountByMailPass(testMail, wrongPass);
    if (wrongLogin == null) {
        System.out.println("Đúng: Đăng nhập thất bại với sai password.");
    } else {
        System.out.println("Sai: Đăng nhập thành công với sai password.");
    }

    // --- Test getAllTeacherInfor() ---
    System.out.println("\n--- Test getAllTeacherInfor() ---");
    List<Account> teachers = ad.getAllTeacherInfor();
    if (teachers != null) {
        System.out.println("Danh sách tất cả giáo viên:");
        for (Account teacher : teachers) {
            System.out.println("ID: " + teacher.getAccountID() + ", Tên: " + teacher.getFirstName() + " " + teacher.getLastName() + ", Email: " + teacher.getEmail() + ", Role: " + (teacher.getRole() != null ? teacher.getRole().getRoleName() : "null"));
        }
        System.out.println("Tổng số giáo viên: " + teachers.size());
    } else {
        System.out.println("Lỗi khi lấy danh sách giáo viên.");
    }

    // --- Test getAllParentInfor() ---
    System.out.println("\n--- Test getAllParentInfor() ---");
    List<Account> parents = ad.getAllParentInfor();
    if (parents != null) {
        System.out.println("Danh sách tất cả phụ huynh:");
        for (Account parent : parents) {
            System.out.println("ID: " + parent.getAccountID() + ", Tên: " + parent.getFirstName() + " " + parent.getLastName() + ", Email: " + parent.getEmail() + ", Role: " + (parent.getRole() != null ? parent.getRole().getRoleName() : "null"));
        }
        System.out.println("Tổng số phụ huynh: " + parents.size());
    } else {
        System.out.println("Lỗi khi lấy danh sách phụ huynh.");
    }

    // --- Test getAllEmail() ---
    System.out.println("\n--- Test getAllEmail() ---");
    List<String> allEmails = ad.getAllEmail();
    if (allEmails != null) {
        System.out.println("Danh sách tất cả email:");
        for (String email : allEmails) {
            System.out.println("- " + email);
        }
        System.out.println("Tổng số email: " + allEmails.size());
    } else {
        System.out.println("Lỗi khi lấy tất cả các email.");
    }

    // --- Test getAccountByAcId(int id) ---
    System.out.println("\n--- Test getAccountByAcId(int id) ---");
    int testRoleIdTeacher = 3; // Giả sử role_id = 3 là Teacher
    List<Account> accountsByTeacherRole = ad.getAccountByAcId(testRoleIdTeacher);
    if (accountsByTeacherRole != null) {
        System.out.println("Danh sách tài khoản có role ID = " + testRoleIdTeacher + " (Teacher?):");
        for (Account acc : accountsByTeacherRole) {
            System.out.println("ID: " + acc.getAccountID() + ", Tên: " + acc.getFirstName() + " " + acc.getLastName() + ", Email: " + acc.getEmail() + ", Role ID: " + (acc.getRole() != null ? acc.getRole().getRoleID() : "null"));
        }
        System.out.println("Tổng số tài khoản có role ID = " + testRoleIdTeacher + ": " + accountsByTeacherRole.size());
    } else {
        System.out.println("Lỗi khi lấy tài khoản theo role ID = " + testRoleIdTeacher + ".");
    }

    // --- Test getAccountByAcId2() ---
    System.out.println("\n--- Test getAccountByAcId2() ---");
    List<Account> nonTeachingTeachers = ad.getAccountByAcId2();
    if (nonTeachingTeachers != null) {
        System.out.println("Danh sách giáo viên chưa được gán vào lớp:");
        for (Account teacher : nonTeachingTeachers) {
            System.out.println("ID: " + teacher.getAccountID() + ", Tên: " + teacher.getFirstName() + " " + teacher.getLastName() + ", Email: " + teacher.getEmail() + ", Role: " + (teacher.getRole() != null ? teacher.getRole().getRoleName() : "null"));
        }
        System.out.println("Tổng số giáo viên chưa gán lớp: " + nonTeachingTeachers.size());
    } else {
        System.out.println("Lỗi khi lấy danh sách giáo viên chưa gán lớp.");
    }

    // --- Test getAccountByName(String name) ---
    System.out.println("\n--- Test getAccountByName(String name) ---");
    String testLastName = "Nguyen"; // Thay bằng một phần tên có thật trong DB
    List<Account> accountsByName = ad.getAccountByName(testLastName);
    if (accountsByName != null) {
        System.out.println("Danh sách tài khoản có tên chứa '" + testLastName + "':");
        for (Account acc : accountsByName) {
            System.out.println("ID: " + acc.getAccountID() + ", Tên: " + acc.getFirstName() + " " + acc.getLastName() + ", Email: " + acc.getEmail() + ", Role: " + (acc.getRole() != null ? acc.getRole().getRoleName() : "null"));
        }
        System.out.println("Tổng số tài khoản có tên chứa '" + testLastName + "': " + accountsByName.size());
    } else {
        System.out.println("Lỗi khi lấy tài khoản theo tên.");
    }

    // Bạn có thể thêm các test case cho addAccount, updateAccount, deleteAccount,
    // getGoogleAccountByID, addGoogleAccount, updateParent tương tự.
    // Lưu ý rằng các test cho việc thêm, sửa, xóa dữ liệu cần được thực hiện cẩn thận
    // và có thể cần kiểm tra lại database sau khi chạy.
}
    
    
}
