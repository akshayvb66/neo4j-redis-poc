package com.stackroute.graph.repository;

import com.stackroute.graph.model.Knowledge;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

public interface KnowledgeRepository extends Neo4jRepository<Knowledge,Integer> {

    @Query("MATCH (u:Knowledge) RETURN u")
    Collection<Knowledge> getAllKnowledge();


//    @Query("match(p:Concept{name:{0}}) return p")
//    Collection<Concept> getConcept();

    @Query("match(k:Knowledge{paragraphId:{0},intentLevel:{1}}) return k")
    Knowledge getKnowledge(Integer paragraphId,String intentLevel);

 //   match(p:Concept{name: "JSP"})
//    match(k:Knowledge{paragraphId: 123,intentLevel: "Knowledge"})
//    CREATE(k-[:k:Knowledge{paragraphId: 123,intentLevel: "Knowledge"}{confidenceScore: 8}]->p)
        @Query("match(p:Concept{name:{0}}) match(k:Knowledge{paragraphId:{1},intentLevel:{2}}) CREATE(p)-[:Knowledgeof {confidenceScore:{3}}]->(k)")
    Collection<Knowledge> insertRelationship(String name,Integer paragraphId,String intentLevel,String confidenceScore);




}
