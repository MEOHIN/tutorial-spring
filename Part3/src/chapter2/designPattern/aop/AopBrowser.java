package chapter2.designPattern.aop;

import chapter2.designPattern.proxy.Html;
import chapter2.designPattern.proxy.InterfaceBrowser;

public class AopBrowser implements InterfaceBrowser {

    private String url;
    private Html html;
    private Runnable before;
    private Runnable after;

    public AopBrowser(String url, Runnable before, Runnable after) {
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() {

        before.run();

        if (html == null){
            this.html = new Html(url);
            System.out.println("AopBrowser html loading from: " + url);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        after.run();
        System.out.println("AopBrowser html cache: " + url);
        return null;
    }
}
