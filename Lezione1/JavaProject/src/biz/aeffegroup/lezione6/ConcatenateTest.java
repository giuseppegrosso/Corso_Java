package biz.aeffegroup.lezione6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class ConcatenateTest
{

	private final static Logger logger = Logger.getLogger(ConcatenateTest.class.getName());

	private final List<String> list;
	private final String outputFilename;

	public ConcatenateTest(String outputFilename) {
        this.outputFilename = outputFilename;
        this.list = new ArrayList<>();
    }

	public void add(String file)
	{
		this.list.add(file);
	}

	public void execute()
	{
		logger.log(Level.FINE, "inizio elaborazione...");
		try
		{
			Document document = new Document();
			PdfCopy copy = new PdfCopy(document, new FileOutputStream(this.outputFilename + ".pdf"));
			document.open();
			PdfReader reader;
			int pagesNumber;
			for (String file : this.list)
			{
				reader = new PdfReader(file);
				pagesNumber = reader.getNumberOfPages();
				for (int page = 0; page < pagesNumber;)
				{
					copy.addPage(copy.getImportedPage(reader, ++page));
				}
			}
			document.close();
			copy.close();
			
			addNumberPage(outputFilename, outputFilename + "_second.pdf");
			logger.log(Level.FINE, "fine elaborazione...");
		} catch (DocumentException | IOException e)
		{
			logger.log(Level.SEVERE, "", e);
		}
	}
	
	 public void addNumberPage(String src, String dest) throws IOException, DocumentException {
	        PdfReader reader = new PdfReader(src);
	        int n = reader.getNumberOfPages();
	        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
	        PdfContentByte pagecontent;
	        for (int i = 0; i < n; ) {
	            pagecontent = stamper.getOverContent(++i);
	            ColumnText.showTextAligned(pagecontent, Element.ALIGN_RIGHT,
	                    new Phrase(String.format("Pag %s/%s", i, n)), 559, 16, 0);
	        }
	        stamper.close();
	        reader.close();
	    }
	

	public static void main(String[] args)
	{
		ConcatenateTest c = new ConcatenateTest("c:/temp/test1_concat_test2");
		c.add("c:/temp/hello.pdf");
		c.add("c:/temp/ordine.servizio.pdf");
		c.execute();
	}
}