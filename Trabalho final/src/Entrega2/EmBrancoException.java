package Entrega2;

import javax.swing.JOptionPane;

@SuppressWarnings("serial") //estava dando alerta amarelo se n�o utilizasse
public class EmBrancoException extends Exception{
	EmBrancoException(){
		JOptionPane.showMessageDialog(null, "TENTE NOVAMENTE");
	}
}
