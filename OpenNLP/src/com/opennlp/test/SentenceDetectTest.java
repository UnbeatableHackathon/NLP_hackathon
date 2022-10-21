package com.opennlp.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
 
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;
/**
 * @author tutorialkart
 */
public class SentenceDetectTest {
 
    public static void main(String[] args) {
        try {
            new SentenceDetectTest().sentenceDetect();
            new SentenceDetectTest().nameFinder();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public void sentenceDetect() throws InvalidFormatException, IOException {
        String paragraph = "Apache openNLP supports the most common NLP tasks, such as tokenization, sentence segmentation, part-of-speech tagging, named entity extraction, chunking, parsing, and coreference resolution. These tasks are usually required to build more advanced text processing services. OpenNLP also includes maximum entropy and perceptron based machine learning.";
 
        // refer to model file "en-sent,bin", available at link http://opennlp.sourceforge.net/models-1.5/
        InputStream is = new FileInputStream("en-sent.bin");
        SentenceModel model = new SentenceModel(is);
 
        // load the model
        SentenceDetectorME sdetector = new SentenceDetectorME(model);
 
        // detect sentences in the paragraph
        String sentences[] = sdetector.sentDetect(paragraph);
 
        // print the sentences detected, to console
        for(int i=0;i<sentences.length;i++){
            System.out.println(sentences[i]);
        }
        is.close();
    }
    
	public void nameFinder() throws InvalidFormatException, IOException {
//		// Loading the NER - Person model InputStream inputStream = new
//		InputStream inputStream = new FileInputStream("en-ner-person.bin");
//		TokenNameFinderModel model = new TokenNameFinderModel(inputStream);
//
//		// Instantiating the NameFinder class
//		NameFinderME nameFinder = new NameFinderME(model);
//		// Getting the sentence in the form of String array
//		String[] sentence = new String[] { "Mike", "and", "Smith", "are", "good", "friends" };
//
//		// Finding the names in the sentence
//		Span nameSpans[] = nameFinder.find(sentence);
//
//		// Printing the spans of the names in the sentence
//		for (Span s : nameSpans)
//			System.out.println(s.toString());
		
	      //Loading the tokenizer model 
	      InputStream inputStreamTokenizer = new 
	         FileInputStream("en-token.bin");
	      TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer); 
	       
	      //Instantiating the TokenizerME class 
	      TokenizerME tokenizer = new TokenizerME(tokenModel); 
	       
	      //Tokenizing the sentence in to a string array 
	      String sentence = "Open Allen Smith's profile"; 
	      String tokens[] = tokenizer.tokenize(sentence); 
	       
	      //Loading the NER-person model 
	      InputStream inputStreamNameFinder = new 
	         FileInputStream("en-ner-person.bin");       
	      TokenNameFinderModel model = new TokenNameFinderModel(inputStreamNameFinder);
	      
	      //Instantiating the NameFinderME class 
	      NameFinderME nameFinder = new NameFinderME(model);       
	      
	      //Finding the names in the sentence 
	      Span nameSpans[] = nameFinder.find(tokens);        
	      
	      //Printing the names and their spans in a sentence 
	      for(Span s: nameSpans)        
	         System.out.println(s.toString()+"  "+tokens[s.getStart()]); 

	}
}
