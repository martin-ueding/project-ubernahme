// Copyright (c) 2011 Martin Ueding <dev@martin-ueding.de>

package projectubernahme;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/** tries to translate strings, returns the input if nothing could be found */
public class Localizer {
	private static ResourceBundle bundle;

	private static void init () {
		try {
			bundle = ResourceBundle.getBundle("projectubernahme/strings");
		} catch (MissingResourceException e) {
			System.out.println("No Bundle for "+Locale.getDefault().getLanguage());
		}
	}

	public static String get (String query) {
		if (bundle == null) {
			init();
		}
		
		if (bundle != null && bundle.containsKey(query)) {
			return bundle.getString(query);
		}
		else {
			if (bundle != null && !query.equals("String “{0}” is missing in bundle “{1}”.")) {
				if (ProjectUbernahme.getConfigValue("displayDebugLogMessages").equals("true")) {
					ProjectUbernahme.log(MessageFormat.format(Localizer.get("String “{0}” is missing in bundle “{1}”."), new Object[] {query, bundle.getLocale()}), MessageTypes.DEBUG);
				}
			}
			return query;
		}
	}
}
