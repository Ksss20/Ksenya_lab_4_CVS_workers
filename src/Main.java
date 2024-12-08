import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.CSVReaderBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static com.opencsv.ICSVParser.DEFAULT_NULL_FIELD_INDICATOR;

public class Main {
    public static void main(String[] args) {

        List<Worker> workers = new ArrayList<>();
        Map<String, Division> divisions = new HashMap<>();

        String csvFile = "src/foreign_names.csv";
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

        try (CSVReader reader = new CSVReaderBuilder(new FileReader(csvFile))
                .withCSVParser(parser)
                .withSkipLines(1)
                .build()) {
            String[] record;
            while ((record = reader.readNext()) != null) {
                int i = 0;

                int id = Integer.parseInt(record[i++]);
                String name = record[i++];
                String gender = record[i++];
                String birthDate = record[i++];
                String divisionName = record[i++];
                double salary = Integer.parseInt(record[i++]);

                if (!divisions.containsKey(divisionName)) {
                    divisions.put(divisionName, new Division(divisionName));
                }
                Division division = divisions.get(divisionName);

                Worker worker = new Worker(id, name, gender, birthDate, division, salary);
                workers.add(worker);

            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        System.out.println("Workers");
        for (Worker worker : workers) {
            System.out.println(worker);
        }
        System.out.println("Divisions");
        for (Division division : divisions.values()) {
            System.out.println(division);
        }
    }
}
