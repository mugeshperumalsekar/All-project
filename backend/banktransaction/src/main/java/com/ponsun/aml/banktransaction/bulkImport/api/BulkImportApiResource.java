package com.ponsun.aml.banktransaction.bulkImport.api;

import com.ponsun.aml.banktransaction.bulkImport.services.BulkImportWritePlatformService;
import com.ponsun.aml.banktransaction.infrastructure.fileupload.XlsFileParser;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/V1/bulkImport")
@Tag(name = "BulkImportApiResource")
public class BulkImportApiResource {

    private final BulkImportWritePlatformService bulkImportWritePlatformService;
    @PostMapping("/tableBulkImport")
    public Response saveDataFromFile() {
        XlsFileParser xlsFileParser = new XlsFileParser("D:/files", "Transaction.xlsx");
        final List<Map<String, Object>> data = xlsFileParser.parseRecordTable();

        System.out.println(data);
        Response response =  this.bulkImportWritePlatformService.saveBulkData(data);
        //Response response=null;
        return response;
    }
//    @PostMapping("/tableBulkImport")
//    public Response saveDataFromFile() {
//        String filePath = "D:/files/data.xlsx";
//        XlsFileParser xlsFileParser = new XlsFileParser(filePath);
//
//        try {
//            final List<Map<String, Object>> data = xlsFileParser.parseTable();
//
//            if (data != null) {
////                for (Map<String, Object> row : data) {
////                    for (Map.Entry<String, Object> entry : row.entrySet()) {
////                        System.out.println(entry.getKey() + ": " + entry.getValue());
////                    }
////                }
//System.out.println("data" + data);
//                Response response = this.bulkImportWritePlatformService.saveBulkData(data);
//                return new Response("No data was parsed.");
//            } else {
//                System.err.println("No data was parsed.");
//                return new Response("No data was parsed.");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Response("Error: " + e.getMessage());
//        }
//    }
}
