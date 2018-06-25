package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BarzahlungsUI
{
	private JDialog _rechenfenster;
	private JPanel _panel;

	private JButton _ok;
	private JButton _abbrechen;

	private JTextField _gezahlterBetrag;
	private JTextField _herauszugebenderBetrag;

	private int _gesamtbetrag;

	public BarzahlungsUI(int gesamtbetrag)
	{
		_gesamtbetrag = gesamtbetrag;
		_rechenfenster = new JDialog();
		_rechenfenster.setSize(400, 300);
		_panel = new JPanel();
		_panel.setLayout(new GridLayout(4, 2));
		_gezahlterBetrag = new JTextField("0");
		_herauszugebenderBetrag = new JTextField("0");

		_panel.add(new JTextField("Zu zahlender Betrag:"));
		_panel.add(new JTextField("" + gesamtbetrag));
		_panel.add(new JTextField("Gezahlter Betrag:"));
		_panel.add(_gezahlterBetrag);
		_gezahlterBetrag.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (isNumeric(_gezahlterBetrag.getText()))
				{
					if ((Integer.parseInt(_gezahlterBetrag.getText()) <= _gesamtbetrag))
					{
						_herauszugebenderBetrag.setText("Gezahlter Betrag ist zu klein!");
					}
					else
					{
						_herauszugebenderBetrag.setText("" + WechselBetragErrechnen(_gesamtbetrag));
					}
				}
			}
		});

		_panel.add(new JTextField("Herauszugebender Betrag:"));
		_panel.add(_herauszugebenderBetrag);

		_rechenfenster.add(_panel, BorderLayout.CENTER);
		_rechenfenster.setEnabled(true);
		_rechenfenster.setVisible(true);

	}

	private int WechselBetragErrechnen(int gesamtbetrag)
	{
		return Integer.parseInt(_gezahlterBetrag.getText()) - (gesamtbetrag);
	}

	public boolean isNumeric(String s)
	{
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");
	}
}
