package biz.aeffegroup.lezione5.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ZipPdfTest
{

	/** Path to the resulting PDF file. */
	public static final String RESULT = "c:/temp/itextPdf.zip";

	/**
	 * Creates a zip file with five PDF documents: hello1.pdf to hello5.pdf
	 * 
	 * @param args
	 *            no arguments needed
	 */
	public static void main(String[] args) throws DocumentException, IOException
	{
		// creating a zip file with different PDF documents
		ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(RESULT));
		for (int i = 1; i <= 5; i++)
		{
			ZipEntry entry = new ZipEntry("ItextPdf_" + i + ".pdf");
			zip.putNextEntry(entry);

			// step 1
			Document document = new Document();
			// step 2
			PdfWriter writer = PdfWriter.getInstance(document, zip);
			writer.setCloseStream(false);
			// step 3
			document.open();
			// step 4
			document.add(new Paragraph("Benvenuto nel documento numero : " + i));
			// step 5
			document.close();

			zip.closeEntry();
		}
		zip.close();
	}
}