package qi.edu.br.util;

public class Numeric {

	public static boolean isNumeric(String n)
	{
		try {

			float num = Float.parseFloat(n);
			
			if(num > 0){
				return true;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
