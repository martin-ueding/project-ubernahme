package projectubernahme;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/** tries to translates stings, returns the input if nothing could be found */
public class Localizer {
	static ResourceBundle bundle;

	private static void init () {
		try {
		bundle = ResourceBundle.getBundle("projectubernahme/strings");
		} catch (MissingResourceException e) {
			System.out.println("No Bundle for "+Locale.getDefault().getLanguage());
		}
	}

	public static String get(String query) {
		if (bundle == null) {
			init();
		}
		
		if (bundle != null && bundle.containsKey(query)) {
			return bundle.getString(query);
		}
		else {
			if (bundle != null) {
				System.out.println("String \""+query+"\" is missing in "+bundle.getLocale());
			}
			return query;
		}
	}
}
