package com.stackroute.graph.repository;

import com.stackroute.graph.model.Concept;
import com.stackroute.graph.model.Knowledge;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface ConceptRepository extends Neo4jRepository<Concept,Integer> {

        @Query("match(p:Concept{name:{0}}) return p")
        Collection<Concept> getConcept(String name);
}
