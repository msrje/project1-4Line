package com.green.nowon.message;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;

@Service
public class NlpKomoranService {
	
	public void nlpAnalyze(String strToAnalyze) {
		Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);

	    KomoranResult analyzeResultList = komoran.analyze(strToAnalyze);

	    System.out.println(analyzeResultList.getPlainText());

	    List<Token> tokenList = analyzeResultList.getTokenList();
	    for (Token token : tokenList) {
	        System.out.format("(%2d, %2d) %s/%s\n", token.getBeginIndex(), token.getEndIndex(), token.getMorph(), token.getPos());
	    }
	}
	
}
