package org.gmr.web.multipart;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;

public class GFileItemFactory
  implements FileItemFactory
{
  private int sizeThreshold = Integer.MAX_VALUE;
  
  public FileItem createItem(String fieldName, String contentType, boolean isFormField, String fileName)
  {
    return new GFileItem(fieldName, contentType, isFormField, fileName, this.sizeThreshold);
  }
  
  public void setSizeThreshold(int sizeThreshold)
  {
    this.sizeThreshold = sizeThreshold;
  }
  
  public int getSizeThreshold()
  {
    return this.sizeThreshold;
  }
}
