/**
* <ul>
* Android Tutorial, An <strong>Android2EE</strong>'s project.</br>
* Produced by <strong>Dr. Mathias SEGUY</strong> with the smart contribution of <strong>Julien PAPUT</strong>.</br>
* Delivered by <strong>http://android2ee.com/</strong></br>
* Belongs to <strong>Mathias Seguy</strong></br>
* ****************************************************************************************************************</br>
* This code is free for any usage but can't be distribute.</br>
* The distribution is reserved to the site <strong>http://android2ee.com</strong>.</br>
* The intelectual property belongs to <strong>Mathias Seguy</strong>.</br>
* <em>http://mathias-seguy.developpez.com/</em></br>
* </br>
* For any information (Advice, Expertise, J2EE or Android Training, Rates, Business):</br>
* <em>mathias.seguy.it@gmail.com</em></br>
* *****************************************************************************************************************</br>
* Ce code est libre de toute utilisation mais n'est pas distribuable.</br>
* Sa distribution est reservée au site <strong>http://android2ee.com</strong>.</br>
* Sa propriété intellectuelle appartient à <strong>Mathias Séguy</strong>.</br>
* <em>http://mathias-seguy.developpez.com/</em></br>
* </br>
* Pour tous renseignements (Conseil, Expertise, Formations J2EE ou Android, Prestations, Forfaits):</br>
* <em>mathias.seguy.it@gmail.com</em></br>
* *****************************************************************************************************************</br>
* Merci à vous d'avoir confiance en Android2EE les Ebooks de programmation Android.
* N'hésitez pas à nous suivre sur twitter: http://fr.twitter.com/#!/android2ee
* N'hésitez pas à suivre le blog Android2ee sur Developpez.com : http://blog.developpez.com/android2ee-mathias-seguy/
* *****************************************************************************************************************</br>
* com.android2ee.android.tuto</br>
* 25 mars 2011</br>
*/
package com.android2ee.android.tuto.gui.multi.tab;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;

public class MultiTabBrowserTuto extends TabActivity {
	String tag="MultiTabBrowserTuto";
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e(tag,tag+"=>onCreate ");
		// Define the Tab structure
		setContentView(R.layout.main);
		// Retrieve the ressource to access to the icon
		Resources resources = getResources(); // Resource object to get Drawables
		// Set the tabHost (set it has final to use it in the OnTabChangeListener)
		final TabHost tabHost = getTabHost();
		// Define the tabSpec that can be thought has the content of the TabPanel
		TabHost.TabSpec tabSpec;
		// Define the intent that is used to populate the tabSpec
		Intent intent;

		// Create an Intent to launch an Activity for the tab
		intent = new Intent().setClass(this, Android2eeWebSTI.class);

		// Initialize a TabSpec for each tab and add it to the TabHost
		// Get a new TabHost.TabSpec associated with this tab host.
		tabSpec = tabHost.newTabSpec("Android2ee");
		// Define its indicator the label displayed (it should be
		// ressources.getString(R.string.stringId)
		tabSpec.setIndicator("Android2EE", resources.getDrawable(R.drawable.ic_tab));
		// Define the content of the Spec (the TabPanel)
		tabSpec.setContent(intent);
		// Add it to the tab container
		tabHost.addTab(tabSpec);

		// Do the same with the tab that displays a simple TextView:
		// Define the intent that will be displayed
		intent = new Intent().setClass(this, TextViewActivity.class);
		// Get a new TabHost.TabSpec associated with this tab host.
		tabSpec = tabHost.newTabSpec("textView");
		// Define its indicator the label displayed (it should be
		// ressources.getString(R.string.stringId)
		tabSpec.setIndicator("TextView", resources.getDrawable(R.drawable.ic_tab));
		// Define the content of the Spec (the TabPanel)
		tabSpec.setContent(intent);
		// Add it to the tab container
		tabHost.addTab(tabSpec);
		
		// Do the same with the tab that displays a simple Clock (analogic and digital):
		// Define the intent that will be displayed
		intent = new Intent().setClass(this, ClockAD.class);
		// Get a new TabHost.TabSpec associated with this tab host.
		tabSpec = tabHost.newTabSpec("clock");
		// Define its indicator the label displayed
		tabSpec.setIndicator("Clock", resources.getDrawable(R.drawable.ic_tab));
		// Define the content of the Spec (the TabPanel)
		tabSpec.setContent(intent);
		// Add it to the tab container
		tabHost.addTab(tabSpec);
		
		
		//Define the current tab displayed (here the clock)
		tabHost.setCurrentTab(2);
		//Add a listener that just displays a Toast with the tag of the new selected tab
		tabHost.setOnTabChangedListener(new OnTabChangeListener() {
			@Override
			public void onTabChanged(String tabId) {
				Toast.makeText(getApplicationContext(), "New tab selection : " + tabHost.getCurrentTabTag(),
						Toast.LENGTH_SHORT).show();
			}
		});

	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		Log.e(tag,tag+"=>onDestroy ");
		super.onDestroy();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		Log.e(tag,tag+"=>onPause ");
		super.onPause();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		Log.e(tag,tag+"=>onResume ");
		super.onResume();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onStop()
	 */
	@Override
	protected void onStop() {
		Log.e(tag,tag+"=>onStop ");
		super.onStop();
	}
}