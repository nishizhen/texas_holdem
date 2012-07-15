/*
 * Klasse f�r menschliche Spieler, im wesentlichen wichtig f�r die Interaktivit�t
 * die Funktion setzen, fordert zur Eingabe heraus
 */
package mp.texas;

import android.util.Log;

public class Humanspieler extends Spieler 
{

	
	public Humanspieler(Spieler selbst, int chips)
	{
		profil=App.selbst.getProfil();
		this.chips=chips;
	}
	
	
	public Humanspieler() 
	{
		profil=new Profil();
	}
	
	
	public int setzen(Pokerspiel pokerspiel)
	{
		Log.d("Human","setzen");
		App.setInteracted(false);
		return App.setzwert;
		
	}

	@Override
	public void gameover() {
		Log.d("GameOver","Human Player");
		super.gameover();
	}


	
	
	

}
