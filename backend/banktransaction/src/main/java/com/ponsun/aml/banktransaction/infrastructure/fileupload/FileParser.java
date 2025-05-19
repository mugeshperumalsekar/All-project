package com.ponsun.aml.banktransaction.infrastructure.fileupload;

import java.util.List;
import java.util.Map;

public interface FileParser {
    List<Map<String, Object>> parseRecordTable();
}
