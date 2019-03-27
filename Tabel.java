package ProduseSQL;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Tabel extends JFrame  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con;
	private JPanel contentPane;
	private JTable table;
	private JTextField id_input;
	private JTextField den_input;
	private JTextField cat_input;
	private JTextField dep_input;
	private JTextField pret_input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabel frame = new Tabel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
   public void clearInputs() {
	   id_input.setText(null);
	   den_input.setText(null);
	   cat_input.setText(null);
	   pret_input.setText(null);
	   dep_input.setText(null);
	    id_input.setBackground(new Color(153, 153, 153));
		id_input.setForeground(new Color(255, 255, 255));
		den_input.setForeground(new Color(255, 255, 255));
		den_input.setBackground(new Color(153, 153, 153));
		cat_input.setForeground(new Color(255, 255, 255));
		cat_input.setBackground(new Color(153, 153, 153));
		pret_input.setForeground(new Color(255, 255, 255));
		pret_input.setBackground(new Color(153, 153, 153));
		dep_input.setForeground(new Color(255, 255, 255));
		dep_input.setBackground(new Color(153, 153, 153));
   }

	public void refreshTable() {
		try {
    		String afisare = "select * from produse";
    		PreparedStatement pstmt = con.prepareStatement(afisare);
    	    ResultSet rs = pstmt.executeQuery();
    		table.setModel(DbUtils.resultSetToTableModel(rs));
    	} catch(Exception ex) {
    		System.err.println("Eroare: " +ex);
    	}
	}
	
	public Tabel() {
		con = Conectare.conect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 364);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(237, 11, 514, 225);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			//selectare din tabel
			public void mouseClicked(MouseEvent arg0) {
				TableModel model = table.getModel();
				int row = table.getSelectedRow();
				id_input.setText(model.getValueAt(row, 0).toString());
				den_input.setText(model.getValueAt(row, 1).toString());
				cat_input.setText(model.getValueAt(row, 2).toString());
				pret_input.setText(model.getValueAt(row, 3).toString());
				dep_input.setText(model.getValueAt(row, 4).toString());
			}
		});
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		
		JLabel lblIdul = new JLabel("ID-ul");
		lblIdul.setForeground(new Color(204, 204, 204));
		lblIdul.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 16));
		lblIdul.setBounds(40, 32, 51, 23);
		contentPane.add(lblIdul);
		
		id_input = new JTextField();
		id_input.setForeground(new Color(255, 255, 255));
		id_input.setBackground(new Color(153, 153, 153));
		id_input.setBounds(133, 32, 86, 20);
		contentPane.add(id_input);
		id_input.setColumns(10);
		
		JLabel lblLipsaID = new JLabel("");
		lblLipsaID.setForeground(Color.RED);
		lblLipsaID.setBounds(40, 53, 179, 14);
		contentPane.add(lblLipsaID);
		
		id_input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				try {
				int id = Integer.parseInt(id_input.getText());
				lblLipsaID.setText("");
				}catch(NumberFormatException e) {
					lblLipsaID.setText("*introdu cod din numere");
				}
			}
		});
		id_input.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				id_input.setBackground(new Color(255, 255, 255));
				id_input.setForeground(new Color(0, 0, 0));
				den_input.setForeground(new Color(255, 255, 255));
				den_input.setBackground(new Color(153, 153, 153));
				cat_input.setForeground(new Color(255, 255, 255));
				cat_input.setBackground(new Color(153, 153, 153));
				pret_input.setForeground(new Color(255, 255, 255));
				pret_input.setBackground(new Color(153, 153, 153));
				dep_input.setForeground(new Color(255, 255, 255));
				dep_input.setBackground(new Color(153, 153, 153));
			}
		});
		
		den_input = new JTextField();
		den_input.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				den_input.setBackground(new Color(255, 255, 255));
				den_input.setForeground(new Color(0, 0, 0));
				id_input.setForeground(new Color(255, 255, 255));
				id_input.setBackground(new Color(153, 153, 153));
				cat_input.setForeground(new Color(255, 255, 255));
				cat_input.setBackground(new Color(153, 153, 153));
				pret_input.setForeground(new Color(255, 255, 255));
				pret_input.setBackground(new Color(153, 153, 153));
				dep_input.setForeground(new Color(255, 255, 255));
				dep_input.setBackground(new Color(153, 153, 153));
			}
		});
		den_input.setForeground(new Color(255, 255, 255));
		den_input.setBackground(new Color(153, 153, 153));
		den_input.setBounds(133, 78, 86, 20);
		contentPane.add(den_input);
		den_input.setColumns(10);
		
		JLabel lblLipsaDenumire = new JLabel("");
		lblLipsaDenumire.setForeground(Color.RED);
		lblLipsaDenumire.setBounds(40, 101, 179, 14);
		contentPane.add(lblLipsaDenumire);
		
		cat_input = new JTextField();
		cat_input.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cat_input.setBackground(new Color(255, 255, 255));
				cat_input.setForeground(new Color(0, 0, 0));
				id_input.setForeground(new Color(255, 255, 255));
				id_input.setBackground(new Color(153, 153, 153));
				den_input.setForeground(new Color(255, 255, 255));
				den_input.setBackground(new Color(153, 153, 153));
				pret_input.setForeground(new Color(255, 255, 255));
				pret_input.setBackground(new Color(153, 153, 153));
				dep_input.setForeground(new Color(255, 255, 255));
				dep_input.setBackground(new Color(153, 153, 153));
			}
		});
		cat_input.setForeground(new Color(255, 255, 255));
		cat_input.setBackground(new Color(153, 153, 153));
		cat_input.setBounds(133, 126, 86, 20);
		contentPane.add(cat_input);
		cat_input.setColumns(10);
		
		JLabel lblLipsaCategorie = new JLabel("");
		lblLipsaCategorie.setForeground(Color.RED);
		lblLipsaCategorie.setBounds(40, 147, 179, 14);
		contentPane.add(lblLipsaCategorie);
		
		JLabel lblPretul = new JLabel("Pretul");
		lblPretul.setForeground(new Color(204, 204, 204));
		lblPretul.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 15));
		lblPretul.setBounds(40, 169, 72, 23);
		contentPane.add(lblPretul);
		
		JLabel lblLipsaPret = new JLabel("");
		lblLipsaPret.setForeground(Color.RED);
		lblLipsaPret.setBounds(40, 191, 179, 14);
		contentPane.add(lblLipsaPret);
		
		dep_input = new JTextField();
		dep_input.setForeground(new Color(255, 255, 255));
		dep_input.setBackground(new Color(153, 153, 153));
		dep_input.setBounds(133, 216, 86, 20);
		contentPane.add(dep_input);
		dep_input.setColumns(10);
		
		JLabel lblLipsaDepozit = new JLabel("");
		lblLipsaDepozit.setForeground(Color.RED);
		lblLipsaDepozit.setBounds(40, 235, 179, 14);
		contentPane.add(lblLipsaDepozit);
		
		dep_input.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dep_input.setBackground(new Color(255, 255, 255));
				dep_input.setForeground(new Color(0, 0, 0));
				id_input.setForeground(new Color(255, 255, 255));
				id_input.setBackground(new Color(153, 153, 153));
				den_input.setForeground(new Color(255, 255, 255));
				den_input.setBackground(new Color(153, 153, 153));
				pret_input.setForeground(new Color(255, 255, 255));
				pret_input.setBackground(new Color(153, 153, 153));
				cat_input.setForeground(new Color(255, 255, 255));
				cat_input.setBackground(new Color(153, 153, 153));
			}
		});
		
		dep_input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				try {
					int dep = Integer.parseInt(dep_input.getText());
					lblLipsaDepozit.setText("");
					}catch(NumberFormatException e) {
						lblLipsaDepozit.setText("*introdu codul depozitului");
					}
			}
		});
		
		JLabel lblDenumirea = new JLabel("Denumirea");
		lblDenumirea.setForeground(new Color(204, 204, 204));
		lblDenumirea.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 15));
		lblDenumirea.setBounds(40, 78, 86, 23);
		contentPane.add(lblDenumirea);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(new Color(204, 204, 204));
		lblCategoria.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 15));
		lblCategoria.setBounds(40, 126, 72, 23);
		contentPane.add(lblCategoria);
		
		JLabel lblDepozitul = new JLabel("Depozitul");
		lblDepozitul.setForeground(new Color(204, 204, 204));
		lblDepozitul.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 15));
		lblDepozitul.setBounds(40, 214, 72, 23);
		contentPane.add(lblDepozitul);
		
		//butonul de adaugare
		JButton btnAdauga = new JButton("Adauga");
		btnAdauga.setBackground(new Color(30, 144, 255));
		btnAdauga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!id_input.getText().trim().isEmpty()) {
			        if(!den_input.getText().trim().isEmpty()) {
			           if(!cat_input.getText().trim().isEmpty() ) {
			        	  if(!pret_input.getText().trim().isEmpty() ) { 
			                if(!dep_input.getText().trim().isEmpty()) {
			            	   try {
			   		    		int id = Integer.parseInt(id_input.getText());
			   					String den = den_input.getText();
			   					String cat = cat_input.getText();
			   					double pret = Double.parseDouble(pret_input.getText());
			   					int dep = Integer.parseInt(dep_input.getText());
			   					String verificare = "select * from produse where idProdus = '"+id+"'";
			   					PreparedStatement pstmt1 = con.prepareStatement(verificare);
			   					ResultSet rs = pstmt1.executeQuery(verificare);
			   					if(!rs.next()) {
			   		    		String adaugare = "insert into produse VALUES (?,?,?,?,?)";
			   		    		PreparedStatement pstmt = con.prepareStatement(adaugare);
			   		    		pstmt.setInt(1, id);
			   		    		pstmt.setString(2, den);
			   		    		pstmt.setString(3, cat);
			   		    		pstmt.setDouble(4, pret);
			   		    		pstmt.setInt(5, dep);
			   		    		pstmt.executeUpdate();
			   		    		JOptionPane.showMessageDialog(btnAdauga, "Produsul a fost adaugat!");
			   					} else {
			   				    JOptionPane.showMessageDialog(btnAdauga, "Produsul exista!");	
			   					}    } 
			   					catch(Exception ex) {
			   		    		System.err.println("Eroare "+ex);
			                                        }
			            	   refreshTable();
			   				   clearInputs();
			   				   lblLipsaID.setText(null);
			   				   lblLipsaDenumire.setText(null);
			   				   lblLipsaCategorie.setText(null);
			   				   lblLipsaPret.setText(null);
			   				   lblLipsaDepozit.setText(null);     
			               } else {lblLipsaDepozit.setText("*introdu depozitul");
			                       lblLipsaPret.setText(null);
			                       lblLipsaCategorie.setText(null);
			                       lblLipsaDenumire.setText(null);
				                   lblLipsaID.setText(null);}
			        	  }else {lblLipsaPret.setText("*nu ai introdus pretul");
	                       lblLipsaCategorie.setText(null);
	                       lblLipsaDenumire.setText(null);
		                   lblLipsaID.setText(null);}
			             }else {lblLipsaCategorie.setText("*nu ai introdus categoria");
			                    lblLipsaDenumire.setText(null);
			                    lblLipsaID.setText(null);}
			           } else {lblLipsaDenumire.setText("*introdu denumirea");
			                   lblLipsaID.setText(null);}
			        } else lblLipsaID.setText("*introdu ID-ul");
			}
		});
		btnAdauga.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		btnAdauga.setBounds(40, 255, 89, 23);
		contentPane.add(btnAdauga);
		
		//butonul de stergere
		JButton btnElimina = new JButton("Sterge");
		btnElimina.setBackground(new Color(255, 0, 0));
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!id_input.getText().trim().isEmpty()) {
                   try {
			    	Integer id = Integer.parseInt(id_input.getText());
			    	String verificare = "select * from produse where idProdus = '"+id+"'";
   					PreparedStatement pstmt1 = con.prepareStatement(verificare);
   					ResultSet rs = pstmt1.executeQuery(verificare);
   					if(rs.next()) {
			        String stergere = "DELETE FROM produse WHERE idProdus = ?";
			        PreparedStatement pstmt = con.prepareStatement(stergere);
			    	pstmt.setInt(1, id);
			    	pstmt.executeUpdate();
			    	JOptionPane.showMessageDialog(btnElimina, "Produsul a fost eliminat!");
			    	}
   					else{
   				    JOptionPane.showMessageDialog(btnElimina, "Nu exista produs cu asa ID!");
   					}}
			        catch(Exception ex) {
			    	  System.err.println("Eroare "+ex);
			          }
				    refreshTable();
				    clearInputs();
				    lblLipsaID.setText(null);
				}
				else lblLipsaID.setText("*introdu ID-ul");
			    }
		  });
		btnElimina.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		btnElimina.setBounds(139, 255, 89, 23);
		contentPane.add(btnElimina);
		
		JLabel lblpentruStergereIntrodu = new JLabel("* pentru stergere introdu doar ID-ul produsului sau selecteaza-l din tabel si sterge-l");
		lblpentruStergereIntrodu.setForeground(new Color(255, 102, 0));
		lblpentruStergereIntrodu.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblpentruStergereIntrodu.setBounds(28, 274, 508, 40);
		contentPane.add(lblpentruStergereIntrodu);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				   clearInputs();
				   refreshTable();
			}
		});
		button.setIcon(new ImageIcon(Tabel.class.getResource("/Photos/Webp.net-resizeimage.png")));
		button.setBounds(237, 255, 23, 23);
		contentPane.add(button);
		
		pret_input = new JTextField();
		pret_input.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				    pret_input.setBackground(new Color(255, 255, 255));
					pret_input.setForeground(new Color(0, 0, 0));
				    cat_input.setBackground(new Color(153, 153, 153));
					cat_input.setForeground(new Color(255, 255, 255));
					id_input.setForeground(new Color(255, 255, 255));
					id_input.setBackground(new Color(153, 153, 153));
					den_input.setForeground(new Color(255, 255, 255));
					den_input.setBackground(new Color(153, 153, 153));
					dep_input.setForeground(new Color(255, 255, 255));
					dep_input.setBackground(new Color(153, 153, 153));
			}
		});
		pret_input.setForeground(Color.WHITE);
		pret_input.setColumns(10);
		pret_input.setBackground(new Color(153, 153, 153));
		pret_input.setBounds(133, 172, 86, 20);
		contentPane.add(pret_input);
		
		refreshTable();
	}
}
