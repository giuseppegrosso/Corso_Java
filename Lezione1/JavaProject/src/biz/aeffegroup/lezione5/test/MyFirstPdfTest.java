package biz.aeffegroup.lezione5.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class MyFirstPdfTest
{

	/** Path to the resulting PDF file. */
	public static final String RESULT = "c:/temp/" + MyFirstPdfTest.class.getSimpleName() + "_"
			+ Calendar.getInstance().getTimeInMillis() + ".pdf";

	/**
	 * creazione del file pdf.
	 * 
	 * @param args
	 *            no arguments needed
	 */
	public static void main(String[] args) throws DocumentException, IOException
	{
		new MyFirstPdfTest().createPdf(RESULT);
	}

	/**
	 * Creates a PDF document.
	 * 
	 * @param filename
	 *            the path to the new PDF document
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void createPdf(String filename) throws DocumentException, IOException
	{

		// step 1
		Document document = new Document(PageSize.A6.rotate());
		// step 2
		PdfWriter.getInstance(document, new FileOutputStream(filename));
		// step 3
		document.open();
		// step 4
		document.add(new Paragraph("Benvenuto al corso Aeffegroup di Java come vedi è possibile inserire una serie di righe all'interno di un documento pdf. Tutto questo grazie alla libreria itext for java"));
		// step 5
		document.close();
	}
	
}