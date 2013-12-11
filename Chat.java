import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame implements ActionListener {

	public String name;
	public JTextArea textOut;
	public JTextField textIn;
	public JLabel label;
	public Chat other;

	public Chat(String t) {
		super(t);
		name = t;

		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);

		Timer time = new Timer(10, new Listener());

		textOut = new JTextArea("");
		textIn = new JTextField("");
		label = new JLabel("");

		textOut.setEditable(false);
		textIn.addActionListener(this);

		JPanel p = new JPanel(new GridLayout(2, 1, 5, 5));
		p.add(label);
		p.add(textIn);

		add(textOut, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		time.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(textIn.getText().equals(""))
			return;
		
		textOut.setText(textOut.getText() + name + ": " + textIn.getText()
				+ "\n");
		other.textOut.setText(textOut.getText());

		textIn.setText("");

	}

	class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (textIn.getText().equals(""))
				other.label.setText("");
			else
				other.label.setText(name + " yazıyor...");
		}

	}

}
