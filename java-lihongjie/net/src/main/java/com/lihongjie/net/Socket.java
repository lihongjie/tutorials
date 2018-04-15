package com.lihongjie.net;

/**
 * Socket Builder
 */
public class Socket {

    private final int port;
    private final String host;
    private final boolean ssl;
    private final int timeout;

    private Socket(int port, String host, boolean ssl, int timeout) {
        this.port = port;
        this.host = host;
        this.ssl = ssl;
        this.timeout = timeout;
    }

    public static class Builder {
        private int port = 0;
        private String host = null;
        private boolean ssl = false;
        private int timeout = 0;

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder ssl(boolean ssl) {
            this.ssl = ssl;
            return this;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public Socket build() {
            Socket socket = new Socket(this.port, this.host, this.ssl, this.timeout);
            return socket;
        }
    }
}
