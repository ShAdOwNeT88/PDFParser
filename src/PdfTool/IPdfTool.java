package PdfTool;

import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.IOException;


public interface IPdfTool {
    PDDocument loadPdf(String urlPdf);
    String extractTextFromPdf(int startPage, int endPage, PDDocument pdDocument) throws IOException;
    String extractNameSurnameDelegator(String pdfConverted);
    String extractDocumentNumbDelegator(String pdfConverted);
    String extractbirthDateDelegator(String pdfConverted);
    String extractNameSurnameDelegate(String pdfConverted);
    String extractDocumentNumbDelegate(String pdfConverted);
    String extractbirthDateDelegate(String pdfConverted);
    String normalizeString(String strToNormalize);

}
