//the first is that it assumes that every Unicode character can be represented in a single 16-bit Java char. With the UTF-16 encoding that Java uses internally for strings, only about the first 216 Unicode characters or code points (the Basic Multilingual Plane or BMP) can be represented in a single char;
//he remaining code points require two chars
//Unicode characters, this solution is not enough. INteger incrementing also does unboxing and boxing. 

public class FirstNonRepeatedChar{
	public static char firstchar(String str){
		int[] count = new int[256];
		for(int i=0;i<str.length();i++){
          char c = str.charAt(i);
          count[c]++;
		}
        for(int i=0;i<str.length();i++){
        	char c = str.charAt(i);
        	if(count[c]==1)
        		return c;
        }

        return null;
	}
}

public class FirstNonRepeatedChar{
	public static char firstChar(String str){
        HashMap<Integer,Object> hmap = new HashMap<Integer,Object>();
        Object seen, seenFirst = new Object(), seenSecond = new Object();
		for(int i=0;i<str.length();i++){
			final int cp = str.codePointAt(i);
			i += Character.charCount(cp);
            seen = hmap.get(cp);
            if(seen==null)
            	hmap.put(cp,seenFirst);
            else{
            	if(seen==seenOnce)
            		hmap.put(cp,seenSecond);
            }

		}

		for(int i=0;i<str.length();i++){
			final int cp = str.codePointAt(i);
			if(hmap.get(cp)==seenFirst)
				return new String(Character.tochars(cp));
		}
	return null;
	}
}
