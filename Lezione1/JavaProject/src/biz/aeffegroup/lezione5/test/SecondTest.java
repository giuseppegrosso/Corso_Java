package biz.aeffegroup.lezione5.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class SecondTest
{
	public static final String RESULT = "c:/temp/" + SecondTest.class.getSimpleName() + "_"
			+ Calendar.getInstance().getTimeInMillis() + ".pdf";

	/**
	 * Creates a PDF file: hello_direct.pdf
	 * 
	 * @param args
	 *            no arguments needed
	 */
	public static void main(String[] args) throws DocumentException, IOException
	{
		// step 1
		Document document = new Document();
		// step 2
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
		// step 3
		document.open();
		// step 4
		PdfContentByte canvas = writer.getDirectContentUnder();
		writer.setCompressionLevel(0);
		canvas.saveState(); // q
		canvas.beginText(); // BT
		canvas.moveText(100, 788); // 36 788 Td
		canvas.setFontAndSize(BaseFont.createFont(), 12); // /F1 12 Tf
		canvas.showText(getText()); // (Hello World)Tj
		canvas.endText(); // ET
		canvas.restoreState(); // Q
		// step 5
		document.close();
	}
	
	private static String getText()
	{
		return 		"Benvenuto al corso Aeffegroup di Java "
				+ "come vedi è possibile inserire una serie \n"
				+ "di righe all'interno di un documento pdf. "
				+ "Tutto questo grazie alla libreria itext for java";

	}
}
