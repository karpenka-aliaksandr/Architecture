package gb.karpenka.N4_ISP;

public class ICP {
    //Разделим интерфейсы и имплементируем только нужную функциональность
}

public interface IPdfReport(){
    public String generatePdf();
}

public interface IExcelReport(){
    public String generateExcel();
}


public class PdfReport implements IPdfReport(){
    public String generatePdf(){
        return pdf;
        }
}