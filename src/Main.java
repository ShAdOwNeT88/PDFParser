import PdfTool.PdfPresenter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        /*
        * This little library compiled as a .jar file is used from command-line.
        * COMMAND USAGE
        * java -jar name_of_package.jar path_of_pdf_file
        * COMMAND EXAMPLE
        * java -jar PDFParser.jar /Users/iovineAntonio/Desktop/prova01.pdf
        * */

        //Error for null path in command line and message to show guidelines for tool
        if (args.length == 0)
        {
            System.out.println("* This little library compiled as a .jar file is used from command-line.\n" +
                    "        * COMMAND USAGE\n" +
                    "        * java -jar name_of_package.jar path_of_pdf_file\n" +
                    "        * COMMAND EXAMPLE\n" +
                    "        * java -jar PDFParser.jar /Users/iovineAntonio/Desktop/prova01.pdf");
            System.exit(0);
        }

        else{
            //get path of pdf file passing to presenter
            String path = args[0];

            //initialize and extract information about Delegator and Delegate
            PdfPresenter presenter = new PdfPresenter(path);
            presenter.obtainsAllDetailsOfDelegator();
            presenter.obtainAllDetailsOfDelegate();
        }
    }
}
