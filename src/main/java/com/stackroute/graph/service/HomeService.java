package com.stackroute.graph.service;

import com.stackroute.graph.model.Concept;
import com.stackroute.graph.model.Knowledge;
import com.stackroute.graph.repository.ConceptRepository;
import com.stackroute.graph.repository.KnowledgeRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class HomeService {
     private ConceptRepository conceptRepository;
     private KnowledgeRepository knowledgeRepository;
     public HomeService(ConceptRepository conceptRepository,KnowledgeRepository knowledgeRepository){
          this.conceptRepository=conceptRepository;
          this.knowledgeRepository=knowledgeRepository;
     }

     public Iterable<Knowledge> getAllKnowledge(){return knowledgeRepository.findAll();}


     public Iterable<Concept> getAllConcepts( String name){
          return conceptRepository.getConcept(name);
     }



     @Cacheable(value="Knowledge")
     public Knowledge getPerticularKnowledge(Integer paragraphId,String intentLevel){
          System.out.println("Inside get request");
          return knowledgeRepository.getKnowledge(paragraphId,intentLevel);
     }


     public void saveKnowledgeToDb(Knowledge knowledge) {
          knowledgeRepository.save(knowledge);
     }

     public void addRelationship(String name,
                                 Integer paragraphId, String intentLevel,String confidenceScore)
     {
          knowledgeRepository.insertRelationship(name,paragraphId,intentLevel,confidenceScore);
     }
}
