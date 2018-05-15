import java.io.DataInputStream;
import java.io.InputStream;

//prob id: 979A

public class pizza{
    public static void main(String[] args) throws Exception{
        Parser ps = new Parser(System.in);
        long n = ps.nextLong();
        n = n+1;

        if(n == 1){
            System.out.println("0");
            return;
        }

        if(n % 2 == 0){
            System.out.println(n/2);
        }
        else{
            System.out.println(n);
        }
    }

    static class Parser
    {
        final private int BUFFER_SIZE = 1 << 16;

        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Parser(InputStream in)
        {
            din = new DataInputStream(in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public long nextLong() throws Exception
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = c == '-';
            if (neg) c = read();
            do
            {
                ret = ret * 10 + c - '0';
                c = read();
            } while (c > ' ');
            if (neg) return -ret;
            return ret;
        }

        //reads in the next string
        public String next() throws Exception
        {
            StringBuilder ret =  new StringBuilder();
            byte c = read();
            while (c <= ' ') c = read();
            do
            {
                ret = ret.append((char)c);
                c = read();
            } while (c > ' ');
            return ret.toString();
        }

        public int nextInt() throws Exception
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = c == '-';
            if (neg) c = read();
            do
            {
                ret = ret * 10 + c - '0';
                c = read();
            } while (c > ' ');
            if (neg) return -ret;
            return ret;
        }

        private void fillBuffer() throws Exception
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws Exception
        {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }
}
