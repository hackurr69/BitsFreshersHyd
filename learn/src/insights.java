import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
public class insights extends JFrame implements ActionListener{
	private JLabel name,id,city,state,hobbies,branch,detail;
	private JTextField nametext,idtext,citytext,statetext,hobbiestext,branchtext;
	private JButton save;
	private JPanel p;
	private insights(){
		setTitle("2023");
		detail=new JLabel("2023 Batch Details");
		name=new JLabel("Name");
		id=new JLabel("Id no.");
		city=new JLabel("City");
		state=new JLabel("State");
		hobbies=new JLabel("Hobby");
		branch=new JLabel("Branch");
		nametext=new JTextField();
		idtext=new JTextField();
		citytext=new JTextField();
		statetext=new JTextField();
		hobbiestext=new JTextField();
		branchtext=new JTextField();
		save=new JButton("SAVE");
		
		nametext.addActionListener(this);
		idtext.addActionListener(this);
		citytext.addActionListener(this);
		statetext.addActionListener(this);
		hobbiestext.addActionListener(this);
		branchtext.addActionListener(this);
		save.addActionListener(this);
		
		p=new JPanel();
		add(p);
	
		name.setForeground(new Color(0,120,215));
		id.setForeground(new Color(0,120,215));
		city.setForeground(new Color(0,120,215));
		state.setForeground(new Color(0,120,215));
		hobbies.setForeground(new Color(0,120,215));
		branch.setForeground(new Color(0,120,215));
		save.setBackground(new Color(0,120,215));
		save.setForeground(new Color(250,250,250));
		
		p.setLayout(null);
		
		detail.setBounds(30,0,250,40);
		name.setBounds(30, 50, 60, 30);
		nametext.setBounds(90, 50, 160, 30);
		id.setBounds(30, 90, 60, 30);
		idtext.setBounds(90, 90, 160, 30);
		city.setBounds(30, 130, 60, 30);
		citytext.setBounds(90, 130, 160, 30);
		state.setBounds(30, 170, 60, 43);
		statetext.setBounds(90, 170, 160, 30);
		hobbies.setBounds(30, 210, 60, 30);
		hobbiestext.setBounds(90, 210, 160, 30);
		branch.setBounds(30, 250, 60, 30);
		branchtext.setBounds(90, 250, 160, 30);
		save.setBounds(90,285,80,30);
		
		detail.setFont(new Font("Harlow Solid",Font.BOLD,25));
		name.setFont(new Font("Harlow Solid",Font.BOLD,15));
		id.setFont(new Font("Harlow Solid",Font.BOLD,15));
		city.setFont(new Font("Harlow Solid",Font.BOLD,15));
		state.setFont(new Font("Harlow Solid",Font.BOLD,15));
		hobbies.setFont(new Font("Harlow Solid",Font.BOLD,15));
		branch.setFont(new Font("Harlow Solid",Font.BOLD,15));
		
		p.setBackground(new Color(205,246,104));
		
		p.add(detail);
		p.add(name);
		p.add(nametext);
		p.add(id);
		p.add(idtext);
		p.add(city);
		p.add(citytext);
		p.add(state);
		p.add(statetext);
		p.add(hobbies);
		p.add(hobbiestext);
		p.add(branch);
		p.add(branchtext);
		p.add(save);
		
		setSize(300,360);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(nametext.getText().equals("")||idtext.getText().equals("")||citytext.getText().equals("")||statetext.getText().equals("")||hobbiestext.getText().equals("")||branchtext.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Please enter all details");
		}
		else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/learn?" +"user=root&password=root@1234");		   
				PreparedStatement pr=conn.prepareStatement("insert into insight(name,id,city,state,hobby,branch)values(?,?,?,?,?,?)");
				pr.setString(1,nametext.getText());
				pr.setString(2,idtext.getText());
				pr.setString(3,citytext.getText());
				pr.setString(4,statetext.getText());
				pr.setString(5,hobbiestext.getText());
				pr.setString(6,branchtext.getText());
				pr.executeUpdate();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null,"Saved Successfully");
			dispose();
		}
	}
	public static void main(String[] args) {
		new insights();
	}
}