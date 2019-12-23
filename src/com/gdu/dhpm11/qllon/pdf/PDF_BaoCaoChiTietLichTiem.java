package com.gdu.dhpm11.qllon.pdf;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDF_BaoCaoChiTietLichTiem {
    private static String FILE = "d:/Report/Bao_Cao_Chi_Tiet_Lich_Tiem.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    private String[] header = {"STT", "Sản phẩm", "Hình ảnh", "Mã", "SL", "Đơn giá", "Giảm giá", "Giá bán", "Thành tiền"};

    public static void main(String[] args) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            document.add(new Paragraph("Bao Cao Chi Tiet Lich Tiem"));
            document.add(new Paragraph(new Date().toString()));
            document.add(new Paragraph("------------------------------------------------------------------"));
            document.add(new Paragraph(" "));
            PdfPTable table = new PdfPTable(2);
            table.addCell("1");
            table.addCell("2");
            table.addCell("3");
            table.addCell("4");
            document.add(table);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
