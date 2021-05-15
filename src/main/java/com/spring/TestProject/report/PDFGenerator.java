package com.spring.TestProject.report;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.spring.TestProject.DTO.FormDTO;
import com.spring.TestProject.DTO.UserDTO;
import com.spring.TestProject.model.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class PDFGenerator {
    private static BaseFont baseFont = loadBaseFont("/asset/times-roman.ttf");

    private static Font fontHeader = new Font(baseFont, 16, Font.BOLD, BaseColor.BLACK);

    private static Font fontNormal = new Font(baseFont, 14, Font.NORMAL, BaseColor.BLACK);

    private static BaseFont loadBaseFont(String fontName) {
        BaseFont baseFont= null;
        try {
            baseFont = BaseFont.createFont(fontName, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseFont;
    }

    public static ByteArrayInputStream usersReport(List<UserDTO> userDTOS, User user) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Paragraph para = new Paragraph( "Список пользователей системы", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(4);
            Stream.of("Имя", "Фамилия", "Отчество", "Роль")
                    .forEach(headerTitle -> {
                        PdfPCell header = new PdfPCell();
                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        header.setHorizontalAlignment(Element.ALIGN_CENTER);
                        header.setBorderWidth(2);
                        header.setPhrase(new Phrase(headerTitle, fontNormal));
                        table.addCell(header);
                    });
            DecimalFormat df = new DecimalFormat("###.##");

            for (UserDTO userDTO : userDTOS) {
                table.addCell(new Phrase(userDTO.getFirstName(), fontNormal));
                table.addCell(new Phrase(userDTO.getLastName(), fontNormal));
                table.addCell(new Phrase(userDTO.getSecondName(), fontNormal));
                table.addCell(new Phrase(userDTO.getRole(), fontNormal));
            }

            document.add(table);

            document.add(new Phrase("Отчет сформировал: " + user.getFirstName() + " " + user.getLastName() + " "
                    + user.getSecondName() + "\n", fontNormal));

            document.add(new Phrase("Дата создания отчета: " + LocalDate.now(), fontNormal));

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

    public static ByteArrayInputStream passedFormsReport(List<FormDTO> formDTOS, User user) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Paragraph para = new Paragraph( "Список пройденных анкет", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(4);
            Stream.of("Имя", "Фамилия", "Отчество", "Название анкеты")
                    .forEach(headerTitle -> {
                        PdfPCell header = new PdfPCell();
                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        header.setHorizontalAlignment(Element.ALIGN_CENTER);
                        header.setBorderWidth(2);
                        header.setPhrase(new Phrase(headerTitle, fontNormal));
                        table.addCell(header);
                    });
            for (FormDTO formDTO : formDTOS) {
                table.addCell(new Phrase(formDTO.getUser().getFirstName(), fontNormal));
                table.addCell(new Phrase(formDTO.getUser().getLastName(), fontNormal));
                table.addCell(new Phrase(formDTO.getUser().getSecondName(), fontNormal));
                table.addCell(new Phrase(formDTO.getNameForm(), fontNormal));
            }

            document.add(table);

            document.add(new Phrase("Отчет сформировал: " + user.getFirstName() + " " + user.getLastName() + " "
                    + user.getSecondName() + "\n", fontNormal));

            document.add(new Phrase("Дата создания отчета: " + LocalDate.now(), fontNormal));

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}
