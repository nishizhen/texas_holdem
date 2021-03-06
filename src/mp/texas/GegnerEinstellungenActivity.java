package mp.texas;

import java.util.ArrayList;

import mp.texas.push.PushService;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;


public class GegnerEinstellungenActivity extends Activity 
{

	Button spielStarten;
	SeekBar gegnerLevel;
	TextView text;
	TextView menschlicheGegner;
	LinearLayout layoutGegner;
	LinearLayout layoutMain;
	ScrollView scroll;
	ArrayList<Profil> mitspieler=new ArrayList<Profil>();
	App app;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gegnereinstellungen);
		app=(App)getApplication();
		
		scroll=(ScrollView)findViewById(R.id.scrollViewGegnerEinstellungen);
		mitspieler.add(new Profil(3));
		mitspieler.add(new Profil(2));
		mitspieler.add(new Profil(1));
	
		boolean joinedPlayer = false;
		text=new TextView(this);
		text.setText("Hallo");
		
		menschlicheGegner=(TextView)findViewById(R.id.textViewGegnerMenschlich);
		layoutMain=(LinearLayout)findViewById(R.id.GegnerMainLayout);
		
		
				if(App.singlegame==false)
		{
		    scroll.addView(produceLayoutGegner(),0);
		    		   
		}
				else{
			menschlicheGegner.setVisibility(View.INVISIBLE);
		}
//				ClientPokerspielService.actionSpielErstellen(getApplicationContext());
				
<<<<<<< HEAD
				Log.d("Button", "Hier3");
				App.pokerspiel = new Pokerspiel(App.Mitspieler, App.Startkapital, App.BlindsArt, App.BigBlind, App.BlindsWert);
//				App.Mitspieler.add(App.selbst);
				if(joinedPlayer == false){
					ClientPokerspielService.actionSpielBeitreten(getApplicationContext());
					joinedPlayer = true;
				}
				
				Log.d("beigetreten", App.selbst.getProfil().getName() + " has joined the game");
=======
				//App.pokerspiel = new Pokerspiel();

				App.selbst = new Spieler();

				//ArrayList<Spieler> spielers = App.pokerspiel.getAlleSpieler();
				
// 				spielers.add(selbst);
//				HIERMIT GIBT ES PROBLEME!!!!!! KEINE AHNUNG WARUM?!				
				ClientPokerspielService.actionSpielBeitreten(getApplicationContext());
				Log.d("beigetreten", App.ProfilName + " has joined the game");
>>>>>>> michael
		
		spielStarten=(Button) findViewById(R.id.buttonGegnerEinstellungenSpielStarten);
		spielStarten.setOnClickListener(
				new View.OnClickListener() 
				{             
					public void onClick(View v) 
					{   Log.d("Button", "Neues Spiel starten"); // Perform action on click 
					
<<<<<<< HEAD
						App.GegnerLevel=gegnerLevel.getProgress();
						Log.d("Level",String.valueOf(App.GegnerLevel));

						ClientPokerspielService.actionSpielErstellen(getApplicationContext());
=======
						app.GegnerLevel=gegnerLevel.getProgress();
						Log.d("Level",String.valueOf(app.GegnerLevel));
						//app.Mitspieler mit SPielern f�llen
						//app.pokerspiel= new Pokerspiel(app.Mitspieler, app.Startkapital, app.BlindsArt, app.BlindsWert, app.BigBlind);
						if(app.singlegame==false)
						{ClientPokerspielService.actionSpielErstellen(getApplicationContext());
						}
						else
						{
						App.pokerspiel=new Pokerspiel(false,App.AnzahlSpieler,App.Startkapital,App.BlindsArt,App.BlindsWert,App.BigBlind,App.GegnerLevel);
						Log.d("SPieler im App.pokerspiel",String.valueOf(App.pokerspiel.getAlleSpieler().size()));
						}
>>>>>>> michael
						startActivity(new Intent(getApplicationContext(),SpielActivity.class));
					
					}         
				});
				
		gegnerLevel=(SeekBar)findViewById(R.id.seekBarGegnerEinstellungenLevel);
		gegnerLevel.setMax(100);
	}
	
	public LinearLayout produceLayoutGegner()
	{
		//ScrollView scroll=new ScrollView(getApplicationContext());
		LinearLayout temp=new LinearLayout(this);
		temp.setOrientation(LinearLayout.VERTICAL);
		
		for(Profil n : mitspieler)
		{
			temp.addView(Gegnervorschau(n));
		}
		//scroll.addView(temp);
		return temp;
		
	}
							

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	
	private RelativeLayout Gegnervorschau(Profil gegner)
	{
		RelativeLayout gegnerLayout=new RelativeLayout(getApplicationContext());
		//HIER FOR SCHLEIFE �BER ALLE MITSPIELER
		ImageView bild=new ImageView(this);
		CheckBox check=new CheckBox(this);
		
		bild.setImageResource(R.drawable.as); //(gegner.getImage()
		bild.setAdjustViewBounds(true);
		bild.setScaleType(ScaleType.CENTER_INSIDE);
		bild.setMaxWidth(60);
		bild.setId(1);
		
		TextView name=new TextView(this);
		name.setText("SPIELERNAME"); //gegner.getName()
		
		
		gegnerLayout.addView(bild,0);
		
		LayoutParams params=new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.RIGHT_OF, 1);
		params.addRule(RelativeLayout.CENTER_VERTICAL);
		
		gegnerLayout.addView(name,params);
		 
		LayoutParams params2=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		params2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		params2.addRule(RelativeLayout.CENTER_VERTICAL);
		gegnerLayout.addView(check,params2);
		check.setChecked(true);
		return gegnerLayout;
		
	}

}
