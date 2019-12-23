package com.gdu.dhpm11.qllon.pdf;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDF_BaoCaoChiTietLonNai {
    private static String FILE = "d:/Report/Bao_Cao_Chi_Tiet_Lon_Nai.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    public String[] header = {"STT", "Mã Tai", "Ngày phối", "Ngày đẻ", "Tổng số lợn", "Số lợn chết", "Tổng số lợn sống", "Tuổi lợn"};
    private Paragraph paragraph;
    private Document document;

    public static void main(String[] args) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            document.add(new Paragraph("Bao Cao Chi Tiet Lich Tiem"));
            document.add(new Paragraph(new Date().toString()));
            document.add(new Paragraph("------------------------------------------------------------------"));
            document.add(new Paragraph(" "));
            PDF_BaoCaoChiTietLonNai pdf_baoCaoChiTietLonNai=new PDF_BaoCaoChiTietLonNai();
            String[] header = {"STT", "Mã Tai", "Ngày phối", "Ngày đẻ", "Tổng số lợn", "Số lợn chết", "Tổng số lợn sống", "Tuổi lợn"};
//            pdf_baoCaoChiTietLonNai.createTable(header,);
//            document.add(table);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void createTable(String[] header, ArrayList<String[]> clients) {
        try {

            paragraph = new Paragraph();
//            paragraph.setFont(fText);
            PdfPTable pdfPTable = new PdfPTable(header.length);
            pdfPTable.setWidthPercentage(100);
            pdfPTable.setSpacingBefore(10);
            PdfPCell pdfPCell;

            float[] columnWidths = {0.9f, 2f, 1.9f, 1f, 1f, 2.5f, 1.2f, 2.5f};
            pdfPTable.setWidths(columnWidths);
//            pdfPTable.setHorizontalAlignment(Element.ALIGN_CENTER);

            int indexC = 0;
            while (indexC < header.length) {
//                pdfPCell = new PdfPCell(new Phrase(header[indexC++], fTableTitle));
                pdfPCell = new PdfPCell(new Phrase(header[indexC++]));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdfPCell.setBackgroundColor(BaseColor.GREEN);
                pdfPCell.setFixedHeight(20);
                pdfPTable.addCell(pdfPCell);
            }

            for (int indexR = 0; indexR < clients.size(); indexR++) {
                String[] row = clients.get(indexR);

                for (indexC = 0; indexC < header.length; indexC++) {
//                    pdfPCell = new PdfPCell(new Phrase(row[indexC], fTable));
                    pdfPCell = new PdfPCell(new Phrase(row[indexC]));
                    pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    pdfPCell.setFixedHeight(100);
                    pdfPTable.addCell(pdfPCell);
                }
            }

//            // Row Tổng cộng:
//            PdfPCell cell;
//
//            cell = new PdfPCell(new Phrase("Tổng cộng: ", fTable));
//            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setColspan(4);
//            cell.setBackgroundColor(new BaseColor(255, 239, 246));
//            pdfPTable.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(String.valueOf(/*Giohang.tongSoLuongSPGioHang*/TongSoLuongGioHang), fTable));
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setColspan(1);
//            cell.setBackgroundColor(new BaseColor(255, 239, 246));
//            pdfPTable.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Phí vận chuyển: ", fTable));
//            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setColspan(3);
//            cell.setBackgroundColor(new BaseColor(255, 239, 246));
//            pdfPTable.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("0đ", fTable));
//            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cell.setColspan(1);
//            cell.setBackgroundColor(new BaseColor(255, 239, 246));
//            pdfPTable.addCell(cell);
//
//            // Row Tổng cộng tiền thanh toán
//            PdfPCell cellTongTienThanhToan;
//
//            cellTongTienThanhToan = new PdfPCell(new Phrase("Tổng cộng tiền thanh toán: ", fCellTongCongTienThanhToan));
//            cellTongTienThanhToan.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            cellTongTienThanhToan.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cellTongTienThanhToan.setColspan(8);
//            pdfPTable.addCell(cellTongTienThanhToan);
//
//            cellTongTienThanhToan = new PdfPCell(new Phrase(/*Giohang.tonghoadon*/TongHoaDon, fTableCellThanhTien));
//            cellTongTienThanhToan.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            cellTongTienThanhToan.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            cellTongTienThanhToan.setBorderColor(BaseColor.RED);
//            cellTongTienThanhToan.setBackgroundColor(BaseColor.ORANGE);
//            cellTongTienThanhToan.setColspan(1);
//            pdfPTable.addCell(cellTongTienThanhToan);

            paragraph.add(pdfPTable);
            document.add(paragraph);
//            cellSL = new PdfPCell(new Phrase("6", fTable));
//            cellSL.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.addCell(cellSL);

//            cellPhiVanChuyen = new PdfPCell(new Phrase("Phí vận chuyển: ", fTable));
//            cellPhiVanChuyen.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            cellTongCong.setColspan(3);
//            table.addCell(cellPhiVanChuyen);

//            cellThanhTien = new PdfPCell(new Phrase("0đ", fTable));
//            cellThanhTien.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            table.addCell(cellThanhTien);

//            PdfPTable table = new PdfPTable(4);
////            table.setTotalWidth(document.getPageSize().getWidth() - 70);
////            table.setLockedWidth(true);
////            PdfPCell contractor = new PdfPCell(new Phrase("Tổng cộng:", fTable));
////            contractor.setColspan(5);
////            table.addCell(contractor);
////            PdfPCell workType = new PdfPCell(new Phrase("Refractory Works"));
////            workType.setColspan(4);
////            table.addCell(workType);
////            PdfPCell supervisor = new PdfPCell(new Phrase("XXXXXXXXXXXXXX"));
////            supervisor.setColspan(3);
////            table.addCell(supervisor);
////            PdfPCell paySlipHead = new PdfPCell(new Phrase("XXXXXXXXXXXXXXXX"));
////            paySlipHead.setColspan(5);
////            table.addCell(paySlipHead);
////            PdfPCell paySlipMonth = new PdfPCell(new Phrase("XXXXXXX"));
////            paySlipMonth.setColspan(5);
////            table.addCell(paySlipMonth);
////            PdfPCell blank = new PdfPCell(new Phrase(""));
////            blank.setColspan(5);
////            table.addCell(blank);
////            document.add(table);

            // I see 3 columns in your example
//            PdfPTable table = new PdfPTable(3);
//            // The first column appears to have double the width of the other columns
//            table.setWidths(new int[]{ 2, 1, 1});
//            // the first row consists of 1 cell that spans the 3 columns
//            PdfPCell c1 = new PdfPCell(new Phrase("Content 1"));
//            c1.setColspan(3);
//            table.addCell(c1);
//            // Then follows a row with normal cells
//            table.addCell("Content 2");
//            table.addCell("Content 3");
//            table.addCell("Content 4");
//            // Again we have a row with 1 cell that spans 3 columns
//            PdfPCell c5 = new PdfPCell(new Phrase("Content 5"));
//            c5.setColspan(3);
//            table.addCell(c5);
//            // Now we have a row with 1 normal cell and 1 that spans 2 columns
//            table.addCell("Content 7.1");
//            PdfPCell c7 = new PdfPCell(new Phrase("Content 7.2"));
//            c7.setRowspan(3);
//            table.addCell(c7);
//            // now we can add the table
//            document.add(table);


//            PdfPCell cell1 = new PdfPCell(new Phrase("C"));
//            cell1.setRowspan(2);
//            table.addCell(cell1);
//
//            PdfPCell cell2 = new PdfPCell(new Phrase("D"));
//            cell2.setRowspan(3);
//            table.addCell(cell2);
//
//            table.addCell("B");
//            table.addCell("F");
//
//            PdfPCell hang2cot2 = new PdfPCell(new Phrase("E"));
//            hang2cot2.setRowspan(2);
//            table.addCell(hang2cot2);
//
//            table.addCell("J");
            //            PdfPTable table = new PdfPTable(header.length);
//            table.setWidthPercentage(100);
//            PdfPCell cell;
//
//            cell = new PdfPCell(new Phrase("Tổng cộng: ", fTable));
//            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            cell.setColspan(3);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("6", fTable));
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            cell.setColspan(1);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("Phí vận chuyển: ", fTable));
//            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            cell.setColspan(3);
//            table.addCell(cell);
//
//            cell = new PdfPCell(new Phrase("0đ", fTable));
//            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            cell.setColspan(1);
//            table.addCell(cell);
//
//            PdfPCell cellTongTienThanhToan;
//
//            cellTongTienThanhToan = new PdfPCell(new Phrase("Tổng cộng tiền thanh toán: ", fTable));
//            cellTongTienThanhToan.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            cellTongTienThanhToan.setVerticalAlignment(Element.ALIGN_CENTER);
//            cellTongTienThanhToan.setColspan(7);
//            table.addCell(cellTongTienThanhToan);
//
//            cellTongTienThanhToan = new PdfPCell(new Phrase("179000đ", fTable));
//            cellTongTienThanhToan.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            cellTongTienThanhToan.setColspan(1);
//            table.addCell(cellTongTienThanhToan);
//
//            document.add(table);
        } catch (Exception e) {

        }

    }

}
