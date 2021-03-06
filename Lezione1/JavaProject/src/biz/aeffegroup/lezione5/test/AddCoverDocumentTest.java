package biz.aeffegroup.lezione5.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;

public class AddCoverDocumentTest
{
	 
    /** The original PDF file. */
    public static final String COVER
        = "c:/temp/hero.pdf";
    /** The original PDF file. */
    public static final String SRC
        = "c:/temp/proposta.pdf";
 
    /** The resulting PDF file. */
    public static final String DEST
        = "c:/temp/pages_with_cover.pdf";
 
    /**
     * Manipulates a PDF file src with the file dest as result
     * @param src the original PDF
     * @param dest the resulting PDF
     * @throws IOException
     * @throws DocumentException
     */
    public void manipulatePdf(String src, String dest)
        throws IOException, DocumentException {
        PdfReader cover = new PdfReader(COVER);
        PdfReader reader = new PdfReader(src);
        Document document = new Document();
        PdfCopy copy = new PdfCopy(document, new FileOutputStream(dest));
        document.open();
        copy.addDocument(cover);
        copy.addDocument(reader);
        document.close();
        cover.close();
        reader.close();
    }
 
    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException
     */
    public static void main(String[] args)
        throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new AddCoverDocumentTest().manipulatePdf(SRC, DEST);
    }
}
