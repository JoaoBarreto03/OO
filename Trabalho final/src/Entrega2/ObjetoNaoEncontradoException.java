package Entrega2;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ObjetoNaoEncontradoException extends Exception{
	public ObjetoNaoEncontradoException() {
		JOptionPane.showMessageDialog(null, "Objeto n�o encontrado exception.");
	}
}
