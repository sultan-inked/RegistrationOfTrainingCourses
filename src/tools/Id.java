package tools;

public abstract class Id {
	public static String create(String signature, int counter) {
		if(signature.trim().equals("") || signature == null || counter < 0){
			Cnsl.println("Error: Whith signature or counter (make id)");
			return null;
		}
		String counterStr = "" + counter;
		signature = signature.substring(0, signature.length() -counterStr.length());
		return signature += counterStr;
	}
}
