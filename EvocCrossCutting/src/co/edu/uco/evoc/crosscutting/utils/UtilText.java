package co.edu.uco.evoc.crosscutting.utils;

public final class UtilText {
	
	
	private static final UtilText INSTANCE = new UtilText();
	public static final String EMPTY = "";
	
	private UtilText() {
		super();
	}
	
	public static final UtilText getUtilText() {
		return INSTANCE;
	}
	
	public final  boolean isNull(final String text) {
		return UtilObject.isNull(text);
	}
	
	public final String getDefault(final String text, final String defaultValue) {
		
		String result = text;
		
		if(isNull(text)) {
			result = isNull(defaultValue) ? EMPTY : defaultValue;
		}
		
		return result;
		
	}
	
	public final String getDefault(final String text) {
		return getDefault(text, EMPTY);
	}
	
	public final String getDefaultValue() {
		return EMPTY;
	}
	
	public final String applyTrim(final String text) {
		return getDefault(text).trim();
	}
	
	public final boolean matchPattern(final String text, final String pattern) {
		return getDefault(text).matches(getDefault(pattern));
	}
	
	public static void main(String[] args) {
		
		System.out.println(getUtilText().applyTrim(" mi casita   "));
		
		
	}

}
