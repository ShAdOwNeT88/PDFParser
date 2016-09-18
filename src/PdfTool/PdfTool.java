package PdfTool;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PdfTool implements IPdfTool {

    PDDocument pdDocument;
    PDFTextStripper pdfStripper;
    String textOfPdf;

    /*
    * Create document for extraction from an url of existing pdf */
    @Override
    public PDDocument loadPdf(String urlPDf) {
        File file = new File(urlPDf);
        if(file.exists()){
            try {
                pdDocument = PDDocument.load(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pdDocument;
    }

    /*
    * Extraction text from PDF
    * @param startPage and endPage index for start and stop extracting
    * @param pdDocument passing to pdfStripper */

    @Override
    public String extractTextFromPdf(int startPage, int endPage, PDDocument pdDocument) throws IOException {
        try {
            pdfStripper = new PDFTextStripper();
            pdfStripper.setStartPage(startPage);
            pdfStripper.setEndPage(endPage);
            textOfPdf = pdfStripper.getText(pdDocument);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return textOfPdf;
    }

    @Override
    /*
    * Extract Name and surname of Delagtor from a String
    * */
    public String extractNameSurnameDelegator(String pdfConverted) {
        int startIndex = 0,stopIndex = 0;
        String firstPart = null, nameSurnameDelegator = "";
        String[] delegator = null;

        //Get first part of the module regards delegator
        String[] splittedString = pdfConverted.split("DELEGA");
        firstPart = splittedString[1];

        delegator = firstPart.split(" ");

        //recognize where name start and ends and save two index
        for(int i = 0; i< delegator.length; i++){
            if(delegator[i].equalsIgnoreCase("sottoscritto/a")){
                startIndex = i;
            }

            if(delegator[i].equalsIgnoreCase("nato/a")){
                stopIndex = i;
            }
        }

        //Extract substring for name and surname
        for(int j = startIndex + 1; j < stopIndex; j++){
            nameSurnameDelegator = nameSurnameDelegator.concat(" ").concat(delegator[j]);
        }

        return nameSurnameDelegator;
    }

    @Override
    /*
    * Extract document number of Delegator from a String
    * */
    public String extractDocumentNumbDelegator(String pdfConverted) {
        int startIndex = 0;
        String firstPart = null, documentNumberDelegator = "";
        String[] delegator = null;

        //Get first part of the module regards delegator
        String[] splittedString = pdfConverted.split("DELEGA");
        firstPart = splittedString[1];

        delegator = firstPart.split(" ");

        //recognize where document number start and save index
        for(int i = 0; i< delegator.length; i++){
            if(delegator[i].equalsIgnoreCase("n.")){
                startIndex = i + 1;
            }
        }

        documentNumberDelegator = delegator[startIndex];

        return documentNumberDelegator;
    }

    @Override
    /*
    * Extract Birth date of Delegator from string
    * */
    public String extractbirthDateDelegator(String pdfConverted) {
        int startIndex = 0;
        String firstPart = null, birthDelegator = "";
        String[] delegator = null;

        //Get first part of the module regards delegator
        String[] splittedString = pdfConverted.split("DELEGA");
        firstPart = splittedString[1];

        delegator = firstPart.split(" ");

        //recognize where birth start and save index
        for(int i = 0; i< delegator.length; i++){
            if(delegator[i].equalsIgnoreCase("il")){
                startIndex = i + 1;
            }
        }

        birthDelegator = delegator[startIndex];

        return birthDelegator;
    }


    @Override
    /*
    * Extract Name and surname of Delegate from a String
    * */
    public String extractNameSurnameDelegate(String pdfConverted) {
        int startIndex = 0,stopIndex = 0;
        String secondPart = null, nameSurnameDelegate = "";
        String[] delegate = null;

        //Get first part of the module regards delegate
        String[] splittedString = pdfConverted.split("DELEGA");

        secondPart = splittedString[2];

        delegate = secondPart.split(" ");

        //recognize where name start and ends and save two index
        for(int i = 0; i< delegate.length; i++){
            if(delegate[i].equalsIgnoreCase("sig./a")){
                startIndex = i;
            }

            if(delegate[i].equalsIgnoreCase("nato/a")){
                stopIndex = i;
            }
        }

        //Extract substring for name and surname
        for(int j = startIndex + 1; j < stopIndex; j++){
            nameSurnameDelegate = nameSurnameDelegate.concat(" ").concat(delegate[j]);
        }

        return nameSurnameDelegate;
    }

    @Override
    /*
    * Extract document number of Delegate from a String
    * */
    public String extractDocumentNumbDelegate(String pdfConverted) {
        int startIndex = 0;
        String secondPart = null, documentNumberDelegate = "";
        String[] delegate = null;

        //Get first part of the module regards delegate
        String[] splittedString = pdfConverted.split("DELEGA");
        secondPart = splittedString[2];

        delegate = secondPart.split(" ");

        //recognize where document number start and save index
        for (int i = 0; i < delegate.length; i++) {
            if (delegate[i].equalsIgnoreCase("n.")) {
                startIndex = i + 1;
            }
        }

        documentNumberDelegate = delegate[startIndex];

        return documentNumberDelegate;
    }

    @Override
    /*
    * Extract Birth date of Delegate from string
    * */
    public String extractbirthDateDelegate(String pdfConverted) {
        int startIndex = 0;
        String secondPart = null, birthDelegator = "";
        String[] delegate = null;

        //Get first part of the module regards delegate
        String[] splittedString = pdfConverted.split("DELEGA");
        secondPart = splittedString[2];

        delegate = secondPart.split(" ");

        //recognize where birth start and save index
        for(int i = 0; i< delegate.length; i++){
            if(delegate[i].equalsIgnoreCase("il")){
                startIndex = i + 1;
            }
        }

        birthDelegator = delegate[startIndex];

        return birthDelegator;
    }

    @Override
    /*
    * Normalize String by removing all new lines and all multiple spaces
    * */
    public String normalizeString(String strToNormalize) {
        String removeNewLine = strToNormalize.replaceAll("\\r\\n|\\r|\\n", " ");
        String removeMultiSpace = removeNewLine.trim().replaceAll("\\s+", " ");

        return removeMultiSpace;
    }
}
