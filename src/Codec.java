public class Codec {

	private String[] getURIParts(String url) {
		return url.split("://");
	}
	
    
    private String applyHash(String url) {
		String[] contextPath = getURIParts(url);
        StringBuilder result = new StringBuilder(contextPath[0]);
        result.append(":");
        result.append("//");
        result.append(new StringBuilder(contextPath[1]).reverse().toString());
        return result.toString();
	}
    
    
	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
        return applyHash(longUrl);
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		 return applyHash(shortUrl);
	}

	public static void main(String[] args) {
		Codec codec = new Codec();
		String encoded = codec.encode("https://bone.example.net/?brother=agreement&beds=bird");
		System.out.println(encoded);
		String dcoded = codec.encode(encoded);
		System.out.println(dcoded);
	}

}
