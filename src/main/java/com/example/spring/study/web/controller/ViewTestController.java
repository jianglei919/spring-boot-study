package com.example.spring.study.web.controller;

import com.example.spring.study.domain.User;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import org.springframework.web.servlet.view.document.AbstractXlsxStreamingView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jianglei on 2019/9/2.
 */
@Controller
@RequestMapping("/view")
public class ViewTestController {

    @GetMapping("/excel")
    public ModelAndView renderExcel(@ModelAttribute("model") Map<String, Object> model) {
        AbstractXlsxStreamingView excelView = new AbstractXlsxStreamingView() {
            @SuppressWarnings("unchecked")
            @Override
            protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                              HttpServletResponse response) throws Exception {
                Sheet sheet = workbook.createSheet();

                // header
                Row headerRow = sheet.createRow(0);
                List<String> headerNames = (List<String>) model.get("header");
                for (int column = 0; column < headerNames.size(); column++) {
                    headerRow.createCell(column).setCellValue(headerNames.get(column));
                }

                // body
                List<User> users = (List<User>) model.get("user");
                for (int row = 1; row <= users.size(); row++) {
                    Row userRow = sheet.createRow(row);
                    int index = row - 1;
                    userRow.createCell(0).setCellValue(users.get(index).getName());
                    userRow.createCell(1).setCellValue(users.get(index).getSex());
                    userRow.createCell(2).setCellValue(users.get(index).getAge());
                }

                // set output file name
                response.setHeader(
                        "Content-disposition",
                        "attachment; filename=" + URLEncoder.encode("user", "utf-8")
                                + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + ".xlsx");
            }
        };

        return new ModelAndView(excelView, model);
    }

    @GetMapping("/pdf")
    public ModelAndView renderPdf(@ModelAttribute("model") Map<String, Object> model){
        AbstractPdfView pdfView = new AbstractPdfView() {
            @Override
            protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                            HttpServletRequest request, HttpServletResponse response) throws Exception {
                List<String> headerNames = (List<String>)model.get("header");
                List<User> users = (List<User>)model.get("user");

                document.newPage();
                PdfPTable table = new PdfPTable(3);
                table.setHeaderRows(0);

                // header
                for(int i=0;i<headerNames.size();i++){
                    PdfPCell cell = new PdfPCell();
                    cell.setBackgroundColor(Color.GRAY);
                    cell.setPhrase(new Phrase(headerNames.get(i)));
                    table.addCell(cell);
                }

                // body
                for(int row=0; row<users.size();row++){
                    PdfPCell nameCell = new PdfPCell();
                    nameCell.setPhrase(new Phrase(users.get(row).getName()));
                    table.addCell(nameCell);

                    PdfPCell sexCell = new PdfPCell();
                    sexCell.setPhrase(new Phrase(users.get(row).getSex()));
                    table.addCell(sexCell);

                    PdfPCell ageCell = new PdfPCell();
                    ageCell.setPhrase(new Phrase(users.get(row).getAge().toString()));
                    table.addCell(ageCell);
                }

                document.add(table);
            }
        };

        return new ModelAndView(pdfView, model);
    }

    @ModelAttribute
    private void getUser(Model model) {
        List<String> headers = Lists.newArrayList();
        headers.add("Name");
        headers.add("Sex");
        headers.add("Age");

        List<User> users = Lists.newArrayList();
        users.add(new User("Jack", "M", 20));
        users.add(new User("Emily", "W", 24));
        users.add(new User("Tom", "M", 23));

        Map<String, Object> data = Maps.newHashMap();
        data.put("header", headers);
        data.put("user", users);

        model.addAttribute("model", data);
    }
}
