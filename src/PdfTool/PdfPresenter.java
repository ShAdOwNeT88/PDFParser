package PdfTool;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;

public class PdfPresenter implements IPdfPresenter {
    String pathOfPdf,extractedPdf;
    PdfTool tool;
    PDDocument doc;

    /*
    * Constructor
    * Extract text from pdf file defined by pathToPdfFile passed from main command line
    * initialize PdfTool,PDDocument and extract the text from pdf*/

    public PdfPresenter(String pathToPdfFile) throws IOException {
        pathOfPdf = pathToPdfFile;
        tool = new PdfTool();
        doc = tool.loadPdf(pathOfPdf);
        extractedPdf = tool.extractTextFromPdf(1,1,doc);
    }

    @Override
    /*
    * Obtain detail regard Delegator
    * */
    public void obtainsAllDetailsOfDelegator() {

        String nameSurnameDelegator = tool.extractNameSurnameDelegator(tool.normalizeString(extractedPdf));
        String numDocDelegator = tool.extractDocumentNumbDelegator(tool.normalizeString(extractedPdf));
        String birthDateDelegator = tool.extractbirthDateDelegator(tool.normalizeString(extractedPdf));

        System.out.println("DELEGANTE: ".concat(nameSurnameDelegator).concat(" ").concat(numDocDelegator).concat(" ").concat(birthDateDelegator));

    }

    @Override
    /*
    * Obtain detail regard Delegate
    * */
    public void obtainAllDetailsOfDelegate() {

        String nameSurnameDelegate = tool.extractNameSurnameDelegate(tool.normalizeString(extractedPdf));
        String numDocDelegate = tool.extractDocumentNumbDelegate(tool.normalizeString(extractedPdf));
        String birthDateDelegate = tool.extractbirthDateDelegate(tool.normalizeString(extractedPdf));

        System.out.println("DELEGATO: ".concat(nameSurnameDelegate).concat(" ").concat(numDocDelegate).concat(" ").concat(birthDateDelegate));
    }

    public void printExtractedLine(){
        System.out.println(extractedPdf);
    }
}
