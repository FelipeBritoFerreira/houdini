package org.gmr.web.multipart;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.output.ThresholdingOutputStream;

public class GOutputStream
  extends ThresholdingOutputStream
{
  private final ByteArrayOutputStream memoryOutputStream;
  private boolean closed = false;
  
  public GOutputStream(long threshold)
  {
    super((int)threshold);
    this.memoryOutputStream = new ByteArrayOutputStream();
  }
  
  protected OutputStream getStream()
    throws IOException
  {
    return this.memoryOutputStream;
  }
  
  protected void thresholdReached()
  {
    throw new UnsupportedOperationException("Not possible in GAE. Will never reach!! Try changing max upload size setting.");
  }
  
  public boolean isInMemory()
  {
    return true;
  }
  
  public byte[] getData()
  {
    return this.memoryOutputStream.toByteArray();
  }
  
  public void close()
    throws IOException
  {
    super.close();
    this.closed = true;
  }
  
  public void writeTo(OutputStream out)
    throws IOException
  {
    if (!this.closed) {
      throw new IOException("Stream not closed");
    }
    this.memoryOutputStream.writeTo(out);
  }
}
