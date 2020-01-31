package org.aztec.sovn.core.ml.prolog;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.aztec.framework.core.utils.CodecUtils;
import org.springframework.stereotype.Component;

import alice.tuprolog.InvalidLibraryException;
import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;

@Component("prologEngine")
public class PrologEngine {
	
	public final static String DEFAULT_LINE_SEPERATOR = "\n";
	
	Prolog prolog;
	
	public PrologEngine() throws InvalidLibraryException {
		prolog = PrologFactory.getBasicProlog();
	}
	
	public SolveInfo solve(String query) throws MalformedGoalException {
		SolveInfo si = prolog.solve(query);
		return si;
	}
	
	public void addTheory(File prologFile) throws MalformedGoalException, InvalidLibraryException, FileNotFoundException, IOException, InvalidTheoryException{
		Theory theory = new Theory(new FileInputStream(prologFile));
		prolog.addTheory(theory);
	}
	
	public void addTheory(String text) throws InvalidLibraryException, InvalidTheoryException, MalformedGoalException {
		Theory theory = new Theory(text);
		prolog.addTheory(theory);
	}

	public static void main(String[] args) {
		
		try {
			PrologEngine prologEngine = new PrologEngine();
			//prologEngine.addTheory("chinese(lm).\ngz(lm).\nprog(X) :- chinese(X),gz(X).");
			String agentName = "lm@ok";
			String base64 = "lmAATTok";
			//String base64 = CodecUtils.encodeBASE64Str(agentName);
			System.out.println(base64);
			prologEngine.addTheory("chinese(" + base64 + ").");
			prologEngine.addTheory("gz(" + base64 + ").");
			prologEngine.addTheory("prog(X) :- chinese(X),gz(X).");
			prologEngine.addTheory("add(X,hp,(aPc+bPc_1)/cPc) :- prog(X).");
			//SolveInfo si = prologEngine.solve("prog(X).");
			SolveInfo si = prologEngine.solve("add(X,ATTR,Y).");
			System.out.println(si);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
