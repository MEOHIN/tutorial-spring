package springIntro.di;

public class DIMain {
    public static void main(String[] args) {

        String url = "www.naver.com/books/it?page=206&name=spring-boot";

/**        Base 64 encoding     */
//        Base64Encoder base64Encoder = new Base64Encoder();
//        InterfaceEncoder base64Encoder = new Base64Encoder();
        Encoder encoder = new Encoder(new UrlEncoder());
        String result = encoder.encode(url);
        System.out.println(result);

/**        url encoding     */
//        UrlEncoder urlEncoder = new UrlEncoder();
//        InterfaceEncoder urlEncoder = new UrlEncoder();
//        String urlResult = encoder.encode(url);
//        System.out.println(urlResult);
    }
}
