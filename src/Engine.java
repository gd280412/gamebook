package NossoJogo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import basico.Book;
import basico.Player;
import basico.Character;
import basico.Event;
import basico.Choice;
import basico.BattleChoice;
import basico.BlankChoice;
import basico.Enemy;
import basico.BlankEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.Action;
import javax.swing.JLabel;

public class Engine extends JFrame {

	private JPanel contentPane;
	private JTextArea texto;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private Book book;
	private JTextField op1;
	private JTextField op2;
	private JTextArea player;
	private JLabel lblPersonagem;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Engine frame = new Engine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Engine() {
		this.book = createBook();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		texto = new JTextArea(book.showHistory());
		texto.setEditable(false);
		texto.setBounds(12, 25, 681, 381);
		contentPane.add(texto);
		texto.setColumns(10);
		
		JButton b1 = new JButton("Opção 0");
		b1.setAction(action);
		b1.setBounds(710, 418, 117, 25);
		contentPane.add(b1);
		
		JButton b2 = new JButton("Opção 1");
		b2.setAction(action_1);
		b2.setBounds(710, 455, 117, 25);
		contentPane.add(b2);
		
		JLabel lblGabriel = new JLabel(book.showHistoryBook());
		lblGabriel.setBounds(12, 0, 415, 30);
		contentPane.add(lblGabriel);
		Choice choice = book.selectChoice(0);
		op1 = new JTextField(choice.getDescription());
		op1.setEditable(false);
		op1.setBounds(28, 418, 684, 25);
		contentPane.add(op1);
		op1.setColumns(10);
		
		choice = book.selectChoice(1);
		op2 = new JTextField(choice.getDescription());
		op2.setEditable(false);
		op2.setBounds(28, 455, 684, 25);
		contentPane.add(op2);
		op2.setColumns(10);
		
		player = new JTextArea();
		player.setBounds(705, 25, 124, 381);
		contentPane.add(player);
		player.setColumns(10);
		player.setText(book.mostraPlayer());
		
		lblPersonagem = new JLabel("Personagem");
		lblPersonagem.setBounds(711, 5, 100, 15);
		contentPane.add(lblPersonagem);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Opção 1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			String auxTexto = book.nextEvent(0);
			texto.setText(auxTexto + "" + book.showHistory());
			player.setText(book.mostraPlayer());
			if(auxTexto != null){
				if(!book.nextEvents().isEmpty()){
					op1.setText(book.selectChoice(0).getDescription());
					op2.setText(book.selectChoice(1).getDescription());
				} else {
					op1.setText("Sair");
					op2.setText("Resetar jogo");
				}
			} else {
				System.exit(0);
			}
		}
	}
	
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Opção 2");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			String auxTexto = book.nextEvent(1);
			texto.setText(auxTexto + "" + book.showHistory());
			player.setText(book.mostraPlayer());
			if(auxTexto != null){
				if(!book.nextEvents().isEmpty()){
					op1.setText(book.selectChoice(0).getDescription());
					op2.setText(book.selectChoice(1).getDescription());
				} else {
					op1.setText("Sair");
					op2.setText("Resetar jogo");
				}
			} else {
				book.resetHistory();
				player.setText(book.mostraPlayer());
				texto.setText(book.showHistory());
				op1.setText(book.selectChoice(0).getDescription());
				op2.setText(book.selectChoice(1).getDescription());
			}
		}
	}
	
	public static Book createBook() {
        Event eventoFinal_4 = new BlankEvent("Seu tempo acabou. Game Over!", new ArrayList<Choice>());                  //Não deveria entrar aqui, era pra ser proximoPasso_1
        Event eventoFinal_3 = new BlankEvent("Parabens, você saiu do labirinto!!!", new ArrayList<Choice>());
        
        ArrayList<Choice> novasEscolhas_4 = new ArrayList<Choice>();
        Choice escolhaDireita_5 = new BlankChoice("Ir para direita", eventoFinal_3);
        Enemy enemy_boss = new Enemy(60, 5);
        Choice escolhaEsquerda_5 = new Batalhar("Ir para esquerda", eventoFinal_3, enemy_boss, "mago muito poderoso. Ele é o guardião do labirinto."); //Voltar oara proximoPasso_1
        novasEscolhas_4.add(escolhaEsquerda_5);
        novasEscolhas_4.add(escolhaDireita_5);
        
        Event proximoPasso_4 = new BlankEvent("Para onde ir agora?", novasEscolhas_4);
        
        ArrayList<Choice> novasEscolhas_3 = new ArrayList<Choice>();
        Enemy enemy_3 = new Enemy(20, 4);
        Choice escolhaDireita_4 = new Batalhar("Ir para direita", proximoPasso_4, enemy_3, "lobisomem");
        Choice escolhaEsquerda_4 = new HealerChoice("Ir para esquerda", proximoPasso_4);
        novasEscolhas_3.add(escolhaEsquerda_4);
        novasEscolhas_3.add(escolhaDireita_4);
       
        
        Event proximoPasso_3 = new BlankEvent("Caramba, você chegou longe. Será que vai chegar ao fim?", novasEscolhas_3);
        Event eventoFinal_2 = new BlankEvent("Você entrou em uma câmara de gás venenoso. Game over!", new ArrayList<Choice>());
        
 
        ArrayList<Choice> novasEscolhas_2 = new ArrayList<Choice>();
        Enemy enemy_2 = new Enemy(40, 2);
        Choice escolhaDireita_3 = new Batalhar("Ir para direita", proximoPasso_3, enemy_2, "mercenário");
        Choice escolhaEsquerda_3 = new BlankChoice("Ir para esquerda", eventoFinal_2);
        novasEscolhas_2.add(escolhaEsquerda_3);
        novasEscolhas_2.add(escolhaDireita_3);
        
        Event proximoPasso_2 = new BlankEvent("Para onde ir agora?", novasEscolhas_2);
        
        ArrayList<Choice> novasEscolhas_1 = new ArrayList<Choice>();
        Enemy enemy_1 = new Enemy(30, 1);
        Choice escolhaDireita_2 = new Batalhar("Ir para direita", proximoPasso_2, enemy_1, "lobo");
        Choice escolhaEsquerda_2 = new UpgradeChoice("Ir para esquerda", proximoPasso_2);
        novasEscolhas_1.add(escolhaEsquerda_2);
        novasEscolhas_1.add(escolhaDireita_2);
        
        Event proximoPasso_1 = new BlankEvent("Nada aconteceu. Para onde ir agora?", novasEscolhas_1);
        Event eventoFinal_1 = new BlankEvent("Você caiu em um buraco de espinhos. Game Over!", new ArrayList<Choice>());
        
        ArrayList<Choice> escolhasIniciais = new ArrayList<Choice>();
        Choice escolhaDireita_1 = new BlankChoice("Ir para direita", eventoFinal_1);
        Choice escolhaEsquerda_1 = new BlankChoice("Ir para esquerda", proximoPasso_1);
        escolhasIniciais.add(escolhaEsquerda_1);
        escolhasIniciais.add(escolhaDireita_1);
        
        Event ganhandoItem = new EncontrandoItem("Para onde ir agora?",escolhasIniciais,new Armadura("Armadura dourada",0,20));
        
        ArrayList<Choice> ganhando = new ArrayList<Choice>();
        Choice escolhaDireita = new BlankChoice("Ir para direita", ganhandoItem);
        Choice escolhaEsquerda = new BlankChoice("Ir para esquerda", ganhandoItem);
        ganhando.add(escolhaEsquerda);
        ganhando.add(escolhaDireita);

        Event eventoInitial = new BlankEvent("Você está em Labirinto. " +
                "Tente chegar até o fim.", ganhando);

        Book livro = new Book("Labirinto", eventoInitial, new Player(10, 10,0,0));

        return livro;
    }
	
}
