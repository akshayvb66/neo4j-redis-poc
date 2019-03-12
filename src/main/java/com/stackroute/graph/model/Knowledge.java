package com.stackroute.graph.model;
import lombok.Data;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.io.Serializable;


@NodeEntity
@Data
public class Knowledge implements Serializable {
    @Id
    private int paragraphId;
    private String name;
    private String documentId;
    private String domain;
    private String intentLevel;
    private String nodeName;

}