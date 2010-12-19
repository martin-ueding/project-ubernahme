package projectubernahme;

/** translates stings
  There have to be translated strings in sting_lang.properties files, in order for this to work. At this point, it just returns the string that is queried since the program is changing rapidly and any translation would not do any good right now. */
public class Localizer {
	public static String get (String query) {
		return query;
	}
}
