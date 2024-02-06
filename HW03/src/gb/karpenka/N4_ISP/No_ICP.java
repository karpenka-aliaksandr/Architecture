package gb.karpenka.N4_ISP;

public class No_ICP {
    //Разработчик Алекс создал интерфейс "отчет" и добавил два метода:
    // generateExcel() и generatedPdf(). Теперь клиент А хочет использовать
    // этот интерфейс, но он намерен использовать отчеты только в PDF-формате,
    // а не в Excel. Устроит ли его такая функциональность?
    //
    // Нет. Он должен будет реализовать два метода, один из которых по большому
    // счету не нужен и существует только благодаря Алексу — дизайнеру программного обеспечения.
    // Клиент воспользуется либо другим интерфейсом, либо оставит поле для Excel пустым.
}
public interface IReport(){
    public String generateExcel();
    public String generatePdf();
}

public class PdfReport implements IPdfReport(){
    public String generateExcel(){
        return null;
        }
    public String generatePdf(){
        return pdf;
        }
}