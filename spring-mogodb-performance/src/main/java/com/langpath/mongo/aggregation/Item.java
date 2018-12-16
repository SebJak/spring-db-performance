package com.langpath.mongo.aggregation;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "items")
@Data
@Builder
public class Item {
    String id;
    String time;
    String system;
}
