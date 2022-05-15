package com.satori.service.impl;

import com.satori.service.DocumentGenerationService;
import org.springframework.stereotype.Service;

@Service
public class DocumentGenerationServiceImpl implements DocumentGenerationService {

/*    public ByteArrayInputStream generateExcel(String username) {
        List<Member> workdays = memberRepository.findAll();
        try (XSSFWorkbook wb = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {


            String sheetName = "Workday Report";

            XSSFSheet sheet = wb.createSheet(sheetName);

            Row headerRow = sheet.createRow((short) 0);

            Cell cell = headerRow.createCell((short) 0);
            cell.setCellValue("Day");

            cell = headerRow.createCell((short) 2);
            cell.setCellValue("Comments");

            cell = headerRow.createCell((short) 1);
            cell.setCellValue("Working Hours");

            cell = headerRow.createCell((short) 3);
            cell.setCellValue("Target");

            cell = headerRow.createCell((short) 4);
            cell.setCellValue("Actual");

            int r = 1;
            for (Member workday : workdays) {
                Row row = sheet.createRow(r++);
                row.createCell(0).setCellValue(workday.getWorkday().toString());
                row.createCell(2).setCellValue(workday.getComments());

                double wh = workday.getWorkingHours().getHour() + (workday.getWorkingHours().getMinute() / 60);

                row.createCell(1).setCellValue(wh);
                row.createCell(4).setCellValue(workday.getActual());
            }

            //chart

            XSSFDrawing drawing = sheet.createDrawingPatriarch();
            XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 8, 10, 40);

            XSSFChart chart = drawing.createChart(anchor);
            chart.setTitleText("Productivity Raport");
            chart.setTitleOverlay(false);

            XDDFChartLegend legend = chart.getOrAddLegend();
            legend.setPosition(LegendPosition.TOP_RIGHT);


            XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
            bottomAxis.setTitle("Days");
            XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
            leftAxis.setTitle("Amount");

            XDDFDataSource<String> days = XDDFDataSourcesFactory.fromStringCellRange(sheet,
                    new CellRangeAddress(0, workdays.size() + 1, 0, 0));

            XDDFNumericalDataSource<Double> target = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
                    new CellRangeAddress(0, workdays.size() + 1, 3, 3));

            XDDFNumericalDataSource<Double> actual = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
                    new CellRangeAddress(0, workdays.size() + 1, 4, 4));


            XDDFBarChartData data = (XDDFBarChartData) chart.createData(ChartTypes.BAR, bottomAxis, leftAxis);

            XDDFChartData.Series series1 = data.addSeries(days, target);
            series1.setTitle(" Target", null);
            data.setVaryColors(true);
            chart.plot(data);

            XDDFChartData.Series series2 = data.addSeries(days, actual);
            series2.setTitle("Actual", null);
            data.setVaryColors(true);
            chart.plot(data);

            // in order to transform a bar chart into a column chart, you just need to change the bar direction
            XDDFBarChartData bar = (XDDFBarChartData) data;
            bar.setBarDirection(BarDirection.COL);


            wb.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }*/
}
