package org.example.homework.commands;

import freemarker.template.Template;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.example.homework.catalog.Catalog;
import org.example.homework.documents.Document;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportCommand extends CatalogCommand{
    public ReportCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void execute() {
        // Configure FreeMarker
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
        configuration.setClassForTemplateLoading(this.getClass(), "/templates/");


        // Define the data that will be put into the HTML template
        Map<String, Object> data = new HashMap<>();
        List<Document> documents = catalog.getDocuments();
        data.put("documents", documents);

        // Generate the HTML report
        try {
            Template template = configuration.getTemplate("report.ftl");
            String report = generateReport(template, data);
            saveReportToFile(report);
            System.out.println("Report generated successfully.");
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    private String generateReport(Template template, Map<String, Object> data) throws TemplateException, IOException {
        StringWriter writer = new StringWriter();
        template.process(data, writer);
        return writer.toString();
    }

    private void saveReportToFile(String report) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Laborator_5/report.html"));
            writer.write(report);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
