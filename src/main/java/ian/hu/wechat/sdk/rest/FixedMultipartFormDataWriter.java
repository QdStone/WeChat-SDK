package ian.hu.wechat.sdk.rest;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataWriter;
import org.jboss.resteasy.plugins.providers.multipart.MultipartOutput;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Provider
@Produces("multipart/form-data")
public class FixedMultipartFormDataWriter extends MultipartFormDataWriter {
    @Override
    protected void write(MultipartOutput multipartOutput, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException {
        OutputStream partsStream = new NoClosableOutputStream(entityStream);
        super.write(multipartOutput, mediaType, httpHeaders, partsStream);
        entityStream.write("\r\n".getBytes("utf-8"));
    }

    private static class NoClosableOutputStream extends FilterOutputStream {
        private NoClosableOutputStream(OutputStream entityStream) {
            super(entityStream);
        }

        @Override
        public void close() throws IOException {
            //super.close();
            flush();
        }
    }
}
