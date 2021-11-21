package Login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BEAN.TaiKhoan;
import DAO.TaiKhoanDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassJDialog extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField textTaiKhoan;
	private JPasswordField passwordHienTai;
	private JPasswordField passwordMoi;
	private JPasswordField passwordXacNhan;
	//private LoginJDialog dialogLogin = new LoginJDialog();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			dialog = new ChangePassJDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//			dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//		        @Override
//		        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//		        	System.exit(0);
//		        }
//		    });
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	public void display() {
		try {
			ChangePassJDialog dialog = new ChangePassJDialog();
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
	public ChangePassJDialog() {
		setTitle("Đổi Mật Khẩu");
		setBounds(100, 100, 503, 401);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblLoginForm = new JLabel("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
		lblLoginForm.setForeground(new Color(0, 204, 255));
		lblLoginForm.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblLoginForm.setIcon(new ImageIcon(LoginJDialog.class.getResource("/images/khachHang.png")));
		lblLoginForm.setSize(326, 80);
		lblLoginForm.setLocation(90, 10);
		contentPanel.add(lblLoginForm);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 111, 421, 243);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Tài Khoản:");
		lblUsername.setIcon(new ImageIcon(LoginJDialog.class.getResource("/images/1024px-User_icon_2.svg.png")));
		lblUsername.setBounds(20, 14, 124, 35);
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Mật Khẩu:");
		lblPassword.setIcon(new ImageIcon(LoginJDialog.class.getResource("/images/1024px-Password.svg (1).png")));
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(20, 55, 163, 35);
		panel.add(lblPassword);
		
		textTaiKhoan = new JTextField();
		textTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textTaiKhoan.setBounds(190, 14, 221, 35);
		panel.add(textTaiKhoan);
		textTaiKhoan.setColumns(10);
		
		passwordHienTai = new JPasswordField();
		passwordHienTai.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordHienTai.setEchoChar('*');
		passwordHienTai.setBounds(190, 59, 221, 31);
		panel.add(passwordHienTai);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginJDialog loginJDialog = new LoginJDialog();
				loginJDialog.main(null);;
				setVisible(false);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBounds(15, 196, 124, 37);
		panel.add(btnLogin);
		
		JButton btniDoiMK = new JButton("Đổi mật khẩu");
		btniDoiMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textTaiKhoan.getText().trim();
				String passCurr = getPass(passwordHienTai.getPassword());
				String passNew = getPass(passwordMoi.getPassword());
				String passConf = getPass(passwordXacNhan.getPassword());
				TaiKhoan acc = TaiKhoanDAO.checkTaiKhoan(user, passCurr);
				if(acc.getTaikhoan() != null) {
					if(passNew.equals(passConf)) {
						if(TaiKhoanDAO.updatePass(user, passNew) == true) {
							JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!", "Đổi mật khẩu",
			                        JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "Đổi mật khẩu không thành công!",
			                        "Đổi mật khẩu", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Mật khẩu xác nhận không trùng khớp!",
		                        "Đổi mật khẩu", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không chính sác!",
	                        "Đổi mật khẩu", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btniDoiMK.setFont(new Font("Tahoma", Font.BOLD, 14));
		btniDoiMK.setBounds(216, 196, 163, 37);
		panel.add(btniDoiMK);
		
		JLabel lblXcNhnMt = new JLabel("Mật Khẩu Mới:");
		lblXcNhnMt.setIcon(new ImageIcon(ChangePassJDialog.class.getResource("/images/1024px-Password.svg (1).png")));
		lblXcNhnMt.setForeground(Color.BLACK);
		lblXcNhnMt.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblXcNhnMt.setBounds(20, 100, 150, 35);
		panel.add(lblXcNhnMt);
		
		passwordMoi = new JPasswordField();
		passwordMoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordMoi.setEchoChar('*');
		passwordMoi.setBounds(190, 100, 221, 31);
		panel.add(passwordMoi);
		
		passwordXacNhan = new JPasswordField();
		passwordXacNhan.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordXacNhan.setEchoChar('*');
		passwordXacNhan.setBounds(190, 145, 221, 31);
		panel.add(passwordXacNhan);
		
		JLabel lblXcNhnMt_1 = new JLabel("Xác nhận:");
		lblXcNhnMt_1.setIcon(new ImageIcon(ChangePassJDialog.class.getResource("/images/1024px-Password.svg (1).png")));
		lblXcNhnMt_1.setForeground(Color.BLACK);
		lblXcNhnMt_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblXcNhnMt_1.setBounds(20, 141, 150, 35);
		panel.add(lblXcNhnMt_1);
	}
	public String getPass(char[] pass) {
		String passCorrect = "";
		for(char c : pass) {
			passCorrect += c;
		}
		return passCorrect;
	}

}
