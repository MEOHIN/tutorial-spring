package client.dto;

//  T : generic Type
public class Req<T> {

    private Header header;

    private T resBody;

    public static class Header {
        private String responseConde;

        public String getResponseConde() {
            return responseConde;
        }

        public void setResponseConde(String responseConde) {
            this.responseConde = responseConde;
        }

        @Override
        public String toString() {
            return "Header{" +
                    "responseConde='" + responseConde + '\'' +
                    '}';
        }
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public T getResBody() {
        return resBody;
    }

    public void setResBody(T resBody) {
        this.resBody = resBody;
    }

    @Override
    public String toString() {
        return "Req{" +
                "header=" + header +
                ", resBody=" + resBody +
                '}';
    }
}
