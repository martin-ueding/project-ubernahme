package projectubernahme;

import java.util.ResourceBundle;

/** translates stings */
public class Localizer {
	static ResourceBundle bundle = ResourceBundle.getBundle("sprache");

	public static String get(String query) {
		if (bundle.containsKey(query)) {
			return bundle.getString(query);
		}
		else {
			System.out.println("String \""+query+"\" is missing in "+bundle.getLocale());
			return query;
		}
	}
}
