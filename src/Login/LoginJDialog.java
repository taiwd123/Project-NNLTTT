package Login;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AdminForm.AdminJFrame;
import BEAN.TaiKhoan;
import DAO.NhanVienDAO;
import DAO.TaiKhoanDAO;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textTaiKhoan;
	private JPasswordField passwordField;
	private static LoginJDialog dialog;
	//private ChangePassJDialog dialogChange = new ChangePassJDialog();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog = new LoginJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.addWindowListener(new java.awt.event.WindowAdapter() {
		        @Override
		        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        	System.exit(0);
		        }
		    });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginJDialog() {
		setTitle("Đăng Nhập");
		
		setBounds(100, 100, 503, 365);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblLoginForm = new JLabel("Đăng Nhập");
		lblLoginForm.setForeground(new Color(0, 204, 255));
		lblLoginForm.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblLoginForm.setIcon(new ImageIcon(LoginJDialog.class.getResource("/images/khachHang.png")));
		lblLoginForm.setSize(252, 80);
		lblLoginForm.setLocation(126, 10);
		contentPanel.add(lblLoginForm);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 111, 421, 180);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Tài Khoản:");
		lblUsername.setIcon(new ImageIcon(LoginJDialog.class.getResource("/images/1024px-User_icon_2.svg.png")));
		lblUsername.setBounds(10, 10, 170, 35);
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Mật Khẩu:");
		lblPassword.setIcon(new ImageIcon(LoginJDialog.class.getResource("/images/1024px-Password.svg (1).png")));
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(17, 74, 163, 35);
		panel.add(lblPassword);
		
		textTaiKhoan = new JTextField();
		textTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textTaiKhoan.setBounds(190, 14, 221, 35);
		panel.add(textTaiKhoan);
		textTaiKhoan.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordField.setEchoChar('*');
		passwordField.setBounds(190, 74, 221, 31);
		panel.add(passwordField);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textTaiKhoan.getText().trim();
				char[] pass = passwordField.getPassword();
				String passCorrect="";
				for(char c : pass) {
					passCorrect += c;
				}
				TaiKhoan acc = TaiKhoanDAO.checkTaiKhoan(user, passCorrect);
				if(acc.getTaikhoan() != null) {
					
					if(NhanVienDAO.getNhanVien(acc.getManv()).getChucvu().equals("Admin")) {
						
						AdminJFrame adminJFrame = new AdminJFrame();
						adminJFrame.main(null);
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công!", "Đăng nhập",
		                        JOptionPane.INFORMATION_MESSAGE);
						dialog.setVisible(false);
					}
				}
				else {
	                JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không chính xác!",
	                        "Đăng nhập", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBounds(235, 133, 124, 37);
		panel.add(btnLogin);
		
		JButton btnDoiMK = new JButton("Đổi mật khẩu");
		btnDoiMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassJDialog changePassJDialog = new ChangePassJDialog();
				changePassJDialog.main(null);;
				dialog.setVisible(false);
			}
		});
		btnDoiMK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDoiMK.setBounds(17, 133, 163, 37);
		panel.add(btnDoiMK);
		
	}
}
