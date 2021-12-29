package chapter2.designPattern.proxy;

public class Browser implements InterfaceBrowser {

    private String url;

    public Browser(String url) {
        this.url = url;
    }


    @Override
    public Html show() {
        System.out.println("browser loading html from : " + url);
        return new Html(url);
    }
}
