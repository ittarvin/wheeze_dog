package cn.zjcw.zipkin.file.sender;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zipkin2.Call;
import zipkin2.codec.Encoding;
import zipkin2.reporter.BytesMessageEncoder;
import zipkin2.reporter.Sender;

import java.nio.charset.StandardCharsets;
import java.util.List;


public class FileSender extends Sender {

    private static final Logger logger = LoggerFactory.getLogger(FileSender.class);

    private boolean spanSent = false;

    boolean isSpanSent() {
        return this.spanSent;
    }

    transient boolean closeCalled;

    final BytesMessageEncoder messageEncoder;

    public FileSender(){
        this.messageEncoder = BytesMessageEncoder.forEncoding(encoding());
    }

    @Override
    public Encoding encoding() {
        return Encoding.JSON;
    }

    @Override
    public int messageMaxBytes() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int messageSizeInBytes(List<byte[]> encodedSpans) {
        return encoding().listSizeInBytes(encodedSpans);
    }

    @Override
    public Call<Void> sendSpans(List<byte[]> encodedSpans) {

        this.spanSent = true;

        if (this.closeCalled) {

            throw new IllegalStateException("close");

        } else {

            byte[] message = this.messageEncoder.encode(encodedSpans);

            String srt2 = new String(message, StandardCharsets.UTF_8);

            logger.info(srt2);
        }

        return Call.create(null);

    }

    public void close() {
        this.closeCalled = true;
    }
}
