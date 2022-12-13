package carro;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.awt.event.ActionEvent;
import carro.Conexao;

public class TelaCarro extends JFrame {

	private JPanel contentPane;
	private JTextField tfCor;
	private JTextField tfRoda;
	private JTextField tfAcessorio;
	private JTextField tfMarca;
	private JTextField tfModelo;
	HashSet<String> Carro;
	ArrayList <Carro> x;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCarro frame = new TelaCarro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TelaCarro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		x = new ArrayList<>();
		Carro = new HashSet<String>();
		
		JPanel jPanel1 = new JPanel();
		jPanel1.setBackground(Color.WHITE);
		contentPane.add(jPanel1, BorderLayout.CENTER);
		
		JLabel Cor = new JLabel();
		Cor.setText("Cor");
		Cor.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfCor = new JTextField();
		tfCor.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel Roda = new JLabel();
		Roda.setText("Roda");
		Roda.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfRoda = new JTextField();
		tfRoda.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel modelo = new JLabel();
		modelo.setText("Acessório");
		modelo.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfAcessorio = new JTextField();
		tfAcessorio.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel Marca = new JLabel();
		Marca.setText("Marca");
		Marca.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfMarca = new JTextField();
		tfMarca.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel modelo1 = new JLabel();
		modelo1.setText("Modelo");
		modelo1.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfModelo = new JTextField();
		tfModelo.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton Cadastrar1 = new JButton();
		Cadastrar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carro c1 = new Carro();
	            c1.setModelo(tfModelo.getText());
	            c1.setAcessorio(tfAcessorio.getText());
	            c1.setMarca(tfMarca.getText());
	            c1.setCor(tfCor.getText());
	            c1.setRoda(tfRoda.getText());

				try {
					Connection con = Conexao.faz_conexao();
					String sql = "insert into especificacoes(marca, modelo, cor, roda, acessorio) values (?, ?, ?, ?, ?)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, c1.getMarca());
					stmt.setString(2, c1.getModelo());
					stmt.setString(3, c1.getCor());
					stmt.setString(4, c1.getRoda());
					stmt.setString(5, c1.getAcessorio());
					
				stmt.execute();
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

			}catch (SQLException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Faltando informações obrigatórias!");
					
				}
				
			}
		});
		Cadastrar1.setText("Cadastrar");
		Cadastrar1.setFont(new Font("Arial", Font.BOLD, 14));
		Cadastrar1.setBackground(new Color(204, 204, 255));
		
		JButton Sair = new JButton();
		Sair.addActionListener(new ActionListener() {
			public void actionPerformed(AWTEvent e) {
				 System.exit(0);
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		Sair.setText("Sair");
		Sair.setFont(new Font("Arial", Font.BOLD, 14));
		Sair.setBackground(new Color(204, 204, 255));
		
		JLabel jLabel2 = new JLabel();
		jLabel2.setText("Carros");
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton Dicionario = new JButton();
		Dicionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Marcela\\Desktop\\LP1-main\\E2\\nomes.csv"))){
					String line = br.readLine();
					Map<String, String> map = new HashMap<>();
					while (line != null) {
						String [] fields = line.split(";");
						
						String modeloc = "Modelo: ";
						String modelo = fields[0];
						String acessorioc = "Acessorio: ";
						String acessorio = fields[1];
						String marcac = "Marca: ";
						String marca = fields[2];
						String corc = "Cor: ";
						String cor = fields[3];
						String rodac = "Roda: ";
						String roda = fields[4];
						
						map.put(modeloc, modelo);
						map.put(acessorioc, acessorio);
						map.put(marcac, marca);
						map.put(corc, cor);
						map.put(rodac, roda);
						
						line = br.readLine();
						
					}
					System.out.println("Dicionario");
					for (String key: map.keySet()) {
						
						System.out.println(key + map.get(key));
						JOptionPane.showMessageDialog(null, key + map.get(key));
						
					}
				} catch (Exception e2) {
					System.out.println("Error: " + e2.getMessage());
				}
				
			}
		});
		Dicionario.setText("Dicionário");
		Dicionario.setFont(new Font("Arial", Font.BOLD, 14));
		Dicionario.setBackground(new Color(204, 204, 255));
		GroupLayout gl_jPanel1 = new GroupLayout(jPanel1);
		gl_jPanel1.setHorizontalGroup(
			gl_jPanel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel1.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addComponent(Cadastrar1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(Dicionario, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Sair, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_jPanel1.createSequentialGroup()
												.addComponent(modelo)
												.addGap(18))
											.addGroup(gl_jPanel1.createSequentialGroup()
												.addComponent(modelo1, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)))
										.addGroup(gl_jPanel1.createSequentialGroup()
											.addComponent(Marca)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_jPanel1.createSequentialGroup()
										.addComponent(Cor)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_jPanel1.createSequentialGroup()
									.addComponent(Roda, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(tfModelo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
								.addComponent(tfAcessorio, Alignment.LEADING)
								.addComponent(tfMarca, Alignment.LEADING)
								.addComponent(tfCor, Alignment.LEADING)
								.addComponent(tfRoda, Alignment.LEADING))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
				.addComponent(jLabel2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
		);
		gl_jPanel1.setVerticalGroup(
			gl_jPanel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel1.createSequentialGroup()
					.addGap(10)
					.addComponent(jLabel2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(modelo1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(modelo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfAcessorio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Marca, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfCor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Cor, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfRoda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Roda, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(Cadastrar1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(Dicionario, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(Sair, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		jPanel1.setLayout(gl_jPanel1);
	}
}
