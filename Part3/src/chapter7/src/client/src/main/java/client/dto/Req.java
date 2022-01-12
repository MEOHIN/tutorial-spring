package client.dto;

//  T : generic Type
public class Req<T> {

    private Header header;

    private T body;

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
}
