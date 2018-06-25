package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf;
/**
 * TESTTESTTEST
 * @author Goldfisch
 *Das Barzahlungswerkzeug soll den Verkäufer bei Barzahlungen unterstützen, indem es den Gesamtbetrag anzeigt, 
 *die Barzahlung erfasst und den Wechselbetrag errechnet
 */
public class Barzahlungswerkzeug
{
	BarzahlungsUI _barzahlungsUI;
			
	public Barzahlungswerkzeug(int gesamtbetrag)
	{
		_barzahlungsUI = new BarzahlungsUI(gesamtbetrag);
	}
}
